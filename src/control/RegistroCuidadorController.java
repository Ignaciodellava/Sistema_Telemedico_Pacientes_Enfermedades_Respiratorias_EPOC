package control;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXComboBox;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Vector;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Cuidador;
import model.Medico;
import model.Paciente;

public class RegistroCuidadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField RnombreCuidador;

    @FXML
    private TextField RapellidosCuidador;

    @FXML
    private TextField RdniCuidador;

    @FXML
    private DatePicker RfnCuidador;

    @FXML
    private Button CrearCuidador;

    @FXML
    private TextField RusuarioCuidador;

    @FXML
    private PasswordField RcontrasenaCuidador;

    @FXML
    private ChoiceBox<String> RgeneroCuidador;

    @FXML
    void CrearCuidador(ActionEvent event) {

    	String nombre = RnombreCuidador.getText();
    	String apellidos = RapellidosCuidador.getText();
    	String dni = RdniCuidador.getText();
    	String usuario = RusuarioCuidador.getText();
    	String contrasena = RcontrasenaCuidador.getText();
    	String genero = RgeneroCuidador.getValue();
    	LocalDate fn = RfnCuidador.getValue();
    	String fechan = fn.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    	
    	Vector<Cuidador> c_list = new Vector<Cuidador>();
    	
		
		//Leer
				try (Reader reader = new FileReader("cuidadores.json")) {
					Gson gson = new Gson();
					Type tipoListaUsuarios = new TypeToken<Vector<Cuidador>>(){}.getType();
					c_list = gson.fromJson(reader, tipoListaUsuarios);
					//reader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				Cuidador c = new Cuidador (LoginMedicoController.id,nombre, apellidos, dni, usuario,contrasena, fechan, genero);
				
		    	
				Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
				String representacionBonita = prettyGson.toJson(c);
				System.out.println(representacionBonita);
		
				c_list.add(c);
		//Escribir 
			
		try(FileWriter writer = new FileWriter("cuidadores.json")){
			prettyGson.toJson(c_list, writer);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void initialize() {
        assert RnombreCuidador != null : "fx:id=\"RnombreCuidador\" was not injected: check your FXML file 'vista_registro_cuidador.fxml'.";
        assert RapellidosCuidador != null : "fx:id=\"RapellidosCuidador\" was not injected: check your FXML file 'vista_registro_cuidador.fxml'.";
        assert RdniCuidador != null : "fx:id=\"RdniCuidador\" was not injected: check your FXML file 'vista_registro_cuidador.fxml'.";
        assert RfnCuidador != null : "fx:id=\"RfnCuidador\" was not injected: check your FXML file 'vista_registro_cuidador.fxml'.";
        assert CrearCuidador != null : "fx:id=\"CrearCuidador\" was not injected: check your FXML file 'vista_registro_cuidador.fxml'.";
        assert RusuarioCuidador != null : "fx:id=\"RusuarioCuidador\" was not injected: check your FXML file 'vista_registro_cuidador.fxml'.";
        assert RcontrasenaCuidador != null : "fx:id=\"RcontrasenaCuidador\" was not injected: check your FXML file 'vista_registro_cuidador.fxml'.";
        assert RgeneroCuidador != null : "fx:id=\"RgeneroCuidador\" was not injected: check your FXML file 'vista_registro_cuidador.fxml'.";

        ObservableList<String> genero = FXCollections.observableArrayList("masculino","femenino");
        RgeneroCuidador.setItems(genero);
    }
}


