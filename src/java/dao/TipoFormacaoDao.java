package dao;

import bean.TipoFormacaoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoFormacaoDao {

    private Connection connection;

    public boolean insere(TipoFormacaoBean tipoformacao) throws SQLException, ClassNotFoundException, Exception {
        String sql1 = "SELECT * FROM tipoformacao WHERE descricao= '" + tipoformacao.getDescricao() + "' ";
        String sql = "INSERT INTO tipoformacao(descricao) VALUES(?)";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, tipoformacao.getDescricao());
                stmt.executeUpdate();
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean delete(String id) throws Exception {
        String sql = "DELETE FROM tipoformacao WHERE id_Tipo = " + id;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Endereco Pessoa com sucesso no BD!");
                return true;
            } else {
                System.out.println("Erro ao remover Pessoa no BD!");
            }
            stmt.close();
            return false;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean atualiza(TipoFormacaoBean tipoformacao) throws ClassNotFoundException, Exception {
        String sql = "UPDATE tipoformacao SET descricao='" + tipoformacao.getDescricao() + "'"
                + " WHERE id_Tipo= " + tipoformacao.getId_Tipo();
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<TipoFormacaoBean> listarTipoFormacao() throws ClassNotFoundException, Exception {
        List<TipoFormacaoBean> tipoformacaos = new ArrayList<>();
        String sql = "SELECT * FROM tipoformacao";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoFormacaoBean tipoformacao = new TipoFormacaoBean();
                tipoformacao.setId_Tipo(rs.getString("id_Tipo"));
                tipoformacao.setDescricao(rs.getString("descricao"));
                tipoformacaos.add(tipoformacao);
            }
            stmt.close();
            return tipoformacaos;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar tipoformacaos no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<TipoFormacaoBean> listarTipoFormacaoID(String id) throws ClassNotFoundException, Exception {
        List<TipoFormacaoBean> tipoformacaos = new ArrayList<>();
        String sql = "SELECT * FROM tipoformacao WHERE id_Tipo = " + id;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                TipoFormacaoBean tipoformacao = new TipoFormacaoBean();
                tipoformacao.setId_Tipo(rs.getString("id_Tipo"));
                tipoformacao.setDescricao(rs.getString("descricao"));
                tipoformacaos.add(tipoformacao);
            }
            stmt.close();
            return tipoformacaos;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar tipoformacaos no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public TipoFormacaoBean listarTipoID(String id) throws ClassNotFoundException, Exception {
        TipoFormacaoBean tipoFormacaoBean = new TipoFormacaoBean();
        String sql = "SELECT * FROM tipoformacao WHERE id_Tipo = " + id;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tipoFormacaoBean.setId_Tipo(rs.getString("id_Tipo"));
                tipoFormacaoBean.setDescricao(rs.getString("descricao"));
            }
            stmt.close();
            return tipoFormacaoBean;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }
}
