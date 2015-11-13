package dao;

import bean.EnderecoBean;
import conexao.FabricaConexao;
import bean.PessoaBean;
import static dao.PessoaDao.stmt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    private static Connection connection;

    public PessoaDao() throws Exception {
        PessoaDao.connection = new FabricaConexao().getConnection();
    }

    public boolean insere(PessoaBean pessoa, int tipUser) throws SQLException, ClassNotFoundException, Exception {
        EnderecoDao end = new EnderecoDao();
        PreparedStatement stmt = null;
        String sql1 = "SELECT id_Pessoa FROM pessoa WHERE cpf= '" + pessoa.getCpf() + "' OR email = '" + pessoa.getEmail() + "'";
        ResultSet rs = stmt().executeQuery(sql1);
        int idEndereco;
        if (!rs.next()) {
            idEndereco = end.insere(pessoa.getEndereco());
            String sql = "INSERT INTO pessoa( nome, sobreNome, idade, sexo, cpf, Endereco_id_Endereco, "
                    + "senha , id_tipo, email, telefone, ativo) VALUES(?,?,?,?,?,?,?,?,?,?, ?)";
            try {
                stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
                return false;
            } finally {
                FabricaConexao.fechaConexao(EnderecoDao.connection, stmt());
            }
        } else {
            return false;
        }
    }
    public boolean insereNaoAdmin(PessoaBean pessoa, int tipUser) throws SQLException, ClassNotFoundException, Exception {
        EnderecoDao end = new EnderecoDao();
        PreparedStatement stmt = null;
        String sql1 = "SELECT id_Pessoa FROM pessoa WHERE cpf= '" + pessoa.getCpf() + "' OR email = '" + pessoa.getEmail() + "'";
        ResultSet rs = stmt().executeQuery(sql1);
        int idEndereco;
        if (!rs.next()) {
            idEndereco = end.insere(pessoa.getEndereco());
            String sql = "INSERT INTO pessoa( nome, sobreNome, idade, sexo, cpf, Endereco_id_Endereco, "
                    + "senha , id_tipo, email, telefone, ativo) VALUES(?,?,?,?,?,?,?,?,?,?, ?)";
            try {
                stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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

            } catch (SQLException | ClassNotFoundException e) {
                System.out.println(e);
                return false;
            } finally {
                FabricaConexao.fechaConexao(EnderecoDao.connection, stmt());
            }
        } else {
            return false;
        }
    }

    public boolean delete(int id) throws Exception {
        PreparedStatement stmt = null;
        boolean removidoSucesso = false;
        String sql = "DELETE FROM pessoa WHERE id_Pessoa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Endereco Pessoa com sucesso no BD!");
                removidoSucesso = true;
            } else {
                System.out.println("Erro ao remover Pessoa no BD! 00");
            }
            stmt.close();
            return removidoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao remover Pessoa no BD!");
            throw new RuntimeException(e);
        }
    }
    
    public boolean desativa(int id) throws Exception {
        PreparedStatement stmt = null;
        boolean removidoSucesso = false;
        String sql = "UPDATE pessoa SET ativo=0  WHERE id_Pessoa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int ok = stmt.executeUpdate();
            if (ok == 1) {
                System.out.println("Pessoa desativada com sucesso no BD!");
                removidoSucesso = true;
            } else {
                System.out.println("Erro ao desativar Pessoa no BD!");
            }
            stmt.close();
            return removidoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao desativar Pessoa no BD!");
            throw new RuntimeException(e);
        }
    }

    public boolean atualiza(PessoaBean pessoa) throws ClassNotFoundException, Exception {
        boolean atualizadoSucesso = false;
        String sql = "UPDATE pessoa SET nome=?,sobreNome=?,idade=?,sexo=?,cpf=?, "
                + "senha=?,email=?,telefone=?, id_tipo=? , ativo=? "
                + "WHERE id_Pessoa= ?";
        EnderecoBean endereco = pessoa.getEndereco();
        EnderecoDao enderecoDAO = new EnderecoDao();
        String idd = pessoa.getId_Pessoa();
        if (enderecoDAO.atualiza(endereco, idd) == false) {
            return false;
        }
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
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
            int ok = stmt.executeUpdate();

            return atualizadoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(PessoaDao.connection, stmt());
        }
    }
    public boolean atualizaUser(PessoaBean pessoa) throws ClassNotFoundException, Exception {
        boolean atualizadoSucesso = false;
        String sql = "UPDATE pessoa SET nome=?,sobreNome=?,idade=?,sexo=?,cpf=?, "
                + "senha=?,email=?,telefone=? "
                + "WHERE id_Pessoa= ?";
        EnderecoBean endereco = pessoa.getEndereco();
        EnderecoDao enderecoDAO = new EnderecoDao();
        String idd = pessoa.getId_Pessoa();
        if (enderecoDAO.atualiza(endereco, idd) == false) {
            return false;
        }
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
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

            return atualizadoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(PessoaDao.connection, stmt());
        }
    }

    public List<PessoaBean> listarPessoa(String id_tipo) throws ClassNotFoundException, Exception {

        List<PessoaBean> pessoas = new ArrayList<>();
        EnderecoDao enderecoDAO;
        TipoDeUsuarioDao tipoUserDao;
        String sql = null;
        
        if(id_tipo.equals("2")){
            sql = "SELECT * FROM pessoa ";
        }else{
            sql = "SELECT * FROM pessoa WHERE id_tipo != 2 AND ativo = 1";
        }
     
        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        try {
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
            return pessoas;
        } finally {
            FabricaConexao.fechaConexao(PessoaDao.connection, stmt());
        }
    }

    public List<PessoaBean> listarPessoaID(String id) throws ClassNotFoundException, Exception {

        List<PessoaBean> pessoas = new ArrayList<>();
        EnderecoDao enderecoDAO;
        TipoDeUsuarioDao tipoUserDao;
        String sql = "SELECT * FROM pessoa WHERE id_Pessoa = " + id;

        PreparedStatement stmt = null;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        try {
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
            return pessoas;
        } finally {
            FabricaConexao.fechaConexao(PessoaDao.connection, stmt());
        }
    }
}
