package control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import model.Admin;
import model.Medico;

public class RegistroAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField Rclaveadmin;

    @FXML
    private PasswordField RcontrasenaAdmin;

    @FXML
    private Button bventana;

    @FXML
    void regsitrarAdmin(ActionEvent event) {
    	String clave = Rclaveadmin.getText();
    	String contrasena = RcontrasenaAdmin.getText();
    	
    	
    	
    	Vector<Admin> m_list = new Vector<Admin>();
    	
    	Admin ultimo = new Admin();
    	
    	
		
		
		//Leer
				try (Reader reader = new FileReader("admin.json")) {
					Gson gson = new Gson();
					Type tipoListaUsuarios = new TypeToken<Vector<Admin>>(){}.getType();
					m_list = gson.fromJson(reader, tipoListaUsuarios);
					//reader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				
				
				Admin m = new Admin (clave,contrasena);
		    	
				Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
				String representacionBonita = prettyGson.toJson(m);
				System.out.println(representacionBonita);
		
				m_list.add(m);
		//Escribir 
			
		try(FileWriter writer = new FileWriter("admin.json")){
			prettyGson.toJson(m_list, writer);
			
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void volverventana(ActionEvent event) {
    	try {
    		
    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_menu_principal.fxml"));
    		
    		MenuPrincipalController control = new MenuPrincipalController();
    		
    		loader2.setController(control);

    		Parent root = loader2.load();
    		
    		Scene scene = new Scene(root);
    		Stage stage = new Stage();
    		
    		stage.setScene(scene);
    		stage.show();
    		
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}

    }

    @FXML
    void initialize() {
        assert Rclaveadmin != null : "fx:id=\"Rclaveadmin\" was not injected: check your FXML file 'vista_registro_admin.fxml'.";
        assert RcontrasenaAdmin != null : "fx:id=\"RcontrasenaAdmin\" was not injected: check your FXML file 'vista_registro_admin.fxml'.";
       
        assert bventana != null : "fx:id=\"bventana\" was not injected: check your FXML file 'vista_registro_admin.fxml'.";

    }
}

