package model;

import java.time.LocalDate;
import java.util.ArrayList;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

public class Paciente {
	
	

	public String id;
	public String nombre;
	public String apellidos;
	public String DNI;
	public String usuario;
	public String contrasena;
	public String fn;
	public String genero;
	
	
	
	
	

	public Paciente(String nombre, String apellidos, String DNI,String usuario, String contrasena, String fn, String genero,String id) {
		super();
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.DNI=DNI;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.fn=fn;
		this.genero=genero;
		this.id = id;
		
		
	}
	public Paciente() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public String getUsername() {
		return usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public String getFn() {
		return fn;
	}

	public String getGenero() {
		return genero;
	}
	public String toString() {
		return nombre+ ";"+ apellidos +";"+ DNI+";"+usuario+";"+contrasena+";"+fn+";"+genero+";";
	}
	public String NicetoString() {
		return "Nombre: "+ nombre+ "\n"+"Apellidos: "+ apellidos +"\n"+ "DNI: "+DNI+"\n"+"Fecha Nac: "+fn+"\n"+"Género: "+genero;
	}

}