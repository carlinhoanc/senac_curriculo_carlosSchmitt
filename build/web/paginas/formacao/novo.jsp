<%-- 
    Document   : newjspNovo
    Created on : 07/10/2015, 08:38:56
    Author     : CarlosRoberto
--%>
<%@ page session="true" %>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file="../../includes/heard.jsp" %>
    <%@ page contentType="text/html" pageEncoding="UTF-8"%>
    <title>Cadastrar novo tipo de Formação</title>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>

    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <h2>Cadastrar novo tipo de Formação</h2>
        <% if (id_tipo.equals("2")) { %>
        <form action="${pageContext.request.contextPath}/Curriculo?acao=TipoFormacaoAdiciona" method="post" >
            <fieldset>
                <div class="win100">
                    <input type="text" id="descricao" name="descricao" placeholder="Digite a descricao" required="required" />
                </div>
            </fieldset>
            <br/>
            <br/>
            <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                <a href="${pageContext.request.contextPath}/paginas/formacao/index.jsp" type="button"  class="btn btn-danger">Cancelar</a>
                <input type="submit" value="Salvar" class="btn btn-success" />
            </div>
        </form>
        <% }%>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>