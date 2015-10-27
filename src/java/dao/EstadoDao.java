package dao;

import bean.EstadosBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstadoDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    private static Connection connection;

    public EstadoDao() throws ClassNotFoundException {
        EstadoDao.connection = new FabricaConexao().getConnection();
    }

    public EstadosBean seledctPorID(int id) throws SQLException, ClassNotFoundException, Exception {
        EstadosBean estado = null;
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM estado WHERE id =" + id;

        try {

            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);

            String retorno = null;
            while (rs.next()) {
                estado = new EstadosBean();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("UF"));
            }
            stmt.close();
            return estado;
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }

        finally{
        FabricaConexao.fechaConexao(EstadoDao.connection);
        }
    }

    public List<EstadosBean> listarEstados() throws SQLException, ClassNotFoundException, Exception {
        EstadosBean estado = null;
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM estado";
        List<EstadosBean> estados = new ArrayList<>();

        try {

            stmt = com().prepareStatement(sql);
            ResultSet rs = stmt().executeQuery(sql);

            String retorno = null;
            while (rs.next()) {
                estado = new EstadosBean();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setUf(rs.getString("UF"));
                estados.add(estado);
            }
            stmt.close();
            return estados;
        } catch (SQLException | ClassNotFoundException e) {
            return null;
        }

        finally{
        FabricaConexao.fechaConexao(EstadoDao.connection);
        }
    }
}
