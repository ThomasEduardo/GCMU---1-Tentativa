package GCMU.UI.Controllers;

	import java.awt.TextField;
	import java.io.IOException;
	import java.net.URL;
	import java.sql.SQLException;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.ResourceBundle;
	import GCMU.classes.Discente;
	import GCMU.classes.Docente;
	import GCMU.classes.Pessoa;
	import javafx.application.*;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.DatePicker;
	import javafx.scene.control.MenuButton;
	import javafx.scene.control.PasswordField;
	import javafx.stage.Stage;


		public class CrudController implements Initializable {

			@FXML
			private TextField SuapField;
			
			@FXML
			private TextField SenhaField;
			
			@FXML
			private TextField Campo_SUAPServidor;

			@FXML
			private Button Bt_Voltar;
			
			@FXML
			private Button Bt_DiscenteC;
			
			@FXML
			private Button Bt_DocenteC;
		
			@FXML
			private Button Bt_ChaveC;
			
			@FXML
			private Button Bt_MaterialC;
			
			@FXML
			private Button Bt_UtensilioC;
			
			@FXML
			private Button Bt_Remover;
			

			@FXML
			private void btRemover() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Remover.fxml"));
				
				Scene getOut = new Scene(root);
				Main.primaryStage.setTitle("Menu");
				Main.primaryStage.setScene(getOut);
				Main.primaryStage.show(); 
				
			}
			
			@FXML
			private void btDiscenteC() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroDiscente.fxml"));
				
				Scene getOut = new Scene(root);
				Main.primaryStage.setTitle("Menu");
				Main.primaryStage.setScene(getOut);
				Main.primaryStage.show(); 
				
			}
		
			@FXML
			private void btDocenteC() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroDocente.fxml"));
				
				Scene getOut = new Scene(root);
				Main.primaryStage.setTitle("Menu");
				Main.primaryStage.setScene(getOut);
				Main.primaryStage.show(); 
				
			}
			
			@FXML
			private void btChaveC() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroChave.fxml"));
				
				Scene getOut = new Scene(root);
				Main.primaryStage.setTitle("Menu");
				Main.primaryStage.setScene(getOut);
				Main.primaryStage.show(); 
				
			}
			
			@FXML
			private void btUtensilioC() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroUtensilio.fxml"));
				
				Scene getOut = new Scene(root);
				Main.primaryStage.setTitle("Menu");
				Main.primaryStage.setScene(getOut);
				Main.primaryStage.show(); 
				
			}
			
			@FXML
			private void btMaterialC() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroMaterial.fxml"));
				
				Scene getOut = new Scene(root);
				Main.primaryStage.setTitle("Menu");
				Main.primaryStage.setScene(getOut);
				Main.primaryStage.show(); 
				

			}
				@FXML
				private void btVoltar() throws IOException{
					
					
					Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Menu.fxml"));
					
					Scene getOut = new Scene(root);
					Main.primaryStage.setTitle("Menu");
					Main.primaryStage.setScene(getOut);
					Main.primaryStage.show(); 
			
					
			
		}
			@Override
			public void initialize(URL location, ResourceBundle Resources) {
				// TODO Auto-generated method stub
				
			}
		}
			
			
			
		