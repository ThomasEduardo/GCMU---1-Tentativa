package poo.project.GCMU;
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

	public Chaves(int numeroSala, int id, String nomeSala, String observacao) {

		this.numeroSala = numeroSala;
		this.nomeSala = nomeSala;
		this.observacao = observacao;
		this.id = id;

	}

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

	public int getnSala() {

		return numeroSala;

	}

	public void setnSala(int nsala) {

		this.numeroSala = nsala;

	}

	public String getNomeSala() {

		return nomeSala;

	}

	public void setNomeSala(String nomeSala) {

		this.nomeSala = nomeSala;

	}

}