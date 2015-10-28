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

public class FormacaoEditar implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        String idCurri = "" + session.getAttribute("id_curri");
        String id_formacao =  request.getParameter("id_formacaos");

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoId(""+id_formacao);
        request.setAttribute("formacao", formacao);
        
        return "/paginas/pessoa/curriculo/atualizaFormacao.jsp";
    }
}
