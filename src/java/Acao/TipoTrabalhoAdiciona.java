package Acao;

import bean.TipoTrabalhoPublicadosBean;
import dao.TipoTrabalhoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoTrabalhoAdiciona implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TipoTrabalhoPublicadosBean tipos = new TipoTrabalhoPublicadosBean();
        tipos.setDescricao(request.getParameter("descricao"));
        TipoTrabalhoDao tiposDao = new TipoTrabalhoDao();

        if (tiposDao.insere(tipos) == true) {
            request.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            request.setAttribute("msg", "Erro ao inserirr pessoa");
        }

        TipoTrabalhoListarTipoTrabalho obj = new TipoTrabalhoListarTipoTrabalho();
        return obj.executar(request, response);
    }

}
