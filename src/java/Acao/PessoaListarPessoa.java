package Acao;

import bean.PessoaBean;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PessoaListarPessoa implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        PessoaDao pessoaDAO = new PessoaDao();

        HttpSession session = request.getSession();
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
        request.setAttribute("pessoaslista", pessoas);
        return "/paginas/pessoa/lista.jsp";
    }
}
