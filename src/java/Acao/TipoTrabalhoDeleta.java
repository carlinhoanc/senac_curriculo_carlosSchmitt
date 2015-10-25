package Acao;

import bean.TipoTrabalhoPublicadosBean;
import dao.TipoTrabalhoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoTrabalhoDeleta implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idd = req.getParameter("id_TipoPublicados");

        TipoTrabalhoDao tipoTrabalhoDao = new TipoTrabalhoDao();
        tipoTrabalhoDao.delete(Integer.parseInt(idd));

        List<TipoTrabalhoPublicadosBean> tipoTrabalho = tipoTrabalhoDao.listarTipoTrabalho();
        req.setAttribute("tipoTrabalho", tipoTrabalho);
        return "/paginas/trabalhos/lista.jsp";
    }
}
