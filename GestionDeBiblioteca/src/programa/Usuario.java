package programa;

public class Usuario {
	private String nombre;
	private String rol;
	private int id;
	private Libro[] librosPrestados;

	public Usuario(String nombre, String rol, int id, int maxLibrosPrestados) 
	{
		this.nombre = nombre;
		this.rol = rol;
		this.id = id;
		this.librosPrestados = new Libro[maxLibrosPrestados];
	}

	public String getNombre() 
	{
		return nombre;
	}

	public Libro[] getLibrosPrestados() 
	{
		return librosPrestados;
	}

	public void mostrarUsuarios() 
	{
		System.out.println("Id: " + id + "\tNombre: " + nombre + "\tRol: " + rol);
	}

	public void agregarLibro(Libro libro) 
	{
		for (int i = 0; i < librosPrestados.length; i++) 
		{
			if (librosPrestados[i] == null) 
			{
				librosPrestados[i] = libro;
				librosPrestados[i].prestarCopia();
				break;
			}
		}
	}

	public void liberarLibro(Libro libro) 
	{
		for (int i = 0; i < librosPrestados.length; i++) 
		{
			if (librosPrestados[i] == libro) 
			{
				librosPrestados[i].devolverCopia();
				librosPrestados[i] = null;
				break;
			}
		}
	}

	public boolean puedeRealizarPrestamo() 
	{
		int limite = switch (rol.toLowerCase()) 
		{
		case "estudiante" -> 3;
		case "profesor" -> 5;
		case "invitado" -> 1;
		default -> 0;
		};

		int nLibrosPrestados = 0;
		for (int i = 0; i < librosPrestados.length; i++) 
		{
			if (librosPrestados[i] != null)
				nLibrosPrestados++;
		}

		return nLibrosPrestados < limite;
	}
}
