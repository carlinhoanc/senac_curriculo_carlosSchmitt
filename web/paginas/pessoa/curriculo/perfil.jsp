<form action="${pageContext.request.contextPath}/Pessoa?acao=PessoaAtualizar" method="post" >
    <c:forEach var="editar" items="${edita}">
        <h2>Editar meu perfil: ${editar.nome} ${editar.sobreNome}</h2>
        <title>Editar meu perfil: ${editar.nome} ${editar.sobreNome}</title>
        <fieldset>
            <legend>Dados Pessoais</legend>
            <div class="row">
                <div class="col-md-6" >
                    <label>Nome</label>
                    <input type="text" id="nome" name="nome"
                           value="${editar.nome}"
                           placeholder="Digite nome" required="required" />
                </div>
                <div class="col-md-6" >
                    <label>Sobre nome</label>
                    <input type="text" id="sobreNome" name="sobreNome"
                           value="${editar.sobreNome}"
                           placeholder="Digite Sobrenome" required="required" />
                </div>
                <div class="limpar"></div>
            </div>

            <div class="row">
                <div class="col-md-6" >
                    <label>Idade</label>
                    <input type="number" min="1" max="99 "id="idade"
                           value="${editar.idade}"
                           name="idade" placeholder="Digite Idade" required="required" />
                </div>
                <div class="col-md-6" >
                    <label>Sexo</label>
                    <select id="sexo" name="sexo" >
                        <option>Selecione sexo</option>
                        <c:if test= "${editar.sexo == 'M'}">
                            <option value="M" selected >Masculino</option>
                        </c:if>
                        <c:if test= "${editar.sexo != 'M'}">
                            <option value="M" >Masculino</option>
                        </c:if>

                        <c:if test= "${editar.sexo == 'F'}">
                            <option value="F" selected >Feminino</option>
                        </c:if>
                        <c:if test= "${editar.sexo != 'F'}">
                            <option value="F" >Feminino</option>
                        </c:if>
                    </select>
                </div>
                <div class="limpar"></div>
            </div>

            <div class="row">
                <div class="col-md-6" >
                    <label>CPF</label>
                    <input name="cpf" id="cpf" type="text" value="${editar.cpf}" placeholder="Digite CPF" required="required" />
                </div>
                <div class="col-md-6" >
                    <label>Telefone</label>
                    <input name="telefone" id="telefone" value="${editar.telefone}" type="text" placeholder="Digite Telefone" required="required" />
                </div>
                <div class="limpar"></div>
            </div>
            <div class="row">
                <div class="col-md-6" >
                    <label>Senha</label>
                    <input name="senha" type="password" id="senha" value="${editar.senha}" placeholder="Digite senha" required="required" />
                </div>
                <div class="col-md-6" >
                    <label>E-mail</label>
                    <input name="email" type="email" id="email" value="${editar.email}" placeholder="Digite E-mail" required="required" />
                </div>
                <div class="limpar"></div>
            </div>

        </fieldset>

        <fieldset class="mt20 mb20">
            <legend>Endereço</legend>
            <div class="row">
                <div class="col-md-6" >
                    <label>Rua</label>
                    <input name="nomeRua" id="nomeRua" type="text" value="${editar.endereco.nomeRua}" placeholder="Digite Rua" required="required" />
                </div>
                <div class="col-md-6" >
                    <label>Número</label>
                    <input name="numero" type="number" min="1" id="numero" value="${editar.endereco.numero}" placeholder="Digite Número" required="required" />
                </div>
                <div class="limpar"></div>
            </div>
            <div class="row">
                <div class="col-md-6" >
                    <label>Complemento</label>
                    <input name="complemento" id="complemento" value="${editar.endereco.complemento}" type="text" placeholder="Digite complemento" />
                </div>
                <div class="col-md-6" >
                    <label>Bairro</label>
                    <input name="bairro" type="text" id="bairro" value="${editar.endereco.bairro}" placeholder="Digite bairro" required="required" />
                </div>
                <div class="limpar"></div>
            </div>

            <div class="row">
                <div class="col-md-6" >
                    <label>CEP</label>
                    <input id="cep" name="cep" type="text" value="${editar.endereco.cep}" placeholder="Digite CEP" />
                </div>
                <div class="col-md-6" >
                    <label>Cidade/UF</label>
                    <div class="win100">
                        <select id="id_cidade" name="id_cidade" class="chosen-select"  tabindex="2" required="">
                            <option>Selecione uma Cidade</option>
                            <c:forEach items="${cidades}" var="cidade" >

                                <c:if test = "${editar.endereco.cidade.id == cidade.id }" >
                                    <option value="${cidade.id}" selected="">${cidade.cidadeUF}</option>
                                </c:if>
                                <c:if test = "${editar.endereco.cidade.id != cidade.id }" >
                                    <option value="${cidade.id}">${cidade.cidadeUF}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="limpar"></div>
            </div>
        </fieldset>
        <br/><br/>
        <input type="hidden" id="id_Pessoa" name="id_Pessoa" value="${editar.id_Pessoa}" />
    </c:forEach>


    <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
        <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaListarPessoa" type="button"  class="btn btn-danger">Voltar</a>
        <input type="submit" value="Salvar" class="btn btn-success" />
    </div>
</form>

<script>
    var $clo = jQuery.noConflict();
    $clo(".chosen-select").chosen({no_results_text: "Oops, não encontrado!", single_text: "Selecione uma op&ccedil;&atilde;o"});
</script>