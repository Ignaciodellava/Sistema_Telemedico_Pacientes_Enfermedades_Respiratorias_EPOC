package control;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cuidador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginCuidadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bcuidadorloginP;

    @FXML
    private TextField usernameCuidador;

    @FXML
    private PasswordField contrasenaCuidador;

    @FXML
    private Button iniciarSesionCuidador;
    
    public static String id;

    @FXML
    void Cambiarvista(ActionEvent event) {
    	
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
    void IniciarSesionCuidador(ActionEvent event) {
    	
    	String username= usernameCuidador.getText();       //estos van a ser los q escribe el usuario
    	String contrasena = contrasenaCuidador.getText();
    	
    
    
    	Cuidador c = new Cuidador();
    				
    	
    	Vector<Cuidador> c_list = new Vector<Cuidador>();
    	
		//Validar
		int validado = 0;			//primero creo la variable para confirmar si la informacion es correcta
		
		//Leer
    	
				try (Reader reader = new FileReader("cuidadores.json")) {
					Gson gson = new Gson();
					Type tipoListaUsuarios = new TypeToken<Vector<Cuidador>>(){}.getType();
					c_list = gson.fromJson(reader, tipoListaUsuarios);
					reader.close();
					for (int i=0; i<c_list.size(); i++) {         //dentro de este for paso por todo el vector buscando coincidencia
						
						
						
						c = c_list.elementAt(i);					//creo parametros nuevos para coger cada linea del vector
						String usuarioV = c.getUsername();
						String contrasenaV = c.getContrasena();

						if (usuarioV.equals(username) && contrasenaV.equals(contrasena)) {       //si hay coincidencia la variable de arriba se cambia para confirmar que coincide
								
							id = c.getId();		//este id lo uso para saber que medico es y luego eso me ayuda a saber sus pacientes pq cada paciente tiene un apartado en su json para este id del medico
												//creo q es importante q este como public static para otras clases y q sepan q tienen q coger este id
							validado = 1;		
						} 
						
					}
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				
				System.out.println(c_list); 


			if (validado == 1) { //aqui miramos si hubo la coincidencia del if anterior
	    		
				//ventana de menu del medico
				
				//esta mierda me da error pero en principio deberia ser solo el tema de abrir la ventana del medico por eso esta comentado
	    		
				
				try {
		    		
		    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_menu_cuidador.fxml"));
		    		
		    		MenuCuidadorController control = new MenuCuidadorController();
		    		
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

		
	/*   	 else {
	    		 try {
	    	    		
	    	    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_ErrorLogin.fxml"));
	    	    		
	    	    		ErrorLogin control = new ErrorLogin();
	    	    		
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
*/
    }



    @FXML
    void initialize() {
        assert bcuidadorloginP != null : "fx:id=\"bcuidadorloginP\" was not injected: check your FXML file 'vista_login_cuidador.fxml'.";
        assert usernameCuidador != null : "fx:id=\"usernameCuidador\" was not injected: check your FXML file 'vista_login_cuidador.fxml'.";
        assert contrasenaCuidador != null : "fx:id=\"contrasenaCuidador\" was not injected: check your FXML file 'vista_login_cuidador.fxml'.";
        assert iniciarSesionCuidador != null : "fx:id=\"iniciarSesionCuidador\" was not injected: check your FXML file 'vista_login_cuidador.fxml'.";

    }




	public Object closeWindows() {
		// TODO Auto-generated method stub
		return null;
	}
	    	



    }


