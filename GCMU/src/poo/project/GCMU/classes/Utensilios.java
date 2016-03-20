package poo.project.GCMU.classes;
/**
 * 
 * @author GCMU
 * Essa classe representa os materiais perdidos e contem as inform��es sobre eles
 */
public class Utensilios {
	private String locall;
	private String tipo;
	private String status;
	private String observacao;
	private String marca;
	private int id;

	public Utensilios(String locall, String tipo, String status, int id, String observacao, String marca) {
		this.locall = locall;
		this.tipo = tipo;
		this.id = id;
		this.observacao = observacao;
		this.status = status;
		this.marca = marca;
	}
	
	public Utensilios (){}
	
	public String getLocall() {
		return locall;
	}

	public void setLocall(String locall) {
		this.locall = locall;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
