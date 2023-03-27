package control;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPrincipalController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bloginmedico;

    @FXML
    private Button badminlogin;

    @FXML
    private Button bcuidadorlogin;

    @FXML
    private Button bpacientelogin;

    @FXML
    private Button badminregistro;

    @FXML
    void Login(ActionEvent event) {
    	try {
      		 
       		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_login_medico.fxml"));
       		
       		LoginMedicoController control = new LoginMedicoController();
       		
       		loader2.setController(control);

       		Parent root = loader2.load();
       		
       		Scene scene = new Scene(root);
       		Stage stage = new Stage();
       		
       		stage.setScene(scene);
       		stage.show();
       		
       		stage.setOnCloseRequest(e -> control.closeWindows());
    		Stage mystage = (Stage) this.bloginmedico.getScene().getWindow();
    		mystage.close();
    		
       		}
       		catch(Exception e) {
       			e.printStackTrace();
       		}

    }

    @FXML
    void LoginAdministrador(ActionEvent event) {
    	try {
      		 
       		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_login_admin.fxml"));
       		
       		LoginAdminController control = new LoginAdminController();
       		
       		loader2.setController(control);

       		Parent root = loader2.load();
       		
       		Scene scene = new Scene(root);
       		Stage stage = new Stage();
       		
       		stage.setScene(scene);
       		stage.show();
       		
       		stage.setOnCloseRequest(e -> control.closeWindows());
    		Stage mystage = (Stage) this.badminlogin.getScene().getWindow();
    		mystage.close();
       		}
       		catch(Exception e) {
       			e.printStackTrace();
       		}

    }

    @FXML
    void LoginCuidador(ActionEvent event) {
    	try {
      		 
       		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_login_cuidador.fxml"));
       		
       		LoginCuidadorController control = new LoginCuidadorController();
       		
       		loader2.setController(control);

       		Parent root = loader2.load();
       		
       		Scene scene = new Scene(root);
       		Stage stage = new Stage();
       		
       		stage.setScene(scene);
       		stage.show();
       		
//       		stage.setOnCloseRequest(e -> control.closeWindows());
//    		Stage mystage = (Stage) this.bcuidadorlogin.getScene().getWindow();
//    		mystage.close();
       		}
       		catch(Exception e) {
       			e.printStackTrace();
       		}


    }

    @FXML
    void LoginPaciente(ActionEvent event) {
    	try {
      		 
       		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_login_paciente.fxml"));
       		
       		LoginPacienteController control = new LoginPacienteController();
       		
       		loader2.setController(control);

       		Parent root = loader2.load();
       		
       		Scene scene = new Scene(root);
       		Stage stage = new Stage();
       		
       		stage.setScene(scene);
       		stage.show();
       		
       		stage.setOnCloseRequest(e -> control.closeWindows());
    		Stage mystage = (Stage) this.bpacientelogin.getScene().getWindow();
    		mystage.close();
       		}
       		catch(Exception e) {
       			e.printStackTrace();
       		}

    }

    @FXML
    void RegistroAdmin(ActionEvent event) {
    	try {
     		 
       		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_registro_admin.fxml"));
       		
       		RegistroAdminController control = new RegistroAdminController();
       		
       		loader2.setController(control);

       		Parent root = loader2.load();
       		
       		Scene scene = new Scene(root);
       		Stage stage = new Stage();
       		
       		stage.setScene(scene);
       		stage.show();
       		
//       		stage.setOnCloseRequest(e -> control.closeWindows());
//    		Stage mystage = (Stage) this.bloginmedico.getScene().getWindow();
//    		mystage.close();
    		
       		}
       		catch(Exception e) {
       			e.printStackTrace();
       		}
    }

    @FXML
    void initialize() {
        assert bloginmedico != null : "fx:id=\"bloginmedico\" was not injected: check your FXML file 'vista_menu_principal.fxml'.";
        assert badminlogin != null : "fx:id=\"badminlogin\" was not injected: check your FXML file 'vista_menu_principal.fxml'.";
        assert bcuidadorlogin != null : "fx:id=\"bcuidadorlogin\" was not injected: check your FXML file 'vista_menu_principal.fxml'.";
        assert bpacientelogin != null : "fx:id=\"bpacientelogin\" was not injected: check your FXML file 'vista_menu_principal.fxml'.";
        assert badminregistro != null : "fx:id=\"badminregistro\" was not injected: check your FXML file 'vista_menu_principal.fxml'.";

    }
}

