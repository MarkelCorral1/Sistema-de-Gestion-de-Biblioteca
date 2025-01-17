package programa;

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
			}
		}
    }

    public void liberarReserva() {
        listaReservas[0] = null;
        
        for (int i = 0; i < listaReservas.length; i++) {
        	listaReservas[i] = listaReservas[i + 1];
        	if (listaReservas[i] == null) {
        		break;
        	}
		}
    }
    
    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ID: " + id);
        System.out.println("Año de publicación: " + añoPublicacion);
        System.out.println("Copias disponibles: " + copiasDisponibles);
        System.out.println("Reservas actuales: " + cantidadReservas());
    }

    public boolean hayCopiasDisponibles() {
        return copiasDisponibles > 0;
    }
}
