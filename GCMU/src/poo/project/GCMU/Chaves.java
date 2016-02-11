package poo.project.GCMU;
/**
 * 
 * @author GCMU
 * Essa classe representa a entidade chave que podera ser reservada por um discente ou docente e terá as informações para que eles saibam a situação dessa chave
 */
public class Chaves {

	private int nSala;
	private String tipo;
	private String observacao;
	private int id;

	public Chaves(int nSala, int id, String tipo, String observacao) {

		this.nSala = nSala;
		this.tipo = tipo;
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

		return nSala;

	}

	public void setnSala(int nsala) {

		this.nSala = nsala;

	}

	public String getTipo() {

		return tipo;

	}

	public void setTipo(String tipo) {

		this.tipo = tipo;

	}

}