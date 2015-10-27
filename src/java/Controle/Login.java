package Controle;

import bean.CidadeBean;
import bean.PessoaBean;
import dao.CidadeDao;
import dao.CurriculoDao;
import dao.LoginDao;
import dao.PessoaDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String nome = request.getParameter("nome");
        String senha = request.getParameter("senha");

        PessoaBean pessoaModel = new PessoaBean();
        pessoaModel.setSenha(senha);
        pessoaModel.setEmail(nome);

        String retorno = null;

        int insereP = LoginDao.fazerLogin(pessoaModel);
        if (insereP == 0) {
            request.setAttribute("falhalogin", "erro");
            retorno = "/paginas/login/login.jsp";
            RequestDispatcher disp = getServletContext().getRequestDispatcher(retorno);
            disp.forward(request, response);
        } else {
            CidadeDao cidades = new CidadeDao();
            List<CidadeBean> lista = cidades.listaCidades();
            PessoaDao pessoaDAO = new PessoaDao();
            List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(insereP + "");
            CurriculoDao curriDao = new CurriculoDao();
            int idCurri;

            HttpSession session = request.getSession();
            for (PessoaBean pessoa : pessoas) {
                idCurri = curriDao.idCurri(Integer.parseInt(pessoa.getId_Pessoa()));

                if (idCurri == 0) {
                    session.setAttribute("temCurri", "0");
                }else{
                    session.setAttribute("temCurri", "1");
                }

                session.setAttribute("ativo", pessoa.getAtivo());
                session.setAttribute("id_tipo", "" + pessoa.getTipo().getId());
                session.setAttribute("id_pessoa", "" + pessoa.getId_Pessoa());
                session.setAttribute("nome", pessoa.getNome());
                session.setAttribute("sobrenome", pessoa.getSobreNome());
                session.setAttribute("email", pessoa.getEmail());

                System.out.println(pessoa.getTipo().getId());

            }

            request.setAttribute("cidades", lista);
            request.setAttribute("edita", pessoas);
            retorno = "/paginas/pessoa/meuperfil.jsp";

            RequestDispatcher disp = getServletContext().getRequestDispatcher(retorno);
            disp.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
