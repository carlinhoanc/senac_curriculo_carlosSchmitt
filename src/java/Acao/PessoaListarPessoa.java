package Acao;

import bean.PessoaBean;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaListarPessoa implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoa();

//        System.out.println("TAMANHO : " + pessoas.size());
//        System.out.println(pessoas.toString());
        
        request.setAttribute("pessoaslista", pessoas);
        return "/paginas/pessoa/lista.jsp";
        
    }

}
