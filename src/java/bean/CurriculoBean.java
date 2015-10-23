/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author CarlosRoberto
 */
public class CurriculoBean {

    private int id;

    /**
     * resumo do curriculo
     */
    private String resumo;

    /**
     * eperiencia proficional
     */
    private String expProfissional;

    /**
     * formação basica
     */
    private String forBasica;

    /**
     * Formação Medio
     */
    private String FormMedio;
    
    private PessoaBean idPessoa;

    public PessoaBean getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(PessoaBean idPessoa) {
        this.idPessoa = idPessoa;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getExpProfissional() {
        return expProfissional;
    }

    public void setExpProfissional(String expProfissional) {
        this.expProfissional = expProfissional;
    }

    public String getForBasica() {
        return forBasica;
    }

    public void setForBasica(String forBasica) {
        this.forBasica = forBasica;
    }

    public String getFormMedio() {
        return FormMedio;
    }

    public void setFormMedio(String FormMedio) {
        this.FormMedio = FormMedio;
    }
    
    
}
