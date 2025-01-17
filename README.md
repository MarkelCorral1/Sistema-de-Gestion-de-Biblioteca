# Sistema de Gestión de Biblioteca

El sistema a desarrollar implementará las siguientes funcionalidades principales:

## 1. **Gestión de Usuarios**
**Registrar usuarios** con los siguientes datos:
  - Nombre
  - ID único
  - Rol (Estudiante, Profesor, Invitado)
  
**Listar los usuarios** registrados en el sistema.

## 2. **Gestión de Libros**
**Registrar libros** con la siguiente información:
  - Título
  - Autor
  - ID único
  - Año de publicación
  - Cantidad de copias disponibles
  
**Consultar información** de un libro por su ID o título.
  
**Listar todos los libros** disponibles en la biblioteca.

## 3. **Gestión de Préstamos**
Permitir que un **usuario realice un préstamo** de un libro disponible.
**Restricciones según el rol del usuario**:
  - **Estudiantes**: máximo 3 libros.
  - **Profesores**: máximo 5 libros.
  - **Invitados**: máximo 1 libro.
  
**Marcar la devolución** de un libro prestado.

## 4. **Gestión de Reservas**
Permitir que un usuario **reserve un libro** si no hay copias disponibles.
Al **devolver un libro**, liberar la primera reserva en la lista y **notificar al usuario**.

## 5. **Programa Principal**
Implementar un **menú interactivo** que permita al usuario realizar todas las acciones mencionadas.
**Registrar las operaciones realizadas** y mostrarlas como un **log en pantalla**.