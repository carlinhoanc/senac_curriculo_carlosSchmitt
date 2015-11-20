package dao;

import bean.PaisBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDao {

    private Connection connection;

    public PaisBean seledctPorID(String id) throws SQLException, ClassNotFoundException, Exception {
        PaisBean cidade = null;
        String sql = "SELECT * FROM pais WHERE id =" + id;
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                cidade = new PaisBean();
                cidade.setId(rs.getString("id"));
                cidade.setNome(rs.getString("nome"));
            }
            stmt.close();
            return cidade;
        } catch (SQLException e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<PaisBean> listarPaises() throws ClassNotFoundException, Exception {
        List<PaisBean> paisBean = new ArrayList<>();
        String sql = "SELECT * FROM pais";
        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PaisBean paises = new PaisBean();
                paises.setId(rs.getString("id"));
                paises.setNome(rs.getString("nome"));
                paisBean.add(paises);
            }
            stmt.close();
            return paisBean;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar paises no BD!");
            return paisBean;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }
}
