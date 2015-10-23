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

public class EnderecoDAO {
	
	private Connection connection;

	public EnderecoDAO()
	{
		this.connection = new ConnectionFactory().getConnection();
	}

	public int adiciona(Endereco endereco) {
		
		int idInserido = 0;
		String sql = "INSERT INTO Endereco (rua, numero, bairro) VALUES (?, ?, ?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			// seta os valores
			stmt.setString(1, endereco.getRua());
			stmt.setInt(2, endereco.getNumero());
			stmt.setString(3, endereco.getBairro());
			// executa
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();  
		    
			if(rs.next())
		    	idInserido = rs.getInt(1);  
		    
			if(idInserido > 0)
				System.out.println("Endereco inserido com sucesso no BD!");
			else
				System.out.println("Erro ao inserir Endereco no BD!");
			stmt.close();
			return idInserido;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir Endereco no BD!");
			throw new RuntimeException(e);
		}
		finally {
			ConnectionFactory.fechaConexao(this.connection);
		}
	}

	public boolean atualiza(Endereco endereco) {

		boolean atualizadoSucesso = false;
		String sql = "UPDATE Endereco SET rua = ?, numero = ?, bairro = ? WHERE id = ?";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, endereco.getRua());
			stmt.setInt(2, endereco.getNumero());
			stmt.setString(3, endereco.getBairro());
			stmt.setInt(4, endereco.getId());
			// executa
			int ok = stmt.executeUpdate();
			
			if(ok == 1)
			{
				System.out.println("Endereco atualizado com sucesso no BD!");
				atualizadoSucesso = true;
			}
			else
				System.out.println("Erro ao atualizar Endereco no BD!");
			
			stmt.close();
			return atualizadoSucesso;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar Endereco no BD!");
			throw new RuntimeException(e);
		}
		finally {
			ConnectionFactory.fechaConexao(this.connection);
		}
	}

	public boolean remove(int cdPessoa) {
		
		boolean removidoSucesso = false;
		String sql = "DELETE FROM Endereco WHERE id IN (SELECT p.idendereco from Pessoa p WHERE p.id = ?)";

		try {
			// prepared statement para inserção
			PreparedStatement stmt = connection.prepareStatement(sql);
			// seta os valores
			stmt.setInt(1, cdPessoa);
			// executa
			int ok = stmt.executeUpdate();
			if(ok == 1)
			{
				System.out.println("Endereco removido com sucesso no BD!");
				removidoSucesso = true;
			}
			else
				System.out.println("Erro ao remover Endereco no BD!");
			stmt.close();
			return removidoSucesso;
		} catch (SQLException e) {
			System.out.println("Erro ao remover Endereco no BD!");
			throw new RuntimeException(e);
		}
	}
	
	public Endereco obtemEndereco(int cdPessoa) {
		Endereco endereco = null;
		String sql = "SELECT e.* FROM Endereco e INNER JOIN Pessoa p ON e.id = p.idendereco WHERE p.id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, cdPessoa);
			stmt.setMaxRows(1);
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setBairro(rs.getString("bairro"));
				System.out.println("ENDERECO: " + endereco.getId() + " :: " + endereco.getRua());
			}
			stmt.close();
			return endereco;
		} catch (SQLException e) {
			System.out.println("Erro ao buscar endereco no BD!");
			return null;
		}
		finally {
			ConnectionFactory.fechaConexao(this.connection);
		}
	}
	
	public List<Endereco> listarEndereco() {

		List<Endereco> enderecos = new ArrayList<Endereco>();

		String sql = "SELECT * FROM Endereco";
		try {
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			// executa
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt("id"));
				endereco.setRua(rs.getString("rua"));
				endereco.setNumero(rs.getInt("numero"));
				endereco.setBairro(rs.getString("bairro"));
				enderecos.add(endereco);
				System.out.println("Endereço: " + endereco.getId() + " :: " + endereco.getRua() + "::" + endereco.getNumero());
			}
			stmt.close();
			return enderecos;
		} catch (SQLException e) {
			System.out.println("Erro ao buscar enderecos no BD!");
			return enderecos;
		}
		finally {
			ConnectionFactory.fechaConexao(this.connection);
		}
	}
}




*/