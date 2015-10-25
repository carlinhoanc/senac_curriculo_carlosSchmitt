<%-- 
    Document   : Lista
    Created on : 07/10/2015, 08:36:22
    Author     : CarlosRoberto
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@page session="true" %>
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
        <c:if test="${sessionScope.id_tipo == '2' }">
            <c:forEach items="${tipoTrabalho}" var="tipoTrabalhos" >
                ssss
                <div class="container theme-showcase" style="padding-top: 70px" role="main">
                    <div class="row">


                    </div>
                </div>

            </c:forEach>
        </c:if>
    </div>
</div>

<%@ include file="../../includes/footer.jsp" %>
</body>
</html>
