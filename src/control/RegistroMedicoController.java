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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Cuidador;
import model.Medico;

public class RegistroMedicoController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField RnombreMedico;

    @FXML
    private TextField RapellidosMedico;

    @FXML
    private TextField RnidentificacionMedico;

    @FXML
    private TextField RnLicenciaMedico;

    @FXML
    private DatePicker RfnMedico;

    @FXML
    private Button crearCuentaMedico;

    @FXML
    private TextField RcontrasenaMedico;

    @FXML
    private ChoiceBox<String> RgeneroMedico;

    @FXML
    private ChoiceBox<String> RespecialidadmedicaMedica;


    @FXML
    
    void CrearMedico(ActionEvent event) {
    	
    	String nombre = RnombreMedico.getText();
    	String apellidos = RapellidosMedico.getText();
    	String identificacion = RnidentificacionMedico.getText();
    	String licencia = RnLicenciaMedico.getText();
    	String contrasena = RcontrasenaMedico.getText();
    	LocalDate fn = RfnMedico.getValue();
    	String fechan = fn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	String genero =  RgeneroMedico.getValue();
    	String especialidad =  RespecialidadmedicaMedica.getValue();
    	String id = "";
    	
    	
    	Vector<Medico> m_list = new Vector<Medico>();
    	
    	Medico ultimo = new Medico();
    	
    	
		
		
		//Leer
				try (Reader reader = new FileReader("medicos.json")) {
					Gson gson = new Gson();
					Type tipoListaUsuarios = new TypeToken<Vector<Medico>>(){}.getType();
					m_list = gson.fromJson(reader, tipoListaUsuarios);
					//reader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				ultimo = m_list.elementAt(m_list.size()-1);
				id = String.valueOf((Integer.parseInt(ultimo.getId())+ 1));
				
				Medico m = new Medico (nombre,apellidos,identificacion,licencia,contrasena,fechan,genero,especialidad,id);
		    	
				Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
				String representacionBonita = prettyGson.toJson(m);
				System.out.println(representacionBonita);
		
				m_list.add(m);
		//Escribir 
			
		try(FileWriter writer = new FileWriter("medicos.json")){
			prettyGson.toJson(m_list, writer);
			
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    @FXML
    void initialize() {
    	
    	 assert RnombreMedico != null : "fx:id=\"RnombreMedico\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         assert RapellidosMedico != null : "fx:id=\"RapellidosMedico\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         assert RnidentificacionMedico != null : "fx:id=\"RnidentificacionMedico\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         assert RnLicenciaMedico != null : "fx:id=\"RnLicenciaMedico\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         assert RfnMedico != null : "fx:id=\"RfnMedico\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         assert crearCuentaMedico != null : "fx:id=\"crearCuentaMedico\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         assert RcontrasenaMedico != null : "fx:id=\"RcontrasenaMedico\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         assert RgeneroMedico != null : "fx:id=\"RgeneroMedico\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         assert RespecialidadmedicaMedica != null : "fx:id=\"RespecialidadmedicaMedica\" was not injected: check your FXML file 'vista_registro_medico.fxml'.";
         
    	
    	RgeneroMedico.getItems().addAll("masculino","femenino");
        RespecialidadmedicaMedica.getItems().addAll("Medico de cabecera","Medico especialista");
        
    }
    }
  

  

