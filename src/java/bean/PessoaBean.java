package bean;

public class PessoaBean {

    private String id_Pessoa;

    private String nome;

    private String sobreNome;

    private int idade;

    private String sexo;

    private String cpf;

    private EnderecoBean Endereco;

    private TipoAcessoBean tipo;

    private String senha;

    private String email;
    
    private int ativo;
    
    private String telefone;
    
    private int id_tipo;

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
    
    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
    
    public String getId_Pessoa() {
        return id_Pessoa;
    }

    public void setId_Pessoa(String id_Pessoa) {
        this.id_Pessoa = id_Pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public EnderecoBean getEndereco() {
        return Endereco;
    }

    public void setEndereco(EnderecoBean Endereco) {
        this.Endereco = Endereco;
    }

    public TipoAcessoBean getTipo() {
        return tipo;
    }

    public void setTipo(TipoAcessoBean tipo) {
        this.tipo = tipo;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    

}
