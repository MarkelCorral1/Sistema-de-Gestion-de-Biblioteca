package programa;

import java.util.Arrays;

public class Libro {
    private String titulo;
    private String autor;
    private int id;
    private int añoPublicacion;
    private int copiasDisponibles;
    private Reserva[] listaReservas;
    
    public Libro(String titulo, String autor, int id, int añoPublicacion, int copiasDisponibles) {
        this.titulo = titulo;
        this.autor = autor;
        this.id = id;
        this.añoPublicacion = añoPublicacion;
        this.copiasDisponibles = copiasDisponibles;
        listaReservas = new Reserva[10000];
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

    public Reserva[] getlistaReservas() {
        return listaReservas;
    }

    public void prestarCopia() {
        copiasDisponibles--;
    }

    public void devolverCopia() {
        copiasDisponibles++;
    }
    
    // Si hay gente con reservas, se las agrega como prestamo (Si hay huecos disponibles)
    public void devolverCopia(Usuario usuario) {
        copiasDisponibles++;
        
        if (listaReservas[0] != null) {
        	usuario.agregarLibro(this);
        }
    }
    
    public int cantidadReservas() {
    	int cantidadReservas = 0;
    	
        for (int i = 0; i < listaReservas.length; i++) {
        	if (listaReservas[i] != null) {
        		cantidadReservas++;
        	} else {
        		break;
        	}
		}
        
        return cantidadReservas;
	}
    
    public void agregarReserva(Reserva reserva) {
        for (int i = 0; i < listaReservas.length; i++) {
			if (listaReservas[i] == null) {
				listaReservas[i] = reserva;
				break;
			}
		}
    }

	public void liberarReserva(Reserva reserva) 
	{
		// Bucle para liberar reserva
		for (int i = 0; i < listaReservas.length; i++) 
		{
			if (listaReservas[i].getIdReserva() == reserva.getIdReserva())
			{
				listaReservas[i] = null;
				break;
			}
		}
		// Bucle para ordenar la lista (los que son null los mete al final)
		for (int i = 0; i < listaReservas.length - 1; i++) {
			if (listaReservas[i] == null)
			{
				listaReservas[i] = listaReservas[i + 1];
				listaReservas[i + 1] = null;
			}
		}
	}

    public boolean hayCopiasDisponibles() {
        return copiasDisponibles > 0;
    }

	@Override
	public String toString() {
		return "Libro [titulo: " + titulo + ", autor: " + autor + ", id: " + id + ", añoPublicacion: " + añoPublicacion
				+ ", copiasDisponibles: " + copiasDisponibles + "]";
	}
    
    
}