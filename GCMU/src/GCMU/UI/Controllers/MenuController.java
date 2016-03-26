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
	private Button Bt_Memorando;
	@FXML
	private Button Bt_Controll;
	
	@FXML
	private Button Bt_Consulta;
	
	@FXML
	private Button Bt_Reserva;

	
	@FXML
	private void btControll() throws IOException{
		perfil = "Administrador";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Crud.fxml"));
		
		Scene Controll = new Scene(root);
		Main.primaryStage.setTitle("Controle de Dados");
		Main.primaryStage.setScene(Controll);
		Main.primaryStage.show(); 
	}
	
	//
	@FXML
	private void btConsulta() throws IOException{
		
		perfil = "Docente";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Consulta.fxml"));
		
		Scene loginDocente = new Scene(root);
		Main.primaryStage.setTitle("Docente");
		Main.primaryStage.setScene(loginDocente);
		Main.primaryStage.show(); 
		
		
	}
	
	
	@FXML
	private void btReserva() throws IOException{
		perfil = "Discente";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/Reserva.fxml"));
		
		Scene loginSupervisorScreen = new Scene(root);
		
		Main.primaryStage.setTitle("Discente");
		Main.primaryStage.setScene(loginSupervisorScreen);
		Main.primaryStage.show();
	}
	
	@FXML
	private void btMemorando() throws IOException{
		perfil = "Discente";
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/Memorando.fxml"));
		
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