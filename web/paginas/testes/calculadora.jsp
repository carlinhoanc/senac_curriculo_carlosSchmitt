<%-- 
    Document   : calculadora
    Created on : 04/11/2015, 08:40:35
    Author     : CarlosRoberto
--%>

<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <%@ include file="../../includes/heard.jsp" %>
        <script src="${pageContext.request.contextPath}/paginas/testes/calc.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Calculadora</title>
    </head>
    <body>

        <div>

            <input id="resul" name="result" />

            <br/><br/>

            <button class="nume" value="1">1</button>
            <button class="nume" value="2">2</button>
            <button class="nume" value="3">3</button>
            <button class="nume" value="4">4</button>
            <button class="nume" value="5">5</button>

            <br/><br/>

            <button class="nume" value="6">6</button>
            <button class="nume" value="7">7</button>
            <button class="nume" value="8">8</button>
            <button class="nume" value="9">9</button>
            <button class="nume" value="0">0</button>

            <br/><br/>

            <button class="soma" value="+">+</button>
            <button class="subt" value="-">-</button>
            <button class="divi" value="/">/</button>
            <button class="muti" value="*">*</button>

            <br/><br/>

            <button value="(">(</button>
            <button value=")">)</button>
            <button value="=">=</button>
            <button value="limpar">limpar</button>

            <br/><br/>

            <button class="salvar" value="salvar">salvar</button>

            <br/><br/>

            <button class="listar" value="listar">listar valores</button>

            <br/><br/>

            <button class="apagar"  value="apagar">apagar</button>

        </div>

    </body>
</html>
