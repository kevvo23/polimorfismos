package publicacionProfesor;
import java.util.ArrayList;
import java.util.Scanner;

import electrica_s.a.Empleados;
import electrica_s.a.Jefes;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Profesor> a = new ArrayList<Profesor> ();
		int opcion;

		do {
			opcion=menu(sc);
			switch (opcion) {
			case 1:
				introducir(a, sc);
				break;
			case 2:
				/*if (a.size()>0) {
					visualizar (a);
				}else {
					System.out.println("\nNo hay empleados introducidos.\n");
				}*/
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;

			default: 
				System.out.println("Opcion incorrecta");
				break;
			}
		}while(opcion!=6);

		sc.close();
	}

	public static int menu(Scanner sc) {
		int menu;
		System.out.println("1. Introducir un nuevo profesor.");
		System.out.println("2. Añadir publicación.");
		System.out.println("3. Mostrar los libros galardonados de un año concreto.");
		System.out.println("4. Mostrar un listado por departamento de los profesores "
				+ "con mayor número de publicaciones.");
		System.out.println("5. Listado de los profes.");
		System.out.println("6. Salir.");
		menu = sc.nextInt();
		return menu;
	}
	
	public static void introducir(ArrayList <Profesor> a, Scanner sc) {
		String email;
		boolean existe=false;
		
		System.out.println("\nIntroduce los datos del profesor:");
		
		do {
			System.out.print("Email: ");
			email = sc.next();
			if (!validarEmail(email)) {
				System.out.println("ERROR! Formato no valido");
			}
		} while (!validarEmail(email) || existe);
		
		existe=buscarEmail(a, email);
		
		if (!existe) {
			System.out.print("Nombre: ");
			sc.nextLine();
			String nombre = sc.nextLine();
	
			System.out.print("Departamento: ");
			String departamento = sc.next();
			
			Profesor nuevo = new Profesor(email, nombre, departamento, null);
			a.add(nuevo);
			System.out.println("\nProfesor añadido correctamente.");
		}
		
		System.out.println("\nRegresando al menu...\n");
	}
	
	public static boolean validarEmail(String email) {
	    // Regex para validar el formato del email
	    String regex = "^[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]+$";
	    return email.matches(regex);
	}
	
	public static boolean buscarEmail(ArrayList <Profesor> a, String email) {
		boolean existe=false;
		for (int i=0; i<a.size() && !existe; i++) {
			if (a.get(i).getEmail().equalsIgnoreCase(email)) {
				existe=true;
				System.out.println("ERROR! Ese email ya existe.");
			}
		}
		
		return existe;
	}
}
