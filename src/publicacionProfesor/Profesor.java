package publicacionProfesor;

import java.util.ArrayList;

public class Profesor{
	private String email;
	private String nombre;
	private String departamento;
	private ArrayList<Publicacion> publicaciones;
	
	public Profesor() {
		this.email="";
		this.nombre="";
		this.departamento="";
		this.publicaciones= new ArrayList<>();
	}
	
	public Profesor(String e, String n, String d) {
		this.email= e;
		this.nombre= n;
		this.departamento= d;
		this.publicaciones= new ArrayList<>();;
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

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	@Override
	public String toString() {
		return "Profesor [email=" + email + ", nombre=" + nombre + ", departamento=" + departamento + ", publicaciones=" + publicaciones + "]";
	}
}
