package GCMU.UI.Controllers;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroDocente2Controller implements Initializable{
	
	@FXML
	private TextField NomeDiscente_Field;
	
	@FXML
	private TextField MatriculaDiscente_Field;
	
	@FXML
	private TextField CpfDiscente_Field;
	
	@FXML
	private TextField Curso_Field;
	
	
	@FXML
	private Button Bt_CadastrarDocente;
	
	@FXML
	private Button Bt_Voltar;
	


	@FXML
	private void btVoltar() throws IOException{
		
		
		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Crud.fxml"));
		
		Scene menu = new Scene(root);
		Main.primaryStage.setTitle("Menu");
		Main.primaryStage.setScene(menu);
		Main.primaryStage.show(); 
	}
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	

	

}
