package GCMU.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Pessoa;


public class PessoaDAO implements GenericDAO<Integer, Pessoa>{

	public static ConnectionFactory banco;

	public Connection connection;

	private static PessoaDAO instance;

	public PessoaDAO(ConnectionFactory banco) {

		this.connection = (Connection) banco.getConnection();
	}

	public static PessoaDAO getInstance() {

		banco = ConnectionFactory.getInstance();

		instance = new PessoaDAO(banco);

		return instance;
	}

	@Override
	public boolean insert(Pessoa pessoa) throws SQLException {

		try {

			String sql = "INSERT INTO pessoa_tb ("
					+ " matricula, "
					+ " name,"
					+ " email,"
					+ " telefone,"
					+ " senha,"
					+ " cpf,"
					+ " VALUES (?,?,?,?,?)";
			
		

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, pessoa.getMatricula());	
			stmt.setString(2, pessoa.getName());
			stmt.setString(3, pessoa.getEmail());
			stmt.setInt(4, pessoa.getTelefone());
			stmt.setString(5, pessoa.getCpf());
			
			stmt.execute();

		} catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}

		return true;

	}

	@Override
	public Pessoa getById(Integer pk) throws SQLException {

		Pessoa pessoa = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT pessoa.matricula,"
					+ " pessoa.name,"
					+ " pessoa.sala,"
					+ " pessoa.email,"
					+ " pessoa.telefone,"
					+ " pessoa.senha,"
					+ " pessoa.cpf"
					+ " FROM pessoa_tb AS pessoa"
					+ " WHERE pessoa.m = " 
					+ pk;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Pessoa> pessoas = convertToList(rs);

			if (!pessoas.isEmpty())
				pessoa = pessoas.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return pessoa;
	}
	
	public Pessoa getByName(String name) throws SQLException {

		Pessoa pessoa = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT pessoa.matricula,"
				     +" pessoa.email,"
                     +" pessoa.telefone" 
                     +" FROM pessoa_tb AS pessoa"
                     +" WHERE pessoa.name = " + name;
                                     
                                                        

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Pessoa> pessoas = convertToListGetByName(rs);

			if (!pessoas.isEmpty())
				pessoa = pessoas.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return pessoa;
	}
	
	private List<Pessoa> convertToListGetByName(ResultSet rs) throws SQLException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {

			while (rs.next()) {

				// Pessoa
				Pessoa pessoa= new Pessoa();

				pessoa.setMatricula(rs.getInt("pessoa.matricula"));
				pessoa.setEmail(rs.getString("pessoa.email"));
				pessoa.setTelefone(rs.getInt("pessoa.telefone"));
				
	
				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return pessoas;
	}
	
	public Pessoa queryDataNome(String status) throws SQLException {

		Pessoa pessoa = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT D.data, P.name"
					+ " FROM Pessoa_Reserva_Materiais_tb D"
					+ " inner join pessoa_tb P on P.matricula = D.matricula"
					+ " inner join materiais_tb M on M.idMaterial = D.idMaterial AND M.status = "+status; 
					
			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Pessoa> pessoas = convertToListQueryDataNome(rs);

			if (!pessoas.isEmpty())
				pessoa = pessoas.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return pessoa;
	}
	
	private List<Pessoa> convertToListQueryDataNome(ResultSet rs) throws SQLException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {

			while (rs.next()) {

				// Pessoa
				Pessoa pessoa= new Pessoa();

				pessoa.setData(rs.getDate("D.data"));
				pessoa.setName(rs.getString("P.name"));
	
				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return pessoas;
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
				pessoa.setSenha(rs.getString("pessoa.senha"));
				pessoa.setCpf(rs.getString("pessoa.cpf"));
				
	
				pessoas.add(pessoa);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return pessoas;
	}

	@Override
	public boolean delete(Integer pk) throws SQLException {

		PreparedStatement stmt = null;

		try {

			String sql = "DELETE FROM pessoa_tb"
					+ " WHERE matricula = "
					+ pk;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.execute();

		} catch (SQLException e) {

			throw new RuntimeException(e);

		} finally{

			connection.close();
		}

		return true;
	}

	@Override
	public void update(Pessoa pessoa) throws SQLException {

		try {

			String sql = "UPDATE pessoa_tb"
					+ " SET matricula=?, name=?, email=?, telefone=?, senha=?, cpf=?"
					+ " WHERE matricula=?";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setLong(1, pessoa.getMatricula());
			stmt.setString(2, pessoa.getName());
			stmt.setString(3, pessoa.getEmail());
			stmt.setLong(4, pessoa.getTelefone());
			stmt.setString(5, pessoa.getSenha());
			stmt.setString(6, pessoa.getCpf());
			stmt.setLong(7, pessoa.getMatricula());

			stmt.execute();

		}catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}


	}

	@Override
	public List<Pessoa> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> find(Pessoa entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
