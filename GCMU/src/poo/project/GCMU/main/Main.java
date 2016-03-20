package poo.project.GCMU.main;

import java.sql.SQLException;

import poo.project.GCMU.banco.DiscenteDAO;
import poo.project.GCMU.banco.DocenteDAO;
import poo.project.GCMU.classes.Discente;
import poo.project.GCMU.classes.Docente;


public class Main {

	public static void main(String[] args) {
		
		Discente discente = new Discente("13", "informatica","A", 1234, "Thomas","thomas@exemplo.com",83999999,"1234", 
				"117.541.664-50"); 
		try {
			
			DiscenteDAO.getInstance().delete(1234);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}

	}

	
	
	

	
}

