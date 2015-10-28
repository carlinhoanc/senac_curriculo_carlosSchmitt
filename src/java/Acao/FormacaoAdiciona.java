package Acao;

import bean.CidadeBean;
import bean.CurriculoBean;
import bean.FormacaoBean;
import bean.PessoaBean;
import bean.TipoFormacaoBean;
import bean.TrabalhosPublicacosBean;
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
        HttpSession session = request.getSession();
        String idCurri = "" + session.getAttribute("id_curri");
        String idd = "" + session.getAttribute("id_pessoa");

        FormacaoBean formacaoBean = new FormacaoBean();
        TipoFormacaoDao tipoFormacaoDao = new TipoFormacaoDao();

        formacaoBean.setNomeInstitui(request.getParameter("nomeInstitui"));
        formacaoBean.setDataInicio(request.getParameter("dataInicio"));
        formacaoBean.setDataTermino(request.getParameter("dataTermino"));
        formacaoBean.setId_Tipo(tipoFormacaoDao.listarTipoID(request.getParameter("id_tidoFormacao")));
        formacaoBean.setCurriculo_id_Curriculo(idCurri);

        FormacaoDao formacaoDao = new FormacaoDao();

        if (formacaoDao.insere(formacaoBean) == true) {
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

        CurriculoDao curri = new CurriculoDao();
        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        request.setAttribute("curriculo", curriculo);

        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu(idCurri);
        request.setAttribute("formacao", formacao);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosPublicacosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu(idCurri);
        request.setAttribute("trabalhos", trabalhos);

        session.setAttribute("temCurri", "1");

        return "/paginas/pessoa/meuperfil.jsp";
    }

}
