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
	
	public String Autoriza(){
		return "ok, cadastro efetuado";
	}
}
