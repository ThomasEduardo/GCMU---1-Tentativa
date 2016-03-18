package poo.project.GCMU.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import poo.project.GCMU.Materiais;

public class MateriaisDAO implements GenericDAO<Integer, Materiais>{

	public static ConnectionFactory banco;

	public Connection connection;

	private static MateriaisDAO instance;

	public MateriaisDAO(ConnectionFactory banco) {

		this.connection = (Connection) banco.getConnection();
	}

	public static MateriaisDAO getInstance() {

		banco = ConnectionFactory.getInstance();

		instance = new MateriaisDAO(banco);

		return instance;
	}

	@Override
	public boolean insert(Materiais materiais) throws SQLException {

		try {
		
		
				String sql = "INSERT INTO chaves_tb ("
					+ " id,"
					+ " tipo, "
					+ " status, "
					+ " observacao,"
					+ " numeroSala,"
					+ " nomeSala,"
					+ " VALUES (?,?,?,?,?,?)";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, materiais.getId());	
			stmt.setString(2, materiais.getTipo());
			stmt.setString(3, materiais.getStatus());
			stmt.setString(4, materiais.getObservacao());
			stmt.setInt(4, materiais.getNumeroSala());
			stmt.setString(4, materiais.getNomeSala());
			stmt.execute();

		} catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}

		return true;

	}

	@Override
	public Materiais getById(Integer pk) throws SQLException {

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

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Materiais> Materiaiss = convertToList(rs);

			if (!Materiaiss.isEmpty())
				Materiais = Materiaiss.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return Materiais;
	}

	private List<Materiais> convertToList(ResultSet rs) throws SQLException {

		List<Materiais> chavess = new ArrayList<Materiais>();

		try {

			while (rs.next()) {

				// Chaves
				Materiais materiais = new Materiais();

				materiais.setId(rs.getInt("materiais.id"));
				materiais.setNumeroSala(rs.getInt("materiais.numeroSala"));
				materiais.setNomeSala(rs.getString("materiais.nomeSala"));
				materiais.setObservacao(rs.getString("materiais.observacao"));
				
				Materiaiss.add(materiais);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return Materiaiss;
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
	public void update(Materiais entity) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Materiais> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materiais> find(Materiais entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
