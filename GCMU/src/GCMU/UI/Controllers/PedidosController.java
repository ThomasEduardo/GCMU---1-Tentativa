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
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;


	public class PedidosController implements Initializable {

			@FXML
			private Text Pedido;
		
			@FXML
			private Button Bt_Reservar;
	
			@FXML
			private Button Bt_Voltar;
			
			public static String tipoPedido = ChoiceController.tipoPedido;
			
			@FXML
			private void btVoltar() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Choice.fxml"));
				
				Scene DocenteLogin = new Scene(root);
				Main.primaryStage.setTitle("Docente Login");
				Main.primaryStage.setScene(DocenteLogin);
				Main.primaryStage.show(); 
			}
			
		
		
		
			public void initialize(URL location, ResourceBundle Resources){
				if(tipoPedido.equals("Materiais")){
					Pedido.setText("Pedido de Materiais");
			}
	
			}
	}
