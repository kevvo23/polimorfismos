package publicacionProfesor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
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
				if (!a.isEmpty()) {
					añadirPublicacion(a, sc);
				}else {
					System.out.println("\nNo hay profesores introducidos.\n");
				}
				break;
			case 3:
				if (!a.isEmpty()) {
					mostrarLibrosPremiados(a, sc);
				}else {
					System.out.println("\nNo hay profesores introducidos.\n");
				}
				break;
			case 4:
				if (!a.isEmpty()) {
					listadoPorDepartamento(a, sc);
				}else {
					System.out.println("\nNo hay profesores introducidos.\n");
				}
				break;
			case 5:
				if (!a.isEmpty()) {
					listadoProfes (a);
				}else {
					System.out.println("\nNo hay profesores introducidos.\n");
				}
				break;
			case 6:
				System.out.println("Hasta luego!");
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
		Profesor profesor = null;

		System.out.println("\nIntroduce los datos del profesor:");

		do {
			System.out.print("Email: ");
			email = sc.next();
			if (!validarEmail(email)) {
				System.out.println("ERROR! Formato no valido");
			}
			else{
				profesor =buscarEmail(a, email);
			}
			if (profesor!=null) {
				System.out.println("ERROR! Ese email ya existe.");
			}
		} while (!validarEmail(email) || profesor!=null);

		System.out.print("Nombre: ");
		sc.nextLine();
		String nombre = sc.nextLine();

		System.out.print("Departamento: ");
		String departamento = sc.next();

		Profesor nuevo = new Profesor(email, nombre, departamento);
		a.add(nuevo);
		System.out.println("\nProfesor añadido correctamente.");

		System.out.println("\nRegresando al menu...\n");
	}

	public static boolean validarEmail(String email) {
		// Regex para validar el formato del email
		String regex = "^[a-zA-Z0-9._]+@[a-zA-Z]+\\.[a-zA-Z]+$";
		return email.matches(regex);
	}

	public static Profesor buscarEmail(ArrayList <Profesor> a, String email) {
		for (Profesor profesor : a) {
			if (profesor.getEmail().equalsIgnoreCase(email)) {
				return profesor;
			}
		}
		return null;
	}

	public static void añadirPublicacion(ArrayList <Profesor> a, Scanner sc) {
		String email, respuesta, tipo;
		Profesor profesor = null;

		do {
			System.out.println("\nIntroduce el email del profesor: ");
			email=sc.next();
			if (!validarEmail(email)) {
				System.out.println("ERROR! Formto incorrecto");
			}
			else {
				profesor=buscarEmail(a,email);
				if (profesor==null) {
					System.out.println("ERROR! Email inexistente.");
				}
			}
		} while (!validarEmail(email));

		do {
			System.out.println("\n" + profesor.toString());

			do {
				System.out.println("\nLa publicacion es un libro o un articulo? ");
				tipo=sc.next();
				if (!tipo.equalsIgnoreCase("libro") && !tipo.equalsIgnoreCase("articulo")) {
					System.out.println("ERROR!");
				}
			} while (!tipo.equalsIgnoreCase("libro") && !tipo.equalsIgnoreCase("articulo"));

			if (tipo.equalsIgnoreCase("libro")) {
				profesor.getPublicaciones().add(añadirLibro(sc));
			}
			else {
				profesor.getPublicaciones().add(añadirArticulo(sc));
			}

			do {
				System.out.println("\nDeseas añadir mas publicaciones a este mismo profesor? (SI/NO)");
				respuesta=sc.next();
				if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
					System.out.println("ERROR!");
				}
			} while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));
		} while (respuesta.equalsIgnoreCase("si"));

		System.out.println("\nRegresadno al menu...\n");
	}

	public static Publicacion añadirLibro (Scanner sc) {
		String respuesta;
		boolean premiado;

		System.out.println("\nIntroduce los datos del libro:");

		System.out.print("\nAño de publicación: ");
		String fecha = sc.next();

		System.out.print("\nTítulo: ");
		sc.nextLine();
		String titulo = sc.nextLine();

		System.out.print("\nISBN: ");
		int isbn = sc.nextInt();

		do {
			System.out.print("\n¿El libro ha sido premiado? (S/N): ");
			respuesta=sc.next();
			if (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no")) {
				System.out.println("ERROR!");
			}
		} while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

		if (respuesta.equalsIgnoreCase("si")) {
			premiado=true;
		}
		else {
			premiado=false;
		}

		return new Libro(fecha, titulo, isbn, premiado);
	}

	public static Publicacion añadirArticulo (Scanner sc) {

		System.out.println("\nIntroduce los datos del articulo:");

		System.out.print("\nAño de publicación: ");
		String fecha = sc.next();

		System.out.print("\nTítulo: ");
		sc.nextLine();
		String titulo = sc.nextLine();

		System.out.print("\nMedio de publicacion: ");
		String medio = sc.next();

		return new Articulo(fecha, titulo, medio);

	}

	public static void mostrarLibrosPremiados (ArrayList <Profesor> a, Scanner sc) {
		String año;

		System.out.println("Introduzca el año del que quiera ver los libros premiados:");
		año = sc.next();
		for (Profesor p:a) {
			for (int i=0;i<p.getPublicaciones().size();i++) {
				if (p.getPublicaciones().get(i) instanceof Libro) {
					if (p.getPublicaciones().get(i).getFecha_publicacion().equalsIgnoreCase(año)) {
						if (((Libro)(p.getPublicaciones().get(i))).isPremiado()) {
							System.out.println();
						}
					}
				}
			}
		}

	}

	public static void listadoPorDepartamento (ArrayList <Profesor> a, Scanner sc) {
		int esta=0;
		ArrayList <Listado4> listaDepar=new ArrayList <Listado4>();

		for (Profesor p: a){
			esta=0;
			// Recorremos los departamentos con publicaciones que se han ido encontrando
			// Para el primer profe que se lea, aún no hay
			for(int i=0; i<listaDepar.size()&& esta==0;i++){
				if (listaDepar.get(i).getDepar().equalsIgnoreCase(p.getDepartamento())){
					esta=1;
					if (listaDepar.get(i).getNum()< p.getPublicaciones().size()){
						listaDepar.get(i).setNombreProfe(p.getNombre());
						listaDepar.get(i).setNum(p.getPublicaciones().size());
					}//if de que ha encontrado a otro profe de ese departamento con más publicaciones
				}//if de que estamos analizando a un profe que es de un departamento que tenemos en lista
			}//for que recorre los departamentos que vamos apuntando en el listado que pretendemos generar
			//NO HA ENCONTRADO ESE DEPARTAMENTO, si tiene publicaciones, lo añadimos
			if (esta==0){
				if (p.getPublicaciones().size()>0){
					Listado4 aux=new Listado4();
					aux.setDepar(p.getDepartamento());
					aux.setNombreProfe(p.getNombre());
					aux.setNum(p.getPublicaciones().size());
					listaDepar.add(aux);
				}//Hemos encontrado un departamento nuevo pero solo nos interesa si tiene publicaciones
			}//if esta==0, no está registrado ese departamento
		}//for que ha ido recorriendo a todos los profes
		if (listaDepar.size()>0){
			Collections.sort(listaDepar);
			System.out.println("Nombre departamento Nombre profesor Número de publicaciones");
			for(int i=0;i<listaDepar.size();i++){
				System.out.println(listaDepar.get(i).getDepar()+" "+listaDepar.get(i).getNombreProfe()+" "+listaDepar.get(i).getNum());
			}
		}
		else{
			System.out.println("Aún no hay publicaciones de ningún profesor por lo que no hay listado");
		}
		
		System.out.println("\nVolviendo al menu...\n");
	}

	public static void listadoProfes (ArrayList <Profesor> a) {
		for (Profesor p:a) {
			System.out.println(p.toString());
		}
	}
}
