/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.DocenteReservaChave;
import GCMU.classes.DocenteReservaMaterial;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Milena
 */
public class DocenteReservaMaterialDAO {
 
    public void insert(DocenteReservaMaterial docenteReservaMaterial) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        String sql = "INSERT INTO Docente_Reserva_Materiais_tb(horaPedirdo, horaDevoucao, data, matricula, idMaterial) VALUES(?,?,?,?,?)";

        try {

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, docenteReservaMaterial.getHoraPedido());
            stmt.setString(2, docenteReservaMaterial.getHoraDevolucao());
            stmt.setDate(3, docenteReservaMaterial.getData());
            stmt.setInt(4, docenteReservaMaterial.getDocente().getMatricula());
            stmt.setInt(5, docenteReservaMaterial.getMaterial().getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
