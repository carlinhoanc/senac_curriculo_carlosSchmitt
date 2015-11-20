package Acao;

import bean.CidadeBean;
import bean.CurriculoBean;
import bean.FormacaoBean;
import bean.PaisBean;
import bean.PessoaBean;
import bean.TipoTrabalhoPublicadosBean;
import bean.TrabalhosBean;
import dao.CidadeDao;
import dao.CurriculoDao;
import dao.FormacaoDao;
import dao.PaisDao;
import dao.PessoaDao;
import dao.TipoTrabalhoDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TrabalhoAtualiza implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String idCurri = null;
        String idd = "" + session.getAttribute("id_pessoa");
        
        CurriculoDao curri = new CurriculoDao();
        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));
        request.setAttribute("curriculo", curriculo);
             
        if (curri.idCurriPorPessoa(idd).equals("0")) {
            idCurri = "" + session.getAttribute("id_curri");
        } else {
            idCurri = curri.idCurriPorPessoa(idd);
        }

        TrabalhosBean trabalhos = new TrabalhosBean();
        TrabalhosDao trabalhoDao = new TrabalhosDao();
        TipoTrabalhoDao tiposDao = new TipoTrabalhoDao();
        PaisDao paisD = new PaisDao();
        
        trabalhos.setNome(request.getParameter("nome"));
        trabalhos.setAno(Integer.parseInt(request.getParameter("ano")));
        trabalhos.setPais(paisD.seledctPorID(request.getParameter("pais")));
        trabalhos.setId_Curriculo(idCurri);
        trabalhos.setId_TipoPublicados(tiposDao.listarTipoID(request.getParameter("id_tipoTrab")));
        
        trabalhos.setId_TbPublicados(Integer.parseInt(request.getParameter("id_trabalho")));
        trabalhoDao.atualiza(trabalhos, request.getParameter("id_trabalho"));

        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();
        request.setAttribute("cidades", lista);

        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);
        request.setAttribute("edita", pessoas);

        TrabalhosDao trabalhosDao = new TrabalhosDao();
        List<TrabalhosBean> trabalhoLista = trabalhosDao.listarTrabalhosIdCu(idCurri);
        request.setAttribute("trabalhos", trabalhoLista);

        FormacaoDao formacaoDao = new FormacaoDao();
        List<FormacaoBean> formacao = formacaoDao.listarFormacaoIdCu("" + idCurri);
        request.setAttribute("formacao", formacao);

        session.setAttribute("temCurri", "1");
        return "/paginas/pessoa/meuperfil.jsp";
    }
}
