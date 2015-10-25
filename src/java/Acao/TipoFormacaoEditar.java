package Acao;

import bean.TipoFormacaoBean;
import dao.TipoFormacaoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoFormacaoEditar implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idd = req.getParameter("id_TipoFormacao");
        
        TipoFormacaoDao tipos = new TipoFormacaoDao(); 

        List<TipoFormacaoBean> tiposTrab= tipos.listarTipoTrabID(idd);
        req.setAttribute("edita", tiposTrab);
        return "/paginas/formacao/editar.jsp";
    }
}
