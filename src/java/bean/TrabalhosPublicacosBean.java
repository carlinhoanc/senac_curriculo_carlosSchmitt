package bean;

public class TrabalhosPublicacosBean {
 
    private int id;
    
    private String nome;
    
    private int ano;
    
    private PaisBean pais;
    
    private TipoTrabalhoPublicadosBean id_TipoPublicados;
    
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
