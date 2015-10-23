/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acao;

import bean.CidadeBean;
import dao.CidadeDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CarlosRoberto
 */
public class PessoaNovo implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CidadeDao cidades = new CidadeDao();
        List<CidadeBean> lista = cidades.listaCidades();
//        System.out.println("TAMANHO : " + lista.size());
        request.setAttribute("cidades", lista);
        return "/paginas/pessoa/novo.jsp";

    }
}
