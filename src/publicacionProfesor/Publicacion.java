package publicacionProfesor;

import java.time.LocalDate;

public class Publicacion {
	protected LocalDate fecha_publicacion;
	protected String titulo;
	
	public Publicacion() {
		this.fecha_publicacion= null;
		this.titulo="";
	}
	
	public Publicacion(LocalDate fp, String t) {
		this.fecha_publicacion= fp;
		this.titulo=t;
	}

	public LocalDate getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(LocalDate fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Publicacion [fecha_publicacion=" + fecha_publicacion + ", titulo=" + titulo + "]";
	}
}
