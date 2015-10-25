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
    <title>Tipos de Formação</title>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>
    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <h2>Tipos de Formação</h2>
        <c:if test="${sessionScope.id_tipo == '2' }">

            <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoFormacaoNovo">Novo</a>
            <br/>
            <br/>
            <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoFormacaoListarTipoFormacao">Listar</a>

            <div class="page-header">
                <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                    <a href="${pageContext.request.contextPath}/paginas/curriculo"type="button" class="btn btn-danger">Voltar</a>
                </div>
            </div>
        </c:if>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>