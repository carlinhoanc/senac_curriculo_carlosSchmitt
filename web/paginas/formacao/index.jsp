<%-- 
    Document   : newjspindex
    Created on : 07/10/2015, 08:44:55
    Author     : CarlosRoberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoAdiciona">Novo</a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/Curriculo?acao=TipoTrabalhoListarTipoTrabalho">Listar</a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}">Voltar</a>

        

    </body>
</html>
