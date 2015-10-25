package Acao;

import bean.TipoTrabalhoPublicadosBean;
import dao.TipoTrabalhoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TipoTrabalhoAtualizar implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TipoTrabalhoPublicadosBean tipos = new TipoTrabalhoPublicadosBean();
        tipos.setDescricao(request.getParameter("descricao"));
        tipos.setId(Integer.parseInt(request.getParameter("id_tipoTrab")));
        TipoTrabalhoDao tiposDao = new TipoTrabalhoDao();

        if (tiposDao.insere(tipos, 1) == true) {
            request.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            request.setAttribute("msg", "Erro ao inserirr pessoa");
        }

        TipoTrabalhoListarTipoTrabalho obj = new TipoTrabalhoListarTipoTrabalho();
        return obj.executar(request, response);
    }
}
