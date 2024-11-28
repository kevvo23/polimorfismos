package publicacionProfesor;

import java.util.ArrayList;

public class Profesor {
	private String email;
	private String nombre;
	private String departamento;
	private ArrayList<Publicacion> p;
	
	public Profesor() {
		this.email="";
		this.nombre="";
		this.departamento="";
		this.p= new ArrayList<>();
	}
	
	public Profesor(String e, String n, String d, ArrayList<Publicacion> pub) {
		this.email= e;
		this.nombre= n;
		this.departamento= d;
		this.p= pub;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public ArrayList<Publicacion> getP() {
		return p;
	}

	public void setP(ArrayList<Publicacion> p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Profesor [email=" + email + ", nombre=" + nombre + ", departamento=" + departamento + ", p=" + p + "]";
	}
}
