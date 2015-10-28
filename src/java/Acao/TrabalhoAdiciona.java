package Acao;

import bean.CidadeBean;
import bean.CurriculoBean;
import bean.FormacaoBean;
import bean.PessoaBean;
import bean.TrabalhosPublicacosBean;
import dao.CidadeDao;
import dao.CurriculoDao;
import dao.FormacaoDao;
import dao.PaisDao;
import dao.PessoaDao;
import dao.TipoTrabalhoDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TrabalhoAdiciona implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String idCurri = "" + session.getAttribute("id_curri");
        String idd = "" + session.getAttribute("id_pessoa");

        TipoTrabalhoDao tipodao = new TipoTrabalhoDao();
        PaisDao paisDao = new PaisDao();
        TrabalhosPublicacosBean trabalhoBean = new TrabalhosPublicacosBean();

        trabalhoBean.setNome(request.getParameter("nome"));
        trabalhoBean.setAno(Integer.parseInt(request.getParameter("ano")));
        trabalhoBean.setPais(paisDao.seledctPorID(request.getParameter("pais")));
        trabalhoBean.setId_TipoPublicados(tipodao.listarTipoID(request.getParameter("id_tipoTrab")));
        trabalhoBean.setId_Curriculo(idCurri);

        TrabalhosDao trabalhosDao = new TrabalhosDao();

        if (trabalhosDao.insere(trabalhoBean) == true) {
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

        List<TrabalhosPublicacosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu(idCurri);
        request.setAttribute("trabalhos", trabalhos);

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu(""+idCurri);
        request.setAttribute("formacao", formacao);

        session.setAttribute("temCurri", "1");
        return "/paginas/pessoa/meuperfil.jsp";
    }

}
