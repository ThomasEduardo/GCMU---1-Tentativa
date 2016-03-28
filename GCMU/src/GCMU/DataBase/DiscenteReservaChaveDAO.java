/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.DiscenteReservaChave;
import GCMU.classes.DocenteReservaChave;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
}
