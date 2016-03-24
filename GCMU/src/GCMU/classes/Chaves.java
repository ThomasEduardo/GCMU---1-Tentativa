package GCMU.classes;
/**
 * 
 * @author GCMU
 * Essa classe representa a entidade chave que podera ser reservada por um discente ou docente e ter� as informa��es para que eles saibam a situa��o dessa chave
 */
public class Chaves {

	private int numeroSala;
	private String nomeSala;
	private String observacao;
	private int id;
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Chaves(int numeroSala, int id, String nomeSala, String observacao) {

		this.numeroSala = numeroSala;
		this.nomeSala = nomeSala;
		this.observacao = observacao;
		this.id = id;

	}
	
	public Chaves(){}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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