/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCMU.DataBase;

import GCMU.classes.Utensilios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ClelioJr
 */
public class UtensiliosDAO {
    public boolean insert(Utensilios  utensilios) {

		Connection con = ConnectionFactory.getConnection();

                PreparedStatement stmt = null;

		try {	

			String sql = "INSERT INTO utensilios_tb(tipo, observacao, locall, marca) VALUES(?,?,?,?)";

			stmt = (PreparedStatement) con.prepareStatement(sql);
	
			stmt.setString(1, utensilios.getTipo());
		
			stmt.setString(2, utensilios.getObservacao());
			stmt.setString(3, utensilios.getLocall());
			stmt.setString(4, utensilios.getMarca());
			
			stmt.execute();

                        JOptionPane.showMessageDialog(null, "Salvo!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "ERRO "+e);

		} finally {

			ConnectionFactory.closeConnection(con , stmt);  
		}

		return true;

	}
	
	
	public boolean delete(Utensilios u) throws SQLException {

 		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		try {

			String sql = "DELETE FROM utensilios_tb"
					+ " WHERE id = ?";


			stmt = (PreparedStatement) con.prepareStatement(sql);
                        stmt.setInt(1, u.getId());
			stmt.execute();
                        JOptionPane.showMessageDialog(null, "Deletado!");
		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, e);

		} finally{

			ConnectionFactory.closeConnection(con , stmt);
		}

		return true;
	}

	public void update(Utensilios  utensilios) throws SQLException {

                Connection con = ConnectionFactory.getConnection();
                PreparedStatement stmt = null;
		try {

			String sql = "UPDATE utensilios_tb"
					+ " SET tipo=?, locall =?, observacao=?, marca=?"
					+ " WHERE id=?";

                         stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, utensilios.getTipo());
                        stmt.setString(2, utensilios.getLocall());
			stmt.setString(3, utensilios.getObservacao());
			stmt.setString(4, utensilios.getMarca());
			
			stmt.setLong(5, utensilios.getId());

			stmt.execute();
                        JOptionPane.showMessageDialog(null, "Alterado!");
		}catch (SQLException e) {

			System.out.println(e);

		} finally {
                    

			ConnectionFactory.closeConnection(con , stmt);
		}


	}

}
