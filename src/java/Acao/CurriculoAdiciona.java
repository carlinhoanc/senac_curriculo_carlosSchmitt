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

public class CurriculoAdiciona implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        CurriculoDao curri = new CurriculoDao();

        String idd = "" + session.getAttribute("id_pessoa");
        String temCurri = "" + session.getAttribute("temCurri");

        CurriculoBean curriBeans = new CurriculoBean();
        curriBeans.setExpProfissional(request.getParameter("expProfissional"));
        curriBeans.setForBasica(request.getParameter("forBasica"));
        curriBeans.setFormMedio(request.getParameter("formMedio"));
        curriBeans.setIdPessoa(idd);
        curriBeans.setId(Integer.parseInt(temCurri));
        curriBeans.setResumo(request.getParameter("resumo"));

        if (curri.insere(curriBeans) == true) {
            request.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            request.setAttribute("msg", "Erro ao inserirr pessoa");
        }
        
        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();

        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
        
        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));

        session.setAttribute("temCurri", "1");
        request.setAttribute("curriculo", curriculo);
        request.setAttribute("cidades", lista);
        request.setAttribute("edita", pessoas);

        return "/paginas/pessoa/meuperfil.jsp";
    }

}
