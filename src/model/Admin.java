package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Admin {
	
	
	public String clave;
	public String contrasena;

	public Admin(String clave, String contrasena) {
		super();
		
		this.clave=clave;
		this.contrasena = contrasena;
		
	}

	public Admin() {}
	
	public String toString() {
		return clave+ ";"+ contrasena;
	}
	public String getClave() {
		return clave;
	}
	
	public String getContrasena() {
		return contrasena;
	}

	

	

}
