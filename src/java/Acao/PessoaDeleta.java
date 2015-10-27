package Acao;

import bean.PessoaBean;
import dao.EnderecoDao;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PessoaDeleta implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idd = req.getParameter("id_pessoa");

        PessoaDao pessoaDAO = new PessoaDao();
        EnderecoDao end = new EnderecoDao();

//        end.deleta(Integer.parseInt(idd));
//        pessoaDAO.delete(Integer.parseInt(idd));
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
