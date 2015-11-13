<!DOCTYPE html>
<html>
    <%@ page session="true" %>
    <%@ page language="java"%> 
    <%@ page import="java.util.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <head>        
        <title>Lista de Usuários</title>
        <%@ include file="../../includes/heard.jsp" %>

        <script src="${pageContext.request.contextPath}/resource/js/jquery.tablesorter.js"></script>
        <script src="${pageContext.request.contextPath}/resource/js/jquery.tablesorter.widgets.js"></script>
        <script src="${pageContext.request.contextPath}/resource/js/jquery.tablesorter.pager.js"></script>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/tabela.css">
        <script src="${pageContext.request.contextPath}/resource/js/tabela.js"></script>
        <script>
                    $(function () {
                    $('button.filter').click(function () {
                    var col = $(this).data('column'),
                            txt = $(this).data('filter');
                            $('table').find('.tablesorter-filter').val('').eq(col).val(txt);
                            $('table').trigger('search', false);
                            return false;
                    });
                            $('button.zebra').click(function () {
                    var t = $(this).hasClass('btn-success');
                            if (t) {
                    removing classes applied by the zebra widget
                            you shouldn't ever need to use this code, it is only for this demo
                            $('table').find('tr').removeClass('odd even');
                    }
                    $('table')
                            .toggleClass('table-striped')[0]
                            .config.widgets = (t) ? ["uitheme", "filter"] : ["uitheme", "filter", "zebra"];
                            $(this)
                            .toggleClass('btn-danger btn-success')
                            .find('i')
                            .toggleClass('icon-ok icon-remove glyphicon-ok glyphicon-remove').end()
                            .find('span')
                            .text(t ? 'disabled' : 'enabled');
                            $('table').trigger('refreshWidgets', [false]);
                            return false;
                    });
                    });
        </script>

    </head>
    <body>
        <%@ include file="../../includes/topo.jsp" %>

        <div class="container theme-showcase" style="padding-top: 70px" role="main">
            <h2>Lista de Curriculos</h2>

            <div class="table-responsive">
                <table class="listagem table">
                    <thead>  
                        <tr>  
                            <th>ID</th>  
                            <th>Nome</th>  
                            <th class="filter-select filter-exact" data-placeholder="Idade  ">Idade</th>  
                            <th class="filter-select filter-exact" data-placeholder="Sexo">Sexo</th>  
                            <th>Cidade</th>  
                            <th></th>
                            <th class="filter-select filter-exact" data-placeholder="UF">Uf</th>  
                            <th></th>
                            <th>A&ccedil;&otilde;es</th>  
                        </tr>  
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID</th>  
                            <th>Nome</th>  
                            <th>Idade</th>  
                            <th>Sexo</th>  
                            <th>Cidade</th>  
                            <th></th>
                            <th>UF</th>  
                            <th></th>
                            <th>A&ccedil;&otilde;es</th>  
                        </tr>
                        <tr>
                            <th colspan="7" class="ts-pager form-horizontal">
                                <button type="button" class="btn first"><i class="icon-step-backward glyphicon glyphicon-step-backward"></i></button>
                                <button type="button" class="btn prev"><i class="icon-arrow-left glyphicon glyphicon-backward"></i></button>
                                <span class="pagedisplay"></span> 
                                <button type="button" class="btn next"><i class="icon-arrow-right glyphicon glyphicon-forward"></i></button>
                                <button type="button" class="btn last"><i class="icon-step-forward glyphicon glyphicon-step-forward"></i></button>

                                <select class="pagesize input-mini" title="Select page size">
                                    <option value="1">1</option>
                                    <option value="5">5</option>
                                    <option selected="selected" value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                    <option value="40">40</option>
                                </select>
                                <select class="pagenum input-mini" title="Select page number"></select>
                            </th>
                        </tr>
                    </tfoot

                    <tbody>
                        <c:forEach items="${pessoaslista}" var="pessoas" >
                            <tr> 
                                <td>${pessoas.id_Pessoa}</td>
                                <td>${pessoas.nome}  ${pessoas.sobreNome}</td>
                                <td>${pessoas.idade}</td>
                                <td>${pessoas.sexo}</td>
                                <td>${pessoas.endereco.cidade.nome}<td>
                                <td>${pessoas.endereco.cidade.estados}<td>
                                <td>
                                    <div>
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
                                            <c:if test="${sessionScope.id_tipo == '2'}">
                                                <form id="editaPessoa${pessoas.id_Pessoa}" 
                                                      action="${pageContext.request.contextPath}/Pessoa?acao=PessoaEditar" method="post" >
                                                </c:if>
                                                <c:if test="${sessionScope.id_tipo != '2'}">
                                                    <form id="editaPessoa${pessoas.id_Pessoa}" 
                                                          action="${pageContext.request.contextPath}/Pessoa?acao=PessoaMeuPerfil" method="post" >
                                                    </c:if>
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
                                    </div>
                                </td>
                            </tr>
                            </div>
                        </c:forEach>
                        </div>

                    </tbody>
                </table>
            </div>
        </div>

        <%@ include file="../../includes/footer.jsp" %>
    </body>
</html>
