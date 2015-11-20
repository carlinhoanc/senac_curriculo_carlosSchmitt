package dao;

import bean.PessoaBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    private final Connection connection;

    public LoginDao() throws ClassNotFoundException {
        this.connection = new FabricaConexao().getConnection();
    }

    public int fazerLogin(PessoaBean pessoa) throws SQLException, ClassNotFoundException, Exception {
        String sql = "SELECT id_Pessoa FROM pessoa WHERE ativo = 1 AND senha LIKE '" + pessoa.getSenha() + "' "
                + "AND email LIKE '" + pessoa.getEmail() + "'";
        int retorno = 0;
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                retorno = 0;
            } else {
                retorno = rs.getInt("id_Pessoa");
            }
            stmt.close();
            return retorno;
        } catch (SQLException e) {
            System.out.println(e);
            return retorno;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public int fazerLoginAdmin(PessoaBean pessoa) throws SQLException, ClassNotFoundException, Exception {
        String sql = "SELECT id_Pessoa FROM pessoa WHERE senha LIKE '" + pessoa.getSenha() + "' "
                + "AND email LIKE '" + pessoa.getEmail() + "' AND id_tipo= " + pessoa.getTipo();
        int retorno = 0;
        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                retorno = 0;
            } else {
                retorno = rs.getInt("id_Pessoa");
            }
            stmt.close();
            return retorno;
        } catch (SQLException e) {
            System.out.println(e);
            return retorno;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }
}
