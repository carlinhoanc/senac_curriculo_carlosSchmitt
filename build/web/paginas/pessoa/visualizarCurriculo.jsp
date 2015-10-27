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
                <h2>Curriculo de ${editar.nome} ${editar.sobreNome}</h2>
                <title>Curriculo de: ${editar.nome} ${editar.sobreNome}</title>
                <div class="row">
                    <div class="col-md-6" >
                        <fieldset>
                            <legend>Dados Pessoais</legend>
                            <h5><b>Nome: </b>${editar.nome} ${editar.sobreNome}</h5>
                            <h5><b>Idade: </b>${editar.idade}</h5>
                            <h5><b>Sexo: </b>
                                <c:if test= "${editar.sexo == 'M'}">
                                    Masculino
                                </c:if>
                                <c:if test= "${editar.sexo == 'F'}">
                                    Feminino
                                </c:if>
                            </h5>
                            <h5><b>CPF: </b>${editar.cpf}</h5>
                            <h5><b>Telefone: </b>${editar.telefone}</h5>
                            <h5><b>Email: </b>${editar.email}</h5>
                        </fieldset>
                    </div>

                    <div class="col-md-6" >
                        <fieldset>
                            <legend>Endereço</legend>
                            <h5><b>Rua: </b>${editar.endereco.nomeRua}</h5>
                            <h5><b>Número: </b>${editar.endereco.numero}</h5>
                            <h5><b>Complemento: </b>${editar.endereco.complemento}</h5>
                            <h5><b>Bairro: </b>${editar.endereco.bairro}</h5>
                            <h5><b>CEP: </b>${editar.endereco.cep}</h5>
                            <h5><b>Cidade </b>${editar.endereco.cidade.nome}</h5>
                            <h5><b>Estado </b>${editar.endereco.cidade.estados}</h5>
                        </fieldset>
                    </div>
                </div> 
            </c:forEach>

            <c:forEach var="curriculo" items="${curriculo}">
                <fieldset>
                    <legend>Curriculo</legend>
                    <div class="row">
                        <div class="col-md-6" >  
                            <b>Resumo</b>
                            <div>
                                ${curriculo.resumo}
                            </div>

                            <b>Experiência Profissional</b>
                            <div>
                                ${curriculo.expProfissional}
                            </div>
                        </div>
                        <div class="col-md-6" >  
                            <b>Formação Básica</b>
                            <div>
                                ${curriculo.forBasica}
                            </div>
                            <b>Formação Média</b>
                            <div>
                                ${curriculo.formMedio}
                            </div>
                        </div>
                    </div>
                </fieldset>
            </c:forEach>
            <br/>
            <br/>
            <div class="btn-group btn-group grupo_botoes" role="group" aria-b="...">
                <a class="btn btn-warning" href="${pageContext.request.contextPath}/Pessoa?acao=PessoaListarPessoa">Voltar</a>
            </div>
        </form>
    </div>

    <%@ include file="../../includes/footer.jsp" %>

</body>