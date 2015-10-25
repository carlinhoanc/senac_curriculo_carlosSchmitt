<%-- 
    Document   : newjspNovo
    Created on : 07/10/2015, 08:38:56
    Author     : CarlosRoberto
--%>
<%@page session="true" %>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file="../../includes/heard.jsp" %>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>

    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <% if (id_tipo.equals("2")) { %>
        <% } else { %> 
        <form action="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoAdiciona" method="post" >
            <fieldset>
                <legend>Dados Pessoais</legend>

                <div class="win100">
                    <div class="win48 esq" >
                        <input type="text" id="nome" name="nome" placeholder="Digite nome" required="required" />
                    </div>
                    <div class="win48 dir" >
                        <input type="text" id="sobreNome" name="sobreNome" placeholder="Digite Sobrenome" required="required" />
                    </div>
                    <div class="limpar"></div>
                </div>

            </fieldset>
            <br/>
            <br/>
            <input type="submit" value="enviar" class="enviar" />
        </form>
        <% }%>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>