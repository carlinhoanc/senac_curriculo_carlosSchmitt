package dao;

import bean.TrabalhosBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrabalhosDao {

    private Connection connection;

    public boolean insere(TrabalhosBean p) throws SQLException, ClassNotFoundException, Exception {
        String sql1 = "SELECT * FROM tbpublicados WHERE nome= '" + p.getNome().replace("'", "") + "' "
                + "AND ano = '" + p.getAno() + "' AND pais= '" + p.getPais().getId() + "' "
                + "AND TipoPublicados_id_TipoPublicados='" + p.getId_TipoPublicados().getId() + "' "
                + "AND Curriculo_id_Curriculo = '" + p.getId_Curriculo() + "' ;";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                String sql = "INSERT INTO tbpublicados"
                        + "(nome, ano, pais, TipoPublicados_id_TipoPublicados, Curriculo_id_Curriculo) VALUES(?,?,?,?,?)";
                stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, p.getNome());
                stmt.setInt(2, p.getAno());
                stmt.setString(3, p.getPais().getId());
                stmt.setString(4, p.getId_TipoPublicados().getId());
                stmt.setString(5, p.getId_Curriculo());
                stmt.executeUpdate();
                stmt.close();
            }
            stmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean deletaPorCurriculo(String id) throws SQLException, ClassNotFoundException, Exception {
        String sql = "DELETE FROM tbpublicados WHERE Curriculo_id_Curriculo  = " + id;
        System.out.println(sql);
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
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
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean deleta(String id) throws SQLException, ClassNotFoundException, Exception {
        String sql = "DELETE FROM tbpublicados WHERE id_TbPublicados  = ?";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
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
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean atualiza(TrabalhosBean p, String id) throws Exception {
        PreparedStatement stmt = null;
        String sql = "UPDATE tbpublicados SET nome=? ,ano=? ,pais=? ,TipoPublicados_id_TipoPublicados=? WHERE id_TbPublicados = ?";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
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
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<TrabalhosBean> listarTrabalhosIdCu(String idC) throws SQLException, ClassNotFoundException, Exception {
        List<TrabalhosBean> result = new ArrayList<>();
        String sql = "SELECT * FROM tbpublicados where Curriculo_id_Curriculo = " + idC;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            PaisDao paisdao;
            TipoTrabalhoDao tipoTrab;
            while (rs.next()) {
                tipoTrab = new TipoTrabalhoDao();
                paisdao = new PaisDao();
                TrabalhosBean trabalhoBean = new TrabalhosBean();
                trabalhoBean.setId_TbPublicados(rs.getInt("id_TbPublicados"));
                trabalhoBean.setId_TipoPublicados(tipoTrab.listarTipoID(rs.getString("TipoPublicados_id_TipoPublicados")));
                trabalhoBean.setNome(rs.getString("nome"));
                trabalhoBean.setAno(rs.getInt("ano"));
                trabalhoBean.setPais(paisdao.seledctPorID(rs.getString("pais")));
                result.add(trabalhoBean);
            }
            stmt.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }
    public List<TrabalhosBean> listarTrabalho(String idC) throws SQLException, ClassNotFoundException, Exception {
        List<TrabalhosBean> result = new ArrayList<>();
        String sql = "SELECT * FROM tbpublicados where id_TbPublicados = " + idC;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            PaisDao paisdao;
            TipoTrabalhoDao tipoTrab;
            while (rs.next()) {
                tipoTrab = new TipoTrabalhoDao();
                paisdao = new PaisDao();
                TrabalhosBean trabalhoBean = new TrabalhosBean();
                trabalhoBean.setId_TbPublicados(rs.getInt("id_TbPublicados"));
                trabalhoBean.setId_TipoPublicados(tipoTrab.listarTipoID(rs.getString("TipoPublicados_id_TipoPublicados")));
                trabalhoBean.setNome(rs.getString("nome"));
                trabalhoBean.setAno(rs.getInt("ano"));
                trabalhoBean.setPais(paisdao.seledctPorID(rs.getString("pais")));
                result.add(trabalhoBean);
            }
            stmt.close();
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public TrabalhosBean obtemTrabalhos(String id_curri) throws Exception {
        TrabalhosBean tbpublicados = null;
        String sql = "SELECT * FROM tbpublicados WHERE Curriculo_id_Curriculo = " + id_curri;
        PaisDao paisdao;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                paisdao = new PaisDao();
                tbpublicados = new TrabalhosBean();
                tbpublicados.setId_TbPublicados(rs.getInt("id_TbPublicados"));
                tbpublicados.setNome(rs.getString("nome"));
                tbpublicados.setAno(rs.getInt("ano"));
                tbpublicados.setPais(paisdao.seledctPorID(rs.getString("pais")));
            }
            stmt.close();
            return tbpublicados;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar tbpublicados no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

}
