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

public class PessoaCurriculo implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse res) throws Exception {
        String idd= request.getParameter("id_pessoa");

        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();
        
        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
         
//        System.out.println("TAMANHO : " + pessoas.size());
        
        HttpSession session = request.getSession();
        String temCurri = "" + session.getAttribute("temCurri");
        String id_curri = "" + session.getAttribute("id_curri");
        String id_pessoa = "" + session.getAttribute("id_pessoa");

        CurriculoBean curriBeans = new CurriculoBean();
        CurriculoDao curri = new CurriculoDao();
        List<CurriculoBean> curriculo = curri.listaCurriculoUnico(Integer.parseInt(id_pessoa));

        request.setAttribute("curriculo", curriculo);
        request.setAttribute("cidades", lista);
        request.setAttribute("edita", pessoas);

        return "/paginas/pessoa/visualizarCurriculo.jsp";
    }
}
