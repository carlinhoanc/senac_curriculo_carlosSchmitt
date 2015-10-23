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
public class FormacaoBean {

    private int id;

    /**
     * noem da instituiçao
     */
    private String nomeInstitui;

    /**
     * data de inicio
     */
    private String dataInicio;

    /**
     * data Termino
     */
    private String dataTermino;

    /**
     * id do tipo de formação
     */
    private TipoFormacaoBean id_Tipo;

    /**
     * id do curriculo
     */
    private CurriculoBean Curriculo_id_Curriculo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeInstitui() {
        return nomeInstitui;
    }

    public void setNomeInstitui(String nomeInstitui) {
        this.nomeInstitui = nomeInstitui;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public TipoFormacaoBean getId_Tipo() {
        return id_Tipo;
    }

    public void setId_Tipo(TipoFormacaoBean id_Tipo) {
        this.id_Tipo = id_Tipo;
    }

    public CurriculoBean getCurriculo_id_Curriculo() {
        return Curriculo_id_Curriculo;
    }

    public void setCurriculo_id_Curriculo(CurriculoBean Curriculo_id_Curriculo) {
        this.Curriculo_id_Curriculo = Curriculo_id_Curriculo;
    }

}
