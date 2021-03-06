<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@ page language="java"%> 
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <%@ include file="../../includes/heard.jsp" %>
        <title>Login</title>
    </head>
    <body>
        <%@ include file="../../includes/topo.jsp" %>
        <div class="container theme-showcase" style="padding-top: 70px" role="main">
            <h1>Área de login</h1>
            <c:if test="${sessionScope.loginCorreto == '1'}">
                <div class="alert alert-danger" role="alert">
                    Já está logado no sistema
                </div>
            </c:if>

            <c:if test="${sessionScope.loginCorreto != '1'}">
                <div class="alert alert-danger" role="alert">
                    Usuário ou senha inválidos, tente novamente
                </div>
                <form action="${pageContext.request.contextPath}/Login" method="POST" onsubmit="setCookie();" >
                    <p><input name="nome" id="nome" value="" placeholder="digite nome" type="text"/></p>
                    <p><input name="senha"  id="senha" type="password"  placeholder="digite senha"/></p>
                    <p><input value="Enviar" type="submit" /></p>
                </form>
            </c:if>
        </div>
        <%@ include file="../../includes/footer.jsp" %>

    </body>
</html>
