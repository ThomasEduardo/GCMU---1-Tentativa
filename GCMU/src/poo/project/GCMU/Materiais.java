package poo.project.GCMU;
/**
 * 
 * @author GCMU
 * Essa classe representa a entidade materiais que podera ser reservado por um discente ou docente, sendo essa a responsavel por conter as inormações dos materiais
 */
public class Materiais {

	private String salaDestino;
	private String tipo;
	private String status;
	private String observacao;
	private int id;

	public Materiais(String salaDestino, int id, String tipo, String status, String observacao) {

		this.salaDestino = salaDestino;
		this.tipo = tipo;
		this.status = status;
		this.observacao = observacao;
		this.id = id;

	}

	public String getSalaDestino() {

		return salaDestino;

	}

	public void setSalaDestino(String salaDestino) {

		this.salaDestino = salaDestino;

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

}