
<nav class="navbar navbar-default navbar-fixed-top">
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
            <c:if test="${sessionScope.id_tipo == '1' || sessionScope.id_tipo == '2' }">
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaMeuPerfil">Meu Perfil</a>
                </li>
            </c:if>

            <c:if test="${sessionScope.id_tipo == '2' }">
                <li role="presentation">
                    <a href="${pageContext.request.contextPath}/paginas/curriculo/index.jsp">Admin Tipos</a>
                </li>
            </c:if>

            <c:choose>
                <c:when test="${sessionScope.id_tipo == '1' || sessionScope.id_tipo == '2' }">
                    <li role="presentation">
                        <a href="Logoff">Sair</a>
                    </li>
                </c:when>
                <c:otherwise>
                    <li role="presentation"> 
                        <a href="Login">Login</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>


