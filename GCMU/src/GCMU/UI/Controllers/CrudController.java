package GCMU.UI.Controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import GCMU.classes.Discente;
import GCMU.classes.Docente;
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
import javafx.scene.control.TextField;

public class CrudController implements Initializable {

    @FXML
    private Button Bt_Voltar;

    @FXML
    private Button Bt_Discente;

    @FXML
    private Button Bt_Docente;

    @FXML
    private Button Bt_Chave;

    @FXML
    private Button Bt_Material;

    @FXML
    private Button Bt_Utensilio;

    @FXML
    private Button Bt_Remover;

    @FXML
    private void btRemover() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/Remover.fxml"));

        Scene getOut = new Scene(root);
        Main.primaryStage.setTitle("Menu");
        Main.primaryStage.setScene(getOut);
        Main.primaryStage.show();

    }

    @FXML
    private void btDiscente() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroDocente2.fxml"));

        Scene getOut = new Scene(root);
        Main.primaryStage.setTitle("Menu");
        Main.primaryStage.setScene(getOut);
        Main.primaryStage.show();

    }

    @FXML
    private void btDocente() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroDocente.fxml"));

        Scene getOut = new Scene(root);
        Main.primaryStage.setTitle("Menu");
        Main.primaryStage.setScene(getOut);
        Main.primaryStage.show();

    }

    @FXML
    private void btChave() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroChave.fxml"));

        Scene getOut = new Scene(root);
        Main.primaryStage.setTitle("Menu");
        Main.primaryStage.setScene(getOut);
        Main.primaryStage.show();

    }

    @FXML
    private void btUtensilio() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroUtensilio.fxml"));

        Scene getOut = new Scene(root);
        Main.primaryStage.setTitle("Menu");
        Main.primaryStage.setScene(getOut);
        Main.primaryStage.show();

    }

    @FXML
    private void btMaterial() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/GCMU/UI/Fxml/CadastroMaterial.fxml"));

        Scene getOut = new Scene(root);
        Main.primaryStage.setTitle("Menu");
        Main.primaryStage.setScene(getOut);
        Main.primaryStage.show();

    }

    @FXML
    private void btVoltar() throws IOException {

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
