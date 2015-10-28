package Acao;

import bean.TipoFormacaoBean;
import dao.TipoFormacaoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoFormacaoDeleta implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        String idd = req.getParameter("id_Tipo");

        TipoFormacaoDao tipoFormaDao = new TipoFormacaoDao();
        tipoFormaDao.delete(idd);

        List<TipoFormacaoBean> tipoForma = tipoFormaDao.listarTipoFormacao();
        req.setAttribute("tipoForma", tipoForma);
        return "/paginas/formacao/lista.jsp";
    }
}
