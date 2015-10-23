/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CarlosRoberto
 */
public interface Acao {

//  public String executar(HttpServletRequest request, HttpServletResponse response);
    public String executar(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
