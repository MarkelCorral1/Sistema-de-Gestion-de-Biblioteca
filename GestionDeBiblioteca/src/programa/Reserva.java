package programa;

public class Reserva {
    private int idReserva;
    private Usuario usuario;
    private Libro libro;
    private String fechaReserva;

    public Reserva(int idReserva, Usuario usuario, Libro libro, String fechaReserva) {
        this.idReserva = idReserva;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaReserva = fechaReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }
}