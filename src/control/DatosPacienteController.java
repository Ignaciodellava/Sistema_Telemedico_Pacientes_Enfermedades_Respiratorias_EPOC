package control;

import java.io.FileNotFoundException;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Paciente;
import model.Sensor;

public class DatosPacienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button botonsensores;

    @FXML
    private TextField Sensores;
    
    @FXML
    private TextArea edatospaciente;

    @FXML
    void vueltamenu(ActionEvent event) {
    	 try {
	    		
	    		FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_menu_medico.fxml"));
	    		
	    		MenuMedicoController control = new MenuMedicoController();
	    		
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
				

				if (idP.equals(MenuMedicoController.usuario)) {       
						
					
					
					System.out.println(p);		
					
				 antiguo = Sensores.getText();
					Sensores.setText(antiguo +"\n" +p.toString()+"\n" );
				} 
				
			}
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    	

    
    	
    
    
    
    @FXML
    void initialize() {
    	
try (Reader reader = new FileReader("pacientes.json")) {
    		
    		Paciente p = new Paciente();
        	
        	Vector<Paciente> p_list = new Vector<Paciente>();
        	
    		Gson gson = new Gson();
			java.lang.reflect.Type tipoListaUsuarios = new TypeToken<Vector<Paciente>>(){}.getType();
			p_list = gson.fromJson(reader, tipoListaUsuarios);
			reader.close();
			
			String dni = MenuMedicoController.dni;
			
			for (int i=0; i<p_list.size(); i++) {         //dentro de este for paso por todo el vector buscando coincidencia de id
				
				p = p_list.elementAt(i);
				

				if (dni.equals(p.getDNI())) {  
					
					edatospaciente.setText(p.NicetoString());
				}
			}
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
    	
    	
       assert edatospaciente != null : "fx:id=\"edatospaciente\" was not injected: check your FXML file 'vista_datos_paciente.fxml'.";

    }
}

