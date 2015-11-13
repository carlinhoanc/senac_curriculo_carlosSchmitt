package dao;

import bean.PessoaBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public static int fazerLogin(PessoaBean pessoa) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "SELECT id_Pessoa FROM pessoa WHERE "
                + "ativo = 1 "
                + "AND senha LIKE '" + pessoa.getSenha() + "' "
                + "AND email LIKE '" + pessoa.getEmail() + "'";
        ResultSet rs = stmt().executeQuery(sql);
        int retorno;
        if (!rs.next()) {
            retorno = 0;
        } else {
            retorno = rs.getInt("id_Pessoa");
        }
        return retorno;
    }

    @SuppressWarnings({"null", "ConvertToTryWithResources"})
    public static int fazerLoginAdmin(PessoaBean pessoa) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "SELECT id_Pessoa FROM pessoa WHERE senha LIKE '" + pessoa.getSenha() + "' "
                + "AND email LIKE '" + pessoa.getEmail() + "' "
                + "AND id_tipo= " + pessoa.getTipo();
        ResultSet rs = stmt().executeQuery(sql);
        int retorno;
        if (!rs.next()) {
            retorno = 0;
        } else {
            retorno = rs.getInt("id_Pessoa");
        }
        return retorno;
    }
}
