package GCMU.classes;

import java.util.Date;

/**
 * 
 * @author GCMU
 *	Essa eh uma classe mae que contem os atributos comuns entre discente e docente 
 */
public class Pessoa {
	private int matricula;
	private String name;
	private String email;
	private int telefone;
	private String senha;
	private String cpf;
	private Date data;

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Pessoa(int matricula, String name, String email, int telefone, String senha, String cpf) {
		this.matricula = matricula;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.setCpf(cpf);
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public Pessoa(){}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	/**
	 *  A funcao desse metodo, sera de requisitar a chave para o Dicente/Docente.
	 *  Ele ira printar na tela que a chave foi reservada, se nao, que esta ocupada!
	 * @return
	 */
	public String requisitaChave() {
		return ("ok, Chave Reservada!");
	}
	/**
	 *  A fuA funcao desse metodo, sera de requisitar materiais para o Docente.
	 *  ele ira printar na tela que o material foi reservado, se nao, que esta ocupado!
	 * @return
	 */
	public String requisitaMateriais() {
		return ("ok, Material reservado!");
	}
	/**
	 *  A funcao desse metodo, sera de requisitar um untencio perdido para o Aluno/
	 *  Dicente/Docente. Ele ira printar na tela que o untencilio foi encontrado!
	 * @return
	 */
	public String requisitaUtensilios() {
		return ("ok, Utencilio Encontrado!");
	}
}