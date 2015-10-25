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
    <title>Tipos de trabalhos</title>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>
    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <h2>Tipos de trabalhos</h2>
        <c:if test="${sessionScope.id_tipo == '2' }">
            
            <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoNovo">Novo</a>
            <br/>
            <br/>
            <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoListarTipoTrabalho">Listar</a>
            <br/>
            <br/>
            <a href="${pageContext.request.contextPath}">Voltar</a>

        </c:if>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>