package GCMU.DataBase;

import GCMU.classes.Chaves;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Pessoa;
import javax.swing.JOptionPane;


public class PessoaDAO {

	
	public boolean insert(Pessoa pessoa) {

                Connection con = (Connection) ConnectionFactory.getConnection();

                PreparedStatement stmt = null;

		try {	

			String sql = "INSERT INTO pessoa_tb(matricula, name, email, telefone) VALUES(?,?,?,?)";

			stmt = (PreparedStatement) con.prepareStatement(sql);

				
			stmt.setInt(1, pessoa.getMatricula());
			stmt.setString(2, pessoa.getName());
			stmt.setString(3, pessoa.getEmail());
			stmt.setInt(4, pessoa.getTelefone());			

			stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Salvo!");

		} catch (SQLException e) {

			JOptionPane.showMessageDialog(null, "ERRO"+e);

		} finally {

			ConnectionFactory.closeConnection(con , stmt);      
		}

		return true;

	}
	
	public Pessoa getById(Integer pk) throws SQLException {

                Connection con = (Connection) ConnectionFactory.getConnection();
                
		Pessoa pessoa = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT pessoa.matricula,"
					+ " pessoa.name,"
					+ " pessoa.sala,"
					+ " pessoa.email,"
					+ " pessoa.telefone,"
					+ " pessoa.cpf"
					+ " FROM pessoa_tb AS pessoa"
					+ " WHERE pessoa.m = " 
					+ pk;

			stmt = (PreparedStatement) con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Pessoa> pessoas = convertToList(rs);

			if (!pessoas.isEmpty())
				pessoa = pessoas.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

                    ConnectionFactory.closeConnection(con , stmt);
			
		}

		return pessoa;
	}
	
	private List<Pessoa> convertToList(ResultSet rs) throws SQLException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {

			while (rs.next()) {

				// Pessoa
				Pessoa pessoa= new Pessoa();

				pessoa.setMatricula(rs.getInt("pessoa.Matricula"));
				pessoa.setName(rs.getString("pessoa.name"));
				pessoa.setEmail(rs.getString("pessoa.email"));
				pessoa.setTelefone(rs.getInt("pessoa.telefone"));

				
	
				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return pessoas;
	}
	
	public boolean delete(Integer pk) throws SQLException {

		Connection con = (Connection) ConnectionFactory.getConnection();

		PreparedStatement stmt = null;

		try {

			String sql = "DELETE FROM pessoa_tb"
					+ " WHERE matricula = "
					+ pk;

			stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.execute();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		} finally{

			 ConnectionFactory.closeConnection(con , stmt);
		}

		return true;
	}

	public void update(Pessoa pessoa) throws SQLException {

		 Connection con = (Connection) ConnectionFactory.getConnection();
                    PreparedStatement stmt = null;
		try {

			String sql = "UPDATE pessoa_tb"
					+ " SET matricula=?, name=?, email=?, telefone=?"
					+ " WHERE matricula=?";

			stmt = (PreparedStatement) con.prepareStatement(sql);

			stmt.setLong(1, pessoa.getMatricula());
			stmt.setString(2, pessoa.getName());
			stmt.setString(3, pessoa.getEmail());
			stmt.setLong(4, pessoa.getTelefone());
			stmt.setLong(5, pessoa.getMatricula());

			stmt.execute();

		}catch (SQLException e) {

			System.out.println(e);

		} finally {
                     

			ConnectionFactory.closeConnection(con , stmt);

		}


	}
}