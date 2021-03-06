<%@ page session="true" %>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file="../../includes/heard.jsp" %>
    <title>Tipos de Forma&ccedil;&atilde;o</title>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>
    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <h2>Tipos de Forma&ccedil;&atilde;o</h2>
        <c:if test="${sessionScope.id_tipo == '2' }">
            <div class="page-header">
                <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                    <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoFormacaoNovo" type="button" class="btn btn-primary">Novo</a>
                    <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoFormacaoListarTipoFormacao" type="button" class="btn btn-success">Listar</a>
                </div>
            </div>
            <div class="page-header">
                <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                    <a href="${pageContext.request.contextPath}/paginas/curriculo/index.jsp"type="button" class="btn btn-danger">Voltar</a>
                </div>
            </div>
        </c:if>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>