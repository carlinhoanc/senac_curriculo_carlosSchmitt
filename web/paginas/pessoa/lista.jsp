<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page session="true" %>
    <%@ page language="java"%> 
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários</title>
        <%@ include file="../../includes/heard.jsp" %>
    </head>
    <body>
        <%@ include file="../../includes/topo.jsp" %>
        <div class="container theme-showcase" style="padding-top: 70px" role="main">
            <h2>Lista de Usuários</h2>
            <div class="row">
                <c:forEach items="${pessoaslista}" var="pessoas" >
                    <div class="col-md-6">
                        <fieldset>
                            <legend>Dados Pessoais</legend>
                            <b>id:</b> ${pessoas.id_Pessoa}
                            <br/>
                            <c:if test="${pessoas.tipo.id == '2' }">
                                <b>Nome do <i>AdMinistrador </i>:</b>  ${pessoas.nome}  ${pessoas.sobreNome}
                            </c:if>
                            <c:if test="${pessoas.tipo.id != '2' }">
                                <b>Nome:</b> ${pessoas.nome}  ${pessoas.sobreNome}
                            </c:if>
                            <br/>
                            <b>Idade:</b> ${pessoas.idade}
                            <br/>
                            <b>Sexo:</b> ${pessoas.sexo}
                            <br/>
                            <b>Cidade:</b> ${pessoas.endereco.cidade.nome}  ${pessoas.endereco.cidade.estados}
                            <br/>

                            <h4>
                                <form id="editaPessoa${pessoas.id_Pessoa}" method="post" 
                                      action="${pageContext.request.contextPath}/Pessoa?acao=PessoaCurriculo" >
                                    <input type="hidden" value="${pessoas.id_Pessoa}" name="id_pessoa" id="id_pessoa" />
                                    <div class="btn-group btn-group-sm" role="group" aria-label="...">
                                        <button type="submit" class="btn btn-lg">Ver Perfil  Completo</button>
                                    </div>
                                </form>
                            </h4>

                            <c:if test="${sessionScope.id_tipo == '2' || sessionScope.id_pessoa == pessoas.id_Pessoa }">

                                <form id="editaPessoa${pessoas.id_Pessoa}" 
                                      action="${pageContext.request.contextPath}/Pessoa?acao=PessoaEditar" method="post" >
                                    <input type="hidden" value="${pessoas.id_Pessoa}" name="id_pessoa" id="id_pessoa" />

                                    <div class="btn-group btn-group  grupo_botoes" role="group" aria-label="...">
                                        <button type="submit" class="btn btn-primary">Alterar</button>
                                        <c:if test="${sessionScope.id_tipo == '2' }">
                                            <button type="button" class="btn btn-danger" data-toggle="modal" 
                                                    data-target="#myModal${pessoas.id_Pessoa}" >Deletar</button>
                                        </c:if>
                                    </div>
                                </form>

                                <div class="modal fade" id="myModal${pessoas.id_Pessoa}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-footer ">
                                                <div class="page-header">
                                                    <h3>
                                                        Deseja realmente deletar ?
                                                    </h3>
                                                </div>
                                                <form id="deletaPessoa${pessoas.id_Pessoa}" 
                                                      action="${pageContext.request.contextPath}/Pessoa?acao=PessoaDeleta" method="post" >

                                                    <input type="hidden" value="${pessoas.id_Pessoa}" name="id_pessoa" id="id_pessoa" />

                                                    <div class="btn-group btn-group-justified" role="group" aria-label="...">
                                                        <div class="btn-group" role="group">
                                                            <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                                                        </div>
                                                        <div class="btn-group" role="group">
                                                            <button type="submit" class="btn btn-danger" >Deletar</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>


                            </c:if>
                        </fieldset>
                        <br/>
                        <br/>
                    </div>
                </c:forEach>
            </div>
        </div>

        <%@ include file="../../includes/footer.jsp" %>
    </body>
</html>
