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
public class TrabalhosPublicacosBean {
 
    private int id;
    
    /**
     * nome da publicacao
     */
    private String nome;
    
    /**
     * ano de publicacao
     */
    private int ano;
    
    /**
     * id do pais
     */
    private PaisBean pais;
    
    /*
    id tipo de publicacao
    */
    private TipoTrabalhoPublicadosBean id_TipoPublicados;
    
    /**
     * id do curriculo
     */
    int id_Curriculo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public PaisBean getPais() {
        return pais;
    }

    public void setPais(PaisBean pais) {
        this.pais = pais;
    }

    public int getId_Curriculo() {
        return id_Curriculo;
    }

    public void setId_Curriculo(int id_Curriculo) {
        this.id_Curriculo = id_Curriculo;
    }

    public TipoTrabalhoPublicadosBean getId_TipoPublicados() {
        return id_TipoPublicados;
    }

    public void setId_TipoPublicados(TipoTrabalhoPublicadosBean id_TipoPublicados) {
        this.id_TipoPublicados = id_TipoPublicados;
    }
    
    
}
