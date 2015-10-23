/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.PessoaBean;
import conexao.FabricaConexao;
import static dao.PessoaDao.stmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CarlosRoberto
 */
public class LoginDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    public LoginDao() {

    }

    public static int fazerLogin(PessoaBean pessoa) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "SELECT id_Pessoa FROM pessoa WHERE senha LIKE '" + pessoa.getSenha()+ "' "
                + "AND email LIKE '" + pessoa.getEmail() + "'";
        ResultSet rs = stmt().executeQuery(sql);
        
        if(!rs.next()) {
            return 0;
        } else {
            return rs.getInt("id_Pessoa");
        }
    }
    public static int fazerLoginAdmin(PessoaBean pessoa) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "SELECT id_Pessoa FROM pessoa WHERE senha LIKE '" + pessoa.getSenha()+ "' "
                + "AND email LIKE '" + pessoa.getEmail() + "' "
                + "AND id_tipo= " + pessoa.getTipo() ;
        ResultSet rs = stmt().executeQuery(sql);
        if(!rs.next()) {
            return 0;
        } else {
            return rs.getInt("id_Pessoa");
        }
    }
}