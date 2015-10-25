package Acao;

import bean.TipoFormacaoBean;
import dao.TipoFormacaoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoFormacaoAtualizar implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TipoFormacaoBean tipos = new TipoFormacaoBean();
        tipos.setId(request.getParameter("id_TipoFormacao"));
        tipos.setDescricao(request.getParameter("descricao"));
        TipoFormacaoDao tiposDao = new TipoFormacaoDao();

        if (tiposDao.atualiza(tipos) == true) {
            request.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            request.setAttribute("msg", "Erro ao inserirr pessoa");
        }

        TipoTrabalhoListarTipoTrabalho obj = new TipoTrabalhoListarTipoTrabalho();
        return obj.executar(request, response);
    }
}
