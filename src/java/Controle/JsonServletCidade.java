/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import bean.CidadeBean;
import dao.CidadeDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "JsonServletCidade", urlPatterns = {"/JsonServletCidade"})
public class JsonServletCidade extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, Exception {
        response.setContentType("text/html;charset=UTF-8");

//        String cidadesNome = request.getParameter("cidadesNome");
//        String cidadesNome = request.getParameter("categoria");
//        List<CidadeBean> list = new ArrayList<>();
//        String json = null;

//        List<String> cidades = new ArrayList<>();
//        if (cidadesNome != null) {
//            list = CidadeDao.ListaCidadePorUF(cidadesNome);
//            json = new Gson().toJson(list);
//        } else {
//            cidades.add("Selecione um estado");
//            json = new Gson().toJson(cidades);
//        }
//        list = CidadeDao.ListaCidadePorUF(cidadesNome);
        
//        System.out.println(cidadesNome);
//        System.out.println(list);
        
        
//        for (CidadeBean list1 : list) {
//            System.out.println(list1);
//        }

//        response.setContentType("application/json");
//        response.getWriter().write(json);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(JsonServletCidade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(JsonServletCidade.class.getName()).log(Level.SEVERE, null, ex);
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
