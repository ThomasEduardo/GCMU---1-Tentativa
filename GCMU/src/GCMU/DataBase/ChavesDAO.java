package GCMU.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Chaves;

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
					+ " idChave,"
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

	public Chaves queryStatus(Integer number, String sala) throws SQLException {

		Chaves chaves = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT chaves.status,"
					+ " chaves.observacao"
					+" FROM chaves_tb AS chaves"
					+" WHERE chaves.nomeSala =" + sala
					+" OR chaves.numeroSala =" + number;


			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Chaves> chavess = convertToListQueryStatus(rs);

			if (!chavess.isEmpty())
				chaves = chavess.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return chaves;
	}

	private List<Chaves> convertToListQueryStatus(ResultSet rs) throws SQLException {

		List<Chaves> chavess = new ArrayList<Chaves>();

		try {

			while (rs.next()) {

				// Chaves
				Chaves chaves = new Chaves();

				chaves.setStatus(rs.getString("chaves.status"));
				chaves.setObservacao(rs.getString("chaves.observacao"));

				chavess.add(chaves);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return chavess;
	}

	@Override
	public Chaves getById(Integer pk) throws SQLException {

		Chaves chaves = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT chaves.idChave,"
					+ " chaves.numeroSala,"
					+ " chaves.nomeSala,"
					+ " chaves.obersevacao,"
					+ " FROM chaves_tb AS chaves"
					+ " WHERE chaves.idChave = " 
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

				chaves.setId(rs.getInt("chaves.idChave"));
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


	public Chaves queryIdChave(String status) throws SQLException {

		Chaves chaves = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT chaves.idChave"
					+" FROM chaves_tb AS chaves"
					+" WHERE chaves.status =" + status;


			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Chaves> chavess = convertToListQueryIdChave(rs);

			if (!chavess.isEmpty())
				chaves = chavess.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return chaves;
	}

	private List<Chaves> convertToListQueryIdChave(ResultSet rs) throws SQLException {

		List<Chaves> chavess = new ArrayList<Chaves>();

		try {

			while (rs.next()) {

				// Chaves
				Chaves chaves = new Chaves();

				chaves.setId(rs.getInt("chaves.idChave"));

				chavess.add(chaves);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return chavess;
	}

	public Chaves queryNumeroNomeSala(Integer id) throws SQLException {

		Chaves chaves = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT numeroSala,"
					+" nomeSala"
					+" FROM chaves_tb"
					+" WHERE idChave =" + id;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Chaves> chavess = convertToListQueryNumeroNomeSala(rs);

			if (!chavess.isEmpty())
				chaves = chavess.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return chaves;
	}

	private List<Chaves> convertToListQueryNumeroNomeSala(ResultSet rs) throws SQLException {

		List<Chaves> chavess = new ArrayList<Chaves>();

		try {

			while (rs.next()) {

				// Chaves
				Chaves chaves = new Chaves();

				chaves.setNomeSala(rs.getString("nomeSala"));
				chaves.setNumeroSala(rs.getInt("numeroSala"));

				chavess.add(chaves);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return chavess;
	}

	public Chaves queryStatusForNomeSala(String nomeSala) throws SQLException {

		Chaves chaves = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT status"
					+" FROM chaves_tb"
					+" WHERE  nomeSala=" +nomeSala;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Chaves> chavess = convertToListQueryStatusForNomeSala(rs);

			if (!chavess.isEmpty())
				chaves = chavess.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return chaves;
	}

	private List<Chaves> convertToListQueryStatusForNomeSala(ResultSet rs) throws SQLException {

		List<Chaves> chavess = new ArrayList<Chaves>();

		try {

			while (rs.next()) {

				// Chaves
				Chaves chaves = new Chaves();

				chaves.setStatus(rs.getString("status"));

				chavess.add(chaves);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return chavess;
	}
	
	public Chaves queryDataNome(String status) throws SQLException {

		Chaves chaves = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT R.data , P.name" 
					+" FROM Pessoa_Reserva_Chaves_tb R"
					+" inner join pessoa_tb P"
					+" on P.matricula = R.matricula"
					+" inner join chaves_tb C"
					+" on C.idchave = R.idChave"
					+" AND C.status =" + status;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Chaves> chavess = convertToListQueryDataNome(rs);

			if (!chavess.isEmpty())
				chaves = chavess.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return chaves;
	}
	
	private List<Chaves> convertToListQueryDataNome(ResultSet rs) throws SQLException {

		List<Chaves> chavess = new ArrayList<Chaves>();

		try {

			while (rs.next()) {

				// Chaves
				Chaves chaves = new Chaves();

				chaves.setStatus(rs.getString("status"));

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
					+ " WHERE idChave = "
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
	public void update(Chaves chaves) throws SQLException {

		try {

			String sql = "UPDATE chaves_tb"
					+ " SET idChave=?, numeroSala=?, nomeSala=?, observacao=?"
					+ " WHERE id=?";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setLong(1, chaves.getId());
			stmt.setInt(2, chaves.getNumeroSala());
			stmt.setString(3, chaves.getNomeSala());
			stmt.setString(4, chaves.getObservacao());
			stmt.setLong(5, chaves.getId());

			stmt.execute();

		}catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}


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
