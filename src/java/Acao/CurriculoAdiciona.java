package Acao;

import bean.CidadeBean;
import bean.CurriculoBean;
import bean.FormacaoBean;
import bean.PessoaBean;
import bean.TrabalhosPublicacosBean;
import dao.CidadeDao;
import dao.CurriculoDao;
import dao.FormacaoDao;
import dao.PessoaDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CurriculoAdiciona implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
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
        request.setAttribute("cidades", lista);

        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
        request.setAttribute("edita", pessoas);

        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        request.setAttribute("curriculo", curriculo);

        int idCurri = Integer.parseInt((String) session.getAttribute("id_curri"));
        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosPublicacosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu("" + idCurri);
        request.setAttribute("trabalhos", trabalhos);

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu("" + idCurri);
        request.setAttribute("formacao", formacao);

        session.setAttribute("temCurri", "1");

        return "/paginas/pessoa/meuperfil.jsp";
    }

}
