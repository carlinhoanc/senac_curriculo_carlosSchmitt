package Acao;

import bean.PessoaBean;
import dao.EnderecoDao;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaDeleta implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idd = req.getParameter("id_pessoa");

        PessoaDao pessoaDAO = new PessoaDao();
        EnderecoDao end = new EnderecoDao();

        end.deleta(Integer.parseInt(idd));
        pessoaDAO.delete(Integer.parseInt(idd));

        List<PessoaBean> pessoas = pessoaDAO.listarPessoa();

        req.setAttribute("pessoaslista", pessoas);
        return "/paginas/pessoa/lista.jsp";
    }
}
