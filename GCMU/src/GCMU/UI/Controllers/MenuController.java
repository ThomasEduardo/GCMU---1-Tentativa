package GCMU.UI.Controllers;



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
	private Button Bt_Docente;
	
	@FXML
	private Button Bt_Discente;

	
	@FXML
	private void btAdministrador() throws IOException{
		perfil = "Administrador";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/AreaAdmin.fxml"));
		
		Scene admLogin = new Scene(root);
		Main.primaryStage.setTitle("Docente");
		Main.primaryStage.setScene(admLogin);
		Main.primaryStage.show(); 
	}
	
	//
	@FXML
	private void btDocente() throws IOException{
		
		perfil = "Docente";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Login.fxml"));
		
		Scene loginDocente = new Scene(root);
		Main.primaryStage.setTitle("Docente");
		Main.primaryStage.setScene(loginDocente);
		Main.primaryStage.show(); 
		
		
	}
	
	
	@FXML
	private void btDiscente() throws IOException{
		perfil = "Discente";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/Login.fxml"));
		
		Scene loginSupervisorScreen = new Scene(root);
		
		Main.primaryStage.setTitle("Discente");
		Main.primaryStage.setScene(loginSupervisorScreen);
		Main.primaryStage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle Resources) {
		// TODO Auto-generated method stub
		
	}
	
}