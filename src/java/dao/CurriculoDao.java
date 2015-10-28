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
import java.util.List;
import javax.servlet.http.HttpSession;

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

    private static Connection connection;

    public CurriculoDao() throws ClassNotFoundException {
        CurriculoDao.connection = new FabricaConexao().getConnection();
    }

    public boolean insere(CurriculoBean curri) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        System.out.println(curri.getIdPessoa());

        String sql1 = "SELECT id_Curriculo FROM curriculo WHERE pessoa_idPessoa= '" + curri.getIdPessoa() + "'";
        ResultSet rs = stmt().executeQuery(sql1);
        if (!rs.next()) {

            String sql = "INSERT INTO curriculo( resumo, expProfissional, forBasica, formMedio, pessoa_idPessoa) VALUES(?,?,?,?,?)";
            stmt = com().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, curri.getResumo());
            stmt.setString(2, curri.getExpProfissional());
            stmt.setString(3, curri.getForBasica());
            stmt.setString(4, curri.getFormMedio());
            stmt.setString(5, curri.getIdPessoa());
            stmt.executeUpdate();
            stmt.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean deleta(int id) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM curriculo WHERE id_Curriculo = ?";
        stmt = com().prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();

        return true;
    }

    public List<CurriculoBean> listaTudo() throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        List<CurriculoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM curriculo";
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);

        while (rs.next()) {
            CurriculoBean curriBean = new CurriculoBean();
            curriBean.setId(Integer.parseInt(rs.getString("id_Curriculo")));
            curriBean.setResumo(rs.getString("resumo"));
            curriBean.setExpProfissional(rs.getString("expProfissional"));
            curriBean.setForBasica(rs.getString("forBasica"));
            curriBean.setFormMedio(rs.getString("formMedio"));
            curriBean.setIdPessoa(rs.getString("pessoa_idPessoa"));
            result.add(curriBean);
        }

        stmt.close();
        return result;
    }

    public List<CurriculoBean> listaCurriculoPessoa(int idC) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        List<CurriculoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM curriculo where pessoa_idPessoa = " + idC;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);

        while (rs.next()) {
            CurriculoBean curriBean = new CurriculoBean();
            curriBean.setId(Integer.parseInt(rs.getString("id_Curriculo")));
            curriBean.setResumo(rs.getString("resumo"));
            curriBean.setExpProfissional(rs.getString("expProfissional"));
            curriBean.setForBasica(rs.getString("forBasica"));
            curriBean.setFormMedio(rs.getString("formMedio"));
            curriBean.setIdPessoa(rs.getString("pessoa_idPessoa"));
            result.add(curriBean);
        }
        stmt.close();
        return result;
    }

    public List<CurriculoBean> listaCurriculoUnico(int idC) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        List<CurriculoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM curriculo where id_Curriculo = " + idC;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);

        while (rs.next()) {
            CurriculoBean curriBean = new CurriculoBean();
            curriBean.setId(Integer.parseInt(rs.getString("id_Curriculo")));
            curriBean.setResumo(rs.getString("resumo"));
            curriBean.setExpProfissional(rs.getString("expProfissional"));
            curriBean.setForBasica(rs.getString("forBasica"));
            curriBean.setFormMedio(rs.getString("formMedio"));
            curriBean.setIdPessoa(rs.getString("pessoa_idPessoa"));
            result.add(curriBean);
        }

        stmt.close();
        return result;
    }

    public String idCurri(String idC) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM curriculo where id_Curriculo = " + idC;
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        String id = "0";
        while (rs.next()) {
            id = rs.getString("id_Curriculo");
        }
        stmt.close();
        return id;
    }

    public String idCurriPorPessoa(String idC) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM curriculo where pessoa_idPessoa = " + idC;
        System.out.println(sql);
        stmt = com().prepareStatement(sql);
        ResultSet rs = stmt().executeQuery(sql);
        String id = null;
        while (rs.next()) {
            id = rs.getString("id_Curriculo");
            System.out.println(id);
        }
        stmt.close();
        return id;
    }

    public boolean atualizar(CurriculoBean curri) throws SQLException, ClassNotFoundException, Exception {

        String sql = "UPDATE curriculo"
                + " SET resumo='" + curri.getResumo() + "',"
                + "expProfissional='" + curri.getExpProfissional() + "',"
                + "forBasica='" + curri.getForBasica() + "',"
                + "formMedio='" + curri.getFormMedio() + "'"
                + "WHERE id_Curriculo= " + curri.getId();
        System.out.println(sql);
        boolean atualizadoSucesso = false;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            return atualizadoSucesso;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(CurriculoDao.connection);
        }
    }
}
