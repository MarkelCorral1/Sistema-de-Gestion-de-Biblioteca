package programa;

public class Usuario {
private String nombre;
private String rol;
private int id;

public Usuario(String nombre, String rol, int id) {
	this.nombre = nombre;
	this.rol = rol;
	this.id = id;
}

public void mostrarUsuarios(){
	System.out.println("Id: " + id + "\tNombre: " + nombre + "\tRol: " + rol);
}

}