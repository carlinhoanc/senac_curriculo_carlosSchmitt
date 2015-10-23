<%-- 
    Document   : cadastroCurriculo
    Created on : 02/09/2015, 09:37:05
    Author     : CarlosRoberto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Pessoa</title>
    </head>
    <body>
        <h1>Cadastro Pessoa</h1>

        <form action="Pessoa" method="POST">
            <p><input type="text" name="nome" placeholder="digite nome" id="nome" /> </p>
            <p><input type="email" name="email" placeholder="digite email" id="email" /> </p>
            <p><input type="tel" name="telefone" id="telefone"  placeholder="digite telefone" /> </p>
            <p>
                <select name="sexo" id="sexo">
                    <option value="masculino">masculino</option>
                    <option value="feminino">feminino</option>
                </select>
            </p>
            <p><input name="endereco" id="endereco"  placeholder="digite seu endereço" /></p>

            <p><input type="submit" value="Salvar" /> </p>
        </form>

        
        <a href="${pageContext.request.contextPath}/Pessoa?acao=PessoaAdicionar">Novo</a>
        <a href="javascript:window.history.go(-1)">Voltar</a>

    </body>
</html>
