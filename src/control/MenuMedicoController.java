package control;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sun.javafx.scene.control.skin.FXVK.Type;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Paciente;

	
	import com.jfoenix.controls.JFXTextField;
	import java.net.URL;
	import java.util.ResourceBundle;
	import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MenuMedicoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botonId;

    @FXML
    private TextArea Mlistarpacientes;

    @FXML
    private TextField MdniPaciente;

  public static String dni;
  public static String usuario;
  
  
  @FXML
  void añadirSensor(ActionEvent event) {
	  try {
      	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_registro_sensor.fxml"));
  		
  		RegistroSensorController control = new RegistroSensorController();
  		
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
    void buscarPaciente(ActionEvent event) {
    	try (Reader reader = new FileReader("pacientes.json")) {
    		
    		Paciente p = new Paciente();
        	
        	Vector<Paciente> p_list = new Vector<Paciente>();
        	
    		Gson gson = new Gson();
			java.lang.reflect.Type tipoListaUsuarios = new TypeToken<Vector<Paciente>>(){}.getType();
			p_list = gson.fromJson(reader, tipoListaUsuarios);
			reader.close();
			
			dni = MdniPaciente.getText();
			
			
			for (int i=0; i<p_list.size(); i++) {         //dentro de este for paso por todo el vector buscando coincidencia de id
				
				p = p_list.elementAt(i);
				
         
				
				if (dni.equals(p.getDNI())) {       //si hay coincidencia de id se entra dentro del if
						
					 usuario= p.getUsername();
					 
					try {
			        	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_datos_paciente.fxml"));
			    		
			    		DatosPacienteController control = new DatosPacienteController();
			    		
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
				
			}
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void cerrarsesion(ActionEvent event) {
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
    void mostrarPacientes(ActionEvent event) {
    	try (Reader reader = new FileReader("pacientes.json")) {
    		
    		Paciente p = new Paciente();
        	
        	Vector<Paciente> p_list = new Vector<Paciente>();
        	
    		Gson gson = new Gson();
			java.lang.reflect.Type tipoListaUsuarios = new TypeToken<Vector<Paciente>>(){}.getType();
			p_list = gson.fromJson(reader, tipoListaUsuarios);
			reader.close();
			
			for (int i=0; i<p_list.size(); i++) {         //dentro de este for paso por todo el vector buscando coincidencia de id
				
				p = p_list.elementAt(i);
				String idP = p.getId();
				String antiguo = "";
				

				if (idP.equals(LoginMedicoController.id)) {       //si hay coincidencia de id se entra dentro del if
						
					
					//this.Paciente=p.get(i);
					//etiquetapacientes.setText(System.out.println(p));
					
					System.out.println(p);		/*aqui es donde habria que setear un label o textfield para que este print 
											  se haga en la ventana que como no puedo tocar ventanas ns como se haria
												  pero ahora mismo te los escribe por consola*/
					
				 antiguo = Mlistarpacientes.getText();
					Mlistarpacientes.setText(antiguo +"\n" +p.toString());
				} 
				
			}
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void registrarCuidador(ActionEvent event) {
    	try {
        	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_registro_cuidador.fxml"));
    		
    		RegistroCuidadorController control = new RegistroCuidadorController();
    		
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
    void registrarPacientes(ActionEvent event) {
    	try {
        	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_registro_paciente.fxml"));
    		
    		RegistroPacienteController control = new RegistroPacienteController();
    		
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
        assert Mlistarpacientes != null : "fx:id=\"Mlistarpacientes\" was not injected: check your FXML file 'vista_menu_medico.fxml'.";
        assert MdniPaciente != null : "fx:id=\"MdniPaciente\" was not injected: check your FXML file 'vista_menu_medico.fxml'.";

    }
}
	
