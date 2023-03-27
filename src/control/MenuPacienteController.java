package control;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cuidador;
import model.Medico;
import model.Paciente;
import model.Sensor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class MenuPacienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea etiquetadatospaciente;
    

    @FXML
    private TextField misSensores;

    @FXML
    private Label sensores;

    @FXML
    private Button botonSensores;

    @FXML
    private TextField misMedicos;

    @FXML
    private Button botonmedico;

    @FXML
    private Button botoncuidadores;

    @FXML
    private TextField misCuidadores;
    
    
    @FXML
    void MostrarSensores(ActionEvent event) {
    	
try (Reader reader = new FileReader("sensores.json")) {
    		
    		Sensor p = new Sensor();
        	
        	Vector<Sensor> p_list = new Vector<Sensor>();
        	
    		Gson gson = new Gson();
			java.lang.reflect.Type tipoListaUsuarios = new TypeToken<Vector<Sensor>>(){}.getType();
			p_list = gson.fromJson(reader, tipoListaUsuarios);
			reader.close();
			
			for (int i=0; i<p_list.size(); i++) {        
				
				p = p_list.elementAt(i);
				String idP = p.getUsuario();
				String antiguo = "";
				

				if (idP.equals(LoginPacienteController.usuario)) {       
						
					
					
					System.out.println(p);		
					
				 antiguo = misSensores.getText();
					misSensores.setText(antiguo  +p.toString() +"\n");
				} 
				
			}
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    	

    
    
    @FXML
    void MostrarMedicos(ActionEvent event) {

try (Reader reader = new FileReader("medicos.json")) {
    		
    		Medico p = new Medico();
        	
        	Vector<Medico> p_list = new Vector<Medico>();
        	
    		Gson gson = new Gson();
			java.lang.reflect.Type tipoListaUsuarios = new TypeToken<Vector<Medico>>(){}.getType();
			p_list = gson.fromJson(reader, tipoListaUsuarios);
			reader.close();
			
			for (int i=0; i<p_list.size(); i++) {        
				
				p = p_list.elementAt(i);
				String idP = p.getId();
				String antiguo = "";
				

				if (idP.equals(LoginPacienteController.id)) {       
						
					
					
					System.out.println(p);		
					
				 antiguo = misMedicos.getText();
					misMedicos.setText(antiguo +"\n" +p.toString());
				} 
				
			}
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    	
    	
    
    
    @FXML
    void MostrarCuidadores(ActionEvent event) {
try (Reader reader = new FileReader("cuidadores.json")) {
    		
    		Cuidador p = new Cuidador();
        	
        	Vector<Cuidador> p_list = new Vector<Cuidador>();
        	
    		Gson gson = new Gson();
			java.lang.reflect.Type tipoListaUsuarios = new TypeToken<Vector<Cuidador>>(){}.getType();
			p_list = gson.fromJson(reader, tipoListaUsuarios);
			reader.close();
			
			for (int i=0; i<p_list.size(); i++) {         //dentro de este for paso por todo el vector buscando coincidencia de id
				
				p = p_list.elementAt(i);
				String idP = p.getId();
				String antiguo = "";
				

				if (idP.equals(LoginPacienteController.id)) {       //si hay coincidencia de id se entra dentro del if
						
					
					//this.Paciente=p.get(i);
					//etiquetapacientes.setText(System.out.println(p));
					
					System.out.println(p);		/*aqui es donde habria que setear un label o textfield para que este print 
											  se haga en la ventana que como no puedo tocar ventanas ns como se haria
												  pero ahora mismo te los escribe por consola*/
					
				 antiguo = misCuidadores.getText();
					misCuidadores.setText(antiguo +"\n"+p.toString());
					
					
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
    void initialize() {
    	
    	
        
    }
}
