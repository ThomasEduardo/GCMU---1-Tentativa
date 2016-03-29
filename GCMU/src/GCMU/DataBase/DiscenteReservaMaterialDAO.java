/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.DataBase.ConnectionFactory;
import GCMU.DataBase.MateriaisDAO;
import GCMU.classes.DiscenteReservaChave;
import GCMU.classes.DiscenteReservaMaterial;
import GCMU.classes.DocenteReservaMaterial;
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
public class DiscenteReservaMaterialDAO {

    public void insert(DiscenteReservaMaterial discenteReservaMaterial) throws SQLException {

         Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        String sql = "INSERT INTO Discente_Reserva_Materiais_tb(horaPedirdo, horaDevoucao, data, matricula, idMaterial) VALUES(?,?,?,?,?)";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, discenteReservaMaterial.getHoraPedido());
            stmt.setString(2, discenteReservaMaterial.getHoraDevolucao());
            stmt.setDate(3, discenteReservaMaterial.getData());
            stmt.setInt(4, discenteReservaMaterial.getDiscente().getMatricula());
            stmt.setInt(5, discenteReservaMaterial.getMaterial().getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public DiscenteReservaMaterial getById(Integer pk) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        DiscenteReservaMaterial discenteReservaMaterial = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT id,"
                    + " horaPedido,"
                    + " horaDevolucao,"
                    + " data,"
                    + " matricula,"
                    + " idChave"
                    + " FROM Discente_Reserva_Material_tb"
                    + " WHERE id = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<DiscenteReservaMaterial> discenteReservaMateriais = convertToList(rs);

            if (!discenteReservaMateriais.isEmpty()) {
                discenteReservaMaterial = discenteReservaMateriais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return discenteReservaMaterial;
    }

    private List<DiscenteReservaMaterial> convertToList(ResultSet rs) throws SQLException {

        List<DiscenteReservaMaterial> discenteReservaMateriais = new ArrayList<DiscenteReservaMaterial>();

        try {

            while (rs.next()) {

                // Chaves
                DiscenteReservaMaterial discenteReservaMaterial = new DiscenteReservaMaterial();

                discenteReservaMaterial.setId(rs.getInt("id"));
                discenteReservaMaterial.setHoraDevolucao(rs.getString("horaDevolucao"));
                discenteReservaMaterial.setHoraPedido(rs.getString("horaPedido"));
                discenteReservaMaterial.setData(rs.getDate("data"));

                MateriaisDAO materiaisdao = new MateriaisDAO();
                discenteReservaMaterial.setMaterial(materiaisdao.getById(rs.getInt("idMaterial")));

                discenteReservaMateriais.add(discenteReservaMaterial);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return discenteReservaMateriais;
    }
}
