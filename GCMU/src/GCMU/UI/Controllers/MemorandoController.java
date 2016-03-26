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


		public class MemorandoController implements Initializable {


			@FXML
			private Button Bt_Voltar;
			
			public static String tipoPedido;
			
			
		
			@FXML
			private void btVoltar() throws IOException{
					
					
					Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Menu.fxml"));
					
					Scene Menu = new Scene(root);
					Main.primaryStage.setTitle("Menu");
					Main.primaryStage.setScene(Menu);
					Main.primaryStage.show(); 
			}
		@Override
		public void initialize(URL location, ResourceBundle Resources) {
			// TODO Auto-generated method stub
			
		}
		
	}
			
		