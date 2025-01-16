package programa;
import java.util.Date;
public class Reserva {
	// Atributos
    private String idReserva;
    private Usuario usuario;
    private Libro libro;
    private Date fechaReserva;

    // Metodos
    public Reserva(String idReserva, Usuario usuario, Libro libro, Date fechaReserva) {
        this.idReserva = idReserva;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaReserva = fechaReserva;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }
}