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

    private static Connection connection;

    public LoginDao() throws ClassNotFoundException {
        LoginDao.connection = new FabricaConexao().getConnection();
    }

    public static int fazerLogin(PessoaBean pessoa) throws SQLException, ClassNotFoundException, Exception {

        String sql = "SELECT id_Pessoa FROM pessoa WHERE "
                + "ativo = 1 "
                + "AND senha LIKE '" + pessoa.getSenha() + "' "
                + "AND email LIKE '" + pessoa.getEmail() + "'";
        int retorno = 0;
        try {
            ResultSet rs = stmt().executeQuery(sql);
            if (!rs.next()) {
                retorno = 0;
            } else {
                retorno = rs.getInt("id_Pessoa");
            }
            stmt().close();
            return retorno;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return retorno;
        } finally {
            FabricaConexao.fechaConexao(LoginDao.connection);
        }
    }

    public static int fazerLoginAdmin(PessoaBean pessoa) throws SQLException, ClassNotFoundException, Exception {
        String sql = "SELECT id_Pessoa FROM pessoa WHERE senha LIKE '" + pessoa.getSenha() + "' "
                + "AND email LIKE '" + pessoa.getEmail() + "' "
                + "AND id_tipo= " + pessoa.getTipo();
        int retorno = 0;
        try {
            ResultSet rs = stmt().executeQuery(sql);
            if (!rs.next()) {
                retorno = 0;
            } else {
                retorno = rs.getInt("id_Pessoa");
            }
            stmt().close();
            return retorno;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return retorno;
        } finally {
            FabricaConexao.fechaConexao(LoginDao.connection);
        }
    }
}
