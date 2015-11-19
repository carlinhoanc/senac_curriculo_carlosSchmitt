package dao;

import bean.PaisBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PaisDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    static Connection connection;

    public PaisDao() throws ClassNotFoundException {
        PaisDao.connection = new FabricaConexao().getConnection();
    }

    public PaisBean seledctPorID(String id) throws SQLException, ClassNotFoundException, Exception {
        PaisBean cidade = null;
        String sql = "SELECT * FROM pais WHERE id =" + id;
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);
            while (rs.next()) {
                cidade = new PaisBean();
                cidade.setId(rs.getString("id"));
                cidade.setNome(rs.getString("nome"));
            }
            stmt.close();
            return cidade;
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        } finally {
            FabricaConexao.fechaConexao(PaisDao.connection, stmt());
        }
    }

    public List<PaisBean> listarPaises() throws ClassNotFoundException, Exception {
        List<PaisBean> paisBean = new ArrayList<>();
        String sql = "SELECT * FROM pais";
        try {
            PreparedStatement stmt = null;
            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);
            while (rs.next()) {
                PaisBean paises = new PaisBean();
                paises.setId(rs.getString("id"));
                paises.setNome(rs.getString("nome"));
                paisBean.add(paises);
            }
            stmt.close();
            stmt().close();
            return paisBean;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Erro ao buscar paises no BD!");
            return paisBean;
        } finally {
            FabricaConexao.fechaConexao(PaisDao.connection, stmt());
        }
    }
}
