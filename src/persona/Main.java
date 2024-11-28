package persona;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona ("1234", "Alex");
		p1.visualizar();
		Cliente c1 = new Cliente ("4321", "Igor", 19);
		c1.visualizar();
		Trabajador t1 = new Trabajador ("6547", "DeOrbe", 20000);
		t1.visualizar();
	}

}
