/*


package deletar_depoois;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.entidades.Endereco;
import model.entidades.Pessoa;

/**
 *
 * @author Jéssica
 * /

public class EnderecoDaoJessica {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public int salvar(Pessoa p) throws Exception {
        int idEndereco = 0;

        try {
            conn = Conexao.abrirConexao();

            String query = "insert into endereco (rua, complemento, cidade, numero, cep, idEstado) values (?,?,?,?,?,?)";
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getEndereco().getRua());
            ps.setString(2, p.getEndereco().getComplemento());
            ps.setString(3, p.getEndereco().getCidade());
            ps.setInt(4, p.getEndereco().getNumero());
            ps.setString(5, p.getEndereco().getCep());
            ps.setInt(6, p.getEndereco().getEstado().getCodigo());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            rs.next();

            idEndereco = rs.getInt(1);

        } catch (Exception exc) {
            System.out.println("Erro ao salvar endereço: " + exc.getMessage());
        } finally {
            Conexao.fechaConexao(conn, ps, rs);
        }
        return idEndereco;
    }

    public void alterar(Pessoa p) throws Exception {
        try {
            conn = Conexao.abrirConexao();
            
            String query = "update endereco set rua = ?, numero = ?, complemento = ?, cidade = ?, cep = ? where id = ?";
            ps = conn.prepareCall(query);
            ps.setString(1, p.getEndereco().getRua());
            ps.setInt(2, p.getEndereco().getNumero());
            ps.setString(3, p.getEndereco().getComplemento());
            ps.setString(4, p.getEndereco().getCidade());
            ps.setString(5, p.getEndereco().getCep());
            ps.setInt(6, p.getEndereco().getCodigo());
            ps.executeUpdate();
            
        } catch (Exception exc) {
            System.out.println("Erro ao alterar endereco: " + exc.getMessage());
        } finally {
            Conexao.fechaConexao(conn, ps);
        }
    }
    
    
}

*/