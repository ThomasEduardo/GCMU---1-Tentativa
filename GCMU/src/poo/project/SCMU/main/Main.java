package poo.project.SCMU.main;

import java.sql.SQLException;

import poo.project.GCMU.Docente;
import poo.project.GCMU.banco.DocenteDAO;


public class Main {

	public static void main(String[] args) {
		
		Docente docente = new Docente("chefe", "técnico", "manha", 199, "Matheus", "matehus@exemplo.com",999999,
				"1234", "9999dsds99", 4444444);
		
		try {
			
			DocenteDAO.getInstance().insert(docente);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

	}

}
