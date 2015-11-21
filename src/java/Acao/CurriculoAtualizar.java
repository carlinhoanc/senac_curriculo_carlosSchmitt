package Acao;

import bean.CidadeBean;
import bean.CurriculoBean;
import bean.FormacaoBean;
import bean.PessoaBean;
import bean.TrabalhosBean;
import dao.CidadeDao;
import dao.CurriculoDao;
import dao.FormacaoDao;
import dao.PessoaDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CurriculoAtualizar implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String idd = "" + session.getAttribute("id_pessoa");
        String temCurri = "" + session.getAttribute("temCurri");

        CurriculoBean curriBeans = new CurriculoBean();
        CurriculoDao curri = new CurriculoDao();

        String idCurri = null;
        if (curri.idCurriPorPessoa(idd).equals("0")) {
            idCurri = "" + session.getAttribute("id_curri");
        } else {
            idCurri = curri.idCurriPorPessoa(idd);
        }
        
        System.out.println(idCurri);

        curriBeans.setExpProfissional(request.getParameter("expProfissional"));
        curriBeans.setForBasica(request.getParameter("forBasica"));
        curriBeans.setFormMedio(request.getParameter("formMedio"));
        curriBeans.setIdPessoa(idd);
        curriBeans.setId(Integer.parseInt(idCurri));
        curriBeans.setResumo(request.getParameter("resumo"));

        if (curri.atualizar(curriBeans) == true) {
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

        List<CurriculoBean> curriculo = curri.listaCurriculoUnico(Integer.parseInt(idCurri));
        request.setAttribute("curriculo", curriculo);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu("" + idCurri);
        request.setAttribute("trabalhos", trabalhos);

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu("" + idCurri);
        request.setAttribute("formacao", formacao);

        return "/paginas/pessoa/meuperfil.jsp";
    }
}
