<%@page session="true" %>
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

        <% if (id_tipo.equals("2") || id_tipo.equals("1")) { %>

        <div>

            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li role="presentation" class="active">
                    <a href="#perfil" aria-controls="perfil" role="tab" data-toggle="tab">
                        Perfil
                    </a>
                </li>
                <li role="presentation">
                    <a href="#curriculo" aria-controls="curriculo" role="tab" data-toggle="tab">
                        Curriculo
                    </a>
                </li>
                <li role="presentation">
                    <a href="#formacao" aria-controls="formacao" role="tab" data-toggle="tab">
                        Formação academica
                    </a>
                </li>
                <li role="presentation">
                    <a href="#trabalhos" aria-controls="trabalhos" role="tab" data-toggle="tab">
                        Trabalhos publicados
                    </a>
                </li>
            </ul>

            <!-- Tab panes -->
            <div class="tab-content">
                <div role="tabpanel" class="tab-pane active" id="perfil">
                    <%@ include file="../../paginas/pessoa/curriculo/perfil.jsp" %>
                </div>

                <div role="tabpanel" class="tab-pane" id="curriculo">
                    <c:if test="${sessionScope.id_curri == '0' }">
                        <%@ include file="../../paginas/pessoa/curriculo/curriculo.jsp" %>
                    </c:if>
                    <c:if test="${sessionScope.id_curri == '1' }">
                        <%@ include file="../../paginas/pessoa/curriculo/curriculoAtualizar.jsp" %>
                    </c:if>
                </div>

                <div role="tabpanel" class="tab-pane" id="formacao">

                </div>

                <div role="tabpanel" class="tab-pane" id="trabalhos">

                </div>
            </div>

            <% } else { %> 
            <form action="Login" method="POST" >
                <p><input name="nome" id="nome" value="" placeholder="digite nome" type="text"/></p>
                <p><input name="senha"  id="senha" type="password"  placeholder="digite senha"/></p>
                <p><input value="Enviar" type="submit" /></p>
            </form>
            <% }%> 
        </div>

        <%@ include file="../../includes/footer.jsp" %>

</body>