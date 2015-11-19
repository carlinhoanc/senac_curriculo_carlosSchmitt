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

    private final Connection connection;

    public TipoTrabalhoDao() throws ClassNotFoundException {
        this.connection = new FabricaConexao().getConnection();
    }

    public boolean insere(TipoTrabalhoPublicadosBean tipopublicados) throws SQLException, ClassNotFoundException, Exception {
        String sql1 = "SELECT * FROM tipopublicados WHERE descricao= '" + tipopublicados.getDescricao() + "' ";
        try {
            PreparedStatement stmt = com().prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.executeQuery();
            String sql = "INSERT INTO tipopublicados(descricao) VALUES(?)";
            if (!rs.next()) {
                stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, tipopublicados.getDescricao());
                stmt.executeUpdate();
                stmt.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM tipopublicados WHERE id_TipoPublicados = ?";
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, id);
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

    public boolean atualiza(TipoTrabalhoPublicadosBean tipopublicados) throws ClassNotFoundException, Exception {
        String sql = "UPDATE tipopublicados SET descricao='" + tipopublicados.getDescricao() + "'"
                + " WHERE id_TipoPublicados= " + tipopublicados.getId();
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            stmt.close();
            return false;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<TipoTrabalhoPublicadosBean> listarTipoTrabalho() throws ClassNotFoundException, Exception {
        List<TipoTrabalhoPublicadosBean> tipopublicadoss = new ArrayList<>();
        try {
            String sql = "SELECT * FROM tipopublicados ";
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<TipoTrabalhoPublicadosBean> listarTipoTrabID(String id) throws ClassNotFoundException, Exception {
        List<TipoTrabalhoPublicadosBean> tipopublicadoss = new ArrayList<>();
        String sql = "SELECT * FROM tipopublicados WHERE id_TipoPublicados = " + id;
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public TipoTrabalhoPublicadosBean listarTipoID(String id) throws ClassNotFoundException, Exception {
        TipoTrabalhoPublicadosBean tipopublicados = new TipoTrabalhoPublicadosBean();
        String sql = "SELECT * FROM tipopublicados WHERE id_TipoPublicados = " + id;
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tipopublicados.setId(rs.getString("id_TipoPublicados"));
                tipopublicados.setDescricao(rs.getString("descricao"));
            }
            stmt.close();
            return tipopublicados;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }
}
