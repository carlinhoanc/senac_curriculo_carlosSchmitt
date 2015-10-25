package Acao;

import bean.TipoTrabalhoPublicadosBean;
import dao.TipoTrabalhoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoTrabalhoEditar implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idd = req.getParameter("id_TipoPublicados");
        
        System.out.println(idd);
        
        TipoTrabalhoDao tipos = new TipoTrabalhoDao(); 

        List<TipoTrabalhoPublicadosBean> tiposTrab= tipos.listarTipoTrabID(idd);
        req.setAttribute("edita", tiposTrab);
        return "/paginas/trabalhos/editar.jsp";
    }
}
