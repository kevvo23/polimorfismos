package persona;

public class Cliente extends Persona {

	private int edad;
	
	public Cliente() {
		super();
		this.edad=0;
	}
	
	public Cliente(int e) {
		super();
		this.edad=e;
	}
	
	public Cliente(String d, String n, int e) {
		super(d,n);
		this.edad=e;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return super.toString()+"edad=" + edad;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Edad: "+ this.edad);
	}


}
