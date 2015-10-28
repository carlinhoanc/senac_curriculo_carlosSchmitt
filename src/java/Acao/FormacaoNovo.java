package Acao;

import bean.TipoFormacaoBean;
import dao.TipoFormacaoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormacaoNovo implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        TipoFormacaoDao tipoFormacaoDao = new TipoFormacaoDao();
        List<TipoFormacaoBean> tipoFormacaoBean = tipoFormacaoDao.listarTipoFormacao();
        request.setAttribute("tipoForma", tipoFormacaoBean);

        return "/paginas/pessoa/curriculo/novaFormacao.jsp";
    }

}
