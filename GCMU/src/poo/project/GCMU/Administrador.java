package poo.project.GCMU;

public class Administrador extends Pessoa{
	private String senha;

	public Administrador(String senha, int matricula, String name, String email, String telefone) {
		super(matricula, name, email, telefone, senha);
		this.senha=senha;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	/**
	 *  A funçao desse método, seré de efetuar o cadastro do Aluno/Dicente/Docente,
	 *  ele irá printar na tela que o cadastro fou efetuado com sucesso!
	 * @return
	 */
	public String Autoriza(){
		return "ok, cadastro efetuado";
	}
}
