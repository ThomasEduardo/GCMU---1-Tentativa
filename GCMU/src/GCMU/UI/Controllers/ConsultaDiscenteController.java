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


		public class ConsultaDiscenteController implements Initializable {

			@FXML
			private Button Bt_Materiais;
			
			@FXML
			private Button Bt_Continuar;
			
			public static String tipoPedido;
			
			
			@FXML
			private void btVoltar() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/DocenteLoginController.fxml"));
				
				Scene DocenteLogin = new Scene(root);
				Main.primaryStage.setTitle("Docente Login");
				Main.primaryStage.setScene(DocenteLogin);
				Main.primaryStage.show(); 
			}
			
			//
			@FXML
			private void btMateriais() throws IOException{
				

				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/EscolhaChave.fxml"));
				tipoPedido = "Materiais";
				
				Scene consulta = new Scene(root);
				Main.primaryStage.setTitle("Consulta");
				Main.primaryStage.setScene(consulta);
				Main.primaryStage.show(); 
				
				
			}
			
			
			
			
		}