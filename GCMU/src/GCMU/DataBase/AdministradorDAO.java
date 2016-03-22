package GCMU.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Administrador;

public class AdministradorDAO implements GenericDAO<Integer, Administrador>{

	public static ConnectionFactory banco;

	public Connection connection;

	private static AdministradorDAO instance;

	public AdministradorDAO(ConnectionFactory banco) {

		this.connection = (Connection) banco.getConnection();
	}

	public static AdministradorDAO getInstance() {

		banco = ConnectionFactory.getInstance();

		instance = new AdministradorDAO(banco);

		return instance;
	}

	@Override
	public boolean insert(Administrador administrador) throws SQLException {

		try {

			String sql = "INSERT INTO administrador_tb ("
					+ " siap, "
					+ " senha, "
					+ " pessoa_matricula)"
					+ " VALUES (?,?,?)";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setInt(1, administrador.getSiap());	
			stmt.setString(2, administrador.getSenha());
			stmt.setInt(5, administrador.getMatricula());

			stmt.execute();

		} catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}

		return true;

	}

	@Override
	public Administrador getById(Integer pk) throws SQLException {

		Administrador administrador = null;

		PreparedStatement stmt = null;

		ResultSet rs = null;

		try {

			String sql = "SELECT administrador.siap,"
					+ " administrador.senha,"
					+ " FROM administrador_tb AS administrador"
					+ " WHERE administrador.siap = " 
					+ pk;

			stmt = (PreparedStatement) connection.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			List<Administrador> administradores = convertToList(rs);

			if (!administradores.isEmpty())
				administrador = administradores.get(0);

		} catch (SQLException sqle) {

			throw sqle;

		} finally {

			connection.close();
		}

		return administrador;
	}

	private List<Administrador> convertToList(ResultSet rs) throws SQLException {

		List<Administrador> administradores = new ArrayList<Administrador>();

		try {

			while (rs.next()) {

				// Administrador
				Administrador administrador = new Administrador();

				administrador.setSiap(rs.getInt("administrador.siap"));
				administrador.setSenha(rs.getString("administrador.senha"));

				administradores.add(administrador);
			}

		} catch (SQLException sqle) {

			throw sqle;
		}

		return administradores;
	}

	@Override
	public boolean delete(Integer pk) throws SQLException {

		PreparedStatement stmt = null;

		try {

			String sql = "DELETE FROM administrador_tb"
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
	public void update(Administrador administrador) throws SQLException {
		
		try {

			String sql = "UPDATE administrador_tb"
					+ " SET siap=?, senha=?"
					+ " WHERE siap=?";

			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setLong(1, administrador.getSiap());
			stmt.setString(2, administrador.getSenha());
			stmt.setLong(3, administrador.getSiap());

			stmt.execute();

		}catch (SQLException e) {

			System.out.println(e);

		} finally {

			connection.close();
		}

	}

	@Override
	public List<Administrador> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Administrador> find(Administrador entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}



}
