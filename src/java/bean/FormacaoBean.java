package bean;

public class FormacaoBean {

    private int id;

    private String nomeInstitui;

    private String dataInicio;

    private String dataTermino;

    private TipoFormacaoBean id_Tipo;

    private String Curriculo_id_Curriculo;

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

    public String getCurriculo_id_Curriculo() {
        return Curriculo_id_Curriculo;
    }

    public void setCurriculo_id_Curriculo(String Curriculo_id_Curriculo) {
        this.Curriculo_id_Curriculo = Curriculo_id_Curriculo;
    }

}
