package control;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Admin;

public class LoginAdminController {

	 @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField IclaveAdmin;

	    @FXML
	    private TextField IcontrasenaAdmin;
	    
	    public static String id;

	    @FXML
	    void IniciarsesionAdmin(ActionEvent event) {
	    	String clave = IclaveAdmin.getText();       //estos van a ser los q escribe el usuario
	    	String contrasena = IcontrasenaAdmin.getText();
	    	
	    
	    
	    	Admin a = new Admin();
	    				
	    	
	    	Vector<Admin> m_list = new Vector<Admin>();
	    	
			//Validar
			int validado = 0;			//primero creo la variable para confirmar si la informacion es correcta
			
			//Leer
	    	
					try (Reader reader = new FileReader("admin.json")) {
						Gson gson = new Gson();
						Type tipoListaUsuarios = new TypeToken<Vector<Admin>>(){}.getType();
						m_list = gson.fromJson(reader, tipoListaUsuarios);
						reader.close();
						
						for (int i=0; i<m_list.size(); i++) {         //dentro de este for paso por todo el vector buscando coincidencia
							
							a = m_list.elementAt(i);					//creo parametros nuevos para coger cada linea del vector
							String claveV = a.getClave();
							String contraseña = a.getContrasena();

							if (claveV.equals(clave) && contraseña.equals(contrasena)) {       //si hay coincidencia la variable de arriba se cambia para confirmar que coincide
									
									//este id lo uso para saber que medico es y luego eso me ayuda a saber sus pacientes pq cada paciente tiene un apartado en su json para este id del medico
													//creo q es importante q este como public static para otras clases y q sepan q tienen q coger este id
								validado = 1;		
							} 
							
						}
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
					
					
					System.out.println(m_list); 


				if (validado == 1) { //aqui miramos si hubo la coincidencia del if anterior
		    		
					try {
			        	FXMLLoader loader2 = new FXMLLoader(getClass().getResource("/view/vista_registro_medico.fxml"));
			    		
			    		RegistroMedicoController control = new RegistroMedicoController();
			    		
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
				else {
		    		 try {
		    	    		
		    	    		System.out.println("ventana error");
		    	    		}
		    	    		catch(Exception e) {
		    	    			e.printStackTrace();
		    	    		}

		    	    }
		
    	
    	
    }

		public Object closeWindows() {
			// TODO Auto-generated method stub
			return null;
		}
}


