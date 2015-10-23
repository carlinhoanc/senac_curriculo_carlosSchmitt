package bean;

public class EnderecoBean {

    private String id;

    private String nomeRua;

    private int numero;

    private String complemento;
    
    private String bairro;
    
    private CidadeBean cidade;
    
    private String id_cidade;

    private String cep;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public CidadeBean getCidade() {
        return cidade;
    }

    public void setCidade(CidadeBean cidade) {
        this.cidade = cidade;
    }

    public String getId_cidade() {
        return id_cidade;
    }

    public void setId_cidade(String id_cidade) {
        this.id_cidade = id_cidade;
    }
    
}
