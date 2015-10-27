<%
    String id_tipo = null;
    String id_pessoa = null;
    if (session.getAttribute("id_tipo") != null) {
        id_tipo = (String) session.getAttribute("id_tipo");
    }else{
        id_tipo = "0";
    }
    if (session.getAttribute("id_pessoa") != null) {
        id_pessoa = (String) session.getAttribute("id_pessoa");
    }else{
        id_pessoa = "0";
    }

%>

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
            <% if (id_tipo.equals("2") || id_tipo.equals("1")) { %>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaMeuPerfil">Meu Perfil</a>
            </li>
            <% }%> 
            <% if (id_tipo.equals("2")) { %>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/paginas/curriculo">Admin Tipos</a>
            </li>
            <% }%> 

            <% if (id_tipo.equals("2") || id_tipo.equals("1")) { %>
            <li role="presentation">
                <a href="Logoff">Sair</a>
            </li>
            <% } else { %> 
            <li role="presentation"> 
                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#loginModal" >Login</button> 
            </li>
            <% }%> 
            
            <!--<li role="presentation">            </li>-->
            
            <% if (id_tipo.equals("2") || id_tipo.equals("1")) { %>
            <% } else { %> 
            <% }%>


        </ul>
    </div>
</nav>


<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-footer ">
                <form action="Login" method="POST" >
                    <p><input name="nome" id="nome" value="" placeholder="digite nome" type="text"/></p>
                    <p><input name="senha"  id="senha" type="password"  placeholder="digite senha"/></p>

                    <div class="btn-group btn-group-justified" role="group" aria-label="...">
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                        </div>
                        <div class="btn-group" role="group">
                            <button type="submit" class="btn btn-danger" >Logar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
