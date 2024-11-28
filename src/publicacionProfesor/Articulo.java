package publicacionProfesor;

import java.time.LocalDate;

public class Articulo extends Publicacion{
	private String medio;
	
	public Articulo() {
		super();
		this.medio="";
	}
	
	public Articulo(LocalDate fp, String t, String m) {
		super(fp, t);
		this.medio=m;
	}

	public String getMedio() {
		return medio;
	}

	public void setMedio(String medio) {
		this.medio = medio;
	}

	@Override
	public String toString() {
		return "Articulo [medio=" + medio + ", fecha_publicacion=" + fecha_publicacion + ", titulo=" + titulo + "]";
	}
}
