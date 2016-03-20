package poo.project.GCMU.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import poo.project.GCMU.classes.Chaves;

public class ChavesDAO implements GenericDAO<Integer, Chaves>{

	public static ConnectionFactory banco;

	public Connection connection;

	private static ChavesDAO instance;

	public ChavesDAO(ConnectionFactory banco) {

		this.connection = (Connection) banco.getConnection();
	}

	public static ChavesDAO getInstance() {

		banco = ConnectionFactory.getInstance();

		instance = new ChavesDAO(banco);

		return instance;
	}

	@Override
	public boolean insert(Chaves chaves) throws SQLException {

		try {
		
	
			
				String sql = "INSERT INTO chaves_tb ("
					+ " id,"
					+ " numeroSala, "
					+ " nomeSala, "
					+ " observacao,"
					+ " VALUES (?,?,?,?)";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, chaves.getId());	
			stmt.setInt(2, chaves.getNumeroSala());
			stmt.setString(3, chaves.getNomeSala());
			stmt.setString(4, chaves.getObservacao());
			
			stmt.execute();

		} catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}

		return true;

	}

	@Override
	public Chaves getById(Integer pk) throws SQLException {

		Chaves chaves = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT chaves.id,"
					+ " chaves.numeroSala,"
					+ " chaves.nomeSala,"
					+ " chaves.obersevacao,"
					+ " FROM chaves_tb AS chaves"
					+ " WHERE chaves.id = " 
					+ pk;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Chaves> chavess = convertToList(rs);

			if (!chavess.isEmpty())
				chaves = chavess.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return chaves;
	}

	private List<Chaves> convertToList(ResultSet rs) throws SQLException {

		List<Chaves> chavess = new ArrayList<Chaves>();

		try {

			while (rs.next()) {

				// Chaves
				Chaves chaves = new Chaves();

				chaves.setId(rs.getInt("chaves.id"));
				chaves.setNumeroSala(rs.getInt("chaves.numeroSala"));
				chaves.setNomeSala(rs.getString("chaves.nomeSala"));
				chaves.setObservacao(rs.getString("chaves.observacao"));
				
				chavess.add(chaves);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return chavess;
	}

	@Override
	public boolean delete(Integer pk) throws SQLException {

		PreparedStatement stmt = null;

		try {

			String sql = "DELETE FROM chaves_tb"
					+ " WHERE id = "
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
	public void update(Chaves entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Chaves> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Chaves> find(Chaves entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
