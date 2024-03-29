package GCMU.DataBase;

import GCMU.classes.Chaves;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;

import GCMU.classes.Materiais;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MateriaisDAO {

    public boolean insert(Materiais materiais) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "INSERT INTO materiais_tb(tipo, status, observacao, numeroSala, nomeSala) VALUES(?,?,?,?,?)";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, materiais.getTipo());
            stmt.setString(2, materiais.getStatus());
            stmt.setString(3, materiais.getObservacao());
            stmt.setInt(4, materiais.getNumeroSala());
            stmt.setString(5, materiais.getNomeSala());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo!");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "ERRO" + e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;

    }

    public Materiais getById(Integer pk) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

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

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Materiais> Materiaiss = convertToList(rs);

            if (!Materiaiss.isEmpty()) {
                Materiais = Materiaiss.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            ConnectionFactory.closeConnection(con, stmt);

        }

        return Materiais;
    }
    public List<Materiais> read(){
                Connection con = (Connection) ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
                List<Materiais> m = new ArrayList<Materiais>();
               
            try {
                 String sql = "SELECT * FROM materiais_tb";
                 
                stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();
                
                
                while(rs.next()){
                    Materiais u = new Materiais();
                    u.setId(rs.getInt("idMaterial"));
                    u.setTipo(rs.getString("tipo"));
                    u.setStatus(rs.getString("status"));
                    u.setObservacao(rs.getString("observacao"));
                    u.setNomeSala(rs.getString("nomeSala"));
                    u.setNumeroSala(rs.getInt("numeroSala"));
                    m.add(u);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(ChavesDAO.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                    ConnectionFactory.closeConnection(con, stmt, rs);
            }
            
            return m;
            
        }

    public Materiais queryDataNomeDocente(String status) throws SQLException {

        Connection con = (Connection) GCMU.DataBase.ConnectionFactory.getConnection();

        Materiais material = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT R.data, D.name"
                    + " FROM Docente_Reserva_Materiais_tb R"
                    + " inner join docente_tb D"
                    + " on D.suap = R.suap"
                    + " inner join materiais_tb M"
                    + " on M.idMaterial = R.idMaterial"
                    + " AND M.status =" + status;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Materiais> materiais = convertToList(rs);

            if (!materiais.isEmpty()) {
                material = materiais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            GCMU.DataBase.ConnectionFactory.closeConnection(con, stmt);

        }

        return material;
    }

    public Materiais queryDataNomeDiscente(String status) throws SQLException {

        Connection con = (Connection) GCMU.DataBase.ConnectionFactory.getConnection();

        Materiais material = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT R.data, D.name"
                    + " FROM Discente_Reserva_Materiais_tb R"
                    + " inner join discente_tb D"
                    + " on D.matricula = R.matricula"
                    + " inner join materiais_tb M"
                    + " on M.idMaterial = R.idMaterial"
                    + " AND M.status =" + status;

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Materiais> materiais = convertToList(rs);

            if (!materiais.isEmpty()) {
                material = materiais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            GCMU.DataBase.ConnectionFactory.closeConnection(con, stmt);

        }

        return material;
    }

    public Materiais queryDataDadosDiscente(Date data) throws SQLException {

        Connection con = (Connection) GCMU.DataBase.ConnectionFactory.getConnection();

        Materiais material = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT D.matricula, M.tipo, M.nomeSala, M.numeroSala, D.horaPedido"
                    + " FROM Discente_Reserva_Materiais_tb R"
                    + " inner join discente_tb D"
                    + " on D.matricula = R.matricula and R.data =" + data
                    + " inner join materiais_tb M"
                    + " M.idMaterial = R.idMaterial";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Materiais> materiais = convertToList(rs);

            if (!materiais.isEmpty()) {
                material = materiais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            GCMU.DataBase.ConnectionFactory.closeConnection(con, stmt);

        }

        return material;
    }

    public Materiais queryDataDadosDocente(Date data) throws SQLException {

        Connection con = (Connection) GCMU.DataBase.ConnectionFactory.getConnection();

        Materiais material = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT D.matricula, M.tipo, M.nomeSala, M.numeroSala, D.horaPedido"
                    + " FROM Docente_Reserva_Materiais_tb R"
                    + " inner join docente_tb D"
                    + " on D.suap = R.suap and R.data =" + data
                    + " inner join materiais_tb M"
                    + " M.idMaterial = R.idMaterial";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Materiais> materiais = convertToList(rs);

            if (!materiais.isEmpty()) {
                material = materiais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {

            GCMU.DataBase.ConnectionFactory.closeConnection(con, stmt);

        }

        return material;
    }

    public Materiais queryHoraDevoDataDiscente() throws SQLException {
        Connection con = (Connection) GCMU.DataBase.ConnectionFactory.getConnection();

        Materiais material = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT R.horaDevolucao, R.data"
                    + " FROM Discente_Reserva_Materiais_tb R"
                    + " inner join discente_tb D"
                    + " on D.matricula = R.matricula"
                    + " inner join materiais_tb M"
                    + " M.idMaterial = R.idMaterial";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Materiais> materiais = convertToList(rs);

            if (!materiais.isEmpty()) {
                material = materiais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            GCMU.DataBase.ConnectionFactory.closeConnection(con, stmt);

        }

        return material;
    }

    public Materiais queryHoraDevoDataDocente() throws SQLException {
        Connection con = (Connection) GCMU.DataBase.ConnectionFactory.getConnection();

        Materiais material = null;

        PreparedStatement stmt = null;

        ResultSet rs = null;

        try {

            String sql = "SELECT R.horaDevolucao, R.data"
                    + " FROM Docente_Reserva_Materiais_tb R"
                    + " inner join docente_tb D"
                    + " on D.suap = R.suap"
                    + " inner join materiais_tb M"
                    + " M.idMaterial = R.idMaterial";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            rs = stmt.executeQuery(sql);

            List<Materiais> materiais = convertToList(rs);

            if (!materiais.isEmpty()) {
                material = materiais.get(0);
            }

        } catch (SQLException sqle) {

            throw sqle;

        } finally {
            GCMU.DataBase.ConnectionFactory.closeConnection(con, stmt);

        }

        return material;
    }

    private List<Materiais> convertToList(ResultSet rs) throws SQLException {

        List<Materiais> materiais = new ArrayList<Materiais>();

        try {

            while (rs.next()) {

                // Material
                Materiais material = new Materiais();

                material.setId(rs.getInt("materiais.id"));
                material.setNumeroSala(rs.getInt("materiais.numeroSala"));
                material.setNomeSala(rs.getString("materiais.nomeSala"));
                material.setObservacao(rs.getString("materiais.observacao"));

                DocenteDAO docentedao = new DocenteDAO();
                material.setDocente(docentedao.getById(rs.getInt("docente.suap")));

                DiscenteDAO discentedao = new DiscenteDAO();
                material.setDiscente(discentedao.getById(rs.getInt("discente.matricula")));

                DiscenteReservaMaterialDAO discenteReservaMaterialDAO = new DiscenteReservaMaterialDAO();
                material.setDiscenteReserva(discenteReservaMaterialDAO.getById(rs.getInt("id")));

                DocenteReservaMaterialDAO docenteReservaMaterialDAO = new DocenteReservaMaterialDAO();
                material.setDocenteReserva(docenteReservaMaterialDAO.getById(rs.getInt("id")));

                materiais.add(material);
            }

        } catch (SQLException sqle) {

            throw sqle;
        }

        return materiais;
    }

    public boolean delete(Materiais mm) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {

            String sql = "DELETE FROM materiais_tb"
                    + " WHERE idMaterial = ?";

            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setInt(1, mm.getId());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Removido!");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Erro!" + e);
        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

        return true;
    }

    public void update(Materiais materiais) throws SQLException {

        Connection con = (Connection) ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {

            String sql = "UPDATE materiais_tb"
                    + " SET tipo=?, observavao=?, numeroSala=?, nomeSala=?"
                    + " WHERE id=?";

            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, materiais.getTipo());

            stmt.setString(2, materiais.getObservacao());
            stmt.setLong(3, materiais.getNumeroSala());
            stmt.setString(4, materiais.getNomeSala());
            stmt.setLong(5, materiais.getId());

            stmt.execute();

        } catch (SQLException e) {

            System.out.println(e);

        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
