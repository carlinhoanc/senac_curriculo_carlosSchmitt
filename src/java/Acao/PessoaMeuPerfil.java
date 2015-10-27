package Acao;

import bean.CidadeBean;
import bean.CurriculoBean;
import bean.PessoaBean;
import dao.CidadeDao;
import dao.CurriculoDao;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PessoaMeuPerfil implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse res) throws Exception {
        String idd = null;
        HttpSession session = request.getSession();
        
        if(session.getAttribute("id_pessoa") != null ){
            idd = "" + session.getAttribute("id_pessoa");
        }else{
            idd = request.getParameter("id_pessoa");
        }

        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();
        
        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);

        CurriculoDao curri = new CurriculoDao();
        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        
        request.setAttribute("curriculo", curriculo); 
        request.setAttribute("cidades", lista);
        request.setAttribute("edita", pessoas);

        return "/paginas/pessoa/meuperfil.jsp";
    }
}
