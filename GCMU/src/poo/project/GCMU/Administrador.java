package poo.project.GCMU;

/**
 * 
 * @author GCMU Essa classe seria a de administraco, na qual, o administrador
 *         irá autorizar o discente ou docente para que peguem materias, chaves
 *         ou utencilios, ja os metodos foram feitos para serem chamados em
 *         determinadas operaçoes, que sejam necessarias em contexto geral,
 *         como: Cadastro de chaves, materis e utencilios, o mesmo para
 *         atualização e remocao. 
 */
public class Administrador extends Pessoa {
	private String senha;

	public Administrador(String senha, int matricula, String name, String email, String telefone) {
		super(matricula, name, email, telefone, senha);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * A funcao desse metodo, sera de efetuar o cadastro do
	 * Aluno/Dicente/Docente, ele ira printar na tela que a autorizaçao foi
	 * efetuada com sucesso!
	 * 
	 * @return
	 */
	public String AutorizaPessoa() { 
		return "ok, você está autorizado!";
	}

	// "Cadastro" efetuará o cadastro de uma Chave/ material ou Utencilio,
	// dependendo de onde o método for chaamdo
	public String Cadastro(/*Recurso*/) {
		return "ok, cadastro efetuado!";
	}

	// "Atualizacao" efetuará a atualizaçao dos mesmos, dependendo de onde o
	// método for chaamdo.
	public String Atualizacao(/*Recurso*/) {
		return "ok, Atualizaçao efetuada!";
	}

	// "Remocao" efetuará a atualizaçao dos mesmos, dependendo de onde o método
	// for chaamdo.
	public String Remocao(/*Recurso*/) {
		return "ok, Remoçao efetuada!";
	}

}
