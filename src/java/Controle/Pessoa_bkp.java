package Controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.PessoaDao;
import bean.PessoaBean;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Pessoa_bkp", urlPatterns = {"/Pessoa_bkp"})
public class Pessoa_bkp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            PessoaBean pessoaModel = new PessoaBean();

            PessoaDao PessoaDao = new PessoaDao();
            pessoaModel.setId_Pessoa("8");
            pessoaModel.setNome("Carlos Silva");
            pessoaModel.setSobreNome("Maria Silva");
            pessoaModel.setIdade(40);
            pessoaModel.setSexo("F");
//            pessoaModel.setCpf(123456781);
//            pessoaModel.setCurriculo_id_Curriculo(1);
//            pessoaModel.setEndereco_id_Endereco(2);
            pessoaModel.setSenha("yyyyyyyyyyyyyyy");
//            pessoaModel.setTipo(1);
            pessoaModel.setEmail("carlos@carlos.com");

//            PessoaDao.insere(pessoaModel);
//            boolean insereP = PessoaDao.insere(pessoaModel);
//            if(insereP == false){
//                out.println("Email ou CPF já cadastrados");
//            }else{
//                out.println("cadastro realizado com sucesso");
//            }

//            PessoaDao.listaTudo1();
//            PessoaDao.delete(9);
//            PessoaDao.atualizar(pessoaModel);
//            PessoaDao.atualizar(8, "Carlos Silva", "Maria Silca", 40, "F", "12345678", "1", "2", "cccccccccccccc");

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Pessoa_bkp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Pessoa_bkp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Pessoa_bkp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
