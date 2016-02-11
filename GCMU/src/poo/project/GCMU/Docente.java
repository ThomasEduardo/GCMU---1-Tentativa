package poo.project.GCMU;
/**
 * 
 * @author GCMU
 * Essa classe representa um docente que autorizado pelo administrador podera pegar chaves ou materiais
 */
public class Docente extends Pessoa {
	private String cargo;
	private String area;
	private String turno;

	public Docente(String cargo, String area, String turno, int matricula, String name, String email, String telefone,
			String senha) {
		super(matricula, name, email, telefone, senha);
		this.cargo = cargo;
		this.area = area;
		this.turno = turno;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

}
