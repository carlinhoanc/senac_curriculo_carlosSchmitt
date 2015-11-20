
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="height: 50px"></div>
<div class="row">
    <c:forEach var="trabalho" items="${trabalhos}">
        <div class="col-md-6">
            <p><b>Nome do trabalho: </b>${trabalho.nome}</p>
            <p><b>Ano: </b>${trabalho.ano}</p>
            <p><b>Pais: </b>${trabalho.pais.nome}</p>
            <p><b>Tipo de trabalho: </b>${trabalho.id_TipoPublicados.descricao}</p>

            <div>
                <form id="editaPessoa${trabalho.id_TbPublicados}" 
                      action="${pageContext.request.contextPath}/Curriculo?acao=TrabalhoEditar" method="post" >
                    <input type="hidden" value="${trabalho.id_TbPublicados}" name="id_trabalho" id="id_trabalho" />

                    <div class="btn-group btn-group  grupo_botoes" role="group" aria-label="...">
                        <button type="submit" class="btn btn-primary">Alterar</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" 
                                data-target="#myModal${trabalho.id_TbPublicados}" >Deletar</button>
                    </div>
                </form>

                <div class="modal fade" id="myModal${trabalho.id_TbPublicados}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-footer ">
                                <div class="page-header">
                                    <h3>
                                        Deseja realmente deletar ?
                                    </h3>
                                </div>
                                <form id="deletaPessoa${trabalho.id_TbPublicados}" 
                                      action="${pageContext.request.contextPath}/Curriculo?acao=TrabalhoDeleta" method="post" >

                                    <input type="hidden" value="${trabalho.id_TbPublicados}" name="id_trabalho" id="id_pessoa" />

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
        </div>
    </c:forEach>
</div>



<br/>
<br/>
<c:if test="${sessionScope.temCurri == '0' }">
    <div class="jumbotron">
        <h1>ATen&ccedil;&atilde;o</h1>
        <p>...</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Preencha um curriculo antes</a></p>
    </div>
</c:if>
<c:if test="${sessionScope.temCurri != '0' }">
    <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
        <a href="${pageContext.request.contextPath}/Curriculo?acao=TrabalhoNovo" class="btn btn-danger" >
            Novo
        </a>
    </div>
</c:if>