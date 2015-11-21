<%@ page session="true" %>
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
        <form action="${pageContext.request.contextPath}/Curriculo?acao=TipoFormacaoAtualizar" method="post" >
            <c:forEach var="editar" items="${editaforma}">
                <h2>Editar tipo de forma&ccedil;&atilde;o ${editar.descricao}</h2>
                <fieldset>
                    <title>Editar tipo de Forma&ccedil;&atilde;o: ${editar.descricao}</title>
                    <legend>Tipo de forma&ccedil;&atilde;o -- ${editar.descricao} </legend>
                    <div class="win100">
                        <input type="hidden" value="${editar.id_Tipo}" name="id_Tipo" id="id_Tipo" />
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
        </c:if>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>