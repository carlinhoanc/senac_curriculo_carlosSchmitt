package dao;

import bean.TipoTrabalhoPublicadosBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoTrabalhoDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    static Connection connection;

    public TipoTrabalhoDao() throws ClassNotFoundException {
        TipoTrabalhoDao.connection = new FabricaConexao().getConnection();
    }

    public boolean insere(TipoTrabalhoPublicadosBean tipopublicados) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        String sql1 = "SELECT * FROM tipopublicados WHERE descricao= '" + tipopublicados.getDescricao() + "' ";
        ResultSet rs = stmt().executeQuery(sql1);

        String sql = "INSERT INTO tipopublicados(descricao) VALUES(?)";
        try {
            if (!rs.next()) {
                stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, tipopublicados.getDescricao());
                stmt.executeUpdate();
                stmt.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return false;
        } finally {
            FabricaConexao.fechaConexao(EnderecoDao.connection, stmt());
        }
    }

    public boolean delete(int id) throws Exception {
        PreparedStatement stmt = null;
        boolean removidoSucesso = false;
        String sql = "DELETE FROM tipopublicados WHERE id_TipoPublicados = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
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
        } finally {
            FabricaConexao.fechaConexao(PaisDao.connection, stmt());
        }
    }

    public boolean atualiza(TipoTrabalhoPublicadosBean tipopublicados) throws ClassNotFoundException, Exception {

        boolean atualizadoSucesso = false;
        String sql = "UPDATE tipopublicados SET descricao='" + tipopublicados.getDescricao() + "'"
                + " WHERE id_TipoPublicados= " + tipopublicados.getId();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            return atualizadoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(TipoTrabalhoDao.connection, stmt());
        }
    }

    public List<TipoTrabalhoPublicadosBean> listarTipoTrabalho() throws ClassNotFoundException, Exception {
        List<TipoTrabalhoPublicadosBean> tipopublicadoss = new ArrayList<>();
        String sql = "SELECT * FROM tipopublicados ";
        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        try {
            while (rs.next()) {
                TipoTrabalhoPublicadosBean tipopublicados = new TipoTrabalhoPublicadosBean();
                tipopublicados.setId(rs.getString("id_TipoPublicados"));
                tipopublicados.setDescricao(rs.getString("descricao"));
                tipopublicadoss.add(tipopublicados);
            }
            stmt.close();
            return tipopublicadoss;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar tipopublicadoss no BD!");
            return tipopublicadoss;
        } finally {
            FabricaConexao.fechaConexao(TipoTrabalhoDao.connection, stmt());
        }
    }

    public List<TipoTrabalhoPublicadosBean> listarTipoTrabID(String id) throws ClassNotFoundException, Exception {
        List<TipoTrabalhoPublicadosBean> tipopublicadoss = new ArrayList<>();
        String sql = "SELECT * FROM tipopublicados WHERE id_TipoPublicados = " + id;
        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        try {
            while (rs.next()) {
                TipoTrabalhoPublicadosBean tipopublicados = new TipoTrabalhoPublicadosBean();
                tipopublicados.setId(rs.getString("id_TipoPublicados"));
                tipopublicados.setDescricao(rs.getString("descricao"));
                tipopublicadoss.add(tipopublicados);
            }
            stmt.close();
            return tipopublicadoss;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar tipopublicadoss no BD!");
            return tipopublicadoss;
        } finally {
            FabricaConexao.fechaConexao(TipoTrabalhoDao.connection, stmt());
        }
    }

    public TipoTrabalhoPublicadosBean listarTipoID(String id) throws ClassNotFoundException, Exception {
        TipoTrabalhoPublicadosBean tipopublicados = new TipoTrabalhoPublicadosBean();
        String sql = "SELECT * FROM tipopublicados WHERE id_TipoPublicados = " + id;
        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);

        try (ResultSet rs = stmt().executeQuery(sql)) {
            while (rs.next()) {
                tipopublicados.setId(rs.getString("id_TipoPublicados"));
                tipopublicados.setDescricao(rs.getString("descricao"));
            }
            stmt.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        } finally {
            FabricaConexao.fechaConexao(PaisDao.connection, stmt());
        }
        return tipopublicados;
    }
}
