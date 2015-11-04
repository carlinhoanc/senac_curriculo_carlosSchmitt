package Acao;

import bean.TipoFormacaoBean;
import dao.TipoFormacaoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoFormacaoAtualizar implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TipoFormacaoBean tipos = new TipoFormacaoBean();
        tipos.setId_Tipo(request.getParameter("id_Tipo"));
        tipos.setDescricao(request.getParameter("descricao"));
        TipoFormacaoDao tiposDao = new TipoFormacaoDao();

        if (tiposDao.atualiza(tipos) == true) {
            request.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            request.setAttribute("msg", "Erro ao inserirr pessoa");
        }

        TipoFormacaoDao tipoFormaDao = new TipoFormacaoDao();
        List<TipoFormacaoBean> tipoForma = tipoFormaDao.listarTipoFormacao();
        request.setAttribute("tipoForma", tipoForma);
        return "/paginas/formacao/lista.jsp";
    }
}
