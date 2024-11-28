package persona;

public class Persona {
	protected String dni;
	protected String nombre;
	
	public Persona() {
		this.dni="";
		this.nombre="";
	}
	public Persona(String d, String n) {
		this.dni=d;
		this.nombre=n;
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
	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}
	public void visualizar() {
		System.out.println("DNI: "+ this.dni);
		System.out.println("Nombre: "+ this.nombre);
	}
}
