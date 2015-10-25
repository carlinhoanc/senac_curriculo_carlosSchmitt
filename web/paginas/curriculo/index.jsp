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
        <c:if test="${sessionScope.id_tipo == '2' }">


            <a href="${pageContext.request.contextPath}/paginas/trabalhos">Tipos de Trabalhos</a>
            <br/>
            <br/>
            <a href="${pageContext.request.contextPath}/paginas/formacao">Formação</a>
            <br/>
            <br/>
            <a href="${pageContext.request.contextPath}">Voltar</a>

        </c:if>
    </div>
</body>