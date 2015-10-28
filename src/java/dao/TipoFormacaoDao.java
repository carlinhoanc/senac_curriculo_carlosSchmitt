package dao;

import bean.TipoFormacaoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoFormacaoDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    private static Connection connection;

    public TipoFormacaoDao() throws ClassNotFoundException {
        TipoFormacaoDao.connection = new FabricaConexao().getConnection();
    }

    public boolean insere(TipoFormacaoBean tipoformacao) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO tipoformacao(descricao) VALUES(?)";
        try {
            stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, tipoformacao.getDescricao());
            stmt.executeUpdate();
            stmt.close();
            return true;

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return false;
        } finally {
            FabricaConexao.fechaConexao(EnderecoDao.connection);
        }
    }

    public boolean delete(String id) throws Exception {
        PreparedStatement stmt = null;
        boolean removidoSucesso = false;
        String sql = "DELETE FROM tipoformacao WHERE id_Tipo = " + id;
        try {
            stmt = connection.prepareStatement(sql);
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Endereco Pessoa com sucesso no BD!");
                removidoSucesso = true;
            } else {
                System.out.println("Erro ao remover Pessoa no BD!");
            }
            stmt.close();
            return removidoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Pessoa no BD!");
            throw new RuntimeException(e);
        }
    }

    public boolean atualiza(TipoFormacaoBean tipoformacao) throws ClassNotFoundException, Exception {

        boolean atualizadoSucesso = false;
        String sql = "UPDATE tipoformacao SET descricao='"+tipoformacao.getDescricao()+"'"
                + " WHERE id_Tipo= " + tipoformacao.getId_Tipo();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();

            return atualizadoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(TipoFormacaoDao.connection);
        }
    }

    public List<TipoFormacaoBean> listarTipoFormacao() throws ClassNotFoundException, Exception {
        List<TipoFormacaoBean> tipoformacaos = new ArrayList<>();
        String sql = "SELECT * FROM tipoformacao";
        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        try {
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
            return tipoformacaos;
        } finally {
            FabricaConexao.fechaConexao(TipoFormacaoDao.connection, stmt());
        }
    }

    public List<TipoFormacaoBean> listarTipoFormacaoID(String id) throws ClassNotFoundException, Exception {
        List<TipoFormacaoBean> tipoformacaos = new ArrayList<>();
        String sql = "SELECT * FROM tipoformacao WHERE id_Tipo = " + id;
        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        try {
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
            return tipoformacaos;
        } finally {
            FabricaConexao.fechaConexao(TipoFormacaoDao.connection, stmt());
        }
    }
    
        public TipoFormacaoBean listarTipoID(String id) throws ClassNotFoundException, Exception {
        TipoFormacaoBean tipoFormacaoBean = new TipoFormacaoBean();
        String sql = "SELECT * FROM tipoformacao WHERE id_Tipo = " + id;
        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);

        while (rs.next()) {
            tipoFormacaoBean.setId_Tipo(rs.getString("id_Tipo"));
            tipoFormacaoBean.setDescricao(rs.getString("descricao"));
        }
        stmt.close();
        return tipoFormacaoBean;
    }
}
