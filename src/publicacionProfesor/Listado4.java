package publicacionProfesor;

public class Listado4 implements Comparable<Listado4>{
	private String depar;
	private String nombreProfe;
	private int num;
	
	public Listado4() {
		this.depar="";
		this.nombreProfe="";
		this.num=0;
	}
	
	public String getDepar() {
		return depar;
	}


	public void setDepar(String depar) {
		this.depar = depar;
	}


	public String getNombreProfe() {
		return nombreProfe;
	}


	public void setNombreProfe(String nombreProfe) {
		this.nombreProfe = nombreProfe;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public String toString() {
		return "Listado4 [depar=" + depar + ", nombreProfe=" + nombreProfe + ", num=" + num + "]";
	}


	@Override
	public int compareTo(Listado4 o) {
		int diferencia;
		diferencia= o.getNum()-num;
		if (diferencia==0){
			diferencia=nombreProfe.compareToIgnoreCase(o.getNombreProfe());
		}
		return diferencia;
	}
}
