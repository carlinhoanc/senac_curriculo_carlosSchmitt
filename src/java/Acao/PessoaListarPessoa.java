/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acao;

import bean.PessoaBean;
import dao.PessoaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CarlosRoberto
 */
public class PessoaListarPessoa implements Acao {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PessoaDao pessoaDAO = new PessoaDao();
        List<PessoaBean> pessoas = pessoaDAO.listarPessoa();

//        System.out.println("TAMANHO : " + pessoas.size());
//        System.out.println(pessoas.toString());
        
        request.setAttribute("pessoaslista", pessoas);
        return "/paginas/pessoa/lista.jsp";
        
    }

}
