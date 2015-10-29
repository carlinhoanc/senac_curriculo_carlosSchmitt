package Acao;

import bean.EnderecoBean;
import bean.PessoaBean;
import dao.PessoaDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PessoaAdicionar implements Acao {

    @Override
    public String executar(HttpServletRequest req, HttpServletResponse res) throws Exception {
        EnderecoBean endereco = new EnderecoBean();

        endereco.setNomeRua(req.getParameter("nomeRua"));
        endereco.setNumero(Integer.parseInt(req.getParameter("numero")));
        endereco.setComplemento(req.getParameter("complemento"));
        endereco.setBairro(req.getParameter("bairro"));
        endereco.setId_cidade(req.getParameter("id_cidade"));
        endereco.setCep(req.getParameter("cep"));
        PessoaBean pessoa = new PessoaBean();

        pessoa.setNome(req.getParameter("nome"));
        pessoa.setSobreNome(req.getParameter("sobreNome"));
        pessoa.setIdade(Integer.parseInt(req.getParameter("idade")));
        pessoa.setSexo(req.getParameter("sexo"));
        pessoa.setCpf(req.getParameter("cpf"));
        pessoa.setSenha(req.getParameter("senha"));
        pessoa.setTelefone(req.getParameter("telefone"));
        pessoa.setEmail(req.getParameter("email"));
        pessoa.setEndereco(endereco);
        PessoaDao pessoaDAO = new PessoaDao();

        if (pessoaDAO.insereNaoAdmin(pessoa, 1) == true) {
            req.setAttribute("msg", "Pessoa inserida com sucesso");
        } else {
            req.setAttribute("msg", "Erro ao inserirr pessoa");
        }
        PessoaListarPessoa obj = new PessoaListarPessoa();
        return obj.executar(req, res);
    }
}
