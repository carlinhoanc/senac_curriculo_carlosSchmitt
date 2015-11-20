package dao;

import bean.CidadeBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDao {

    private Connection connection;

    public CidadeBean seledctPorID(int id) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        CidadeBean cidade = null;
        String sql = "SELECT * FROM cidade WHERE id =" + id;
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cidade = new CidadeBean();
                cidade.setEstados(rs.getString("estado"));
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
            }
            stmt.close();            
            return cidade;
        } catch (SQLException e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public CidadeBean obtemCidade(String cdPessoa) throws Exception {
        PreparedStatement stmt = null;
        CidadeBean cidade = null;
        String sql = "SELECT c.* FROM cidade c INNER JOIN endereco e ON c.id = e.id_cidade WHERE e.id_Endereco = " + cdPessoa;
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cidade = new CidadeBean();
                cidade.setEstados(rs.getString("estado"));
                cidade.setId(rs.getInt("id"));
                cidade.setNome(rs.getString("nome"));
            }
            stmt.close();            
            return cidade;
        } catch (SQLException e) {
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
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
        } catch (SQLException e) {
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
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
        } catch (SQLException e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }

    }
}
