<html>
    <%@ page session="true" %>
    <%@ page language="java"%> 
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>
        <%@ include file="../../includes/heard.jsp" %>
        <title>Lista Tipos de trabalhos</title>
    </head>
    <body>
        <%@ include file="../../includes/topo.jsp" %>
        <c:if test="${sessionScope.id_tipo == '2' }">
            <div class="container theme-showcase" style="padding-top: 70px" role="main">
                <h2>Lista Tipos de trabalhos</h2>
                <div>
                    <c:forEach items="${tipoTrabalho}" var="tipoTrabalhos" >
                        <div class="col-md-6">
                            <div><b>ID:</b> ${tipoTrabalhos.id}</div>
                            <div><b>Descri&ccedil;&atilde;o:</b> ${tipoTrabalhos.descricao}</div>
                            <form id="editaPessoa${tipoTrabalhos.id}" action="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoEditar" method="post" >
                                <input type="hidden" value="${tipoTrabalhos.id}" name="id_TipoPublicados" id="id_TipoPublicados" />
                                <div class="btn-group btn-group  grupo_botoes" role="group" aria-label="...">
                                    <button type="submit" class="btn btn-primary">Alterar</button>
                                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal${tipoTrabalhos.id}" >Deletar</button>
                                </div>
                            </form>

                            <div class="modal fade" id="myModal${tipoTrabalhos.id}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-footer ">
                                            <div class="page-header">
                                                <h3>Deseja realmente deletar ?</h3>
                                            </div>
                                            <form id="deletaPessoa${tipoTrabalhos.id}" action="${pageContext.request.contextPath}/Pessoa?acao=TipoTrabalhoDeleta" method="post" >
                                                <input type="hidden" value="${tipoTrabalhos.id}" name="id_TipoPublicados" id="id_TipoPublicados" />
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
                        <a href="${pageContext.request.contextPath}/paginas/trabalhos/index.jsp" type="button" class="btn btn-danger">Voltar</a>
                        <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoNovo" type="button" class="btn btn-primary">Novo</a>
                    </div>
                </div>
            </div>
        </c:if>
        <%@ include file="../../includes/footer.jsp" %>
    </body>
</html>
