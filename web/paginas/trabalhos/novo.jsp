<%@ page session="true" %>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file="../../includes/heard.jsp" %>
    <title>Cadastrar novo tipo de trabalho</title>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>
    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <h2>Cadastrar novo tipo de trabalho</h2>
        <c:if test="${sessionScope.id_tipo == '2' }">
        <form action="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoAdiciona" method="post" >
            <fieldset>
                <div class="win100">
                    <input type="text" id="descricao" name="descricao" placeholder="Digite a descricao" required="required" />
                </div>
            </fieldset>
            <br/>
            <br/>
            <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                <a href="${pageContext.request.contextPath}/paginas/trabalhos/index.jsp" type="button"  class="btn btn-danger">Cancelar</a>
                <input type="submit" value="Salvar" class="btn btn-success" />
            </div>
        </form>
        </c:if>
    </div>
    <%@ include file="../../includes/footer.jsp" %>
</body>