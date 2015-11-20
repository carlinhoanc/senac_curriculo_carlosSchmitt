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
import dao.TipoFormacaoDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormacaoAdiciona implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        CurriculoDao curri = new CurriculoDao();
        String idd = "" + session.getAttribute("id_pessoa");

        String idCurri = null;
        if (curri.idCurriPorPessoa(idd).equals("0")) {
            idCurri = "" + session.getAttribute("id_curri");
        } else {
            idCurri = curri.idCurriPorPessoa(idd);
        }
        
        FormacaoBean formacaoBean = new FormacaoBean();
        TipoFormacaoDao tipoFormacaoDao = new TipoFormacaoDao();

        formacaoBean.setNomeInstitui(request.getParameter("nomeInstitui"));
        formacaoBean.setDataInicio(request.getParameter("dataInicio"));
        formacaoBean.setDataTermino(request.getParameter("dataTermino"));
        formacaoBean.setId_Tipo(tipoFormacaoDao.listarTipoID(request.getParameter("id_tidoFormacao")));
        formacaoBean.setCurriculo_id_Curriculo(idCurri);

        FormacaoDao formacaoDao = new FormacaoDao();
        formacaoDao.insere(formacaoBean);
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu(idCurri);
        request.setAttribute("formacao", formacao);

        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();
        request.setAttribute("cidades", lista);

        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
        request.setAttribute("edita", pessoas);

        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        request.setAttribute("curriculo", curriculo);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu(idCurri);
        request.setAttribute("trabalhos", trabalhos);

        session.setAttribute("temCurri", "1");

        return "/paginas/pessoa/meuperfil.jsp";
    }

}
