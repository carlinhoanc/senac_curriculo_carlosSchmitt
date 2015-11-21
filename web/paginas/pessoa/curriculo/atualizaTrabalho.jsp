<%@ page session="true" %>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <%@ include file="../../../includes/heard.jsp" %>  
    <title>Adicionar trabalho</title>
    <script src="${pageContext.request.contextPath}/resource/js/maskedinput.js"></script>
    <script>
        var $maskk = jQuery.noConflict();
        jQuery(function ($maskk) {
            $maskk("#ano").mask("099999");
        });
    </script>
</head>

<body>
    <%@ include file="../../../includes/topo.jsp" %>
    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <form action="${pageContext.request.contextPath}/Curriculo?acao=TrabalhoAtualiza" method="post" >
            <c:forEach var="trabalhos" items="${trabalhos}">
                <div class="row">
                    <div class="col-md-6" >
                        <label>Nome</label>
                        <input required="" name="nome" type="text" id="nome" value="${trabalhos.nome}" placeholder="Digite nome" />
                    </div>
                    <div class="col-md-6" >
                        <label>Ano</label>
                        <input required="" name="ano" id="ano" value="${trabalhos.ano}" placeholder="Digite ano" type="number" min="1960" max="2050"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6" >
                        <label>Pais</label>
                        <div>
                            <select  class="form-control" required="" id="pais" name="pais">
                                <c:forEach var="pais" items="${paises}">
                                    <c:if test="${trabalhos.pais.id == pais.id}">
                                        <option selected="" value="${pais.id}">${pais.nome}</option>
                                    </c:if>

                                    <c:if test="${trabalhos.pais.id != pais.id}">
                                        <option value="${pais.id}">${pais.nome}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-6" >
                        <label>Tipo de trabalho</label>
                        <div>
                            <select  class="form-control" required="" id="id_tipoTrab" name="id_tipoTrab">
                                <c:forEach var="tipoTrabalhos" items="${tipoTrabalho}">
                                    <c:if test="${trabalhos.id_TipoPublicados.id == tipoTrabalhos.id}">
                                        <option selected="" value="${tipoTrabalhos.id}">${tipoTrabalhos.descricao}</option>
                                    </c:if>

                                    <c:if test="${trabalhos.id_TipoPublicados.id != tipoTrabalhos.id}">
                                        <option value="${tipoTrabalhos.id}">${tipoTrabalhos.descricao}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <input type="hidden" name="id_trabalho" id="id_trabalho" value="${trabalhos.id_TbPublicados}" />
            </c:forEach>
            <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/Pessoa?acao=PessoaMeuPerfil">Cancelar</a>
                <input type="submit" value="Atualizar" class="btn btn-success" />
            </div>
        </form>
    </div>
    <%@ include file="../../../includes/footer.jsp" %>
</body>