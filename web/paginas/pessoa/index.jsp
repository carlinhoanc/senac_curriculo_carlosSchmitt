<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <title>JSP Page</title>
    </head>
    <body>
        <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaNovo">Novo</a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaListarPessoa">Listar</a>
        <br/>
        <br/>
        <a href="${pageContext.request.contextPath}">Voltar</a>
    </body>
</html>
