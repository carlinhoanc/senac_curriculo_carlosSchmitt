package dao;

import bean.FormacaoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormacaoDao {

    private Connection connection;

    public boolean insere(FormacaoBean p) throws SQLException, ClassNotFoundException, Exception {
        String sql1 = "SELECT * FROM formacao "
                + "WHERE nomeInstitui= '" + p.getNomeInstitui() + "' "
                + "AND dataInicio='" + p.getDataInicio() + "' "
                + "AND dataTermino= '" + p.getDataTermino() + "' "
                + "AND id_Tipo='" + p.getId_Tipo().getId_Tipo() + "' "
                + "AND Curriculo_id_Curriculo='" + p.getCurriculo_id_Curriculo() + "' ;";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                String sql = "INSERT INTO formacao "
                        + "(nomeInstitui, dataInicio, dataTermino, id_Tipo, Curriculo_id_Curriculo)"
                        + " VALUES(?,?,?,?,?)";
                stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, p.getNomeInstitui());
                stmt.setString(2, p.getDataInicio());
                stmt.setString(3, p.getDataTermino());
                stmt.setString(4, p.getId_Tipo().getId_Tipo());
                stmt.setString(5, p.getCurriculo_id_Curriculo());
                stmt.executeUpdate();
                stmt.close();
            }
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Formação no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean deleta(String id) throws SQLException, ClassNotFoundException, Exception {
        boolean removidoSucesso = false;
        String sql = "DELETE FROM formacao WHERE id_Formacao  = ?";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, id);
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Formação removido com sucesso no BD!");
                removidoSucesso = true;
            } else {
                System.out.println("Erro ao remover Formação no BD!");
                removidoSucesso = false;
            }
            stmt.close();
            return removidoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Formação no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean deletaPorCurriculo(String id) throws SQLException, ClassNotFoundException, Exception {
        boolean removidoSucesso = false;
        String sql = "DELETE FROM formacao WHERE Curriculo_id_Curriculo = " + id;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Formação removido com sucesso no BD!");
                removidoSucesso = true;
            } else {
                System.out.println("Erro ao remover Formação no BD!");
                removidoSucesso = false;
            }
            stmt.close();
            return removidoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Formação no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean atualiza(FormacaoBean p) throws Exception {
        boolean atualizadoSucesso = false;
        String sql = "UPDATE formacao SET nomeInstitui= ? ,dataInicio=?, dataTermino=?, id_Tipo=? WHERE id_Formacao = ?";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getNomeInstitui());
            stmt.setString(2, p.getDataInicio());
            stmt.setString(3, p.getDataTermino());
            stmt.setString(3, p.getDataTermino());
            stmt.setString(4, p.getId_Tipo().getId_Tipo());
            stmt.setInt(5, p.getId());
            stmt.executeUpdate();
            stmt.close();
            atualizadoSucesso = true;
            return atualizadoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Formação no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<FormacaoBean> listarFormacaoIdCu(String idC) throws SQLException, ClassNotFoundException, Exception {
        List<FormacaoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM formacao where Curriculo_id_Curriculo = " + idC;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
        } catch (Exception e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<FormacaoBean> listarFormacaoId(String idC) throws SQLException, ClassNotFoundException, Exception {
        List<FormacaoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM formacao where id_Formacao = " + idC;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
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
        } catch (Exception e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public FormacaoBean obtemFormacao(String id_curri) throws Exception {
        FormacaoBean formacaoBean = null;
        String sql = "SELECT * FROM formacao WHERE Curriculo_id_Curriculo = " + id_curri;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            TipoFormacaoDao tipoFormacaoDao;
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
            FabricaConexao.fechaConexao(this.connection);
        }
    }

}
