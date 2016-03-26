package GCMU.classes;
/**
 * 
 * @author GCMU
 * Essa classe representa um discente que autorizado pelo administrador podera pegar chaves ou materiais
 */
public class Discente extends Pessoa {
	private String sala;
	private String curso;
	private String turma;

	public Discente(String sala, String curso, String turma, int matricula, String name, String email, int telefone, String cpf) {
		super(matricula, name, email, telefone, cpf);
		this.turma = turma;
		this.sala = sala;
		this.curso = curso;
	}
	
	public Discente(){}
	
	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

}
