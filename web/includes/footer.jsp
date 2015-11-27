<%@page session="true" %>
<div style="padding-top: 70px;"></div>
<nav class="navbar navbar-inverse navbar-fixed-bottom">
    <div class="container">
        <ul class="nav nav-pills">
            <li role="presentation" class="active">
                <a href="${pageContext.request.contextPath}">Home</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaNovo">Cadastrar-se</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaListarPessoa">Lista</a>
            </li>
            <c:if test="${sessionScope.id_tipo == '2' || sessionScope.id_tipo == '1' }">
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaMeuPerfil">Meu Perfil</a>
                </li>

                <li role="presentation">
                    <a href="Logoff">Sair</a>
                </li>
            </c:if>
            <c:if test="${sessionScope.id_tipo == null}">
                <li role="presentation"> 
                    <a href="${pageContext.request.contextPath}/paginas/login/index.jsp">Login</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>