package Acao;

import bean.CidadeBean;
import bean.PessoaBean;
import dao.CidadeDao;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaEditar implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idd= req.getParameter("id_pessoa");

        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();
        
        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
         
//        System.out.println("TAMANHO : " + pessoas.size());
        req.setAttribute("cidades", lista);
        req.setAttribute("edita", pessoas);

        return "/paginas/pessoa/editar.jsp";
    }
}
