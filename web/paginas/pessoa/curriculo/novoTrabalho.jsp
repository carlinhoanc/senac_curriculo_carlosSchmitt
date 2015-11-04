<%@ page session="true" %>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <%@ include file="../../../includes/heard.jsp" %>
    <%@ page contentType="text/html" pageEncoding="UTF-8"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <form action="${pageContext.request.contextPath}/Curriculo?acao=TrabalhoAdiciona" method="post" >
            <div class="row">
                <div class="col-md-6" >
                    <label>Nome</label>
                    <input required="" name="nome" type="text" id="nome" value="" placeholder="Digite nome" />
                </div>
                <div class="col-md-6" >
                    <label>Ano</label>
                    <input required="" name="ano" id="ano" value="" placeholder="Digite ano" type="number" min="1960" max="2050"/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6" >
                    <label>Pais</label>
                    <div>
                        <select  class="form-control" required="" id="pais" name="pais">
                            <option>Selecione um pais</option>
                            <c:forEach var="pais" items="${paises}">
                                <option value="${pais.id}">${pais.nome}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-md-6" >
                    <label>Tipo de trabalho</label>
                    <div>
                        <select  class="form-control" required="" id="id_tipoTrab" name="id_tipoTrab">
                            <option>Selecione um tipo</option>
                            <c:forEach var="tipoTrabalhos" items="${tipoTrabalho}">
                                <option value="${tipoTrabalhos.id}">${tipoTrabalhos.descricao}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </div>

            <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                <input type="submit" value="Salvar" class="btn btn-success" />
            </div>
        </form>
    </div>

    <%@ include file="../../../includes/footer.jsp" %>
</body>