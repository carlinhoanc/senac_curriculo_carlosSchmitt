package Acao;

import bean.CidadeBean;
import bean.CurriculoBean;
import bean.PessoaBean;
import dao.CidadeDao;
import dao.CurriculoDao;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CurriculoAtualizar implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String idd = "" + session.getAttribute("id_pessoa");
        String temCurri = "" + session.getAttribute("temCurri");

        CurriculoBean curriBeans = new CurriculoBean();
        CurriculoDao curri = new CurriculoDao();

        int idCurri = curri.idCurri(Integer.parseInt(idd));

        if (idCurri == 0) {
            session.setAttribute("id_curri", "0");
        } else {
            session.setAttribute("id_curri", idCurri);
        }

        curriBeans.setExpProfissional(request.getParameter("expProfissional"));
        curriBeans.setForBasica(request.getParameter("forBasica"));
        curriBeans.setFormMedio(request.getParameter("formMedio"));
        curriBeans.setIdPessoa(idd);
        curriBeans.setId(idCurri);
        curriBeans.setResumo(request.getParameter("resumo"));

        if (curri.atualizar(curriBeans) == true) {
            request.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            request.setAttribute("msg", "Erro ao inserirr pessoa");
        }

        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();

        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoaID(idd);

        List<CurriculoBean> curriculo = curri.listaCurriculoPessoa(Integer.parseInt(idd));

        request.setAttribute("curriculo", curriculo);
        request.setAttribute("cidades", lista);
        request.setAttribute("edita", pessoas);

        return "/paginas/pessoa/meuperfil.jsp";
    }
}
