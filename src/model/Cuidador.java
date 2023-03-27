package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cuidador {
	
	
	public String id;
	public String nombre;
	public String apellidos;
	public String DNI;
	public String usuario;
	public String contrasena;
	public String fn;
	public String genero;

	public Cuidador(String id,String nombre, String apellidos, String DNI,String usuario, String contrasena, String fn, String genero) {
		super();
		
		this.id=id;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.DNI=DNI;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.fn=fn;	
		this.genero=genero;
	}
	
	
	
	

	public Cuidador() {}
	
	public String toString() {
		return nombre+ ";"+ apellidos +";"+ DNI+";"+usuario+";"+contrasena+";"+fn+";"+genero;
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


	

}

