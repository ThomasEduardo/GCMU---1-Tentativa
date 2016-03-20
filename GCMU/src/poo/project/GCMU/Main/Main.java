package poo.project.GCMU.Main;

import java.sql.SQLException;

import poo.project.GCMU.Classes.Discente;
import poo.project.GCMU.Classes.Docente;
import poo.project.GCMU.DataBase.DiscenteDAO;
import poo.project.GCMU.DataBase.DocenteDAO;


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

