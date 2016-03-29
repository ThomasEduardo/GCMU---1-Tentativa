package GCMU.DataBase;

import GCMU.classes.DiscenteReservaChave;
import GCMU.classes.DocenteReservaChave;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Milena
 */
public class DiscenteReservaChaveDAO {

    public void insert(DiscenteReservaChave discenteReservaChave) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        String sql = "INSERT INTO Discente_Reserva_Chaves_tb(horaPedirdo, horaDevoucao, data, matricula, idChave) VALUES(?,?,?,?,?)";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, discenteReservaChave.getHoraPedido());
            stmt.setString(2, discenteReservaChave.getHoraDevolucao());
            stmt.setDate(3, discenteReservaChave.getData());
            stmt.setInt(4, discenteReservaChave.getDiscente().getMatricula());
            stmt.setInt(5, discenteReservaChave.getChaves().getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DiscenteReservaChave getById(Integer pk) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        DiscenteReservaChave discenteReservaChave = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT id,"
                    + " horaPedido,"
                    + " horaDevolucao,"
                    + " data,"
                    + " suap,"
                    + " idChave"
                    + " FROM Discente_Reserva_Chaves_tb"
                    + " WHERE id = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<DiscenteReservaChave> discenteReservaChaves = convertToList(rs);

            if (!discenteReservaChaves.isEmpty()) {
                discenteReservaChave = discenteReservaChaves.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return discenteReservaChave;
    }

    private List<DiscenteReservaChave> convertToList(ResultSet rs) throws SQLException {

        List<DiscenteReservaChave> discenteReservaChaves = new ArrayList<DiscenteReservaChave>();

        try {

            while (rs.next()) {

                // Chaves
                DiscenteReservaChave discenteReservaChave = new DiscenteReservaChave();

                discenteReservaChave.setId(rs.getInt("id"));
                discenteReservaChave.setHoraDevolucao(rs.getString("horaDevolucao"));
                discenteReservaChave.setHoraPedido(rs.getString("horaPedido"));
                discenteReservaChave.setData(rs.getDate("data"));

                ChavesDAO chavesdao = new ChavesDAO();
                discenteReservaChave.setChaves(chavesdao.getById(rs.getInt("idChave")));

                discenteReservaChaves.add(discenteReservaChave);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return discenteReservaChaves;
    }
}
