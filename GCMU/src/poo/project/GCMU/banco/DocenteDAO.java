package poo.project.GCMU.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import poo.project.GCMU.Docente;

public class DocenteDAO implements GenericDAO<Integer, Docente>{

	public static ConnectionFactory banco;

	public Connection connection;

	private static DocenteDAO instance;

	public DocenteDAO(ConnectionFactory banco) {

		this.connection = (Connection) banco.getConnection();
	}

	public static DocenteDAO getInstance() {

		banco = ConnectionFactory.getInstance();

		instance = new DocenteDAO(banco);

		return instance;
	}

	@Override
	public boolean insert(Docente docente) throws SQLException {

		try {

			String sql = "INSERT INTO docente_tb ("
					+ " matricula, "
					+ " name,"
					+ " email,"
					+ " senha,"
					+ " telefone,"
					+ " cpf,"
					+ " cargo,"
					+ " area,"
					+ " turno)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, docente.getMatricula());
			stmt.setString(2, docente.getName());
			stmt.setString(3, docente.getEmail());
			stmt.setString(4, docente.getSenha());
			stmt.setInt(5, docente.getTelefone());
			stmt.setString(6, docente.getCpf());	
			stmt.setString(7, docente.getCargo());
			stmt.setString(8, docente.getArea());
			stmt.setString(9, docente.getTurno());
			
			stmt.execute();

		} catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}

		return true;

	}

	@Override
	public Docente getById(Integer pk) throws SQLException {

		Docente docente = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT docente.matricula,"
					+ " docente.name,"
					+ " docente.email"
					+ " docente.senha"
					+ " docente.telefone"
					+ " docente.cpf"
					+ " docente.cargo"
					+ " docente.area"
					+ " docente.turno"
					+ " FROM docente_tb AS docente"
					+ " WHERE docente.siap = " 
					+ pk;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Docente> docentes = convertToList(rs);

			if (!docentes.isEmpty())
				docente = docentes.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return docente;
	}

	private List<Docente> convertToList(ResultSet rs) throws SQLException {

		List<Docente> docentes = new ArrayList<Docente>();

		try {

			while (rs.next()) {

				// Pessoa
				Docente docente = new Docente();

				docente.setMatricula(rs.getInt("docente.matricula"));
				docente.setName(rs.getString("docente.name"));
				docente.setEmail(rs.getString("docente.email"));
				docente.setSenha(rs.getString("docente.senha"));
				docente.setTelefone(rs.getInt("docente.telefone"));
				docente.setCpf(rs.getString("docente.cpf"));
				docente.setCargo(rs.getString("docente.cargo"));
				docente.setArea(rs.getString("docente.area"));
				docente.setTurno(rs.getString("docente.turno"));
				
				docentes.add(docente);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return docentes;
	}

	@Override
	public boolean delete(Integer pk) throws SQLException {

		PreparedStatement stmt = null;

		try {

			String sql = "DELETE FROM docente_tb"
					+ " WHERE siap = "
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
	public void update(Docente entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Docente> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Docente> find(Docente entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
