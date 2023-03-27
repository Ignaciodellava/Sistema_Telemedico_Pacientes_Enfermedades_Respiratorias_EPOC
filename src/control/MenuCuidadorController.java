package control;

import java.io.FileReader;

import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import model.Paciente;
import model.Sensor;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MenuCuidadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField usuariomedida;

    @FXML
    private Button botonmedida;
    
    @FXML
    private TextArea Mlistarpacientes;

    @FXML
    private TextField medidatexto;
    
    @FXML
    private TextField MdniPaciente;

    public String id;
    
    public static String dni;
    
    
    @FXML
    void tomarMedida(ActionEvent event) {

    	String usuario = usuariomedida.getText();
    	String medida = medidatexto.getText();
    	
try (Reader reader = new FileReader("sensores.json")) {
    		
    		Sensor p = new Sensor();
        	
        	Vector<Sensor> p_list = new Vector<Sensor>();
        	
    		Gson gson = new Gson();
			java.lang.reflect.Type tipoListaUsuarios = new TypeToken<Vector<Sensor>>(){}.getType();
			p_list = gson.fromJson(reader, tipoListaUsuarios);
			reader.close();
			
			for (int i=0; i<p_list.size(); i++) {         //dentro de este for paso por todo el vector buscando coincidencia de id
				
				p = p_list.elementAt(i);
				

				if (usuario.equals(p.getUsuario())) {       //si hay coincidencia de id se entra dentro del if
						
	//Aquí iría la función de coger una medida, cogeria una medida y la hora se que como sacar la informacion del sensor y editarla pero no como meterla de vuelta en el fichero.
    	
    	
				}
			}	
    } catch (IOException e) {
		// TODO Auto-generated catch block
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
						
					
					 try {
				    		
				    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_datos_paciente2.fxml"));
				    		
				    		DatosPacienteController2 control = new DatosPacienteController2();
				    		
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
			
			for (int i=0; i<p_list.size(); i++) {     
				
				p = p_list.elementAt(i);
				String idP = p.getId();
				String antiguo = "";
				

				if (idP.equals(LoginCuidadorController.id)) {       
					
					System.out.println(p);		
					
					
				 antiguo = Mlistarpacientes.getText();
					Mlistarpacientes.setText(antiguo +"\n" +p.toString());
				} 
				
			}
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void initialize() {
        assert Mlistarpacientes != null : "fx:id=\"Mlistarpacientes\" was not injected: check your FXML file 'vista_menu_cuidador.fxml'.";
        assert MdniPaciente != null : "fx:id=\"MdniPaciente\" was not injected: check your FXML file 'vista_menu_cuidador.fxml'.";

    }
}





   



