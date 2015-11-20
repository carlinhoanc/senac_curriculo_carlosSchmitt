package dao;

import bean.TipoAcessoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TipoDeUsuarioDao {

    private Connection connection;

    public TipoAcessoBean obtemTipoUser(String cdPessoa) throws Exception {
        PreparedStatement stmt = null;
        TipoAcessoBean tipouser = null;
        String sql = "SELECT t.* FROM tipouser t INNER JOIN pessoa p ON t.id_tipo = p.id_tipo WHERE p.id_Pessoa = " + cdPessoa;
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
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
