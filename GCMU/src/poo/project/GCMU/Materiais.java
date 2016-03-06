package poo.project.GCMU;
/**
 * 
 * @author GCMU
 * Essa classe representa a entidade materiais que podera ser reservado por um discente ou docente, sendo essa a responsavel por conter as inorma��es dos materiais
 */
public class Materiais {

	private int id;
	private String tipo;
	private String status;
	private String observacao;
	private int numeroSala;
	private String nomeSala;

	public Materiais( int id, String tipo, String status, String observacao, int numeroSala, String nomeSala) {

	
		this.tipo = tipo;
		this.status = status;
		this.observacao = observacao;
		this.id = id;
		this.numeroSala = numeroSala;
		this.nomeSala = nomeSala;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {

		return tipo;

	}

	public void setTipo(String tipo) {

		this.tipo = tipo;

	}

	public String getStatus() {

		return status;

	}

	public void setStatus(String status) {

		this.status = status;

	}

	public String getObservacao() {

		return observacao;

	}

	public void setObservacao(String observacao) {

		this.observacao = observacao;

	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}


}