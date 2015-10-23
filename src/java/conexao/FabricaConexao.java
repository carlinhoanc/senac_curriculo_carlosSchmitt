/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author CarlosRoberto
 */
public class FabricaConexao {

    public Connection getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/carlos_senac_4", "root", "zaxs1425");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fecha(Connection conn, Statement stmt,
            ResultSet rs) throws Exception {

        try {
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void fechaConexao(Connection conn, Statement stmt, ResultSet rs) throws Exception {
        fecha(conn, stmt, rs);
    }

    public static void fechaConexao(Connection conn, Statement stmt) throws Exception {
        fecha(conn, stmt, null);
    }

    public static void fechaConexao(Connection conn) throws Exception {
        fecha(conn, null, null);
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try (Connection connection = new FabricaConexao().getConnection()) {
            System.out.println("Conexão aberta!");
        }
    }
}
