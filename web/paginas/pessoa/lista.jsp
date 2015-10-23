<%-- 
    Document   : Lista
    Created on : 07/10/2015, 08:36:22
    Author     : CarlosRoberto
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <%@ page language="java"%> 
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>

        <%@ include file="../../includes/heard.jsp" %>
    
    </head>
    <body>
        <%@ include file="../../includes/topo.jsp" %>

        <div class="container theme-showcase" style="padding-top: 70px" role="main">
            <div class="row">
                <c:forEach items="${pessoaslista}" var="pessoas" >
                    <div class="col-md-6">
                        <fieldset>
                            <legend>Dados Pessoais</legend>
                            id : ${pessoas.id_Pessoa}
                            <br/>
                            Nome: ${pessoas.nome}  ${pessoas.sobreNome}
                            <br/>
                            Idade: ${pessoas.idade}
                            <br/>
                            Sexo: ${pessoas.sexo}
                            <br/>
                            Cidade: ${pessoas.endereco.cidade.nome}  ${pessoas.endereco.cidade.estados}
                            <br/>
                            <form id="editaPessoa${pessoas.id_Pessoa}" 
                                  action="${pageContext.request.contextPath}/Pessoa?acao=PessoaEditar" method="post" >
                                <input type="hidden" value="${pessoas.id_Pessoa}" name="id_pessoa" id="id_pessoa" />

                                <div class="btn-group btn-group-sm" role="group" aria-label="...">
                                    <button type="submit" class="btn btn-primary">Alterar</button>
                                    <button type="button" class="btn btn-danger" data-toggle="modal" 
                                            data-target="#myModal${pessoas.id_Pessoa}" >Deletar</button>
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
