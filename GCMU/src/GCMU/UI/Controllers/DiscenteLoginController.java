package GCMU.UI.Controllers;
Package br.edu.ifpb.auxilio.service.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController implements Initializable {
	
	 private static String perfil;
	
	@FXML
	private Button Bt_Admninistrador;
	
	@FXML
	private Button Bt_Discente;
	
	@FXML
	private Button Bt_Docente;
	
	
	@FXML
	private void btAdministrador() throws IOException{
		perfil = "Administrador";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/Menu.fxml"));
		
		Scene admLogin = new Scene(root);
		Main.primaryStage.setTitle("Docente");
		Main.primaryStage.setScene(loginMonitorScreen);
		Main.primaryStage.show(); 
	}
	
	//
	@FXML
	private void btDocente() throws IOException{
		perfil = "Docente";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/Menu.fxml"));
		
		Scene loginMonitorScreen = new Scene(root);
		Main.primaryStage.setTitle("Docente");
		Main.primaryStage.setScene(loginMonitorScreen);
		Main.primaryStage.show(); 
	}
	
	
	@FXML
	private void btDiscente() throws IOException{
		perfil = "Discente";
		Parent root2 = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/Menu.fxml"));
		
		Scene loginSupervisorScreen = new Scene(root);
		
		Main.primaryStage.setTitle("Discente");
		Main.primaryStage.setScene(loginSupervisorScreen);
		Main.primaryStage.show();
	}
	
	

}