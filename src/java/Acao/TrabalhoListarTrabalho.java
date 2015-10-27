package Acao;

import bean.CurriculoBean;
import bean.PaisBean;
import bean.TipoFormacaoBean;
import bean.TrabalhosPublicacosBean;
import dao.CurriculoDao;
import dao.PaisDao;
import dao.TipoFormacaoDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TrabalhoListarTrabalho implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        String idd = "" + session.getAttribute("id_pessoa");
        String idCurri = "" + session.getAttribute("id_curri");
        
        PaisDao paisDao = new PaisDao();
        List<PaisBean> paises = paisDao.listarPaises();
        request.setAttribute("paises", paises);

        TipoFormacaoDao tipoFormaDao = new TipoFormacaoDao();
        List<TipoFormacaoBean> tipoForma = tipoFormaDao.listarTipoTrabalho();
        request.setAttribute("tipoForma", tipoForma);

        CurriculoDao curri = new CurriculoDao();
        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        request.setAttribute("curriculo", curriculo);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosPublicacosBean> trabalhos = trabalhosDao.listarTrabalhosIdCu(idCurri);
                
        request.setAttribute("trabalhos", trabalhos);

        return "/paginas/pessoa/meuperfil.jsp";
    }

}
