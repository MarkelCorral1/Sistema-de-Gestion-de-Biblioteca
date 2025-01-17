package programa;

import java.util.Iterator;
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
		
		int contadorIDPrestamo = 0;
		int contadorPrestamoActual = 0;
		Prestamo[] prestamos = new Prestamo[10000];
		
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
			sc.nextLine();
			
			switch (eleccion)
			{
			case 1:
				System.out.print("Nombre: ");
				String nombreUsuario = sc.nextLine();
				
				boolean seguirRol = true;
				
				String rol = null;
				
				while (seguirRol)
				{
					System.out.print("rol: ");
					System.out.print("\t1. Estudiante");
					System.out.print("\t2. Profesor");
					System.out.print("\t3. Invitado");
					int eleccionRol = sc.nextInt();
					sc.nextLine();
					
					if (eleccionRol == 1) {
						rol = "estudiante";
						seguirRol = false;
					} else if (eleccionRol == 2) {
						rol = "profesor";
						seguirRol = false;
					} else if (eleccionRol == 3) {
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
				sc.nextLine();
				
				System.out.print("Copias disponibles: ");
				int libroCopiasDisponibles = sc.nextInt();
				sc.nextLine();
				// Crear libro
				libros[contadorLibroActual] = new Libro(tituloLibro, autorLibro, contadorIDLibro, libroAñoPublicacion, libroCopiasDisponibles);
				
				break;
				
			case 3:
				Libro libroReserva = null;
				
				boolean seguirLibroReserva = true;
						
				while (seguirLibroReserva)
				{
					System.out.println("Titulo del libro: ");
					String libroBuscar = sc.nextLine();
					
					for (int i = 0; i < libros.length; i++) {
						if (libros[i] == null) {
							System.out.println("Libro no encontrado, introduzca otro libro.");
							break;
						} else if (libros[i].getTitulo().toLowerCase().equals(libroBuscar.toLowerCase())) {
							libroReserva = libros[i];
							seguirLibroReserva = false;
							break;
						}
						
						if (i == libros.length - 1) {
							System.out.println("Libro no encontrado, introduzca otro libro.");
							break;
						}
					}
				}
				
				Usuario usuarioReserva = null;
				
				boolean seguirUsuarioReserva = true;
				
				while (seguirUsuarioReserva)
				{
					System.out.println("Nombre del usuario: ");
					String usuarioBuscar = sc.nextLine();
					
					for (int i = 0; i < usuarios.length; i++) {
						if (usuarios[i] == null) {
							System.out.println("Usuario no encontrado, introduzca otro usuario.");
							break;
						} else if (usuarios[i].getNombre().toLowerCase().equals(usuarioBuscar.toLowerCase())) {
							usuarioReserva = usuarios[i];
							seguirUsuarioReserva = false;
							break;
						}
						
						if (i == usuarios.length - 1) {
							System.out.println("Usuario no encontrado, introduzca otro usuario.");
							break;
						}
					}
				}
				
				System.out.print("Fecha prestamo: ");
				String fechaPrestamo = sc.nextLine();
				
				prestamos[contadorPrestamoActual] = new Prestamo(contadorIDPrestamo, libroReserva, usuarioReserva, fechaPrestamo);
				
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