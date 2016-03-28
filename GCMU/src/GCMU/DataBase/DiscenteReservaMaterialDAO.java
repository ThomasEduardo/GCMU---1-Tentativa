/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.DiscenteReservaMaterial;
import GCMU.classes.DocenteReservaMaterial;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
}
