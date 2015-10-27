package Acao;

import bean.TipoFormacaoBean;
import dao.TipoFormacaoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoFormacaoAdiciona implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TipoFormacaoBean tipos = new TipoFormacaoBean();
        tipos.setId_Tipo(request.getParameter("id_Tipo"));
        tipos.setDescricao(request.getParameter("descricao"));
        TipoFormacaoDao tiposDao = new TipoFormacaoDao();

        if (tiposDao.insere(tipos) == true) {
            request.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            request.setAttribute("msg", "Erro ao inserirr pessoa");
        }

        TipoFormacaoListarTipoFormacao obj = new TipoFormacaoListarTipoFormacao();
        return obj.executar(request, response);
    }

}
