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


		public class CadastroChaveController implements Initializable {

			@FXML
			private TextField SuapField;
			
			@FXML
			private TextField SenhaField;
			
			@FXML
			private TextField ProfField;
			
			@FXML
			private TextField CargoField;
			
			@FXML
			private TextField CpfField;
			
			@FXML
			private TextField NomeField;


			@FXML
			private Button Bt_Voltar;
			
			@FXML
			private Button Bt_Cadastrar;
			
			
			@FXML
			private void btVoltar() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Crud.fxml"));
				
				Scene menu = new Scene(root);
				Main.primaryStage.setTitle("Menu");
				Main.primaryStage.setScene(menu);
				Main.primaryStage.show(); 
			}
			
			//
			@FXML
			private void btCadastrar() throws IOException{
				

				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Menu.fxml"));
				
				Scene consulta = new Scene(root);
				Main.primaryStage.setTitle("Consulta");
				Main.primaryStage.setScene(consulta);
				Main.primaryStage.show(); 
				
				try {
					Docente docente = new Docente();
					Pessoa p = new Pessoa();
					
					Docente d = new Docente();
					
					d.setSiap(Integer.parseInt(SuapField.getText()));
					d.setSenha(SenhaField.getText());
					d.setArea(ProfField.getText());
					d.setCargo(CargoField.getText());
					d.setCpf((CpfField.getText()));
					d.setName(NomeField.getText());
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					docente.insert(d);
				
			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			@Override
			public void initialize(URL location, ResourceBundle Resources) {
				// TODO Auto-generated method stub
				
			}
		}