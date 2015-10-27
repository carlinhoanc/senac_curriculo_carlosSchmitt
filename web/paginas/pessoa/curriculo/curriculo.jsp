
<%@page session="true" %>
<form action="${pageContext.request.contextPath}/Curriculo?acao=CurriculoAdiciona" method="post" >

    <div class="row">
        <label>Resumo</label>
    <textarea id="resumo" name="resumo" ></textarea>
    </div>
    
    <div class="row">
        <label>Experiência Profissional</label>
        <textarea id="expProfissional" name="expProfissional" ></textarea>
    </div>
    
    <div class="row">
        <label>Formação Básica</label>
        <textarea id="forBasica" name="forBasica" ></textarea>
    </div>
    
    <div class="row">
        <label>Formação Média</label>
        <textarea id="formMedio" name="formMedio" ></textarea>
    </div>
 
    <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
        <input type="submit" value="Salvar" class="btn btn-success" />
    </div>

</form>