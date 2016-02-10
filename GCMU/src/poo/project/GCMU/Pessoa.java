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
	/**
	 *  A funçao desse método, seré de requisitar a chave para o Dicente/Docente.
	 *  Ele irá printar na tela que a chave foi reservada, se nao, que está ocupada!
	 * @return
	 */
	public String requisitaChave() {
		return ("ok, Chave Reservada!");
	}
	/**
	 *  A funçao desse método, seré de requisitar materiais para o Docente.
	 *  ele irá printar na tela que o material foi reservado, se nao, que está ocupado!
	 * @return
	 */
	public String requisitaMateriais() {
		return ("ok, Material reservado!");
	}
	/**
	 *  A funçao desse método, seré de requisitar um untencio perdido para o Aluno/
	 *  Dicente/Docente. Ele irá printar na tela que o untencilio foi encontrado!
	 * @return
	 */
	public String requisitaUtensilios() {
		return ("ok, Utencilio Encontrado!");
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
