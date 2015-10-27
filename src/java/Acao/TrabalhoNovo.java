package Acao;

import bean.PaisBean;
import bean.TipoTrabalhoPublicadosBean;
import dao.PaisDao;
import dao.TipoTrabalhoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrabalhoNovo implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        PaisDao paisDao = new PaisDao();
        List<PaisBean> paises = paisDao.listarPaises();
        
        TipoTrabalhoDao tipoTrabalhoDao = new TipoTrabalhoDao();
        List<TipoTrabalhoPublicadosBean> tipoTrabalho = tipoTrabalhoDao.listarTipoTrabalho();

        request.setAttribute("paises", paises);
        request.setAttribute("tipoTrabalho", tipoTrabalho);
        return "/paginas/pessoa/curriculo/novoTrabalho.jsp";
    }

}
