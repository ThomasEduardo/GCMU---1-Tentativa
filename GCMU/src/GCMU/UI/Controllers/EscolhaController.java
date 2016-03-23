package GCMU.UI.Controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

 public class EscolhaController implements Initializable {

	
	public static String tipoPedido =  ConsultaDiscenteController.tipoPedido ;
	@FXML
	private Label pedido;
	
	@FXML
	private Button Bt_Materiais;
	
	@FXML
	private Button Bt_Continuar;
	
	
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
		

		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/FXML/ConsultaDiscente.fxml"));
		
		Scene consulta = new Scene(root);
		Main.primaryStage.setTitle("Consulta");
		Main.primaryStage.setScene(consulta);
		Main.primaryStage.show(); 
		
		
	}
	
	private void perfil(){
		if(tipoPedido.equals("Materiais")){
			
			/*Image img = new Image("br/edu/ifpb/auxilio/recursos/imagens/Servidor.png");
			logoPessoa.setImage(img);*/
			pedido.setText("olá");
			
		}
	}
	
	
 }
