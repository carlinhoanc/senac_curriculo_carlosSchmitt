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
    <title>Cadastros de Tipos de trabalhos e forma&ccedil;&atilde;o</title>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>
    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <c:if test="${sessionScope.id_tipo == '2' }">

            <h2>Cadastros de Tipos de trabalhos e formao</h2>

            <div class="page-header">
                <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                    <a href="${pageContext.request.contextPath}/paginas/trabalhos/index.jsp"
                       type="button" class="btn btn-primary">Trabalhos</a>

                    <a href="${pageContext.request.contextPath}/paginas/formacao/index.jsp"
                       type="button" class="btn btn-success" >Forma&ccedil;&atilde;o</a>
                </div>
            </div>

            <div class="page-header">
                <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                    <a href="${pageContext.request.contextPath}"type="button" class="btn btn-danger">Voltar</a>
                </div>
            </div>
        </c:if>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>