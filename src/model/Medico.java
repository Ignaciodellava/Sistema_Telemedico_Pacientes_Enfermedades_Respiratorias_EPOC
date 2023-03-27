package model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;


public class Medico {

	 
	private String nombre;
	private String apellidos;
	private String licencia;
	private String identificacion;
	private String contrasena;
	public String fn;
	public String genero;
	public String especialidad;
	private String id;
	    
	    
	    public Medico(String nombre, String apellidos, String licencia, String identificacion,String contrasena, String fn,String genero, String especialidad, String id) {
	    	
			this.nombre = nombre;
	    	this.apellidos = apellidos;
	    	this.licencia = licencia;
	    	this.identificacion = identificacion;
	    	this.contrasena = contrasena;
	    	this.fn = fn;
	    	this.genero = genero;
	    	this.especialidad = especialidad;
	    	this.id = id;
	 		// TODO Auto-generated constructor stub
		}
	    
		public Medico() {
			// TODO Auto-generated constructor stub
		}
		public String getNombre() {
			return nombre;
		}
		public String getApellidos() {
			return apellidos;
		}
		public String getLicencia() {
			return licencia;
		}
		public String getIdentificacion() {
			return identificacion;
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
		public String getEspecialidad() {
			return especialidad;
		}
		public String getId() {
			return id;
		}
		
		public String toString() {
	    	String salida = "Medico:  "+ nombre + ", "+ apellidos + "," + licencia+ ";"+identificacion + ","+contrasena+";"+fn+";"+genero+";"+especialidad+";"+id;
	    	return salida;
	    }
	}
	
	

