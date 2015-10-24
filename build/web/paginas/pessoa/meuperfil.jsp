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

        <% if (id_tipo.equals("2") || id_tipo.equals("1")) { %>
        <form action="${pageContext.request.contextPath}/Pessoa?acao=PessoaAtualizar" method="post" >
            <c:forEach var="editar" items="${edita}">
                <fieldset>
                    <legend>Dados Pessoais</legend>
                    <div class="win100">
                        <div class="win48 esq" >
                            <input type="text" id="nome" name="nome"
                                   value="${editar.nome}"
                                   placeholder="Digite nome" required="required" />
                        </div>
                        <div class="win48 dir" >
                            <input type="text" id="sobreNome" name="sobreNome"
                                   value="${editar.sobreNome}"
                                   placeholder="Digite Sobrenome" required="required" />
                        </div>
                        <div class="limpar"></div>
                    </div>

                    <div class="win100">
                        <div class="win48 esq" >
                            <input type="number" min="1" max="99 "id="idade"
                                   value="${editar.idade}"
                                   name="idade" placeholder="Digite Idade" required="required" />
                        </div>
                        <div class="win48 dir" >
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

                    <div class="win100">
                        <div class="win48 esq" >
                            <input name="cpf" id="cpf" type="text" value="${editar.cpf}" placeholder="Digite CPF" required="required" />
                        </div>
                        <div class="win48 dir" >
                            <input name="telefone" id="telefone" value="${editar.telefone}" type="text" placeholder="Digite Telefone" required="required" />
                        </div>
                        <div class="limpar"></div>
                    </div>
                    <div class="win100">
                        <div class="win48 esq" >
                            <input name="senha" type="text" id="senha" value="${editar.senha}" placeholder="Digite senha" required="required" />
                        </div>
                        <div class="win48 dir" >
                            <input name="email" type="email" id="email" value="${editar.email}" placeholder="Digite E-mail" required="required" />
                        </div>
                        <div class="limpar"></div>
                    </div>

                </fieldset>

                <fieldset class="mt20 mb20">
                    <legend>Endereço</legend>
                    <div class="win100">
                        <div class="win48 esq" >
                            <input name="nomeRua" id="nomeRua" type="text" value="${editar.endereco.nomeRua}" placeholder="Digite Rua" required="required" />
                        </div>
                        <div class="win48 dir" >
                            <input name="numero" type="number" min="1" id="numero" value="${editar.endereco.numero}" placeholder="Digite Número" required="required" />
                        </div>
                        <div class="limpar"></div>
                    </div>
                    <div class="win100">
                        <div class="win48 esq" >
                            <input name="complemento" id="complemento" value="${editar.endereco.complemento}" type="text" placeholder="Digite complemento" />
                        </div>
                        <div class="win48 dir" >
                            <input name="bairro" type="text" id="bairro" value="${editar.endereco.bairro}" placeholder="Digite bairro" required="required" />
                        </div>
                        <div class="limpar"></div>
                    </div>

                    <div class="win100">
                        <div class="win48 esq" >
                            <input id="cep" name="cep" type="text" value="${editar.endereco.cep}" placeholder="Digite CEP" />
                        </div>
                        <div class="win48 dir" >
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
                        <div class="limpar"></div>
                    </div>
                </fieldset>
                <br/><br/>
                <input type="hidden" id="id_Pessoa" name="id_Pessoa" value="${editar.id_Pessoa}" />
            </c:forEach>

            <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                <input type="submit" value="Salvar" class="btn btn-success" />
            </div>
        </form>

        <script>
            var $clo = jQuery.noConflict();
            $clo(".chosen-select").chosen({no_results_text: "Oops, não encontrado!", single_text: "Selecione uma opção"});
        </script>

        <% } else { %> 
        <form action="Login" method="POST" >
            <p><input name="nome" id="nome" value="" placeholder="digite nome" type="text"/></p>
            <p><input name="senha"  id="senha" type="password"  placeholder="digite senha"/></p>
            <p><input value="Enviar" type="submit" /></p>
        </form>
        <% }%> 
    </div>

    <%@ include file="../../includes/footer.jsp" %>

</body>