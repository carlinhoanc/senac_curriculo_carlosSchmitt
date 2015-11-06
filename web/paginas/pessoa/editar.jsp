<%-- 
    Document   : newjspNovo
    Created on : 07/10/2015, 08:38:56
    Author     : CarlosRoberto
--%>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
    <%@ include file="../../includes/heard.jsp" %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/chosen.css">
    
    
    <script src="${pageContext.request.contextPath}/resource/js/maskedinput.js"></script>
    <script src="${pageContext.request.contextPath}/resource/js/chosen.jquery.js"></script>
    <script>
        var $maskk = jQuery.noConflict();
        jQuery(function ($maskk) {
            $maskk("#telefone").mask("(00) 0000-00009");
            $maskk("#numero").mask("099999");
            $maskk("#cep").mask("00.000-000");
            $maskk("#cpf").mask("000.000.000-00");
        });
    </script>
</head>

<body>
    <%@ include file="../../includes/topo.jsp" %>
    <div class="container theme-showcase" style="padding-top: 70px" role="main">

        <form action="${pageContext.request.contextPath}/Pessoa?acao=PessoaAtualizar" method="post" >
            <c:forEach var="editar" items="${edita}">

                <h2>Editar Dados Pessoais de  ${editar.nome} ${editar.sobreNome}</h2>
                <title>Editar Dados Pessoais de  ${editar.nome} ${editar.sobreNome}</title>

                <fieldset>
                    <legend>Dados Pessoais de  ${editar.nome} ${editar.sobreNome}</legend>

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
                            <label>Cidade</label>
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
                <c:if test="${sessionScope.id_tipo == '2' }">
                    <fieldset>
                        <legend>A&ccedil;&otilde;es</legend>
                        <div class="row">
                            <div class="col-md-6" >
                                <label>Tipo de usuário</label>
                                <div class="win100">
                                    <select class="form-control" name="id_tipo" id="id_tipo">
                                        <c:if test = "${editar.tipo.id == '1' }" >
                                            <option value="1" selected="" >Registrado</option>
                                            <option value="2" >Admin</option>
                                        </c:if>
                                        <c:if test = "${editar.tipo.id != '1' }" >
                                            <option value="1" >Registrado</option>
                                            <option value="2" selected="" >Admin</option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>

                            <div class="col-md-6" >
                                <label>Ativo?</label>
                                <div class="win100">
                                    <select class="form-control" name="ativo" id="ativo">
                                        <c:if test = "${editar.ativo == '1' }" >
                                            <option value="1" selected="" >Sim</option>
                                            <option value="0" >Não</option>
                                        </c:if>
                                        <c:if test = "${editar.ativo != '1' }" >
                                            <option value="1" >Sim</option>
                                            <option value="0" selected="" >Não</option>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </fieldset>
                </c:if>
                <br/>
                <br/>
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

        <%@ include file="../../includes/footer.jsp" %>
    </div>
</body>