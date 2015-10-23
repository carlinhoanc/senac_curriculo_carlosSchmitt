package Acao;

import bean.EnderecoBean;
import bean.PessoaBean;
import dao.PessoaDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaAtualizar implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        EnderecoBean endereco = new EnderecoBean();
        PessoaBean pessoa = new PessoaBean();

        endereco.setNomeRua(req.getParameter("nomeRua"));
        endereco.setNumero(Integer.parseInt(req.getParameter("numero")));
        endereco.setComplemento(req.getParameter("complemento"));
        endereco.setBairro(req.getParameter("bairro"));
        endereco.setId_cidade(req.getParameter("id_cidade"));
        endereco.setCep(req.getParameter("cep"));
        endereco.setId(req.getParameter("id_Endereco"));

        pessoa.setNome(req.getParameter("nome"));
        pessoa.setSobreNome(req.getParameter("sobreNome"));
        pessoa.setIdade(Integer.parseInt(req.getParameter("idade")));
        pessoa.setSexo(req.getParameter("sexo"));
        pessoa.setCpf(req.getParameter("cpf"));
        pessoa.setAtivo(Integer.parseInt(req.getParameter("ativo")));
        pessoa.setSenha(req.getParameter("senha"));
        pessoa.setTelefone(req.getParameter("telefone"));
        pessoa.setEmail(req.getParameter("email"));
        pessoa.setId_Pessoa(req.getParameter("id_Pessoa"));
        pessoa.setId_tipo(Integer.parseInt(req.getParameter("id_tipo")));
        pessoa.setEndereco(endereco);
        PessoaDao pessoaDAO = new PessoaDao();
        
        if (pessoaDAO.atualiza(pessoa) == true) {
            req.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            req.setAttribute("msg", "Erro ao inserirr pessoa");
        }
        PessoaListarPessoa obj = new PessoaListarPessoa();
        return obj.executar(req, res);
    }
}
