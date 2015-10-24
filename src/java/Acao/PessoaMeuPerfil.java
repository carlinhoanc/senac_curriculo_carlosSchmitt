package Acao;

import bean.CidadeBean;
import bean.PessoaBean;
import dao.CidadeDao;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PessoaMeuPerfil implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idd = null;
        HttpSession session = req.getSession();
        
        if(session.getAttribute("id_pessoa") != null ){
            idd = "" + session.getAttribute("id_pessoa");
        }else{
            idd = req.getParameter("id_pessoa");
        }

        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();
        
        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
         
        req.setAttribute("cidades", lista);
        req.setAttribute("edita", pessoas);

        return "/paginas/pessoa/meuperfil.jsp";
    }
}
