package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

public class Sensor {
	
public String id;
public String tipo;
public Vector<String> valor;
public Vector<String> fecha;
public String usuario;


public Sensor() {
	
}

public Sensor(String id, String tipo, Vector<String> valor,Vector<String> fecha, String usuario) {
	this.id=id;
	this.tipo=tipo;
	this.valor=valor;
	this.fecha = fecha;
	this.usuario = usuario;
}

public String getId() {
	return id;
}

public String getUsuario(){
	return usuario;
}

public String getTipo() {
	return tipo;
}

public Vector<String> getValor() {
	return valor;
}

public Vector<String> getFecha() {
	return fecha;
}

public String toString() {
	return id+ ";"+ tipo +";"+ valor+";"+fecha+";"+ usuario;
}

}





