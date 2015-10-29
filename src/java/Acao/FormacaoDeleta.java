package Acao;

import bean.CurriculoBean;
import bean.FormacaoBean;
import bean.PaisBean;
import bean.PessoaBean;
import bean.TipoFormacaoBean;
import bean.TrabalhosPublicacosBean;
import dao.CurriculoDao;
import dao.FormacaoDao;
import dao.PaisDao;
import dao.PessoaDao;
import dao.TipoFormacaoDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormacaoDeleta implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse res) throws Exception {
        String id_formacaos = "" + request.getParameter("id_formacaos");

        FormacaoDao formacaoDao = new FormacaoDao();
        formacaoDao.deleta(id_formacaos);

        HttpSession session = request.getSession();
        String idd = "" + session.getAttribute("id_pessoa");
        String idCurri = "" + session.getAttribute("id_curri");

        PaisDao paisDao = new PaisDao();
        List<PaisBean> paises = paisDao.listarPaises();
        request.setAttribute("paises", paises);

        TipoFormacaoDao tipoFormaDao = new TipoFormacaoDao();
        List<TipoFormacaoBean> tipoForma = tipoFormaDao.listarTipoFormacao();
        request.setAttribute("tipoForma", tipoForma);

        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
        request.setAttribute("edita", pessoas);

        CurriculoDao curri = new CurriculoDao();
        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        request.setAttribute("curriculo", curriculo);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosPublicacosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu(idCurri);
        request.setAttribute("trabalhos", trabalhos);
        
//           FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu(""+idCurri);
        request.setAttribute("formacao", formacao);

        return "/paginas/pessoa/meuperfil.jsp";
    }
}
