/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import bean.PessoaBean;
import dao.LoginDao;
import dao.PessoaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CarlosRoberto
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Área de login</h1>");

            PessoaBean pessoaModel = new PessoaBean();
            pessoaModel.setSenha(senha);
            pessoaModel.setEmail(nome);

            int insereP = LoginDao.fazerLogin(pessoaModel);
            if (insereP == 0) {
                out.println("Email ou senha incorretos");
            } else {
                out.println("<p>Login efetudado com sucesso</p>");

                ArrayList<Object[]> col = PessoaDao.selectUsuario(insereP);

                out.println("<p>ID: " + insereP + "</p>");
                out.println("<p>Nome: " + col.get(0)[0] + ' ' + col.get(0)[1] + "</p>");
                out.println("<p>Idade: " + col.get(0)[2] + "</p>");
                out.println("<p>Sexo: " + col.get(0)[3] + "</p>");
                out.println("<p>CPF: " + col.get(0)[4] + "</p>");
                out.println("<p>Senha: " + col.get(0)[7] + "</p>");

            }

            out.println("<br/><br/>");
            out.println(" <a href=\"javascript:window.history.go(-1)\">Voltar</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
