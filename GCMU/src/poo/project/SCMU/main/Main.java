package poo.project.SCMU.main;

import java.sql.SQLException;

import poo.project.GCMU.Docente;
import poo.project.GCMU.banco.DocenteDAO;


public class Main {

	public static void main(String[] args) {
		
		Docente docente = new Docente("chefe", "técnico", "manha", 1234, "Matheus", "matehus@exemplo.com",999999,
				"1234", "9999dsds99", 1234);
		
		try {
			
			DocenteDAO.getInstance().delete(1234);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

	}

}
