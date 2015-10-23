/*



package exemplos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import exemplos.jdbc.ConnectionFactory;
import exemplos.modelo.Endereco;
import exemplos.modelo.Pessoa;

public class PessoaDAO {

	private Connection connection;

	public PessoaDAO()
	{
		this.connection = new ConnectionFactory().getConnection();
	}

	public int adiciona(Pessoa pessoa) {

		int idInserido = 0;
		int idEndereco = 0;
		String sql = "INSERT INTO Pessoa (nome, sobrenome, idendereco) VALUES (?, ?, ?)";

		if(pessoa.getEndereco() != null)
		{
			Endereco endereco = pessoa.getEndereco();
			EnderecoDAO enderecoDAO = new EnderecoDAO();

			idEndereco = enderecoDAO.adiciona(endereco);
			if(idEndereco == 0)
				return 0;
		}

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSobrenome());
			stmt.setInt(3, idEndereco);
			// executa
			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();  

			if(rs.next())
				idInserido = rs.getInt(1);  	

			if(idInserido > 0)
				System.out.println("Pessoa inserida com sucesso no BD!");
			else
				System.out.println("Erro ao inserir Pessoa no BD!");

			stmt.close();
			return idInserido;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Pessoa no BD!");
			throw new RuntimeException(e);
		}
		finally {
			ConnectionFactory.fechaConexao(this.connection);
		}
	}

	public boolean atualiza(Pessoa pessoa) {

		boolean atualizadoSucesso = false;
		String sql = "UPDATE Pessoa SET nome = ?, sobrenome = ?, idendereco = ? WHERE id = ?";

		Endereco endereco = pessoa.getEndereco();
		EnderecoDAO enderecoDAO = new EnderecoDAO();

		if(enderecoDAO.atualiza(endereco) == false)
			return false;

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getSobrenome());
			stmt.setInt(3, pessoa.getEndereco().getId());
			stmt.setInt(4, pessoa.getId());
			// executa
			int ok = stmt.executeUpdate();

			if(ok == 1)
			{
				System.out.println("Pessoa atualizada com sucesso no BD!");
				atualizadoSucesso = true;
			}
			else
				System.out.println("Erro ao atualizar Pessoa no BD!");

			stmt.close();
			return atualizadoSucesso;

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Pessoa no BD!");
			throw new RuntimeException(e);
		}
		finally {
			ConnectionFactory.fechaConexao(this.connection);
		}
	}

	public boolean remove(int cdPessoa) {

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		if(enderecoDAO.remove(cdPessoa) == false)
			return false;

		boolean removidoSucesso = false;
		String sql = "DELETE FROM Pessoa WHERE id = ?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, cdPessoa);
			// executa
			int ok = stmt.executeUpdate();

			if(ok == 1)
			{
				System.out.println("Pessoa removida com sucesso no BD!");
				removidoSucesso = true;
			}
			else
				System.out.println("Erro ao remover Pessoa no BD!");

			stmt.close();
			return removidoSucesso;
		} catch (SQLException e) {
			System.out.println("Erro ao remover Pessoa no BD!");
			throw new RuntimeException(e);
		}
	}

	public Pessoa obtemPessoa(int cdPessoa) {
		Pessoa pessoa = null;

		String sql = "SELECT * FROM Pessoa WHERE id = ?";

		EnderecoDAO enderecoDAO = new EnderecoDAO();
		Endereco endereco = enderecoDAO.obtemEndereco(cdPessoa);
		System.out.println("ENDERECO: " + endereco.getId() + " :: " + endereco.getRua());
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setMaxRows(1);
			stmt.setInt(1, cdPessoa);
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSobrenome(rs.getString("sobrenome"));
				pessoa.setEndereco(endereco);
				System.out.println("PESSOA: " + pessoa.getId() + " :: " + pessoa.getEndereco().getRua());
			}
			stmt.close();
			return pessoa;
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pessoas no BD!");
			e.printStackTrace();
			return null;
		}
		finally {
			ConnectionFactory.fechaConexao(this.connection);
		}
	}

	public List<Pessoa> listarPessoa() {

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		EnderecoDAO enderecoDAO;
		String sql = "SELECT * FROM Pessoa";
		try {

			PreparedStatement stmt = connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enderecoDAO = new EnderecoDAO();
				Pessoa pessoa = new Pessoa();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setSobrenome(rs.getString("sobrenome"));
				pessoa.setEndereco(enderecoDAO.obtemEndereco(pessoa.getId()));
				pessoas.add(pessoa);
				System.out.println("PESSOA: " + pessoa.getId() + " :: " + pessoa.getEndereco().getRua());
			}
			stmt.close();
			return pessoas;
		} catch (SQLException e) {
			System.out.println("Erro ao buscar pessoas no BD!");
			return pessoas;
		}
		finally {
			ConnectionFactory.fechaConexao(this.connection);
		}
	}
}



*/