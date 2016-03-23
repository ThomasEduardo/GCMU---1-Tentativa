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


	public class DocenteLoginController implements Initializable {

		
		@FXML
		private Button Bt_Voltar;
		
		@FXML
		private Button Bt_Continuar;
		
		
		@FXML
		private void btVoltar() throws IOException{
			
			
			Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/Menu.fxml"));
			
			Scene menu = new Scene(root);
			Main.primaryStage.setTitle("Menu");
			Main.primaryStage.setScene(menu);
			Main.primaryStage.show(); 
		}
		
		//
		@FXML
		private void btContinuar() throws IOException{
			

			Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/ConsultaDiscente.fxml"));
			
			Scene consulta = new Scene(root);
			Main.primaryStage.setTitle("Consulta");
			Main.primaryStage.setScene(consulta);
			Main.primaryStage.show(); 
			
			
		}
		
		
		
		
	}