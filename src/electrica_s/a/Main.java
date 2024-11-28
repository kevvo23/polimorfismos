package electrica_s.a;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Empleados> a = new ArrayList<Empleados>();
		a.add(new Empleados ("1", "Carlos", "Mayo", 2020, 5));
		a.add(new Jefes ("2", "Pepe", "Enero", 2010, 5, "5"));
		int opcion;

		do {
			opcion=menu(sc);
			switch (opcion) {
			case 0:
				introducir(a, sc);
				break;
			case 1:
				if (a.size()>0) {
					visualizar (a);
				}else {
					System.out.println("\nNo hay empleados introducidos.\n");
				}
				break;
			case 2:
				if (a.size()>0) {
					visualizarJefes (a);
				}else {
					System.out.println("\nNo hay empleados introducidos.\n");
				}
				break;
			case 3:
				if (a.size()>0) {
					visualizarPorDepa (a, sc);
				}else {
					System.out.println("\nNo hay empleados introducidos.\n");
				}
				break;
			case 4:
				if (a.size()>0) {
					buscarNom (a, sc);
				}else {
					System.out.println("\nNo hay empleados introducidos.\n");
				}
				break;
			case 5:
				if (a.size()>0) {
					visualizarPorSueldo (a, sc);
				}else {
					System.out.println("\nNo hay empleados introducidos.\n");
				}
				break;
			case 6:
				if (a.size()>0) {
					visualizarPorAño (a, sc);
				}else {
					System.out.println("\nNo hay empleados introducidos.\n");
				}
				break;

			case 7:
				if (a.size()>0) {
					darBaja (a, sc);
				}else {
					System.out.println("\nNo hay empleados introducidos.\n");
				}
				break;
			case 8:

				break;
			case 9:
				System.out.println("\nHasta pronto!");
				break;

			default: 
				System.out.println("Opcion incorrecta");
				break;
			}
		}while(opcion!=9);

		sc.close();
	}

	public static int menu(Scanner sc) {
		int menu;
		System.out.println("0. Introducir datos de empleade/s y/o jefe/s.");
		System.out.println("1. Visualizar todos los datos.");
		System.out.println("2. Visualizar les jefes.");
		System.out.println("3. Visualizar les jefe/s de un departamento concreto.");
		System.out.println("4. Introducir nombre o al menos un grupo de caracteres del nombre.");
		System.out.println("5. Introducir un salario y mostrar aquelles empleades cuyo salario final es igual o superior.");
		System.out.println("6. Introducir un nº de años y mostrar les jefes que lleven en la empresa esos o más años.");
		System.out.println("7. Dar de baja a un empleade/jefe a partir de su DNI.");
		System.out.println("8. Estadística ordenada alfabéticamente por departamento de los diferentes departamentos que\r\n"
				+ "tienen jefe/s.");
		System.out.println("9. Salir.");
		menu = sc.nextInt();
		return menu;
	}

	public static void introducir(ArrayList <Empleados> a, Scanner sc) {
		String tipo;
		boolean existe=false;

		do {
			System.out.println("\nVas a introducir un empleado o un jefe?");
			tipo=sc.next();
			if (!tipo.equalsIgnoreCase("empleado")&&!tipo.equalsIgnoreCase("jefe")) {
				System.out.println("ERROR");
			}
		} while (!tipo.equalsIgnoreCase("empleado")&&!tipo.equalsIgnoreCase("jefe"));

		System.out.println("\nIntroduce los datos del empleado:");

		System.out.print("DNI: ");
		String dni = sc.next();

		for (int i=0;i<a.size()&&!existe;i++) {
			if (a.get(i).getDni().equalsIgnoreCase(dni)) {
				existe=true;
			}
		}
		
		if (!existe) {
			System.out.print("Nombre: ");
			sc.nextLine();
			String nombre = sc.nextLine();
	
			System.out.print("Mes de entrada: ");
			String mesEntrada = sc.next();
	
			System.out.print("Año de entrada: ");
			int añoEntrada = sc.nextInt();
	
			System.out.print("Porcentaje de incremento de sueldo: ");
			double porcentajeIncremento = sc.nextDouble();
	
			if (tipo.equalsIgnoreCase("empleado")) {
				Empleados nuevo = new Empleados(dni, nombre, mesEntrada, añoEntrada, porcentajeIncremento);
				a.add(nuevo);
				System.out.println("\nEmpleado añadido correctamente.");
				System.out.println("\nRegresando al menu...\n");
			} 
			else {
				System.out.print("Introduce el nombre del departamento: ");
				sc.nextLine();
				String departamento = sc.nextLine();
				Jefes nuevo = new Jefes(dni, nombre, mesEntrada, añoEntrada, porcentajeIncremento, departamento);
				a.add(nuevo);
				System.out.println("\nJefe añadido correctamente.");
				System.out.println("\nRegresando al menu...\n");
			}
		}
		
		else {
			System.out.println("\nEse empleado ya existe.\n");
		}
	}
	
	public static void visualizar (ArrayList <Empleados> a) {
		double sueldoFinal;
		for (Empleados empleado:a) {
			sueldoFinal= empleado.calcularSueldoTotal();
			System.out.println(empleado.toString());
			System.out.println("Sueldo final: " +sueldoFinal+ "€\n");
		}
	}
	
	public static void visualizarJefes (ArrayList <Empleados> a) {
		double sueldoFinal;
		for (Empleados empleado:a) {
			if (empleado instanceof Jefes) {
				sueldoFinal= empleado.calcularSueldoTotal();
				System.out.println(empleado);
				System.out.println("Sueldo final: " +sueldoFinal+ "€\n");
			}
		}
	}
	
	public static void visualizarPorDepa (ArrayList <Empleados> a, Scanner sc) {
		String departamento;
		double sueldoFinal;
		boolean existe=false;
		
		System.out.println("Cual es el departamento? ");
		departamento=sc.next();
		
		for (int i=0; i<a.size()&&!existe; i++) {
			if (a.get(i) instanceof Jefes && ((Jefes) a.get(i)).getDepartamento().equalsIgnoreCase(departamento)) {
				existe=true;
				System.out.println("\nJefe/s del departamento " + departamento + ":");
			}
		}
		
		for (Empleados empleado:a) {
			if (empleado instanceof Jefes && ((Jefes) empleado).getDepartamento().equalsIgnoreCase(departamento)) {	
				sueldoFinal= empleado.calcularSueldoTotal();
				System.out.println(empleado);
				System.out.println("Sueldo final: " +sueldoFinal+ "€\n");
			}
		}
		
		if (!existe) {
			System.out.println("Ese departamento no ha sido introducido todavia.\n");
		}
	}
	
	public static void buscarNom (ArrayList <Empleados> a, Scanner teclado) {
		String nombre;
		boolean encontrado=false;
		System.out.println("Caracteres o nombre a buscar:");
		nombre= teclado.next();
		for(int i =0; i<a.size();i++) {
			if(a.get(i).getNombre().contains(nombre)) {
				System.out.println("Nombre completo: "+a.get(i).getNombre());
				System.out.println("DNI: "+a.get(i).getDni().toString());
				System.out.println("Años de antigüedad: "+ (LocalDate.now().getYear()-a.get(i).getAño()));
				if (a.get(i) instanceof Jefes) {
					System.out.println("Es jefe\n");
				}else {
					System.out.println("No es jefe\n");
				}
				encontrado=true;
			}
		}
		if (!encontrado) {
			System.out.println("No existe");
		}
	}

	
	
	
	public static void visualizarPorSueldo (ArrayList <Empleados> a, Scanner sc) {
		double salario, sueldoFinal;
		boolean existe=false;
		
		System.out.println("Cual es el salario? ");
		salario=sc.nextDouble();
		
		for (Empleados empleado:a) {
			sueldoFinal= empleado.calcularSueldoTotal();
			if (sueldoFinal>=salario) {	
				existe=true;
				System.out.println(empleado);
				System.out.println("Sueldo final: " +sueldoFinal+ "€\n");
			}
		}
		
		if (!existe) {
			System.out.println("No se encontro un salario igual o superior al introducido.\n");
		}
	}
	
	public static void visualizarPorAño (ArrayList <Empleados> a, Scanner teclado) {
		int minima=0;
		boolean existe=false;
		System.out.println("Introduce los años minimos:");
		minima= teclado.nextInt();
		for(int i =0; i<a.size();i++) {
			if(((LocalDate.now().getYear())-a.get(i).getAño())>minima) {
				System.out.println(a.get(i).toString());
				existe= true;
			}		
		}
		if(!existe) {
			System.out.println("No se encontraron empleados con antiguedad superior a "+ minima);
		}
	}
	
	public static void darBaja (ArrayList <Empleados> a, Scanner sc) {
		String dniBaja;
		boolean existe=false;
		
		System.out.println("Cual es el DNI a dar de baja? ");
		dniBaja=sc.next();
		
		for (int i=0; i<a.size() && !existe; i++) {
			if (a.get(i).getDni().equalsIgnoreCase(dniBaja)) {
				existe=true;
				a.remove(i);
				System.out.println("Empleado dado de baja.");
			}
		}
		
		if (!existe) {
			System.out.println("No se ha encontrado ningun empleado con ese DNI.");
		}
	}
	
	public static void ordenar (ArrayList <Empleados> a) {
		
		for (int i=0; i<a.size(); i++) {
			if (a.get(i) instanceof Jefes) {
			}
		}
	}
}
