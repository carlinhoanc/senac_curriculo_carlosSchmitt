package Acao;

import bean.PessoaBean;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PessoaDeleta implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setCharacterEncoding("UTF-8");
        String idd = req.getParameter("id_pessoa");
        PessoaDao pessoaDAO = new PessoaDao();
        pessoaDAO.desativa(Integer.parseInt(idd));

        HttpSession session = req.getSession();
        String id_tipo = null;
        if (session.getAttribute("id_tipo") != null) {
            if (session.getAttribute("id_tipo").equals("2")) {
                id_tipo = "2";
            } else {
                id_tipo = "0";
            }
        } else {
            id_tipo = "0";
        }

        List<PessoaBean> pessoas = pessoaDAO.listarPessoa(id_tipo);

        req.setAttribute("pessoaslista", pessoas);
        return "/paginas/pessoa/lista.jsp";
    }
}
