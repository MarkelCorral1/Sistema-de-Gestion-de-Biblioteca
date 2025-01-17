package programa;

public class Libro {
    private String titulo;
    private String autor;
    private int id;
    private int añoPublicacion;
    private int copiasDisponibles;
    private int reservas;
    
    public Libro(String titulo, String autor, int id, int añoPublicacion, int copiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.añoPublicacion = añoPublicacion;
        this.copiasDisponibles = copiasDisponibles;
        this.reservas = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getId() {
        return id;
    }

    public int getAnioPublicacion() {
        return añoPublicacion;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public int getReservas() {
        return reservas;
    }

    public void registrarReserva() {
        if (copiasDisponibles > 0) {
            reservas++;
            copiasDisponibles--;
            System.out.println("Reserva registrada. Copias restantes: " + copiasDisponibles);
        } else {
            System.out.println("No hay copias disponibles para reserva.");
        }
    }

    public void eliminarReserva() {
        if (reservas > 0) {
            reservas--;
            copiasDisponibles++;
            System.out.println("Reserva eliminada. Copias disponibles: " + copiasDisponibles);
        } else {
            System.out.println("No hay reservas para eliminar.");
        }
    }

    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ID: " + id);
        System.out.println("Año de publicación: " + añoPublicacion);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Reservas actuales: " + reservas);
    }

    public boolean hayCopiasDisponibles() {
        return copiasDisponibles > 0;
    }
}
