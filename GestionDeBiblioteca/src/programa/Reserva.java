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
    
    public void cancelarReserva(Reserva reserva) {
    	reserva.libro.liberarReserva(reserva);
	}

	@Override
	public String toString() {
		return "Reserva [idReserva: " + idReserva + ", usuario: " + usuario + ", libro: " + libro + ", fechaReserva: "
				+ fechaReserva + "]";
	}
    
    
}