
<%@page session="true" %>
<form action="${pageContext.request.contextPath}/Curriculo?acao=CurriculoAdiciona" method="post" >

    <div class="row">
        <label>Resumo</label>
    <textarea id="resumo" name="resumo" ></textarea>
    </div>
    
    <div class="row">
        <label>Experi�ncia Profissional</label>
        <textarea id="expProfissional" name="expProfissional" ></textarea>
    </div>
    
    <div class="row">
        <label>Forma��o B�sica</label>
        <textarea id="forBasica" name="forBasica" ></textarea>
    </div>
    
    <div class="row">
        <label>Forma��o M�dia</label>
        <textarea id="formMedio" name="formMedio" ></textarea>
    </div>
 
    <div class="btn-group btn-group grupo_botoes" role="group" aria-label="...">
        <input type="submit" value="Salvar" class="btn btn-success" />
    </div>

</form>