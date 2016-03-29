package GCMU.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Chaves;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ChavesDAO {

    public boolean insert(Chaves chaves) {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            String sql = "INSERT INTO chaves_tb(numeroSala, nomeSala, status) VALUES(?,?,?)";

            stmt = con.prepareStatement(sql);

            stmt.setInt(1, chaves.getNumeroSala());
            stmt.setString(2, chaves.getNomeSala());
            stmt.setString(3, chaves.getStatus());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo!");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;

    }

    private List<Chaves> read() {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Chaves> chaves = new ArrayList<Chaves>();

        try {

            String sql = "SELECT * FROM chaves_tb";

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Chaves cha = new Chaves();
                cha.setId(rs.getInt("idChave"));
                cha.setNumeroSala(rs.getInt("numeroSala"));
                cha.setNomeSala(rs.getString("nomeSala"));
                cha.setStatus(rs.getString("status"));
                chaves.add(cha);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChavesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return chaves;

    }

    public Chaves queryStatus(Integer number, String sala) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();
        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT chaves.status,"
                    + " chaves.observacao"
                    + " FROM chaves_tb AS chaves"
                    + " WHERE chaves.nomeSala =" + sala
                    + " OR chaves.numeroSala =" + number;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves getById(Integer pk) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT chaves.idChave,"
                    + " chaves.numeroSala,"
                    + " chaves.nomeSala,"
                    + " chaves.status"
                    + " FROM chaves_tb AS chaves"
                    + " WHERE chaves.idChave = "
                    + pk;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    private List<Chaves> convertToList(ResultSet rs) throws SQLException {

        List<Chaves> chaves = new ArrayList<Chaves>();

        try {

            while (rs.next()) {

                // Chaves
                Chaves chave = new Chaves();

                chave.setId(rs.getInt("chaves.idChave"));
                chave.setNumeroSala(rs.getInt("chaves.numeroSala"));
                chave.setNomeSala(rs.getString("chaves.nomeSala"));
                chave.setStatus(rs.getString("chaves.status"));

                DocenteDAO docente = new DocenteDAO();
                chave.setDocente(docente.getById(rs.getInt("docente.suap")));

                DiscenteDAO discente = new DiscenteDAO();
                chave.setDiscente(discente.getById(rs.getInt("discente.matricula")));

                DiscenteReservaChaveDAO discenteReservaChaveDAO = new DiscenteReservaChaveDAO();
                chave.setDiscenteReserva(discenteReservaChaveDAO.getById(rs.getInt("id")));

                DocenteReservaChaveDAO docenteReservaChaveDAO = new DocenteReservaChaveDAO();
                chave.setDocenteReserva(docenteReservaChaveDAO.getById(rs.getInt("id")));

                chaves.add(chave);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return chaves;
    }

    public Chaves queryIdChave(String status) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT chaves.idChave"
                    + " FROM chaves_tb AS chaves"
                    + " WHERE chaves.status =" + status;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves queryNumeroNomeSala(Integer id) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT numeroSala,"
                    + " nomeSala"
                    + " FROM chaves_tb"
                    + " WHERE idChave =" + id;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves queryStatusForNomeSala(String nomeSala) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT status"
                    + " FROM chaves_tb"
                    + " WHERE  nomeSala=" + nomeSala;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves queryDataNomeDocente(String status) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT R.data, D.name"
                    + " FROM Docente_Reserva_Chaves_tb R"
                    + " inner join docente_tb D"
                    + " on D.suap = R.suap"
                    + " inner join chaves_tb C"
                    + " on C.idChave = R.idChave"
                    + " AND C.status =" + status;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves queryDataNomeDiscente(String status) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT R.data , P.name"
                    + " FROM Discente_Reserva_Chaves_tb R"
                    + " inner join discente_tb D"
                    + " on D.matricula = R.matricula"
                    + " inner join chaves_tb C"
                    + " on C.idchave = R.idChave"
                    + " AND C.status =" + status;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves queryDataDadosDocente(Date data) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT D.suap, C.numeroSala, C.nomeSala, A.horaPedido"
                    + " FROM Docente_Reserva_Chaves_tb A"
                    + " inner join docente_tb D"
                    + " on D.suap = A.suap AND A.data =" + data
                    + " inner join chaves_tb C"
                    + " on C.idChave= A.idChave";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves queryDataDadosDiscente(Date data) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT D.matricula, C.numeroSala, C.nomeSala, A.horaPedido"
                    + " FROM Discente_Reserva_Chaves_tb A"
                    + " inner join discente_tb D"
                    + " on D.matricula = A.matricula AND A.data =" + data
                    + " inner join chaves_tb C"
                    + " on C.idChave= A.idChave";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves queryHoraDevoDataDiscente() throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT R.horaDevolucao, R.data"
                    + " FROM Discente_Reserva_Chaves_tb R"
                    + " inner join discente_tb D"
                    + " on D.matricula = R.matricula"
                    + " inner join chaves_tb C"
                    + " on C.idchave = R.idChave";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public Chaves queryHoraDevoDataDocente() throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        Chaves chaves = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT R.horaDevolucao, R.data"
                    + " FROM Docente_Reserva_Chaves_tb R"
                    + " inner join docente_tb D"
                    + " on D.suap = R.suap"
                    + " inner join chaves_tb C"
                    + " on C.idchave = R.idChave";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Chaves> chavess = convertToList(rs);

            if (!chavess.isEmpty()) {
                chaves = chavess.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return chaves;
    }

    public boolean delete(Chaves c) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "DELETE FROM chaves_tb"
                    + " WHERE idChave = ? ";

            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, c.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido!");
        } catch (SQLException e) {

            throw new RuntimeException(e);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

        return true;
    }

    public void update(Chaves chaves) throws SQLException {
        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE chaves_tb"
                    + " SET numeroSala=?, nomeSala=?, status=?"
                    + " WHERE idChave=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setInt(1, chaves.getNumeroSala());
            stmt.setString(2, chaves.getNomeSala());
            stmt.setString(3, chaves.getStatus());
            stmt.setLong(4, chaves.getId());

            stmt.execute();
            JOptionPane.showMessageDialog(null, "Alterado!");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }

    }

    public List<Chaves> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Chaves> find(Chaves entity) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
