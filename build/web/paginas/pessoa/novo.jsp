<%-- 
    Document   : newjspNovo
    Created on : 07/10/2015, 08:38:56
    Author     : CarlosRoberto
--%>
<%@page session="true" %>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file="../../includes/heard.jsp" %>

    <title>Cadastrar novo usuário</title>
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
        <% // if (id_tipo.equals("2") || id_tipo.equals("1")) { %>
        <% if (id_tipo.equals("1")) { %>
        <div class="alert alert-warning" role="alert">
            Você já possui um cadastro
        </div>
        <% } else { %> 
        <form action="${pageContext.request.contextPath}/Pessoa?acao=PessoaAdicionar" method="post" >
            <fieldset>
                <legend>Dados Pessoais</legend>

                <div class="row">
                    <div class="col-md-6" >
                        <input type="text" id="nome" name="nome" placeholder="Digite nome" required="required" />
                    </div>
                    <div class="col-md-6" >
                        <input type="text" id="sobreNome" name="sobreNome" placeholder="Digite Sobrenome" required="required" />
                    </div>
                    <div class="limpar"></div>
                </div>

                <div class="row">
                    <div class="col-md-6" >
                        <input type="number" min="1" max="99 "id="idade" name="idade" placeholder="Digite Idade" required="required" />
                    </div>
                    <div class="col-md-6" >
                        <select id="sexo" name="sexo" >
                            <option value="M">Masculino</option>
                            <option value="F">Feminino</option>
                        </select>
                    </div>
                    <div class="limpar"></div>
                </div>

                <div class="row">
                    <div class="col-md-6" >
                        <input name="cpf" id="cpf" type="text" placeholder="Digite CPF" required="required" />
                    </div>
                    <div class="col-md-6" >
                        <input name="telefone" id="telefone" type="text" placeholder="Digite Telefone" required="required" />
                    </div>
                    <div class="limpar"></div>
                </div>
                <div class="row">
                    <div class="col-md-6" >
                        <input name="senha" type="text" id="senha" placeholder="Digite senha" required="required" />
                    </div>
                    <div class="col-md-6" >
                        <input name="email" type="email" id="email" placeholder="Digite E-mail" required="required" />
                    </div>
                    <div class="limpar"></div>
                </div>

            </fieldset>

            <fieldset class="mt20 mb20">
                <legend>Endereço</legend>
                <div class="row">
                    <div class="col-md-6" >
                        <input name="nomeRua" id="nomeRua" type="text" placeholder="Digite Rua" required="required" />
                    </div>
                    <div class="col-md-6" >
                        <input name="numero" type="number" min="1" id="numero" placeholder="Digite Número" required="required" />
                    </div>
                    <div class="limpar"></div>
                </div>
                <div class="row">
                    <div class="col-md-6" >
                        <input name="complemento" id="complemento" type="text" placeholder="Digite complemento" />
                    </div>
                    <div class="col-md-6" >
                        <input name="bairro" type="text" id="bairro" placeholder="Digite bairro" required="required" />
                    </div>
                    <div class="limpar"></div>
                </div>

                <div class="row">
                    <div class="col-md-6" >
                        <input id="cep" name="cep" type="text" placeholder="Digite CEP" />
                    </div>
                    <div class="col-md-6" >
                        <div class="win100">
                            <select id="id_cidade" name="id_cidade" class="chosen-select"  tabindex="2" required="">
                                <option>Selecione uma Cidade</option>
                                <c:forEach items="${cidades}" var="cidade" >
                                    <option value="${cidade.id}">${cidade.cidadeUF}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="limpar"></div>
                </div>
            </fieldset>

            <c:if test="${sessionScope.id_tipo == '2' }">
                <fieldset>
                    <legend>Ações</legend>

                    <div class="row">
                        <div class="col-md-6" >
                            <label>Tipo de usuário</label>
                            <div class="win100">
                                <select class="form-control" name="id_tipo" id="id_tipo">
                                    <option value="1" >Registrado</option>
                                    <option value="2" >Admin</option>
                                </select>
                            </div>
                        </div>

                        <div class="col-md-6" >
                            <label>Ativo?</label>
                            <div class="win100">
                                <select class="form-control" name="ativo" id="ativo">
                                    <option value="1" >Sim</option>
                                    <option value="0" >Não</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </c:if>
            <br/>
            <br/>
            <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaListarPessoa" type="button"  class="btn btn-danger">Voltar</a>
                <input type="submit" value="Salvar" class="btn btn-success" />
            </div>
        </form>

        <script>
            var $clo = jQuery.noConflict();
            $clo(".chosen-select").chosen({no_results_text: "Oops, não encontrado!", single_text: "Selecione uma opção"});
        </script>

        <% }%>

    </div>

    <%@ include file="../../includes/footer.jsp" %>
</body>