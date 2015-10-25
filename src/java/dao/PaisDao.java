package dao;

import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PaisDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    public PaisDao() {

    }

    public static String seledctPorID(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM pais WHERE id =" + id;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);

        String retorno = null;
        while (rs.next()) {
            retorno = rs.getString("nome");
        }
        return retorno;
    }
}
