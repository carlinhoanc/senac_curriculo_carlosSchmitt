<%@ page session="true" %>
<%@ page language="java"%> 
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<head>
    <%@ include file="../../../includes/heard.jsp" %>
    <title>Adicionar trabalho</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap-datetimepicker.css">
    <script src="${pageContext.request.contextPath}/resource/js/moment.js"></script>
    <script src="${pageContext.request.contextPath}/resource/js/pt-br.js"></script>
    <script src="${pageContext.request.contextPath}/resource/js/bootstrap-datetimepicker.js"></script>
</head>
<body>
    <%@ include file="../../../includes/topo.jsp" %>
    <div class="container theme-showcase" style="padding-top: 70px" role="main">
        <form action="${pageContext.request.contextPath}/Curriculo?acao=FormacaoAtualiza" method="post" >
            <c:forEach var="formacao" items="${formacao}">
                <div class="row">
                    <div class="col-md-6" >
                        <label>Nome da Institui&ccedil;&atilde;o</label>
                        <input required="" name="nomeInstitui" type="text" id="nomeInstitui" value="${formacao.nomeInstitui}" placeholder="Digite nome da Institui&ccedil;&atilde;o" />
                    </div>
                    <div class="col-md-6" >
                        <label>Forma&ccedil;&atilde;o Academica</label>
                        <select id="id_tipoFormacao" name="id_tidoFormacao" required="" >
                            <c:forEach var="tipoFormas" items="${tipoForma}">
                                <c:if test="${formacao.id_Tipo.id_Tipo == tipoFormas.id_Tipo}">
                                    <option selected="" value="${tipoFormas.id_Tipo}">${tipoFormas.descricao}</option>
                                </c:if>

                                <c:if test="${formacao.id_Tipo.id_Tipo != tipoFormas.id_Tipo}">
                                    <option value="${tipoFormas.id_Tipo}">${tipoFormas.descricao}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6" >
                        <label>Data Inicio</label>
                        <div class="form-group">
                            <div class='input-group date' id='datetimepicker1'>
                                <input type='text' class="form-control" name="dataInicio" id="dataInicio" value="${formacao.dataInicio}" placeholder="Digite data Inicio" required="" />
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>

                        <script type="text/javascript">
                            var $fr = jQuery.noConflict();
                            $fr(function () {
                                $fr('#dataInicio').datetimepicker({
                                    format: 'YYYY-MM-DD'
                                });
                            });
                        </script>
                    </div>

                    <div class="col-md-6" >
                        <label>Data Término</label>
                        <div class="form-group">
                            <div class='input-group date' id='datetimepicker1'>
                                <input type='text' class="form-control" required="" name="dataTermino" id="dataTermino" value="${formacao.dataTermino}" placeholder="Digite data Término"  />
                                <span class="input-group-addon">
                                    <span class="glyphicon glyphicon-calendar"></span>
                                </span>
                            </div>
                        </div>

                        <script type="text/javascript">
                            var $fr = jQuery.noConflict();
                            $fr(function () {
                                $fr('#dataTermino').datetimepicker({
                                    format: 'YYYY-MM-DD'
                                });
                            });
                        </script>
                    </div>
                </div>
                <input type="hidden" value="${formacao.id}" id="id_formacao" name="id_formacao" />
            </c:forEach>

            <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
                <a class="btn btn-danger" href="${pageContext.request.contextPath}/Pessoa?acao=PessoaMeuPerfil">Cancelar</a>
                <input type="submit" value="Atualiza" class="btn btn-success" />
            </div>
        </form>
    </div>
    <%@ include file="../../../includes/footer.jsp" %>
</body>