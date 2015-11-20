package Acao;

import bean.FormacaoBean;
import bean.PaisBean;
import bean.TipoTrabalhoPublicadosBean;
import bean.TrabalhosBean;
import dao.CurriculoDao;
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

        String idd = "" + session.getAttribute("id_pessoa");
        CurriculoDao curri = new CurriculoDao();
        if (curri.idCurriPorPessoa(idd).equals("0")) {
            idCurri = "" + session.getAttribute("id_curri");
        } else {
            idCurri = curri.idCurriPorPessoa(idd);
        }
        String id_trab = request.getParameter("id_trabalho");
        
        PaisDao paisDao = new PaisDao();
        List<PaisBean> paises = paisDao.listarPaises();
        request.setAttribute("paises", paises);

        TipoTrabalhoDao tipoTrabalhoDao = new TipoTrabalhoDao();
        List<TipoTrabalhoPublicadosBean> tipoTrabalho = tipoTrabalhoDao.listarTipoTrabalho();
        request.setAttribute("tipoTrabalho", tipoTrabalho);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosBean> trabalhos = trabalhosDao.listarTrabalho(id_trab);
        request.setAttribute("trabalhos", trabalhos);

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu("" + idCurri);
        request.setAttribute("formacao", formacao);

        return "/paginas/pessoa/curriculo/atualizaTrabalho.jsp";
    }
}
