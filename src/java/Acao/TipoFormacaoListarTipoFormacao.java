package Acao;

import bean.TipoFormacaoBean;
import dao.TipoFormacaoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoFormacaoListarTipoFormacao implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        TipoFormacaoDao tipoFormaDao = new TipoFormacaoDao();
        List<TipoFormacaoBean> tipoForma = tipoFormaDao.listarTipoFormacao();
        request.setAttribute("tipoForma", tipoForma);
        return "/paginas/formacao/lista.jsp";
    }

}
