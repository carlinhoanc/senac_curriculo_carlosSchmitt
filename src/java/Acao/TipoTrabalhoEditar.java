package Acao;

import bean.TipoTrabalhoPublicadosBean;
import dao.TipoTrabalhoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoTrabalhoEditar implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setCharacterEncoding("UTF-8");
        String idd = req.getParameter("id_TipoPublicados");

        TipoTrabalhoDao tipos = new TipoTrabalhoDao();
        TipoTrabalhoPublicadosBean tipobean = new TipoTrabalhoPublicadosBean();

        tipobean.setId(req.getParameter("id_TipoPublicados"));
        tipobean.setDescricao(req.getParameter("descricao"));

        List<TipoTrabalhoPublicadosBean> tiposTrab = tipos.listarTipoTrabID(idd);
        req.setAttribute("edita", tiposTrab);
        return "/paginas/trabalhos/editar.jsp";
    }
}
