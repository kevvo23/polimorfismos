package persona;

public class Trabajador extends Persona{

private double salario;
	
	public Trabajador() {
		super();
		this.salario=0;
	}
	
	public Trabajador(double s) {
		super();
		this.salario=s;
	}
	
	public Trabajador(String d, String n, double s) {
		super(d,n);
		this.salario=s;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return super.toString()+"salario=" + salario;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Salario: "+ this.salario);
	}


}
