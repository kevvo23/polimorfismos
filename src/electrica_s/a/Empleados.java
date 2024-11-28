package electrica_s.a;

import java.time.LocalDate;

public class Empleados {
	protected static final String NOMBREEMPRESA="Electrica S.A.";
	protected static double sueldoBase=1000;
	protected String dni;
	protected String nombre;
	protected String mes;
	protected int año;
	protected double porcentaje;
	protected static int contador=0;
	
	public Empleados (){
		this.dni="";
		this.nombre="";
		this.mes="";
		this.año=0;
		this.porcentaje=0;
	}
	
	public Empleados (String d, String n, String m, int a, double p){
		this.dni= d;
		this.nombre= n;
		this.mes= m;
		this.año= a;
		this.porcentaje= p;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	public double calcularSueldoTotal() {
		if((LocalDate.now().getYear()-this.año)>=6) {
			return ((sueldoBase+(sueldoBase*(this.porcentaje/100)))+100);
		}else {
			return ((sueldoBase+(sueldoBase*(this.porcentaje/100))));
		}
	}


	@Override
	public String toString() {
		return "Empleados [dni=" + dni + ", nombre=" + nombre + ", mes=" + mes + ", año=" + año + ", porcentaje="
				+ porcentaje + "% ]";
	}

}
