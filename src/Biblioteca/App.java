package Biblioteca;

import Biblioteca.src.domain.Libro;
import Biblioteca.src.domain.Usuario;
import Biblioteca.src.services.GestionBiblioteca;

public class App {
    public static void main(String[] args) {
        GestionBiblioteca biblioteca = new GestionBiblioteca();

        // Registrar libros
        Libro libro1 = new Libro("Clean Code", "Robert C. Martin", "978-0132350884");
        Libro libro2 = new Libro("Design Patterns", "Gang of Four", "978-0201633610");
        Libro libro3 = new Libro("The Pragmatic Programmer", "Hunt & Thomas", "978-0135957059");
        Libro libro4 = new Libro("Refactoring", "Martin Fowler", "978-0201485677");

        biblioteca.registrarLibro(libro1);
        biblioteca.registrarLibro(libro2);
        biblioteca.registrarLibro(libro3);
        biblioteca.registrarLibro(libro4);

        // Registrar usuarios
        Usuario usuario1 = new Usuario("Juan Pérez", "U001");
        Usuario usuario2 = new Usuario("María García", "U002");

        biblioteca.registrarUsuario(usuario1);
        biblioteca.registrarUsuario(usuario2);

        System.out.println("\n--- Realizando préstamos ---");
        
        // Préstamos exitosos
        biblioteca.realizarPrestamo("U001", "978-0132350884");
        biblioteca.realizarPrestamo("U001", "978-0201633610");
        biblioteca.realizarPrestamo("U001", "978-0135957059");

        biblioteca.realizarPrestamo("U002", "978-0201485677");

        biblioteca.mostrarEstadoUsuarios();
        biblioteca.mostrarLibrosDisponibles();
        biblioteca.mostrarLibrosPrestados();

        // Intentar exceder límite
        System.out.println("\n--- Intentando exceder límite de libros ---");
        try {
            biblioteca.realizarPrestamo("U001", "978-0201485677");
        } catch (IllegalStateException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        // Devoluciones
        System.out.println("\n--- Realizando devoluciones ---");
        biblioteca.realizarDevolucion("U001", "978-0132350884");
        biblioteca.realizarDevolucion("U001", "978-0201633610");

        biblioteca.mostrarEstadoUsuarios();
        biblioteca.mostrarHistorialPrestamos();
    }
}