package Acao;

import bean.FormacaoBean;
import bean.PaisBean;
import bean.TipoTrabalhoPublicadosBean;
import bean.TrabalhosPublicacosBean;
import dao.FormacaoDao;
import dao.PaisDao;
import dao.TipoTrabalhoDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TrabalhoEditar implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String idCurri = "" + session.getAttribute("id_curri");

        PaisDao paisDao = new PaisDao();
        List<PaisBean> paises = paisDao.listarPaises();
        request.setAttribute("paises", paises);

        TipoTrabalhoDao tipoTrabalhoDao = new TipoTrabalhoDao();
        List<TipoTrabalhoPublicadosBean> tipoTrabalho = tipoTrabalhoDao.listarTipoTrabalho();
        request.setAttribute("tipoTrabalho", tipoTrabalho);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosPublicacosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu(idCurri);
        request.setAttribute("trabalhos", trabalhos);

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu("" + idCurri);
        request.setAttribute("formacao", formacao);

        return "/paginas/pessoa/curriculo/atualizaTrabalho.jsp";
    }
}
