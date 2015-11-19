package dao;

import bean.TrabalhosPublicacosBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrabalhosDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    static Connection connection;

    public TrabalhosDao() throws ClassNotFoundException {
        TrabalhosDao.connection = new FabricaConexao().getConnection();
    }

    public boolean insere(TrabalhosPublicacosBean p) throws SQLException, ClassNotFoundException, Exception {
        String sql1 = "SELECT * FROM tbpublicados WHERE nome= '" + p.getNome().replace("'", "") + "' "
                + "AND ano = '" + p.getAno() + "' AND pais= '" + p.getPais().getId() + "' "
                + "AND TipoPublicados_id_TipoPublicados='" + p.getId_TipoPublicados().getId() + "' "
                + "AND Curriculo_id_Curriculo = '" + p.getId_Curriculo() + "' ;";
        try {
            PreparedStatement stmt = null;
            ResultSet rs = stmt().executeQuery(sql1);
            if (!rs.next()) {
                String sql = "INSERT INTO tbpublicados"
                        + "(nome, ano, pais, TipoPublicados_id_TipoPublicados, Curriculo_id_Curriculo) VALUES(?,?,?,?,?)";
                stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, p.getNome());
                stmt.setInt(2, p.getAno());
                stmt.setString(3, p.getPais().getId());
                stmt.setString(4, p.getId_TipoPublicados().getId());
                stmt.setString(5, p.getId_Curriculo());
                stmt.executeUpdate();
                stmt.close();
            }
            stmt().close();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(TrabalhosDao.connection);
        }
    }

    public boolean deletaPorCurriculo(String id) throws SQLException, ClassNotFoundException, Exception {
        String sql = "DELETE FROM tbpublicados WHERE Curriculo_id_Curriculoo  = ?";
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql);
            stmt.setString(1, id);
            int ok = stmt.executeUpdate();
            stmt.close();
            if (ok == 1) {
                System.out.println("Trabalhos removido com sucesso no BD!");
                return true;
            } else {
                System.out.println("Erro ao remover Trabalhos no BD!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover Trabalhos no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(TrabalhosDao.connection);
        }
    }

    public boolean deleta(String id) throws SQLException, ClassNotFoundException, Exception {
        String sql = "DELETE FROM tbpublicados WHERE id_TbPublicados  = ?";
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql);
            stmt.setString(1, id);
            int ok = stmt.executeUpdate();
            stmt.close();
            if (ok == 1) {
                System.out.println("Trabalhos removido com sucesso no BD!");
                return true;
            } else {
                System.out.println("Erro ao remover Trabalhos no BD!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover Trabalhos no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(TrabalhosDao.connection);
        }
    }

    public boolean atualiza(TrabalhosPublicacosBean p, String id) throws Exception {
        PreparedStatement stmt = null;
        String sql = "UPDATE tbpublicados SET nome=? ,ano=? ,pais=? ,TipoPublicados_id_TipoPublicados=? WHERE id_TbPublicados = ?";
        try {
            stmt = com().prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setInt(2, p.getAno());
            stmt.setString(3, p.getPais().getId());
            stmt.setString(4, p.getId_TipoPublicados().getId());
            stmt.setInt(5, p.getId_TbPublicados());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Trabalhos no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(TrabalhosDao.connection);
        }
    }

    public List<TrabalhosPublicacosBean> listarTrabalhosIdCu(String idC) throws SQLException, ClassNotFoundException, Exception {
        List<TrabalhosPublicacosBean> result = new ArrayList<>();
        String sql = "SELECT * FROM tbpublicados where Curriculo_id_Curriculo = " + idC;
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);
            PaisDao paisdao;
            TipoTrabalhoDao tipoTrab;
            while (rs.next()) {
                tipoTrab = new TipoTrabalhoDao();
                paisdao = new PaisDao();
                TrabalhosPublicacosBean trabalhoBean = new TrabalhosPublicacosBean();
                trabalhoBean.setId_TbPublicados(rs.getInt("id_TbPublicados"));
                trabalhoBean.setId_TipoPublicados(tipoTrab.listarTipoID(rs.getString("TipoPublicados_id_TipoPublicados")));
                trabalhoBean.setNome(rs.getString("nome"));
                trabalhoBean.setAno(rs.getInt("ano"));
                trabalhoBean.setPais(paisdao.seledctPorID(rs.getString("pais")));
                result.add(trabalhoBean);
            }
            stmt.close();
            stmt().close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(TrabalhosDao.connection);
        }
    }

    public TrabalhosPublicacosBean obtemTrabalhos(String id_curri) throws Exception {
        TrabalhosPublicacosBean tbpublicados = null;
        String sql = "SELECT * FROM tbpublicados WHERE Curriculo_id_Curriculo = " + id_curri;
        PaisDao paisdao;
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);
            while (rs.next()) {
                paisdao = new PaisDao();
                tbpublicados = new TrabalhosPublicacosBean();
                tbpublicados.setId_TbPublicados(rs.getInt("id_TbPublicados"));
                tbpublicados.setNome(rs.getString("nome"));
                tbpublicados.setAno(rs.getInt("ano"));
                tbpublicados.setPais(paisdao.seledctPorID(rs.getString("pais")));
            }
            stmt.close();
            stmt().close();
            return tbpublicados;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar tbpublicados no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(TrabalhosDao.connection);
        }
    }

}
