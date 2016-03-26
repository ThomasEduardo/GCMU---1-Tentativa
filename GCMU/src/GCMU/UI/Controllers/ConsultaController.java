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


		public class ConsultaController implements Initializable {

			@FXML
			private Button Bt_Materiais;
			
			@FXML
			private Button Bt_Chaves;
			
			@FXML
			private Button Bt_Utensilios;
			
			@FXML
			private Button Bt_Voltar;
			
			public static String tipoPedido;
			
			
			@FXML
			private void btMateriais() throws IOException{
				
				tipoPedido = "Materiais"; 
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/ConsultaMaterial.fxml"));
				
				Scene Pedidos = new Scene(root);
				Main.primaryStage.setTitle("Pedido de materiais");
				Main.primaryStage.setScene(Pedidos);
				Main.primaryStage.show(); 
			}
			
			@FXML
			private void btUtensilios() throws IOException{
				
				tipoPedido = "Utensilios"; 
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/ConsultaUtensilio.fxml"));
				
				Scene Pedidos = new Scene(root);
				Main.primaryStage.setTitle("Pedido de materiais");
				Main.primaryStage.setScene(Pedidos);
				Main.primaryStage.show(); 
			}
			
				
			@FXML
			private void btChaves() throws IOException{
				tipoPedido = "Chaves";
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/ConsultaChave.fxml"));
				
				Scene Chaves = new Scene(root);
				Main.primaryStage.setTitle("Escolha Chave");
				Main.primaryStage.setScene(Chaves);
				Main.primaryStage.show(); 
			}
		
			@FXML
			private void btVoltar() throws IOException{
					
					
					Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Consulta.fxml"));
					
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
			
		