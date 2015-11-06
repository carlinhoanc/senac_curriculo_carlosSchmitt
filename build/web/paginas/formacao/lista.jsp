<%-- 
    Document   : Lista
    Created on : 07/10/2015, 08:36:22
    Author     : CarlosRoberto
--%>


<!DOCTYPE html>
<html>
    <%@ page session="true" %>
    <%@ page language="java"%> 
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <head>
        <%@ include file="../../includes/heard.jsp" %>
        <title>Lista Tipos de forma&ccedil;&atilde;o</title>
    </head>
    <body>
        <%@ include file="../../includes/topo.jsp" %>
        <c:if test="${sessionScope.id_tipo == '2' }">
            <div class="container theme-showcase" style="padding-top: 70px" role="main">
                <h2>Lista Tipos de Forma&ccedil;&otilde;es</h2>
                <div>
                    <c:forEach items="${tipoForma}" var="tipoFormacao" >
                        <div class="col-md-6">
                            <div><b>ID:</b> ${tipoFormacao.id_Tipo}</div>
                            <div><b>Descri&ccedil;&atilde;o:</b> ${tipoFormacao.descricao}</div>

                            <form id="editaPessoa${tipoFormacao.id_Tipo}" 
                                  action="${pageContext.request.contextPath}/Curriculo?acao=TipoFormacaoEditar" method="post" >
                                <input type="hidden" value="${tipoFormacao.id_Tipo}" name="id_Tipo" id="id_Tipo" />

                                <div class="btn-group btn-group  grupo_botoes" role="group" aria-label="...">
                                    <button type="submit" class="btn btn-primary">Alterar</button>
                                    <button type="button" class="btn btn-danger" data-toggle="modal"
                                            data-target="#myModal${tipoFormacao.id_Tipo}" >Deletar</button>
                                </div>
                            </form>

                            <div class="modal fade" id="myModal${tipoFormacao.id_Tipo}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-footer ">
                                            <div class="page-header">
                                                <h3>Deseja realmente deletar ?</h3>
                                            </div>
                                            <form id="deletaPessoa${tipoFormacao.id_Tipo}" 
                                                  action="${pageContext.request.contextPath}/Pessoa?acao=TipoFormacaoDeleta" method="post" >

                                                <input type="hidden" value="${tipoFormacao.id_Tipo}" name="id_Tipo" id="id_Tipo" />

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
                        </div>
                    </c:forEach>
                    <div class="limpar"></div>
                </div>
                <div class="page-header">
                    <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                        <a href="${pageContext.request.contextPath}/paginas/formacao/index.jsp"type="button" class="btn btn-danger">Voltar</a>
                    </div>
                </div>
            </div>
        </c:if>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>
</body>
</html>
