package dao;

import bean.EnderecoBean;
import conexao.FabricaConexao;
import bean.PessoaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao {

    private Connection connection;

    public boolean insere(PessoaBean pessoa, int tipUser) throws SQLException, ClassNotFoundException, Exception {
        EnderecoDao end = new EnderecoDao();
        PreparedStatement stmt = null;
        String sql1 = "SELECT id_Pessoa FROM pessoa WHERE cpf= '" + pessoa.getCpf() + "' OR email = '" + pessoa.getEmail() + "'";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            int idEndereco;
            if (!rs.next()) {
                idEndereco = end.insere(pessoa.getEndereco());
                String sql = "INSERT INTO pessoa( nome, sobreNome, idade, sexo, cpf, Endereco_id_Endereco, "
                        + "senha , id_tipo, email, telefone, ativo) VALUES(?,?,?,?,?,?,?,?,?,?, ?)";
                stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, pessoa.getNome());
                stmt.setString(2, pessoa.getSobreNome());
                stmt.setInt(3, pessoa.getIdade());
                stmt.setString(4, pessoa.getSexo());
                stmt.setString(5, pessoa.getCpf());
                stmt.setInt(6, idEndereco);
                stmt.setString(7, pessoa.getSenha());
                stmt.setInt(8, tipUser);
                stmt.setString(9, pessoa.getEmail());
                stmt.setString(10, pessoa.getTelefone());
                stmt.setInt(11, pessoa.getAtivo());
                stmt.executeUpdate();
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return false;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean insereNaoAdmin(PessoaBean pessoa, int tipUser) throws SQLException, ClassNotFoundException, Exception {
        EnderecoDao end = new EnderecoDao();
        PreparedStatement stmt = null;
        String sql1 = "SELECT id_Pessoa FROM pessoa WHERE cpf= '" + pessoa.getCpf() + "' OR email = '" + pessoa.getEmail() + "'";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            int idEndereco;
            if (!rs.next()) {
                idEndereco = end.insere(pessoa.getEndereco());
                String sql = "INSERT INTO pessoa( nome, sobreNome, idade, sexo, cpf, Endereco_id_Endereco, "
                        + "senha , id_tipo, email, telefone, ativo) VALUES(?,?,?,?,?,?,?,?,?,?, ?)";
                stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, pessoa.getNome());
                stmt.setString(2, pessoa.getSobreNome());
                stmt.setInt(3, pessoa.getIdade());
                stmt.setString(4, pessoa.getSexo());
                stmt.setString(5, pessoa.getCpf());
                stmt.setInt(6, idEndereco);
                stmt.setString(7, pessoa.getSenha());
                stmt.setInt(8, 1);
                stmt.setString(9, pessoa.getEmail());
                stmt.setString(10, pessoa.getTelefone());
                stmt.setInt(11, 1);
                stmt.executeUpdate();
                stmt.close();
                return true;
            } else {
                stmt.close();
                return false;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            return false;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean delete(int id) throws Exception {
        String sql1 = "SELECT id_tipo FROM pessoa WHERE id_Pessoa= '" + id + "' ";
        PreparedStatement stmt = null;
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            int id_tipo = 1;
            while (rs.next()) {
                id_tipo = rs.getInt("id_tipo");
            }

            int contar_adm = 2;
            if (id_tipo == 2) {
                sql1 = "SELECT COUNT(id_tipo) as conta FROM pessoa WHERE id_tipo= '2' ";
                rs = stmt.executeQuery(sql1);
                while (rs.next()) {
                    contar_adm = rs.getInt("conta");
                }
            }
            stmt.close();
            if (contar_adm > 1) {
                String sql = "DELETE FROM pessoa WHERE id_Pessoa = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setInt(1, id);
                int ok = stmt.executeUpdate();
                stmt.close();
                if (ok == 1) {
                    System.out.println("Endereco Pessoa com sucesso no BD!");
                    return true;
                } else {
                    System.out.println("Erro ao remover Pessoa no BD! 00");
                    return false;
                }
            } else {
                stmt.close();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao remover Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean desativa(int id) throws Exception {
        String sql = "UPDATE pessoa SET ativo=0  WHERE id_Pessoa = ?";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int ok = stmt.executeUpdate();
            stmt.close();
            if (ok == 1) {
                System.out.println("Pessoa desativada com sucesso no BD!");
                return true;
            } else {
                System.out.println("Erro ao desativar Pessoa no BD!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao desativar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean atualiza(PessoaBean pessoa) throws ClassNotFoundException, Exception {
        String sql = "UPDATE pessoa SET nome=?,sobreNome=?,idade=?,sexo=?,cpf=?, "
                + "senha=?,email=?,telefone=?, id_tipo=? , ativo=? WHERE id_Pessoa= ?";
        EnderecoBean endereco = pessoa.getEndereco();
        EnderecoDao enderecoDAO = new EnderecoDao();
        String idd = pessoa.getId_Pessoa();
        if (enderecoDAO.atualiza(endereco, idd) == false) {
            return false;
        }
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSobreNome());
            stmt.setInt(3, pessoa.getIdade());
            stmt.setString(4, pessoa.getSexo());
            stmt.setString(5, pessoa.getCpf());
            stmt.setString(6, pessoa.getSenha());
            stmt.setString(7, pessoa.getEmail());
            stmt.setString(8, pessoa.getTelefone());
            stmt.setInt(9, pessoa.getId_tipo());
            stmt.setInt(10, pessoa.getAtivo());
            stmt.setInt(11, Integer.parseInt(pessoa.getId_Pessoa()));
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean atualizaUser(PessoaBean pessoa) throws ClassNotFoundException, Exception {
        String sql = "UPDATE pessoa SET nome=?,sobreNome=?,idade=?,sexo=?,cpf=?, "
                + "senha=?,email=?,telefone=? WHERE id_Pessoa= ?";
        EnderecoBean endereco = pessoa.getEndereco();
        EnderecoDao enderecoDAO = new EnderecoDao();
        String idd = pessoa.getId_Pessoa();
        if (enderecoDAO.atualiza(endereco, idd) == false) {
            return false;
        }
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSobreNome());
            stmt.setInt(3, pessoa.getIdade());
            stmt.setString(4, pessoa.getSexo());
            stmt.setString(5, pessoa.getCpf());
            stmt.setString(6, pessoa.getSenha());
            stmt.setString(7, pessoa.getEmail());
            stmt.setString(8, pessoa.getTelefone());
            stmt.setInt(9, Integer.parseInt(pessoa.getId_Pessoa()));
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<PessoaBean> listarPessoa(String id_tipo) throws ClassNotFoundException, Exception {
        List<PessoaBean> pessoas = new ArrayList<>();
        EnderecoDao enderecoDAO;
        TipoDeUsuarioDao tipoUserDao;
        String sql = null;

        if (id_tipo.equals("2")) {
            sql = "SELECT * FROM pessoa ";
        } else {
            sql = "SELECT * FROM pessoa WHERE id_tipo != 2 AND ativo = 1";
        }
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                enderecoDAO = new EnderecoDao();
                tipoUserDao = new TipoDeUsuarioDao();
                PessoaBean pessoa = new PessoaBean();
                pessoa.setId_Pessoa(rs.getString("id_Pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSobreNome(rs.getString("sobreNome"));
                pessoa.setIdade(rs.getInt("idade"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEndereco(enderecoDAO.obtemEndereco(pessoa.getId_Pessoa()));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setTipo(tipoUserDao.obtemTipoUser(pessoa.getId_Pessoa()));
                pessoas.add(pessoa);
            }
            stmt.close();
            return pessoas;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar pessoas no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<PessoaBean> listarPessoaID(String id) throws ClassNotFoundException, Exception {
        List<PessoaBean> pessoas = new ArrayList<>();
        EnderecoDao enderecoDAO;
        TipoDeUsuarioDao tipoUserDao;
        String sql = "SELECT * FROM pessoa WHERE id_Pessoa = " + id;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                enderecoDAO = new EnderecoDao();
                tipoUserDao = new TipoDeUsuarioDao();
                PessoaBean pessoa = new PessoaBean();
                pessoa.setId_Pessoa(rs.getString("id_Pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSobreNome(rs.getString("sobreNome"));
                pessoa.setIdade(rs.getInt("idade"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEndereco(enderecoDAO.obtemEndereco(pessoa.getId_Pessoa()));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setTelefone(rs.getString("telefone"));
                pessoa.setAtivo(rs.getInt("ativo"));
                pessoa.setTipo(tipoUserDao.obtemTipoUser(pessoa.getId_Pessoa()));
                pessoas.add(pessoa);
            }
            stmt.close();
            return pessoas;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar pessoas no BD!");
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }
}
