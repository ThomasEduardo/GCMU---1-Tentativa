/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.Chaves;
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
public class DocenteReservaChaveDAO {

    public void insert(DocenteReservaChave docenteReservaChave) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        String sql = "INSERT INTO Docente_Reserva_Chaves_tb(horaPedirdo, horaDevoucao, data, matricula, idChave) VALUES(?,?,?,?,?)";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, docenteReservaChave.getHoraPedido());
            stmt.setString(2, docenteReservaChave.getHoraDevolucao());
            stmt.setDate(3, docenteReservaChave.getData());
            stmt.setInt(4, docenteReservaChave.getDocente().getSuap());
            stmt.setInt(5, docenteReservaChave.getChaves().getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DocenteReservaChave getById(Integer pk) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        DocenteReservaChave docenteReservaChave = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT id,"
                    + " horaPedido,"
                    + " horaDevolucao,"
                    + " data,"
                    + " suap,"
                    + " idChave"
                    + " FROM Docente_Reserva_Chaves_tb"
                    + " WHERE id = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<DocenteReservaChave> docenteReservaChaves = convertToList(rs);

            if (!docenteReservaChaves.isEmpty()) {
                docenteReservaChave = docenteReservaChaves.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return docenteReservaChave;
    }

    private List<DocenteReservaChave> convertToList(ResultSet rs) throws SQLException {

        List<DocenteReservaChave> docenteReservaChaves = new ArrayList<DocenteReservaChave>();

        try {

            while (rs.next()) {

                // Chaves
                DocenteReservaChave docenteReservaChave = new DocenteReservaChave();

                docenteReservaChave.setId(rs.getInt("id"));
                docenteReservaChave.setHoraDevolucao(rs.getString("horaDevolucao"));
                docenteReservaChave.setHoraPedido(rs.getString("horaPedido"));
                docenteReservaChave.setData(rs.getDate("data"));

                ChavesDAO chavesdao = new ChavesDAO();
                docenteReservaChave.setChaves(chavesdao.getById(rs.getInt("idChave")));

                docenteReservaChaves.add(docenteReservaChave);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return docenteReservaChaves;
    }

    public void update(DocenteReservaChave docenteReservaChave) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE Discente_Reserva_Chaves_tb"
                    + " SET horaDevolucao=?"
                    + " WHERE id=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, docenteReservaChave.getHoraDevolucao());
            stmt.setInt(2, docenteReservaChave.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alterado!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }

    }
}
