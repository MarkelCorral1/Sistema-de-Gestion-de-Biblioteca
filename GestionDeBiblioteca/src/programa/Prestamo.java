package programa;

public class Prestamo {
	
	private String idPrestamo;
    private Libro libro;
    private Usuario usuario;
    private String fechaPrestamo;
    private String fechaDevolucion;

    public Prestamo(String idPrestamo, Libro libro, Usuario usuario, String fechaPrestamo) {
        this.idPrestamo = idPrestamo;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
    }
        
        public String getIdPrestamo() {
            return idPrestamo;
        }

        public Libro getLibro() {
            return libro;
        }

        public Usuario getUsuario() {
            return usuario;
        }
    }

