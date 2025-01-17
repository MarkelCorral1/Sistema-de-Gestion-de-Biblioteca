# Sistema de Gestión de Biblioteca

El sistema a desarrollar contiene las siguientes clases
  - Usuario
  - Libro
  - Prestamo
  - Reserva
  - Principal

## 1. **Gestión de Usuarios**
**Registrar usuarios** con los siguientes datos:
  - Nombre
  - ID único
  - Rol (Estudiante, Profesor, Invitado)
  - Libros prestados (Array)

**Mostrar informacion**

**Agregar libro**

**Liberar libro**

**Puede realizar prestamo?**


## 2. **Gestión de Libros**
**Registrar libros** con la siguiente información:
  - Título
  - Autor
  - ID único
  - Año de publicación
  - Cantidad de copias disponibles
  - Lista de reservas (Array)
  
**Consultar información**
  
**Prestar copia**

**Devolver copia**

**Devolver copia** y agregarsela a un usuario como prestamo (El que este primero en la lista de reservas)

**Cantidad reservas**

**Agregar reserva**

**Liberar reserva**

**Hay copias disponibles**


## 3. **Gestión de Préstamos**
**Registrar Prestamos** con los siguientes datos:
  - Libro
  - Usuario
  - ID único
  - fecha prestamo
  - fecha devolucion (a meter cuando se realize esta acción)

Permitir que un **usuario realice un préstamo** de un libro disponible.
**Restricciones según el rol del usuario**:
  - **Estudiantes**: máximo 3 libros.
  - **Profesores**: máximo 5 libros.
  - **Invitados**: máximo 1 libro.

**Consultar información**
  
**Marcar la devolución** de un libro prestado.

**Esta disponible** Comprobar si hay copias disponibles

## 4. **Gestión de Reservas**
Permitir que un usuario **reserve un libro** si no hay copias disponibles.
Al **devolver un libro**, liberar la primera reserva en la lista.

**Registrar reserva** con la siguiente información:
  - ID único
  - Usuario
  - Libro
  - Fecha reserva
  
**Consultar información**
  
**Cancelar reserva**


## 5. **Programa Principal**
Implementar un **menú interactivo** que permita al usuario realizar las acciones que se pueden ver debajo.
**Registrar las operaciones realizadas** y mostrarlas como un **log en pantalla**.

El menu cuenta con las siguientes opciones

- Registrar usuarios (Con nombre y rol)
- Registrar libros (Con titulo, autor, año de publicacion y copias disponibles)
- Realizar préstamos (Dando datos del libro a prestar, a que usuario y la fecha del prestamo, con opción de reservarlo si no hay copias)
- Realizar devoluciones (Dando datos del usuario, libro a devolver. Si no quedaban copias, automaticamente se le pasa al primero del array de reservas)
- Cancelar reservas (Dando datos del usuario, libro a quitar reserva)
- Consultar registros (Mostrando sus atributos)
  - Mostrar usuarios
  - Mostrar libros
  - Mostrar préstamos
  - Mostrar reservas
- Salir
