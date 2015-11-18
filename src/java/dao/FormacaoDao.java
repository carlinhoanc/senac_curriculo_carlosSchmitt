package dao;

import bean.FormacaoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FormacaoDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    static Connection connection;

    public FormacaoDao() throws ClassNotFoundException {
        FormacaoDao.connection = new FabricaConexao().getConnection();
    }

    public boolean insere(FormacaoBean p) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;

        String sql1 = "SELECT * FROM formacao "
                + "WHERE nomeInstitui= '" + p.getNomeInstitui() + "' "
                + "AND dataInicio='" + p.getDataInicio() + "' "
                + "AND dataTermino= '" + p.getDataTermino() + "' "
                + "AND id_Tipo='" + p.getId_Tipo().getId_Tipo() + "' "
                + "AND Curriculo_id_Curriculo='" + p.getCurriculo_id_Curriculo() + "' ;";
        ResultSet rs = stmt().executeQuery(sql1);

        if (!rs.next()) {
            String sql = "INSERT INTO formacao "
                    + "(nomeInstitui, dataInicio, dataTermino, id_Tipo, Curriculo_id_Curriculo)"
                    + " VALUES(?,?,?,?,?)";
            stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNomeInstitui());
            stmt.setString(2, p.getDataInicio());
            stmt.setString(3, p.getDataTermino());
            stmt.setString(4, p.getId_Tipo().getId_Tipo());
            stmt.setString(5, p.getCurriculo_id_Curriculo());
            stmt.executeUpdate();
            stmt.close();
        }
        return true;
    }

    public boolean deleta(String id) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        boolean removidoSucesso = false;
        String sql = "DELETE FROM formacao WHERE id_Formacao  = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Formação removido com sucesso no BD!");
                removidoSucesso = true;
            } else {
                System.out.println("Erro ao remover Formação no BD!");
            }
            stmt.close();
            return removidoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Formação no BD!");
            throw new RuntimeException(e);
        }
    }

    public boolean deletaPorCurriculo(String id) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        boolean removidoSucesso = false;
        String sql = "DELETE FROM formacao WHERE Curriculo_id_Curriculoo  = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(id));
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Formação removido com sucesso no BD!");
                removidoSucesso = true;
            } else {
                System.out.println("Erro ao remover Formação no BD!");
            }
            stmt.close();
            return removidoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Formação no BD!");
            throw new RuntimeException(e);
        }
    }

    public boolean atualiza(FormacaoBean p) throws Exception {
        PreparedStatement stmt = null;
        boolean atualizadoSucesso = false;
        String sql = "UPDATE formacao SET "
                + "nomeInstitui= ? ,"
                + "dataInicio=?,"
                + "dataTermino=?,"
                + "id_Tipo=? "
                + "WHERE id_Formacao = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getNomeInstitui());
            stmt.setString(2, p.getDataInicio());
            stmt.setString(3, p.getDataTermino());
            stmt.setString(3, p.getDataTermino());
            stmt.setString(4, p.getId_Tipo().getId_Tipo());
            stmt.setInt(5, p.getId());
            stmt.executeUpdate();

            atualizadoSucesso = true;
            return atualizadoSucesso;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Formação no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(FormacaoDao.connection, stmt());
        }
    }

    public List<FormacaoBean> listarFormacaoIdCu(String idC) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        List<FormacaoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM formacao where Curriculo_id_Curriculo = " + idC;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        TipoFormacaoDao tipoFormacaoDao;
        while (rs.next()) {
            tipoFormacaoDao = new TipoFormacaoDao();
            FormacaoBean formacaoBean = new FormacaoBean();
            formacaoBean.setId(rs.getInt("id_Formacao"));
            formacaoBean.setNomeInstitui(rs.getString("nomeInstitui"));
            formacaoBean.setId_Tipo(tipoFormacaoDao.listarTipoID(rs.getString("id_Tipo")));
            formacaoBean.setDataInicio(rs.getString("dataInicio"));
            formacaoBean.setDataTermino(rs.getString("dataTermino"));
            result.add(formacaoBean);
        }
        stmt.close();
        return result;
    }

    public List<FormacaoBean> listarFormacaoId(String idC) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        List<FormacaoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM formacao where id_Formacao = " + idC;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        TipoFormacaoDao tipoFormacaoDao;
        while (rs.next()) {
            tipoFormacaoDao = new TipoFormacaoDao();
            FormacaoBean formacaoBean = new FormacaoBean();
            formacaoBean.setId(rs.getInt("id_Formacao"));
            formacaoBean.setNomeInstitui(rs.getString("nomeInstitui"));
            formacaoBean.setId_Tipo(tipoFormacaoDao.listarTipoID(rs.getString("id_Tipo")));
            formacaoBean.setDataInicio(rs.getString("dataInicio"));
            formacaoBean.setDataTermino(rs.getString("dataTermino"));
            result.add(formacaoBean);
        }
        stmt.close();
        rs.close();
        return result;
    }

    public FormacaoBean obtemFormacao(String id_curri) throws Exception {
        FormacaoBean formacaoBean = null;
        String sql = "SELECT * FROM formacao WHERE Curriculo_id_Curriculo = " + id_curri;
        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        TipoFormacaoDao tipoFormacaoDao;
        try {
            while (rs.next()) {
                tipoFormacaoDao = new TipoFormacaoDao();
                formacaoBean = new FormacaoBean();
                formacaoBean.setId(rs.getInt("id_Formacao"));
                formacaoBean.setNomeInstitui(rs.getString("nomeInstitui"));
                formacaoBean.setDataInicio(rs.getString("dataInicio"));
                formacaoBean.setDataTermino(rs.getString("dataTermino"));
                formacaoBean.setId_Tipo(tipoFormacaoDao.listarTipoID(rs.getString("id_Tipo")));
            }
            stmt.close();
            return formacaoBean;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar tbpublicados no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(FormacaoDao.connection, stmt());
        }
    }

}
