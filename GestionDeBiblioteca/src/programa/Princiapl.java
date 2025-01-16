package programa;

import java.util.Scanner;

public class Princiapl {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Bienvenido al sistema de gestion de la biblioteca.");
		
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
				
				break;

			case 2:
				
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
	}
}