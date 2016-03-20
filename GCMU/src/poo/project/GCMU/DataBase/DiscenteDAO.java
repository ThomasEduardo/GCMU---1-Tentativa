package poo.project.GCMU.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import poo.project.GCMU.Classes.Discente;


public class DiscenteDAO implements GenericDAO<Integer, Discente>{

	public static ConnectionFactory banco;

	public Connection connection;

	private static DiscenteDAO instance;

	public DiscenteDAO(ConnectionFactory banco) {

		this.connection = (Connection) banco.getConnection();
	}

	public static DiscenteDAO getInstance() {

		banco = ConnectionFactory.getInstance();

		instance = new DiscenteDAO(banco);

		return instance;
	}

	@Override
	public boolean insert(Discente discente) throws SQLException {

		try {

			String sql = "INSERT INTO discente_tb ("
					+ " matricula, "
					+ " curso,"
					+ " sala,"
					+ " turma,"
					+ " pessoa_matricula)"
					+ " VALUES (?,?,?,?,?)";
			
		

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, discente.getMatricula());	
			stmt.setString(2, discente.getCurso());
			stmt.setString(3, discente.getSala());
			stmt.setString(4, discente.getTurma());
			stmt.setInt(5, discente.getMatricula());
			
			stmt.execute();

		} catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}

		return true;

	}

	@Override
	public Discente getById(Integer pk) throws SQLException {

		Discente discente = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT discente.matricula,"
					+ " discente.curso,"
					+ " discente.sala,"
					+ " discente.turma"
					+ " FROM discente_tb AS discente"
					+ " WHERE discente.m = " 
					+ pk;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Discente> discentes = convertToList(rs);

			if (!discentes.isEmpty())
				discente = discentes.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return discente;
	}

	private List<Discente> convertToList(ResultSet rs) throws SQLException {

		List<Discente> discentes = new ArrayList<Discente>();

		try {

			while (rs.next()) {

				// Pessoa
				Discente discente = new Discente();

				discente.setMatricula(rs.getInt("discente.Matricula"));
				discente.setCurso(rs.getString("discente.Curso"));
				discente.setSala(rs.getString("	discente.Sala"));
				discente.setTurma(rs.getString("discente.Turma"));
				
				discentes.add(discente);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return discentes;
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
	public void update(Discente entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Discente> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Discente> find(Discente entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
