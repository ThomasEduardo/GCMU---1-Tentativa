package GCMU.UI.Controllers;

	
	import java.awt.TextField;
import java.io.IOException;
	import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import GCMU.classes.Chaves;
import GCMU.classes.Pessoa;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;


	public class PedidosController implements Initializable {
		@FXML
		private TextField MatriculaField;
		
		@FXML
		private TextField NumeroSalaField;
		
		@FXML
		private TextField NomeSalaField;
		
		@FXML
		private DatePicker DataReservaField;
		
		@FXML
		private Text Pedido;
		
		@FXML
		private Button Bt_Reservar;
	
		@FXML
		private Button Bt_Voltar;
			
			public static String tipoPedido = ReservaController.tipoPedido;
			
			
			
			
			@FXML
			private void btVoltar() throws IOException{
				
				
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Reserva.fxml"));
				
				Scene DocenteLogin = new Scene(root);
				Main.primaryStage.setTitle("Docente Login");
				Main.primaryStage.setScene(DocenteLogin);
				Main.primaryStage.show(); 
			}
			
			@FXML
			private void btReserva() throws IOException, ParseException,SQLException, java.text.ParseException{
				Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Menu.fxml"));
				
				try {
					
					Pessoa p = new Pessoa();
					Chaves c = new Chaves();
					
					p.setMatricula(Integer.parseInt(MatriculaField.getText()));
					c.setNomeSala(NomeSalaField.getText());
					c.setNumeroSala(Integer.parseInt(NumeroSalaField.getText()));;
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					p.setData((java.util.Date)formatter.parse(DataReservaField.getValue().toString()));
	
					Chaves.insert(c);
					
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