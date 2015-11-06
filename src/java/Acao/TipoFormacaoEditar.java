package Acao;

import bean.TipoFormacaoBean;
import dao.TipoFormacaoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoFormacaoEditar implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setCharacterEncoding("UTF-8");
        String idd = req.getParameter("id_Tipo");
        TipoFormacaoDao tipos = new TipoFormacaoDao();
        List<TipoFormacaoBean> tiposForma = tipos.listarTipoFormacaoID("" + idd);
        req.setAttribute("editaforma", tiposForma);
        return "/paginas/formacao/editar.jsp";
    }
}
