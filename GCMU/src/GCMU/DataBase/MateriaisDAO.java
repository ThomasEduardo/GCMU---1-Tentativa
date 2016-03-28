package GCMU.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Materiais;
import javax.swing.JOptionPane;

public class MateriaisDAO{

public boolean insert(Materiais materiais) throws SQLException {

		Connection con =  (Connection) ConnectionFactory.getConnection();

                PreparedStatement stmt = null;

		try {	

			String sql = "INSERT INTO materiais_tb(tipo, status, observacao, numeroSala, nomeSala) VALUES(?,?,?,?,?)";

			stmt = (PreparedStatement) con.prepareStatement(sql);
	
			stmt.setString(1, materiais.getTipo());
			stmt.setString(2, materiais.getStatus());
			stmt.setString(3, materiais.getObservacao());
			stmt.setInt(4, materiais.getNumeroSala());
			stmt.setString(5, materiais.getNomeSala());
			
			stmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Salvo!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "ERRO"+e);

		} finally {

			ConnectionFactory.closeConnection(con , stmt);  
		}

		return true;

	}
	
	public Materiais getById(Integer pk) throws SQLException {
		
		Connection con = (Connection) ConnectionFactory.getConnection();

		Materiais Materiais = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {
			String sql = "SELECT materiais.id,"
					+ " materiais.tipo,"
					+ " materiais.status,"
					+ " materiais.obersevacao,"
					+ " materiais.numeroSala,"
					+ " materiais.nomeSala,"
					+ " FROM materiais_tb AS materiais"
					+ " WHERE materiais.id = " 
					+ pk;

			stmt = (PreparedStatement) con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Materiais> Materiaiss = convertToList(rs);

			if (!Materiaiss.isEmpty())
				Materiais = Materiaiss.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

                    ConnectionFactory.closeConnection(con , stmt);

		}

		return Materiais;
	}

	private List<Materiais> convertToList(ResultSet rs) throws SQLException {

		List<Materiais> materiais = new ArrayList<Materiais>();

		try {

			while (rs.next()) {

				// Material
				Materiais material = new Materiais();

				material.setId(rs.getInt("materiais.id"));
				material.setNumeroSala(rs.getInt("materiais.numeroSala"));
				material.setNomeSala(rs.getString("materiais.nomeSala"));
				material.setObservacao(rs.getString("materiais.observacao"));

				materiais.add(material);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return materiais;
	}
	
	public boolean delete(Materiais mm) throws SQLException {

 		Connection con = (Connection) ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		try {

			String sql = "DELETE FROM materiais_tb"
					+ " WHERE idMaterial = ?";
					
                        
			stmt = (PreparedStatement) con.prepareStatement(sql);
                           stmt.setInt(1, mm.getId());
			stmt.execute();
                        JOptionPane.showMessageDialog(null, "Removido!");
		} catch (SQLException e) {

			
                        JOptionPane.showMessageDialog(null, "Erro!"+e);
		} finally{

			ConnectionFactory.closeConnection(con , stmt);    
		}

		return true;
	}

	public void update(Materiais materiais) throws SQLException {

                Connection con = (Connection) ConnectionFactory.getConnection();
                PreparedStatement stmt = null;
		try {

			String sql = "UPDATE materiais_tb"
					+ " SET tipo=?, observavao=?, numeroSala=?, nomeSala=?"
					+ " WHERE id=?";

			stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setString(1, materiais.getTipo());
			
			stmt.setString(2, materiais.getObservacao());
			stmt.setLong(3, materiais.getNumeroSala());
			stmt.setString(4, materiais.getNomeSala());
			stmt.setLong(5, materiais.getId());

			stmt.execute();

		}catch (SQLException e) {

			System.out.println(e);

		} finally {
                    

			ConnectionFactory.closeConnection(con , stmt);
		}


	}




}
