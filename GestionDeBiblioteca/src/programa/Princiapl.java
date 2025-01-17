package programa;

import java.time.LocalDate;
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

		int contadorIDReserva = 0;
		int contadorReservaActual = 0;
		Reserva[] reservas = new Reserva[10000];

		boolean seguir = true;
		while (seguir) {
			System.out.println("¿Que desea hacer?");
			System.out.println("\t1. Registrar usuarios");
			System.out.println("\t2. Registrar libros");
			System.out.println("\t3. Realizar prestamos");
			System.out.println("\t4. Realizar devoluciones");
			System.out.println("\t5. Cancelar reservas");
			System.out.println("\t6. Consultar registros");
			System.out.println("\t7. Salir");

			int eleccion = sc.nextInt();
			sc.nextLine();

			switch (eleccion) {
			case 1:
				// Crear usuario
				System.out.print("Nombre: ");
				String nombreUsuario = sc.nextLine();

				boolean seguirRol = true;

				String rol = null;
				int maxLibrosPrestados = 0;

				while (seguirRol) {
					System.out.print("rol: ");
					System.out.print("\t1. Estudiante");
					System.out.print("\t2. Profesor");
					System.out.print("\t3. Invitado");
					int eleccionRol = sc.nextInt();
					sc.nextLine();

					if (eleccionRol == 1) {
						rol = "estudiante";
						maxLibrosPrestados = 3;
						seguirRol = false;
					} else if (eleccionRol == 2) {
						rol = "profesor";
						maxLibrosPrestados = 5;
						seguirRol = false;
					} else if (eleccionRol == 3) {
						rol = "invitado";
						maxLibrosPrestados = 1;
						seguirRol = false;
					} else {
						System.out.println("Opcion incorrecta, elija una opcion del 1 al 3.");
					}
				}
				// Crear usuario
				usuarios[contadorUsuarioActual] = new Usuario(nombreUsuario, rol, contadorIDUsuario,
						maxLibrosPrestados);
				contadorUsuarioActual++;
				contadorIDUsuario++;

				break;

			case 2:
				// Crear libro
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
				libros[contadorLibroActual] = new Libro(tituloLibro, autorLibro, contadorIDLibro, libroAñoPublicacion,
						libroCopiasDisponibles);
				contadorLibroActual++;
				contadorIDLibro++;

				break;

			case 3:
				// Realizar prestamo
				Libro libroPrestamo = null;
				int nLibroEnArray = 0;

				boolean seguirLibroPrestamo = true;

				while (seguirLibroPrestamo) {
					System.out.println("Titulo del libro: ");
					String libroBuscar = sc.nextLine();

					for (int i = 0; i < libros.length; i++) {
						if (libros[i] == null) {
							System.out.println("Libro no encontrado, introduzca otro libro.");
							break;
						} else if (libros[i].getTitulo().toLowerCase().equals(libroBuscar.toLowerCase())) {
							libroPrestamo = libros[i];
							seguirLibroPrestamo = false;
							nLibroEnArray = i;
							break;
						}

						if (i == libros.length - 1) {
							System.out.println("Libro no encontrado, introduzca otro libro.");
							break;
						}
					}
				}

				Usuario usuarioPrestamo = null;
				int nUsuarioEnArray = 0;

				boolean seguirUsuarioPrestamo = true;

				while (seguirUsuarioPrestamo) {
					System.out.println("Nombre del usuario: ");
					String usuarioBuscar = sc.nextLine();

					for (int i = 0; i < usuarios.length; i++) {
						if (usuarios[i] == null) {
							continue;
						} else if (usuarios[i].getNombre().toLowerCase().equals(usuarioBuscar.toLowerCase())) {
							usuarioPrestamo = usuarios[i];
							seguirUsuarioPrestamo = false;
							nUsuarioEnArray = i;
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

				if (!usuarioPrestamo.puedeRealizarPrestamo()) {
					System.out.println("ERROR: El usuario ha llegado al limite de libros prestados");
				} else if (!libroPrestamo.hayCopiasDisponibles()) {
					// Realizar reserva
					System.out.println("No hay libros disponibles, deseas reservarlo? (s/n)");
					String respuestaReservar = sc.nextLine();

					if (respuestaReservar.equals("s")) {
						reservas[contadorReservaActual] = new Reserva(contadorIDReserva, usuarioPrestamo, libroPrestamo,
								fechaPrestamo);
						
						libros[nLibroEnArray].agregarReserva(reservas[contadorReservaActual]);

						contadorReservaActual++;
						contadorIDReserva++;
					} else {
						System.out.println("No se ha realizado el prestamo.");
					}
				} else {
					prestamos[contadorPrestamoActual] = new Prestamo(contadorIDPrestamo, libroPrestamo, usuarioPrestamo,
							fechaPrestamo);

					usuarios[nUsuarioEnArray].agregarLibro(libroPrestamo);

					contadorPrestamoActual++;
					contadorIDPrestamo++;
				}

				break;

			case 4:
				// Realizar devolucion
				int nUsuarioEnArray1 = 0;

				boolean seguirUsuarioDevolucion = true;

				while (seguirUsuarioDevolucion) {
					System.out.println("Nombre del usuario: ");
					String usuarioBuscar = sc.nextLine();

					for (int i = 0; i < usuarios.length; i++) {
						if (usuarios[i] == null) {
							continue;
						} else if (usuarios[i].getNombre().toLowerCase().equals(usuarioBuscar.toLowerCase())) {

							seguirUsuarioDevolucion = false;
							nUsuarioEnArray1 = i;
							break;
						}

						if (i == usuarios.length - 1) {
							System.out.println("Usuario no encontrado, introduzca otro usuario.");
							break;
						}
					}
				}

				boolean tieneLibro = false;

				System.out.println("Libros disponibles del usuario: ");
				// Mostrar libros del usuario
				for (int i = 0; i < usuarios[nUsuarioEnArray1].getLibrosPrestados().length; i++) {
					if (usuarios[nUsuarioEnArray1].getLibrosPrestados()[i] != null) {
						System.out.println(
								"\t" + (i + 1) + ". " + usuarios[nUsuarioEnArray1].getLibrosPrestados()[i].getTitulo());
						tieneLibro = true;
					}
				}

				// Borrar libro
				if (tieneLibro) {
					System.out.println("Cual libro desea borrar (numero)");
					int libroBorrar = sc.nextInt() - 1;
					sc.nextLine();

					Libro libroDevolver = usuarios[nUsuarioEnArray1].getLibrosPrestados()[libroBorrar];

					usuarios[nUsuarioEnArray1]
							.liberarLibro(usuarios[nUsuarioEnArray1].getLibrosPrestados()[libroBorrar]);

					for (int i = 0; i < prestamos.length; i++) {
						if (prestamos[i] != null && prestamos[i].getLibro().getTitulo().equals(libroDevolver.getTitulo()) && prestamos[i].getFechaDevolucion() == null) {
							prestamos[i].setFechaDevolucion("2025");
							break;
						}
					}
					
					for (int i = 0; i < libros.length; i++) {
						if (libros[i] != null) {
							if (libroDevolver.getTitulo().equals(libros[i].getTitulo())) {

								Reserva reservaSiguiente = libros[i].getlistaReservas()[0];

								if (reservaSiguiente != null) {
									for (int j = 0; j < usuarios.length; j++) {
										if (reservaSiguiente.getUsuario().getNombre().equals(usuarios[j].getNombre())) {
											usuarios[j].agregarLibro(libros[i]);
											libros[i].liberarReserva(reservaSiguiente);
											
											for (int k = 0; k < prestamos.length; k++) {
												if (prestamos[k] == null ) {
													prestamos[k] = new Prestamo(k, libros[i], usuarios[j], "2025");
													break;
												}
											}
											
											break;
										}
									}
									for (int j = 0; j < reservas.length; j++) {
										
										if (reservas[j] != null && reservaSiguiente.getIdReserva() == reservas[j].getIdReserva()) {
											reservas[j] = null;
											 break;
										}
									}
								}
								break;
							}
						}
					}

				}
				break;

			case 5:
				// Cancelar reservas
				System.out.print("De que usuario deseas cancelar las reservas:");
				Usuario usuarioCancelarReserva = null;
				int nUsuarioEnArray2 = 0;

				boolean seguirUsuarioCancelarReserva = true;

				while (seguirUsuarioCancelarReserva) {
					System.out.println("Nombre del usuario: ");
					String usuarioBuscar = sc.nextLine();

					for (int i = 0; i < usuarios.length; i++) {
						if (usuarios[i] == null) {
							continue;
						} else if (usuarios[i].getNombre().toLowerCase().equals(usuarioBuscar.toLowerCase())) {
							usuarioCancelarReserva = usuarios[i];
							seguirUsuarioCancelarReserva = false;
							nUsuarioEnArray2 = i;
							break;
						}

						if (i == usuarios.length - 1) {
							System.out.println("Usuario no encontrado, desea buscar otro? (s/n)");
							seguirUsuarioCancelarReserva = sc.nextLine().equals("s");

							break;
						}
					}
				}

				boolean hayReserva = false;

				// Si encontro usuario, se mete en el if
				if (usuarioCancelarReserva != null) {
					System.out.println("Reservas disponibles del usuario: ");
					// Mostrar reservas del usuario
					hayReserva = false;

					for (int i = 0; i < reservas.length; i++) {
						if (reservas[i] == null) {
							continue;
						} else if (reservas[i].getUsuario().equals(usuarioCancelarReserva)) {
							System.out.println("\t" + (i + 1) + ". " + reservas[i].getLibro().getTitulo());
							hayReserva = true;
						}
					}
				}

				if (hayReserva) {
					System.out.println("Cual reserva desea borrar (numero)");
					int reservaEliminar = sc.nextInt() - 1;
					sc.nextLine();
					reservas[reservaEliminar].cancelarReserva(reservas[reservaEliminar]);
					reservas[reservaEliminar] = null;
				} else {
					System.out.println("No se encontro ninguna reserva.");
				}

				break;

			case 6:
				System.out.println("¿Que desea hacer?");
				System.out.println("\t1. Mostrar usuarios");
				System.out.println("\t2. Mostrar libros");
				System.out.println("\t3. Mostrar prestamos");
				System.out.println("\t4. Mostrar reservas");
				
				int eleccionRegistros = sc.nextInt();
				sc.nextLine();
				
				switch (eleccionRegistros) {
				case 1:
					for (int i = 0; i < usuarios.length; i++) {
						if (usuarios[i] != null) {
							System.out.println(usuarios[i]);
						}
					}
					break;
				case 2:
					for (int i = 0; i < libros.length; i++) {
						if (libros[i] != null) {
							System.out.println(libros[i]);
						}
					}
					
					break;
				case 3:
					for (int i = 0; i < prestamos.length; i++) {
						if (prestamos[i] != null) {
							System.out.println(prestamos[i]);
						}
					}
					
					break;
				case 4:
					for (int i = 0; i < libros.length; i++) {
						if (libros[i] != null) {
							System.out.println(libros[i]);
							for (Reserva reserva : libros[i].getlistaReservas()) {
								if (reserva != null) {
									System.out.println(reserva);
								}
							}
						}
					}
					
					break;

				default:
					System.out.println("Opcion incorrecta, elija una opcion del 1 al 4.");
					
					break;
				}
				
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