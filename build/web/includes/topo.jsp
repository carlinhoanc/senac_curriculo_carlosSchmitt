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
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaListarPessoa">Meu Perfil</a>
            </li>
            <li role="presentation"> 
                <button type="button" class="btn btn-info" data-toggle="modal" 
                        data-target="#loginModal" >Login</button> </li>
            <!--<li role="presentation">            </li>-->


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