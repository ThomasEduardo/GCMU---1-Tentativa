package poo.project.GCMU.classes;
/**
 * 
 * @author GCMU
 * Essa classe representa um docente que autorizado pelo administrador podera pegar chaves ou materiais
 */
public class Docente extends Pessoa {
	private String cargo;
	private String area;
	private String turno;
	private int siap;

	public Docente(String cargo, String area, String turno, int matricula, String name, String email, int telefone,
			String senha, String cpf, int siap) {
		super(matricula, name, email, telefone, senha, cpf);
		this.cargo = cargo;
		this.area = area;
		this.turno = turno;
		this.siap = siap;
	}
	

	public Docente(){}

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
	
	public int getSiap() {
		return siap;
	}

	public void setSiap(int siap) {
		this.siap = siap;
	}

}
