
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
	private int suap;

	public Docente(String cargo, String area, int suap, String turno, int matricula, String name, String email, int telefone, String cpf,String permissao) {
		super( matricula,  name, email, telefone,permissao);
		this.cargo = cargo;
		this.area = area;
		this.turno = turno;
		this.suap = suap;
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
	
	public int getSuap() {
		return suap;
	}

	public void setSuap1(int suap) {
		this.suap = suap;
	}


	public void setSuap(int parseInt) {
		// TODO Auto-generated method stub
		
	}


	public void setIdPessoa(Object insert) {
		// TODO Auto-generated method stub
		
	}


	
}
