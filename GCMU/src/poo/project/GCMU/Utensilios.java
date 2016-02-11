package poo.project.GCMU;
/**
 * 
 * @author GCMU
 * Essa classe representa os materiais perdidos e contem as informções sobre eles
 */
public class Utensilios {
	private String nome;
	private String tipo;
	private String status;
	private String observacao;
	private int id;

	public Utensilios(String nome, String tipo, String status, int id, String observacao) {
		this.nome = nome;
		this.tipo = tipo;
		this.id = id;
		this.observacao = observacao;
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
