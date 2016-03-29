package GCMU.DataBase;

import GCMU.DataBase.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Docente;

public class DocenteDAO {

    public boolean insert(Docente docente) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
       
        try {
              
            String sql = "INSERT INTO docente_tb(suap, cargo, name, email, permissao) VALUES(?,?,?,?,?)";
            
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, docente.getSuap());
            stmt.setString(2, docente.getCargo());
            stmt.setString(3, docente.getName());
            stmt.setString(4, docente.getEmail());
            stmt.setString(5, docente.getPermissao());

            stmt.execute();

        } catch (SQLException e) {

            System.out.println(e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;

    }

    public Docente getById(Integer pk) throws SQLException {

        Docente docente = null;

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT docente.suap,"
                    + " docente.cargo,"
                    + " docente.name,"
                    + " docente.email,"
                    + " docente.permissao"
                    + " FROM docente_tb AS docente"
                    + " WHERE docente.suap = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Docente> docentes = convertToList(rs);

            if (!docentes.isEmpty()) {
                docente = docentes.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return docente;
    }

    public Docente queryCargo(String area) throws SQLException {

        Docente docente = null;
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT docente.cargo"
                    + " FROM docente_tb AS docente"
                    + " WHERE docente.area = "
                    + area;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Docente> docentes = convertToList(rs);

            if (!docentes.isEmpty()) {
                docente = docentes.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return docente;
    }

    private List<Docente> convertToList(ResultSet rs) throws SQLException {

        List<Docente> docentes = new ArrayList<Docente>();

        try {

            while (rs.next()) {

                // Pessoa
                Docente docente = new Docente();

                docente.setSuap(rs.getInt("docente.suap"));
                docente.setCargo(rs.getString("docente.cargo"));
                docente.setName(rs.getString("docente.name"));
                docente.setEmail(rs.getString("docente.email"));
                docente.setPermissao(rs.getString("docente.permissao"));

                docentes.add(docente);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return docentes;
    }

    public boolean delete(Integer pk) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "DELETE FROM docente_tb"
                    + " WHERE suap = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.execute();

        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;
    }

    public void update(Docente docente) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE docente_tb"
                    + " SET suap=?, cargo=?, name=?, email=?, permissao=?"
                    + " WHERE suap=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setLong(1, docente.getSuap());
            stmt.setString(2, docente.getCargo());
            stmt.setString(3, docente.getName());
            stmt.setString(4, docente.getEmail());
            stmt.setString(5, docente.getPermissao());
            stmt.setLong(6, docente.getSuap());

            stmt.execute();

        } catch (SQLException e) {

            System.out.println(e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Docente> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Docente> find(Docente entity) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
