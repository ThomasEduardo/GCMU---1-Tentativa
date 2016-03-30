package GCMU.DataBase;

import GCMU.classes.DiscenteReservaChave;
import GCMU.classes.DocenteReservaChave;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Milena
 */
public class DiscenteReservaChaveDAO {

    public void insert(DiscenteReservaChave discenteReservaChave) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        String sql = "INSERT INTO Discente_Reserva_Chaves_tb(horaPedido, horDevolucao, data, matricula, idChave) VALUES(?,?,?,?,?)";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, discenteReservaChave.getHoraPedido());
            stmt.setString(2, discenteReservaChave.getHoraDevolucao());
            stmt.setDate(3, discenteReservaChave.getData());
            stmt.setInt(4, discenteReservaChave.getMatricula());
            stmt.setInt(5, discenteReservaChave.getIdChave());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   public List<DiscenteReservaChave> read() {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<DiscenteReservaChave> drcs = new ArrayList<DiscenteReservaChave>();

        try {

            String sql = "SELECT * FROM Discente_Reserva_Chaves_tb";

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                DiscenteReservaChave drc = new DiscenteReservaChave();
                drc.setIdChave(rs.getInt("idChave"));
                drc.setData(rs.getDate("data"));
                drc.setMatricula(rs.getInt("matricula"));
                drc.setHoraDevolucao(rs.getString("horaDevolucao"));
                drc.setHoraPedido(rs.getString("horaPedido"));
                drcs.add(drc);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChavesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return drcs;

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

    public void update(DiscenteReservaChave discenteReservaChave) throws SQLException {
        
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE Discente_Reserva_Chaves_tb"
                    + " SET horaDevolucao=?"
                    + " WHERE id=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, discenteReservaChave.getHoraDevolucao());
            stmt.setInt(2, discenteReservaChave.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alterado!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }

    }

}
