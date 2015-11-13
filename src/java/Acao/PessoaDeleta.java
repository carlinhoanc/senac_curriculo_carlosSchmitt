package Acao;

import bean.PessoaBean;
import dao.CurriculoDao;
import dao.EnderecoDao;
import dao.FormacaoDao;
import dao.PessoaDao;
import dao.TrabalhosDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PessoaDeleta implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();

        String idP = req.getParameter("id_pessoa");
        String idd = "" + session.getAttribute("id_pessoa");

        PessoaDao pessoaDao = new PessoaDao();
        FormacaoDao formacaoDao = new FormacaoDao();
        TrabalhosDao trabalhosDao = new TrabalhosDao();
        EnderecoDao enderecoDao = new EnderecoDao();
        CurriculoDao curriculoDao = new CurriculoDao();

        String idCurri = null;
        String id_tipo = null;
        String retorna = null;

        if (session.getAttribute("id_tipo") != null) {
            if (session.getAttribute("id_tipo").equals("2")) {
                if (curriculoDao.idCurriPorPessoa(idd).equals("0")) {
                    idCurri = "" + session.getAttribute("id_curri");
                } else {
                    idCurri = curriculoDao.idCurriPorPessoa(idP);
                }
                id_tipo = "2";
                retorna = "/paginas/pessoa/lista.jsp";
                enderecoDao.deleta(Integer.parseInt(idP));
                if (!idCurri.equals("0")) {
                    formacaoDao.deletaPorCurriculo(idCurri);
                    trabalhosDao.deletaPorCurriculo(idCurri);
                    curriculoDao.deleta(Integer.parseInt(idCurri));
                }
                pessoaDao.delete(Integer.parseInt(idP));
            } else {
                id_tipo = "0";
                retorna = "/Logoff";
                pessoaDao.desativa(Integer.parseInt(idd));
            }
        } else {
            id_tipo = "0";
            retorna = "/Logoff";
            pessoaDao.desativa(Integer.parseInt(idd));
        }

        List<PessoaBean> pessoas = pessoaDao.listarPessoa(id_tipo);
        req.setAttribute("pessoaslista", pessoas);
        return retorna;
    }
}
