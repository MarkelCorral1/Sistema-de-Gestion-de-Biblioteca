package programa;

import java.util.Scanner;

public class Princiapl {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenido al sistema de gestion de la biblioteca.");
		
		
		int contadorIDUsuario = 0;
		int contadorUsuarioActual = 0;
		Usuario[] usuarios = new Usuario[10000];
		
		int contadorIDLibro = 0;
		int contadorLibroActual = 0;
		Libro[] libros = new Libro[10000];
		
		boolean seguir = true;
		while (seguir)
		{
			System.out.println("¿Que desea hacer?");
			System.out.println("\t1. Registrar usuarios");
			System.out.println("\t2. Registrar libros");
			System.out.println("\t3. Realizar prestamos");
			System.out.println("\t4. Realizar devoluciones");
			System.out.println("\t5. Gestionar reservas");
			System.out.println("\t6. Consultar registros");
			System.out.println("\t7. Salir");
			
			int eleccion = sc.nextInt();
			
			switch (eleccion)
			{
			case 1:
				System.out.print("Nombre: ");
				String nombreUsuario = sc.nextLine();
				
				boolean seguirRol = true;
				
				String rol = "";
				
				while (seguirRol)
				{
					System.out.print("rol: ");
					System.out.print("\t1. Estudiante");
					System.out.print("\t2. Profesor");
					System.out.print("\t3. Invitado");
					int eleccionRol = sc.nextInt();
					
					if (eleccion == 1) {
						rol = "estudiante";
						seguirRol = false;
					} else if (eleccion == 2) {
						rol = "profesor";
						seguirRol = false;
					} else if (eleccion == 3) {
						rol = "invitado";
						seguirRol = false;
					} else {
						System.out.println("Opcion incorrecta, elija una opcion del 1 al 3.");
					}
				}
				// Crear usuario
				usuarios[contadorUsuarioActual] = new Usuario(nombreUsuario, rol, contadorIDUsuario);
				
				break;

			case 2:
				System.out.print("Titulo: ");
				String tituloLibro = sc.nextLine();
				
				System.out.print("Autor: ");
				String autorLibro = sc.nextLine();
				
				System.out.print("Año de publicacion: ");
				int libroAñoPublicacion = sc.nextInt();
				
				System.out.print("Copias disponibles: ");
				int libroCopiasDisponibles = sc.nextInt();
				// Crear libro
				libros[contadorLibroActual] = new Libro(tituloLibro, autorLibro, contadorIDLibro, libroAñoPublicacion, libroCopiasDisponibles);
				
				break;
				
			case 3:
				
				break;
				
			case 4:
				
				break;
				
			case 5:
				
				break;
				
			case 6:
				
				break;
				
			case 7:
				seguir = false;
				System.out.println("Saliendo del sistema de gestion de biblioteca.");
				break;
				
			default:
				System.out.println("Opcion incorrecta, elija una opcion del 1 al 7.");
				break;
			}
		}
		sc.close();
	}
}