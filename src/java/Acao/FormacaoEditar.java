package Acao;

import bean.FormacaoBean;
import bean.TipoFormacaoBean;
import dao.FormacaoDao;
import dao.TipoFormacaoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FormacaoEditar implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String id_formacao = request.getParameter("id_formacaos");

        TipoFormacaoDao tipoFormacaoDao = new TipoFormacaoDao();
        List<TipoFormacaoBean> tipoFormacaoBean = tipoFormacaoDao.listarTipoFormacao();
        request.setAttribute("tipoForma", tipoFormacaoBean);

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoId("" + id_formacao);
        request.setAttribute("formacao", formacao);

        return "/paginas/pessoa/curriculo/atualizaFormacao.jsp";
    }
}
