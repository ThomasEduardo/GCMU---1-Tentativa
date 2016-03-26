package GCMU.UI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ResourceBundle;
import GCMU.classes.Docente;
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

public class CadastroDocenteController implements Initializable {

	@FXML
	private TextField Nome_Field;

	@FXML
	private TextField Suap_Field;

	@FXML
	private TextField Cpf_Field;

	@FXML
	private TextField Cargo_Field;

	@FXML
	private Button Bt_Cadastrar;

	@FXML
	private Button Bt_Voltar;

	@FXML
	private void btCadastrar() throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Menu.fxml"));

		Scene menu = new Scene(root);
		Main.primaryStage.setTitle("Menu");
		Main.primaryStage.setScene(menu);
		Main.primaryStage.show();

		try {
			Docente d = new Docente();

			d.setName(Nome_Field.getText());
			d.setSiap(Integer.parseInt(Suap_Field.getText()));
			d.setCpf(Cpf_Field.getText());
			d.setCargo(Cargo_Field.getText());
			d.insert(d);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void btVoltar() throws IOException {

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
