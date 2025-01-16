package programa;

public class Usuario {
private String nombre;
private String rol;
private int id = 0;

public Usuario(String nombre, String rol) {
	this.nombre = nombre;
	this.rol = rol;
	this.id++;
}

public void mostrarUsuarios(){
	System.out.println("Id: " + id + "\tNombre: " + nombre + "\tRol: " + rol);
}

}