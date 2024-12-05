package publicacionProfesor;

public class Libro extends Publicacion{
	private int isbn;
	private boolean premiado;
	
	public Libro() {
		super();
		this.isbn=0;
		this.premiado= false;
	}
	
	public Libro(String fp, String t, int i, boolean p) {
		super(fp, t);
		this.isbn=i;
		this.premiado=p;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public boolean isPremiado() {
		return premiado;
	}

	public void setPremiado(boolean premiado) {
		this.premiado = premiado;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", premiado=" + premiado + ", fecha_publicacion=" + fecha_publicacion
				+ ", titulo=" + titulo + "]";
	}
}
