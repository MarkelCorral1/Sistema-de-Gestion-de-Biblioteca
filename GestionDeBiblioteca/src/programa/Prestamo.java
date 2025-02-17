package programa;

public class Prestamo {

	private int idPrestamo;
	private Libro libro;
	private Usuario usuario;
	private String fechaPrestamo;
	private String fechaDevolucion;

	public Prestamo(int idPrestamo, Libro libro, Usuario usuario, String fechaPrestamo) {
		this.idPrestamo = idPrestamo;
		this.libro = libro;
		this.usuario = usuario;
		this.fechaPrestamo = fechaPrestamo;
		this.fechaDevolucion = null;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public Libro getLibro() {
		return libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void marcarDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public boolean estaDisponible() {
		return libro.getCopiasDisponibles() > 0;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo: " + idPrestamo + ", libro: " + libro + ", usuario: " + usuario
				+ ", fechaPrestamo: " + fechaPrestamo + ", fechaDevolucion: " + fechaDevolucion + "]";
	}

}
