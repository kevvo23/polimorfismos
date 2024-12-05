package publicacionProfesor;

public class Publicacion {
	protected String fecha_publicacion;
	protected String titulo;
	
	public Publicacion() {
		this.fecha_publicacion= "";
		this.titulo="";
	}
	
	public Publicacion(String fp, String t) {
		this.fecha_publicacion= fp;
		this.titulo=t;
	}

	public String getFecha_publicacion() {
		return fecha_publicacion;
	}

	public void setFecha_publicacion(String fecha_publicacion) {
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
