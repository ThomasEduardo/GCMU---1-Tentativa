package GCMU.classes;

import java.sql.SQLException;

import GCMU.DataBase.DocenteDAO;

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

	public Docente(String cargo, String area, String turno, int matricula, String name, String email, int telefone, String cpf, int siap) {
		super(matricula, name, email, telefone, cpf);
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

	public void setSiap1(int siap) {
		this.siap = siap;
	}


	public void setSiap(int parseInt) {
		// TODO Auto-generated method stub
		
	}


	public void setIdPessoa(Object insert) {
		// TODO Auto-generated method stub
		
	}
	public void insert(Docente docente) throws SQLException {
		DocenteDAO d = new DocenteDAO(null);
		d.insert(docente);
		

	}
}
