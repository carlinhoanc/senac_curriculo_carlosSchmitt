package Controle;

import bean.CidadeBean;
import bean.CurriculoBean;
import bean.FormacaoBean;
import bean.PaisBean;
import bean.PessoaBean;
import bean.TipoFormacaoBean;
import bean.TrabalhosBean;
import dao.CidadeDao;
import dao.CurriculoDao;
import dao.FormacaoDao;
import dao.LoginDao;
import dao.PaisDao;
import dao.PessoaDao;
import dao.TipoFormacaoDao;
import dao.TrabalhosDao;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        LoginDao loginDao = new LoginDao();
        int insereP = loginDao.fazerLogin(pessoaModel);
        HttpSession session = request.getSession();

        if (insereP == 0) {
            session.setAttribute("loginErrado", "0");
            retorno = "/paginas/login/login.jsp";
            RequestDispatcher disp = getServletContext().getRequestDispatcher(retorno);
            disp.forward(request, response);
        } else {

            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, 1);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String formatted = format1.format(cal.getTime());

            // Cria  o objeto Cookie
            Cookie cookieNome = new Cookie("Nome", nome);
            Cookie cookieData = new Cookie("Data", formatted);

            //Adiciona os Cookies no reponse
            response.addCookie(cookieNome);
            response.addCookie(cookieData);

            String idCurri;
            session.setAttribute("loginCorreto", "1");

            CidadeDao cidades = new CidadeDao();
            List<CidadeBean> lista = cidades.listaCidades();
            request.setAttribute("cidades", lista);

            PessoaDao pessoaDAO = new PessoaDao();
            List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(insereP + "");
            request.setAttribute("edita", pessoas);

            CurriculoDao curriDao = new CurriculoDao();

            for (PessoaBean pessoa : pessoas) {
                idCurri = curriDao.idCurriPorPessoa(pessoa.getId_Pessoa());

                if (idCurri.equals("0")) {
                    session.setAttribute("id_curri", "0");
                    session.setAttribute("temCurri", "0");
                } else {
                    session.setAttribute("id_curri", idCurri);
                    session.setAttribute("temCurri", "1");
                }

                session.setAttribute("ativo", pessoa.getAtivo());
                session.setAttribute("id_tipo", "" + pessoa.getTipo().getId());
                session.setAttribute("id_pessoa", "" + pessoa.getId_Pessoa());
                session.setAttribute("nome", pessoa.getNome());
                session.setAttribute("sobrenome", pessoa.getSobreNome());
                session.setAttribute("email", pessoa.getEmail());

                List<CurriculoBean> curriculo = curriDao.listaCurriculoPessoa(Integer.parseInt("" + session.getAttribute("id_pessoa")));
                request.setAttribute("curriculo", curriculo);

                TrabalhosDao trabalhosDao = new TrabalhosDao();
                List<TrabalhosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu("" + idCurri);
                request.setAttribute("trabalhos", trabalhos);

                FormacaoDao formacaoDao = new FormacaoDao();
                List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu("" + idCurri);
                request.setAttribute("formacao", formacao);
            }

            PaisDao paisDao = new PaisDao();
            List<PaisBean> paises = paisDao.listarPaises();
            request.setAttribute("paises", paises);

            TipoFormacaoDao tipoFormaDao = new TipoFormacaoDao();
            List<TipoFormacaoBean> tipoForma = tipoFormaDao.listarTipoFormacao();
            request.setAttribute("tipoForma", tipoForma);

            request.setAttribute("cidades", lista);
            request.setAttribute("edita", pessoas);

            retorno = "/Pessoa?acao=PessoaListarPessoa";
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
