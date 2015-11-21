<%@ page session="true" %>
<form action="${pageContext.request.contextPath}/Curriculo?acao=CurriculoAtualizar" method="post" >
    <c:forEach var="curriculo" items="${curriculo}">
        <div class="row">
            <label>Resumo</label>
            <textarea id="resumo" name="resumo" >${curriculo.resumo}</textarea>
        </div>

        <div class="row">
            <label>Experiência Profissional</label>
            <textarea id="expProfissional" name="expProfissional" >${curriculo.expProfissional}</textarea>
        </div>

        <div class="row">
            <label>Forma&ccedil;&atilde;o Básica</label>
            <textarea id="forBasica" name="forBasica" >${curriculo.forBasica}</textarea>
        </div>

        <div class="row">
            <label>Forma&ccedil;&atilde;o Média</label>
            <textarea id="formMedio" name="formMedio" >${curriculo.formMedio}</textarea>
        </div>

        <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
            <input type="submit" value="Atualzar" class="btn btn-success" />
        </div>
    </c:forEach>
</form>