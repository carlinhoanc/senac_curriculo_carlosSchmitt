/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.TipoAcessoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CarlosRoberto
 */
public class TipoDeUsuarioDao {

    public Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    private final Connection connection;

    public TipoDeUsuarioDao() throws ClassNotFoundException {
        connection = new FabricaConexao().getConnection();
    }

    public TipoAcessoBean obtemTipoUser(String cdPessoa) throws Exception {
        PreparedStatement stmt = null;
        TipoAcessoBean tipouser = null;
        
        String sql = "SELECT t.* FROM tipouser t INNER JOIN pessoa p ON t.id_tipo = p.id_tipo WHERE p.id_Pessoa = " + cdPessoa;
        
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        
        try {
            while (rs.next()) {
                tipouser = new TipoAcessoBean();
                tipouser.setId(rs.getInt("id_tipo"));
                tipouser.setTipo(rs.getString("tipo"));
                tipouser.setDescricao(rs.getString("descricao"));
            }
            stmt.close();
            return tipouser;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar Tipo de user no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }
}
