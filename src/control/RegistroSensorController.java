package control;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Paciente;
import model.Sensor;

public class RegistroSensorController {

    @FXML
    private TextField tipoSensor;

    @FXML
    private TextField valorsensor;
    

    @FXML
    private TextField usuarioSensor;


    @FXML
    private Button botonRegistroSensor;

	
	public Vector<String> valor = new Vector<String>();
	public  Vector<String>fecha = new Vector<String>();;
	
    
    @FXML
    void registrarSensor(ActionEvent event) {
    	
    	String Tipo = tipoSensor.getText();
    	String Valor = valorsensor.getText();
    	String Usuario = usuarioSensor.getText();
    	LocalDateTime Fecha  = LocalDateTime.now();
    	
    	
    	Vector<Sensor> p_list = new Vector<Sensor>();
    	
		
		//Leer
				try (Reader reader = new FileReader("sensores.json")) {
					Gson gson = new Gson();
					Type tipoListaUsuarios = new TypeToken<Vector<Sensor>>(){}.getType();
					p_list = gson.fromJson(reader, tipoListaUsuarios);
					//reader.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				String ffecha = Fecha.toString();
				
				valor.add(Valor);
				fecha.add(ffecha);
			
				Sensor p = new Sensor (LoginMedicoController.id, Tipo, valor,fecha ,Usuario);
				
				Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
				String representacionBonita = prettyGson.toJson(p);
				System.out.println(representacionBonita);
		
				p_list.add(p);
		//Escribir 
			
		try(FileWriter writer = new FileWriter("sensores.json")){
			prettyGson.toJson(p_list, writer);
			
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    	

    }


