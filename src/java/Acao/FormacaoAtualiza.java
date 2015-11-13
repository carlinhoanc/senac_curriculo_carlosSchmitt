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
import dao.TipoFormacaoDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormacaoAtualiza implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String idCurri = null;

        String idd = "" + session.getAttribute("id_pessoa");
        FormacaoBean formacaoBean = new FormacaoBean();
        TipoFormacaoDao tipoFormacaoDao = new TipoFormacaoDao();

        formacaoBean.setId(Integer.parseInt(request.getParameter("id_formacao")));
        formacaoBean.setNomeInstitui(request.getParameter("nomeInstitui"));
        formacaoBean.setDataInicio(request.getParameter("dataInicio"));
        formacaoBean.setDataTermino(request.getParameter("dataTermino"));
        formacaoBean.setId_Tipo(tipoFormacaoDao.listarTipoID(request.getParameter("id_tidoFormacao")));
        formacaoBean.setCurriculo_id_Curriculo(idCurri);

        FormacaoDao formacaoDao = new FormacaoDao();
        formacaoDao.atualiza(formacaoBean);

        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();
        request.setAttribute("cidades", lista);

        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
        request.setAttribute("edita", pessoas);

        CurriculoDao curri = new CurriculoDao();
        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        request.setAttribute("curriculo", curriculo);

        if (curri.idCurriPorPessoa(idd).equals("0")) {
            idCurri = "" + session.getAttribute("id_curri");
        } else {
            idCurri = curri.idCurriPorPessoa(idd);
        }

        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu(idCurri);
        request.setAttribute("formacao", formacao);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosPublicacosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu(idCurri);
        request.setAttribute("trabalhos", trabalhos);

        session.setAttribute("temCurri", "1");

        return "/paginas/pessoa/meuperfil.jsp";

    }
}
