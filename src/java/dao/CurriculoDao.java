package dao;

import bean.CurriculoBean;
import conexao.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurriculoDao {

    private Connection connection;

    public boolean insere(CurriculoBean curri) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        String sql1 = "SELECT id_Curriculo FROM curriculo WHERE pessoa_idPessoa= '" + curri.getIdPessoa() + "'";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql1);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                String sql = "INSERT INTO curriculo( resumo, expProfissional, forBasica, formMedio, pessoa_idPessoa) VALUES(?,?,?,?,?)";
                stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean deleta(int id) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM curriculo WHERE id_Curriculo = ?";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<CurriculoBean> listaTudo() throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        List<CurriculoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM curriculo";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
        } catch (SQLException | NumberFormatException e) {
            throw new RuntimeException(e);
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<CurriculoBean> listaCurriculoPessoa(int idC) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        List<CurriculoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM curriculo where pessoa_idPessoa = " + idC;
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
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
        } catch (SQLException e) {
            return result;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public List<CurriculoBean> listaCurriculoUnico(int idC) throws SQLException, ClassNotFoundException, Exception {
        List<CurriculoBean> result = new ArrayList<>();
        String sql = "SELECT * FROM curriculo where id_Curriculo = " + idC;
        try {
            this.connection = new FabricaConexao().getConnection();
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
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
            }
            return result;
        } catch (SQLException e) {
            return result;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public String idCurri(String idC) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM curriculo where id_Curriculo = " + idC;
        String id = "0";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getString("id_Curriculo");
            }
            stmt.close();
            return id;
        } catch (SQLException e) {
            return id;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public String idCurriPorPessoa(String idC) throws SQLException, ClassNotFoundException, Exception {
        PreparedStatement stmt = null;
        String sql = "SELECT * FROM curriculo where pessoa_idPessoa = " + idC;
        String id = "0";
        try {
            this.connection = new FabricaConexao().getConnection();
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getString("id_Curriculo");
            }
            stmt.close();
            return id;
        } catch (SQLException e) {
            return id;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }

    public boolean atualizar(CurriculoBean curri) throws SQLException, ClassNotFoundException, Exception {
        String sql = "UPDATE curriculo"
                + " SET resumo='" + curri.getResumo() + "',"
                + "expProfissional='" + curri.getExpProfissional() + "',"
                + "forBasica='" + curri.getForBasica() + "',"
                + "formMedio='" + curri.getFormMedio() + "'"
                + "WHERE id_Curriculo= " + curri.getId();

        try {
            this.connection = new FabricaConexao().getConnection();
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Pessoa no BD!");
            return false;
        } finally {
            FabricaConexao.fechaConexao(this.connection);
        }
    }
}
