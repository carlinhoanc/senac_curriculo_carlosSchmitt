/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.CurriculoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author CarlosRoberto
 */
public class CurriculoDao {

    public static Connection com() throws SQLException, ClassNotFoundException {
        Connection con = new FabricaConexao().getConnection();
        return con;
    }

    public static Statement stmt() throws SQLException, ClassNotFoundException {
        Statement stmt = com().createStatement();
        return stmt;
    }

    public CurriculoDao() {

    }

    public static boolean insere(CurriculoBean curri) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO curriculo( resumo, expProfissional, forBasica, FormMedio) VALUES(?,?,?,?)";
        stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1, curri.getResumo());
        stmt.setString(2, curri.getExpProfissional());
        stmt.setString(3, curri.getForBasica());
        stmt.setString(4, curri.getFormMedio());
        stmt.executeUpdate();
        stmt.close();

        return true;

    }

    public static boolean deleta(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM curriculo WHERE id_Curriculo = ?";
        stmt = com().prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();

        return true;
    }

    public static ArrayList<Object[]> listaTudo() throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        ArrayList<Object[]> result = new ArrayList<>();
        String sql = "SELECT * FROM curriculo";
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);

        while (rs.next()) {
            result.add(new Object[]{
                rs.getString("id_Curriculo"),
                rs.getString("resumo"),
                rs.getString("expProfissional"),
                rs.getString("forBasica"),
                rs.getString("FormMedio")
            });
        }

        stmt.close();
        return result;
    }

    public static ArrayList<Object[]> selectUsuario(int idC) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        ArrayList<Object[]> result = new ArrayList<>();
        String sql = "SELECT * FROM curriculo where id_Curriculo = " + idC;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);

        while (rs.next()) {
            result.add(new Object[]{
                rs.getString("id_Curriculo"),
                rs.getString("resumo"),
                rs.getString("expProfissional"),
                rs.getString("forBasica"),
                rs.getString("FormMedio")
            });
        }

        stmt.close();
        return result;
    }

    public static boolean atualizar(CurriculoBean curri) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        
        String sql = "UPDATE curriculo SET resumo=?,expProfissional=?,forBasica=?,FormMedio=? WHERE id_Curriculo= " + curri.getId() ;

        stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1, curri.getResumo());
        stmt.setString(2, curri.getExpProfissional());
        stmt.setString(3, curri.getForBasica());
        stmt.setString(4, curri.getFormMedio());
        stmt.executeUpdate();
        stmt.close();
        
        return true;
    }
}
