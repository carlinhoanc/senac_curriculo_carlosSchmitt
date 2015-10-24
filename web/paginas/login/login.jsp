<%-- 
    Document   : login
    Created on : 02/09/2015, 08:52:44
    Author     : CarlosRoberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@ page language="java"%> 
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <%@ include file="../../includes/heard.jsp" %>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%@ include file="../../includes/topo.jsp" %>

        <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <h1>Área de login</h1>
            
        <c:if test = "${falhalogin == 'erro' }" >
            <div class="alert alert-danger" role="alert">
                Usuário ou senha inválidos, tente novamente
            </div>
        </c:if>
        
        <form action="Login" method="POST" >
            <p><input name="nome" id="nome" value="" placeholder="digite nome" type="text"/></p>
            <p><input name="senha"  id="senha" type="password"  placeholder="digite senha"/></p>
            <p><input value="Enviar" type="submit" /></p>
        </form>
        </div>

        <%@ include file="../../includes/footer.jsp" %>
    </body>
</html>
