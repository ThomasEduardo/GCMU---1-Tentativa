package poo.project.GCMU.classes;

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
	
	private int siap;
	private String senha;
	
	
	public Administrador(int Siap, String senha, int matricula, String name, String email, int telefone, String cpf) {
		super(matricula, name, email, telefone, senha, cpf);
		this.senha = senha;
	}
	
	public Administrador(){}
	
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
		return "ok, Atualização efetuada!";
	}

	// "Remocao" efetuará a atualizaçao dos mesmos, dependendo de onde o método
	// for chaamdo.
	public String Remocao(/*Recurso*/) {
		return "ok, Remoção efetuada!";
	}

	public int getSiap() {
		return siap;
	}

	public void setSiap(int siap) {
		this.siap = siap;
	}

}
