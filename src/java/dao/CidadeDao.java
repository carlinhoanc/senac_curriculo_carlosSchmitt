package dao;

import bean.CidadeBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CidadeDao {

    public Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    private final Connection connection;

    public CidadeDao() throws ClassNotFoundException {
        this.connection = new FabricaConexao().getConnection();
    }

    public CidadeBean seledctPorID(int id) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        CidadeBean cidade = null;
        String sql = "SELECT * FROM cidade WHERE id =" + id;
        
        try {
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);
            while (rs.next()) {
                cidade = new CidadeBean();
                cidade.setEstados(rs.getString("estado"));
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
            }
            stmt.close();
            return cidade;
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public CidadeBean obtemCidade(String cdPessoa) throws Exception {
        PreparedStatement stmt = null;
        CidadeBean cidade = null;
        String sql = "SELECT c.* FROM cidade c INNER JOIN endereco e ON c.id = e.id_cidade WHERE e.id_Endereco = " + cdPessoa;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        try {
            while (rs.next()) {
                cidade = new CidadeBean();
                cidade.setEstados(rs.getString("estados"));
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
            }
            stmt.close();
            return cidade;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar sscidade no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public CidadeBean selectPorUF(String UF) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        CidadeBean cidade = null;
        String sql = "SELECT * FROM cidade WHERE estados LIKE '%" + UF + "%'";
        try {
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);
            while (rs.next()) {
                cidade = new CidadeBean();
                cidade.setEstados(rs.getString("estado"));
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
            }
            stmt.close();
            return cidade;
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<CidadeBean> listaCidadePorUF(String UF) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        CidadeBean cidade = null;
        String sql = "SELECT * FROM cidade WHERE estados LIKE '%" + UF + "%'";
        List<CidadeBean> cidades = new ArrayList<>();
        try {
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);
            while (rs.next()) {
                cidade = new CidadeBean();
                cidade.setEstados(rs.getString("estado"));
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                cidades.add(cidade);
            }
            stmt.close();
            rs.clearWarnings();
            return cidades;
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<CidadeBean> listaCidades() throws SQLException, ClassNotFoundException, Exception {
        CidadeBean cidade = null;
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM cidade order by nome";
        List<CidadeBean> cidades = new ArrayList<>();
        try {
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);
            while (rs.next()) {
                cidade = new CidadeBean();
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
                cidade.setEstados(rs.getString("estados"));
                cidade.setCidadeUF(rs.getString("nome") + " - " + rs.getString("estados"));
                cidades.add(cidade);
            }
            stmt.close();
            return cidades;
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }

    }
}
