package poo.project.GCMU;

public abstract class Pessoa {
	private int matricula;
	private String name;
	private String email;
	private String telefone;
	private String senha;

	public Pessoa(int matricula, String name, String email, String telefone, String senha) {
		this.matricula = matricula;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
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

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String requisitaChave() {
		return ("ok");
	}

	public String requisitaMateriais() {
		return ("ok");
	}

	public String requisitaUtensilios() {
		return ("ok");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
