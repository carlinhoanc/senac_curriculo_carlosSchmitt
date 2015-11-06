package Acao;

import bean.TipoTrabalhoPublicadosBean;
import dao.TipoTrabalhoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoTrabalhoListarTipoTrabalho implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        TipoTrabalhoDao tipoTrabalhoDao = new TipoTrabalhoDao();
        List<TipoTrabalhoPublicadosBean> tipoTrabalho = tipoTrabalhoDao.listarTipoTrabalho();
        request.setAttribute("tipoTrabalho", tipoTrabalho);
        return "/paginas/trabalhos/lista.jsp";
    }

}
