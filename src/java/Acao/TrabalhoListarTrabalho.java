package Acao;

import bean.CurriculoBean;
import bean.FormacaoBean;
import bean.PaisBean;
import bean.TipoFormacaoBean;
import bean.TrabalhosBean;
import dao.CurriculoDao;
import dao.FormacaoDao;
import dao.PaisDao;
import dao.TipoFormacaoDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TrabalhoListarTrabalho implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String idd = "" + session.getAttribute("id_pessoa");
        String idCurri = "" + session.getAttribute("id_curri");

        PaisDao paisDao = new PaisDao();
        List<PaisBean> paises = paisDao.listarPaises();
        request.setAttribute("paises", paises);

        TipoFormacaoDao tipoFormaDao = new TipoFormacaoDao();
        List<TipoFormacaoBean> tipoForma = tipoFormaDao.listarTipoFormacao();
        request.setAttribute("tipoForma", tipoForma);

        CurriculoDao curri = new CurriculoDao();
        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        request.setAttribute("curriculo", curriculo);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu(idCurri);
        request.setAttribute("trabalhos", trabalhos);

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu("" + idCurri);
        request.setAttribute("formacao", formacao);

        return "/paginas/pessoa/meuperfil.jsp";
    }

}
