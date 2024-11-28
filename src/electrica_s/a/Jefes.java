package electrica_s.a;

public class Jefes extends Empleados{
	private static int plusJefe = 250;
	private String departamento;
	
	public Jefes() {
		super();
		this.departamento="";
	}
	
	public Jefes(String d, String n, String m, int a, double p, String dep) {
		super(d, n, m, a, p);
		this.departamento= dep;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
	public double calcularSueldoTotal() {
		return (super.calcularSueldoTotal()+plusJefe);
	}

	@Override
	public String toString() {
		return "Jefes [departamento=" + departamento + ", dni=" + dni + ", nombre=" + nombre + ", mes=" + mes + ", año="
				+ año + ", porcentaje=" + porcentaje + "% ]";
	}
}
