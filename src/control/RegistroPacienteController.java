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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import model.Paciente;

public class RegistroPacienteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button bregistroPaciente;

    @FXML
    private TextField RnombrePaciente;

    @FXML
    private TextField RapellidosPaciente;

    @FXML
    private TextField RdniPaciente;

    @FXML
    private DatePicker RfnPaciente;

    @FXML
    private TextField RusuarioPaciente;

    @FXML
    private PasswordField RcontrasenaPaciente;

    @FXML
    private ChoiceBox<String> RgeneroPaciente;

    @FXML
    void RegistrarPaciente(ActionEvent event) {

    	String nombre = RnombrePaciente.getText();
    	String apellidos = RapellidosPaciente.getText();
    	String dni = RdniPaciente.getText();
    	String usuario = RusuarioPaciente.getText();
    	String contrasena = RcontrasenaPaciente.getText();
    	String genero = RgeneroPaciente.getValue();
    	LocalDate fn = RfnPaciente.getValue();
    	String fechan = fn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	
    	Vector<Paciente> p_list = new Vector<Paciente>();
    	
		
		//Leer
				try (Reader reader = new FileReader("Pacientes.json")) {
					Gson gson = new Gson();
					Type tipoListaUsuarios = new TypeToken<Vector<Paciente>>(){}.getType();
					p_list = gson.fromJson(reader, tipoListaUsuarios);
					//reader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				Paciente p = new Paciente (nombre, apellidos, dni, usuario,contrasena, fechan, genero,LoginMedicoController.id);
				
				Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
				String representacionBonita = prettyGson.toJson(p);
				System.out.println(representacionBonita);
		
				p_list.add(p);
		//Escribir 
			
		try(FileWriter writer = new FileWriter("Pacientes.json")){
			prettyGson.toJson(p_list, writer);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert RnombrePaciente != null : "fx:id=\"RnombrePaciente\" was not injected: check your FXML file 'vista_registro_paciente.fxml'.";
        assert RapellidosPaciente != null : "fx:id=\"RapellidosPaciente\" was not injected: check your FXML file 'vista_registro_paciente.fxml'.";
        assert RdniPaciente != null : "fx:id=\"RdniPaciente\" was not injected: check your FXML file 'vista_registro_paciente.fxml'.";
        assert RfnPaciente != null : "fx:id=\"RfnPaciente\" was not injected: check your FXML file 'vista_registro_paciente.fxml'.";
        assert RusuarioPaciente != null : "fx:id=\"RusuarioPaciente\" was not injected: check your FXML file 'vista_registro_paciente.fxml'.";
        assert RcontrasenaPaciente != null : "fx:id=\"RcontrasenaPaciente\" was not injected: check your FXML file 'vista_registro_paciente.fxml'.";
        assert RgeneroPaciente != null : "fx:id=\"RgeneroPaciente\" was not injected: check your FXML file 'vista_registro_paciente.fxml'.";

        ObservableList<String> genero = FXCollections.observableArrayList("masculino","femenino");
        RgeneroPaciente.setItems(genero);
    }
}
