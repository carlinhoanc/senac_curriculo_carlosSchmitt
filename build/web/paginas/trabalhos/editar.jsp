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
    <%@ page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ include file="../../includes/heard.jsp" %>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>

    <div class="container theme-showcase" style="padding-top: 70px" role="main">

        <% if (id_tipo.equals("2")) { %>
        <form action="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoAtualizar" method="post" >
            <c:forEach var="editar" items="${edita}">
                <h2>Editar tipo de trabalho: ${editar.descricao} </h2>
                <fieldset>
                    <title>Editar tipo de trabalho: ${editar.descricao}</title>
                    <legend>Tipo de trabalho -- ${editar.descricao} </legend>
                    <div class="win100">
                        <input value="${editar.id}" type="hidden" name="id_TipoPublicados" id="id_TipoPublicados" />
                        <input type="text" id="descricao" name="descricao" 
                               value="${editar.descricao}"
                               placeholder="Digite a descricao" required="required" />
                    </div>
                </fieldset>
            </c:forEach>
            <br/>
            <br/>

            <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoFormacaoListarTipoFormacao" type="button"  class="btn btn-danger">Cancelar</a>
                <input type="submit" value="Salvar" class="btn btn-success" />
            </div>
        </form>

        <% }%>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>