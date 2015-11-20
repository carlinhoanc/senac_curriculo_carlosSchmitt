package bean;

public class TrabalhosBean {
 
    private int id_TbPublicados;
    
    private String nome;
    
    private int ano;
    
    private PaisBean pais;
    
    private TipoTrabalhoPublicadosBean id_TipoPublicados;
    
    private String id_Curriculo;

    public int getId_TbPublicados() {
        return id_TbPublicados;
    }

    public void setId_TbPublicados(int id_TbPublicados) {
        this.id_TbPublicados = id_TbPublicados;
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

    public String getId_Curriculo() {
        return id_Curriculo;
    }

    public void setId_Curriculo(String id_Curriculo) {
        this.id_Curriculo = id_Curriculo;
    }

    public TipoTrabalhoPublicadosBean getId_TipoPublicados() {
        return id_TipoPublicados;
    }

    public void setId_TipoPublicados(TipoTrabalhoPublicadosBean id_TipoPublicados) {
        this.id_TipoPublicados = id_TipoPublicados;
    }
    
}
