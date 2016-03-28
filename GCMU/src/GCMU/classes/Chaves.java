package GCMU.classes;

import java.sql.SQLException;

import GCMU.DataBase.ChavesDAO;
import GCMU.DataBase.DocenteDAO;

/**
 * 
 * @author GCMU
 * Essa classe representa a entidade chave que podera ser reservada por um discente ou docente e ter� as informa��es para que eles saibam a situa��o dessa chave
 */
public class Chaves {

	private int numeroSala;
	private String nomeSala;
	private int id;
	private String status;
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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