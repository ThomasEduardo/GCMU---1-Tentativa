package poo.project.GCMU.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import poo.project.GCMU.Pessoa;


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

			String sql = "INSERT INTO discente_tb ("
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
					+ " pessoa.email"
					+ " pessoa.telefone"
					+ " pessoa.senha"
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

	private List<Pessoa> convertToList(ResultSet rs) throws SQLException {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		try {

			while (rs.next()) {

				// Pessoa
				Pessoa pessoa= new Pessoa();

				pessoa.setMatricula(rs.getInt("pessoa.Matricula"));
				pessoa.setName(rs.getString("pessoa.name"));
				pessoa.setEmail(rs.getString("	pessoa.email"));
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

			String sql = "DELETE FROM discente_tb"
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
	public void update(Pessoa entity) throws SQLException {
		// TODO Auto-generated method stub

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
