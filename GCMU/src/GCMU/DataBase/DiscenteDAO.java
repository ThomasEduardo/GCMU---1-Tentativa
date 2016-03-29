package GCMU.DataBase;

import GCMU.DataBase.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Discente;
import javax.swing.JOptionPane;

public class DiscenteDAO {

    public boolean insert(Discente discente) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            
             String sql = "INSERT INTO discente_tb(matricula, curso, name, email, permissao) VALUES(?,?,?,?,?)";

             stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, discente.getMatricula());
            stmt.setString(2, discente.getCurso());
            stmt.setString(3, discente.getName());
            stmt.setString(4, discente.getEmail());
            stmt.setString(5, discente.getPermissao());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Salvo!");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null,e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;

    }

    public Discente getById(Integer pk) throws SQLException {

        Discente discente = null;

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT discente.matricula,"
                    + " discente.curso,"
                    + " discente.name,"
                    + " discente.email,"
                    + " discente.permissao"
                    + " FROM discente_tb AS discente"
                    + " WHERE discente.m = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Discente> discentes = convertToList(rs);

            if (!discentes.isEmpty()) {
                discente = discentes.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return discente;
    }

    private List<Discente> convertToList(ResultSet rs) throws SQLException {

        List<Discente> discentes = new ArrayList<Discente>();

        try {

            while (rs.next()) {

                // Pessoa
                Discente discente = new Discente();

                discente.setMatricula(rs.getInt("discente.matricula"));
                discente.setCurso(rs.getString("discente.curso"));
                discente.setEmail(rs.getString("discente.email"));
                discente.setPermissao("discente.permissao");
                discente.setName(rs.getString("discente.name"));

                discentes.add(discente);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return discentes;
    }

    public boolean delete(Integer pk) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "DELETE FROM discente_tb"
                    + " WHERE matricula = "
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

    public void update(Discente discente) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE discente_tb"
                    + " SET matricula=?, curso=?"
                    + " WHERE matricula=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setLong(1, discente.getMatricula());
            stmt.setString(2, discente.getCurso());
            stmt.setLong(3, discente.getMatricula());

            stmt.execute();

        } catch (SQLException e) {

            System.out.println(e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Discente> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Discente> find(Discente entity) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
