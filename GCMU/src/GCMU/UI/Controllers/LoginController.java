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


	public class LoginController implements Initializable {

		@FXML
		private TextField SiapField;
		
		@FXML
		private TextField SenhaField;
		

		@FXML
		private Button Bt_Voltar;
		
		@FXML
		private Button Bt_Continuar;
		
		
		@FXML
		private void btVoltar() throws IOException{
			
			
			Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Menu.fxml"));
			
			Scene menu = new Scene(root);
			Main.primaryStage.setTitle("Menu");
			Main.primaryStage.setScene(menu);
			Main.primaryStage.show(); 
		}
		
		//
		@FXML
		private void btContinuar() throws IOException{
			

			Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Choice.fxml"));
			
			Scene consulta = new Scene(root);
			Main.primaryStage.setTitle("Consulta");
			Main.primaryStage.setScene(consulta);
			Main.primaryStage.show(); 
			
			try {
				Docente docente = new Docente();
				Pessoa p = new Pessoa();
				
				Docente d = new Docente();
				
				d.setSiap(Integer.parseInt(SiapField.getText()));
				d.setSenha(SenhaField.getText());
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				/////////////////////////////////////////////////////////////////////d.setIdPessoa(p.insert(d));
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
		
		
		
	