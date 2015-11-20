package dao;

import bean.EnderecoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnderecoDao {

    private Connection connection;

    public int insere(EnderecoBean p) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        int idInserido = 1;
        String sql = "INSERT INTO endereco(nomeRua, numero, complemento, bairro, id_cidade, cep) VALUES(?,?,?,?,?,?)";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNomeRua());
            stmt.setInt(2, p.getNumero());
            stmt.setString(3, p.getComplemento());
            stmt.setString(4, p.getBairro());
            stmt.setString(5, p.getId_cidade());
            stmt.setString(6, p.getCep());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                idInserido = rs.getInt(1);
            }
            stmt.close();
            return idInserido;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean deleta(int id) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        boolean removidoSucesso = false;
        String sql = "DELETE FROM endereco WHERE id_Endereco IN "
                + "(SELECT p.Endereco_id_Endereco from pessoa p WHERE p.id_Pessoa = ?)";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Endereco removido com sucesso no BD!");
                removidoSucesso = true;
            } else {
                System.out.println("Erro ao remover Endereco no BD!");
            }
            stmt.close();
            return removidoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Endereco no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean atualiza(EnderecoBean p, String id) throws Exception {
        PreparedStatement stmt = null;
        boolean atualizadoSucesso = false;
        String sql = "UPDATE endereco SET nomeRua=? ,numero=? ,complemento=? ,bairro=? ,id_cidade=? ,cep=? "
                + "WHERE id_Endereco = (SELECT p.Endereco_id_Endereco from pessoa p WHERE p.id_Pessoa = ?)";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, p.getNomeRua());
            stmt.setInt(2, p.getNumero());
            stmt.setString(3, p.getComplemento());
            stmt.setString(4, p.getBairro());
            stmt.setString(5, p.getId_cidade());
            stmt.setString(6, p.getCep());
            stmt.setInt(7, Integer.parseInt(id));
            stmt.executeUpdate();
            stmt.close();
            atualizadoSucesso = true;
            return atualizadoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Endereco no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public EnderecoBean obtemEndereco(String cdPessoa) throws Exception {
        EnderecoBean endereco = null;
        CidadeDao cidadeDao;
        String sql = "SELECT e.* FROM endereco e INNER JOIN pessoa p ON e.id_Endereco = p.Endereco_id_Endereco "
                + "WHERE p.id_Pessoa = " + cdPessoa;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                cidadeDao = new CidadeDao();
                endereco = new EnderecoBean();
                endereco.setId(rs.getString("id_Endereco"));
                endereco.setNomeRua(rs.getString("nomeRua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(cidadeDao.obtemCidade(endereco.getId()));
                endereco.setCep(rs.getString("cep"));
            }
            stmt.close();
            return endereco;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar endereco no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

}
