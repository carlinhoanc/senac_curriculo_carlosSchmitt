/*


package deletar_depoois;

import bean.PessoaBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jéssica
 * /
public class PessoaDAOJessica {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

//    UsuarioDAO usuario = new UsuarioDAO();
    EnderecoDaoJessica end = new EnderecoDaoJessica();

    public void salvar(PessoaBean p) throws Exception {
        int idEndereco;

        try {
            conn = FabricaConexao.abrirConexao();

            idEndereco = end.salvar(p); //salva o endereço e retorna id

            String query = "insert into pessoa (nome, sobrenome, idade, sexo, cpf, idEndereco) values (?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getPrimeiroNome());
            ps.setString(2, p.getSobrenome());
            ps.setInt(3, p.getIdade());
            ps.setString(4, p.getSexo());
            ps.setString(5, p.getCpf());
            ps.setInt(6, idEndereco);
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            rs.next();
            p.setCodigo(rs.getInt(1));

            usuario.salvar(p); //salva login e senha

        } catch (Exception e) {
            System.out.println("Erro ao salvar pessoa: " + e.getMessage());
        } finally {
            Conexao.fechaConexao(conn, ps, rs);
        }
    }

    public void desativar(Pessoa p) throws Exception {
        try {
            conn = Conexao.abrirConexao();
            String query = "update pessoa set ativo = 0 where id = ?";
            ps = conn.prepareCall(query);

            ps.setInt(1, p.getCodigo());
            ps.executeUpdate();

            usuario.desativar(p);

        } catch (Exception e) {
            System.out.println("Erro ao desativar pessoa: " + e.getMessage());
        } finally {
            Conexao.fechaConexao(conn, ps);
        }
    }

    public void alterar(Pessoa p) throws Exception {
        try {
            conn = Conexao.abrirConexao();

            String query = "update pessoa set nome = ?, sobrenome = ?, idade = ?, sexo = ?, cpf = ? where id = ?";
            ps = conn.prepareCall(query);

            ps.setString(1, p.getPrimeiroNome());
            ps.setString(2, p.getSobrenome());
            ps.setInt(3, p.getIdade());
            ps.setString(4, p.getSexo());
            ps.setString(5, p.getCpf());
            ps.setInt(6, p.getCodigo());
            ps.executeUpdate();

            usuario.alterar(p);
            end.alterar(p);
        } catch (Exception e) {
            System.out.println("Erro ao alterar pessoa: " + e.getMessage());
        } finally {
            Conexao.fechaConexao(conn, ps);
        }
    }

    public Pessoa pesquisar(Pessoa p) throws Exception {
        try {
            conn = Conexao.abrirConexao();

            String query = "select * from pessoa p \n"
                    + "inner join endereco e on (p.idEndereco = e.id) \n"
                    + "inner join usuario u on (p.idUsuario = u.id) \n"
                    + "inner join estado est on (e.idEstado = est.id) \n"
                    + "inner join curriculo c on (p.id = c.idPessoa) \n"
                    + "where id = ?";
            ps = conn.prepareCall(query);
            ps.setInt(1, p.getCodigo());
            rs = ps.executeQuery();

            if (rs.next()) {
                Endereco e = new Endereco();
                Estado estado = new Estado();

                //retorna pessoa
                p.setCodigo(rs.getInt("id"));
                p.setPrimeiroNome(rs.getString("nome"));
                p.setSobrenome(rs.getString("sobrenome"));
                p.setIdade(rs.getInt("idade"));
                p.setSexo(rs.getString("sexo"));
                p.setCpf(rs.getString("cpf"));

                //retorna endereço
                e.setCodigo(rs.getInt("idEndereco"));
                e.setCep(rs.getString("cep"));
                e.setCidade(rs.getString("cidade"));
                e.setComplemento(rs.getString("complemento"));
                e.setNumero(rs.getInt("numero"));
                e.setRua(rs.getString("rua"));

                //retorna estado
                estado.setCodigo(rs.getInt("idEstado"));
                estado.setNome(rs.getString("nomeEstado"));
                estado.setSigla(rs.getString("uf"));

                e.setEstado(estado);
                p.setEndereco(e);
            }
            return p;
        } catch (Exception e) {
            System.out.println("Erro ao pesquisar pessoa: " + e.getMessage());
        } finally {
            Conexao.fechaConexao(conn, ps, rs);
        }

        return null;
    }
}

*/