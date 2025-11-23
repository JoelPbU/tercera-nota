package Biblioteca.src.services;

import Biblioteca.src.domain.Libro;
import Biblioteca.src.domain.Usuario;
import Biblioteca.src.domain.RegistroPrestamo;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GestionBiblioteca {
    private Map<String, Libro> libros;
    private Map<String, Usuario> usuarios;
    private List<RegistroPrestamo> historialPrestamos;

    public GestionBiblioteca() {
        this.libros = new HashMap<>();
        this.usuarios = new HashMap<>();
        this.historialPrestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro libro) {
        if (libros.containsKey(libro.getIsbn())) {
            throw new IllegalArgumentException(
                "El libro con ISBN " + libro.getIsbn() + " ya está registrado");
        }
        libros.put(libro.getIsbn(), libro);
        System.out.println("✓ Libro registrado: " + libro);
    }

    public void registrarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getId())) {
            throw new IllegalArgumentException(
                "El usuario con ID " + usuario.getId() + " ya está registrado");
        }
        usuarios.put(usuario.getId(), usuario);
        System.out.println("✓ Usuario registrado: " + usuario);
    }

    public boolean verificarDisponibilidad(String isbn) {
        if (!libros.containsKey(isbn)) {
            return false;
        }
        return libros.get(isbn).isDisponible();
    }

    public void realizarPrestamo(String usuarioId, String isbn) {
        if (!usuarios.containsKey(usuarioId)) {
            throw new IllegalArgumentException("Usuario no registrado");
        }
        if (!libros.containsKey(isbn)) {
            throw new IllegalArgumentException("Libro no registrado");
        }

        Usuario usuario = usuarios.get(usuarioId);
        Libro libro = libros.get(isbn);

        usuario.prestarLibro(libro);
        RegistroPrestamo registro = new RegistroPrestamo(usuario, libro);
        historialPrestamos.add(registro);
        System.out.println("✓ Préstamo realizado: " + usuario.getNombre() + 
            " tomó '" + libro.getTitulo() + "'");
    }

    public void realizarDevolucion(String usuarioId, String isbn) {
        if (!usuarios.containsKey(usuarioId)) {
            throw new IllegalArgumentException("Usuario no registrado");
        }
        if (!libros.containsKey(isbn)) {
            throw new IllegalArgumentException("Libro no registrado");
        }

        Usuario usuario = usuarios.get(usuarioId);
        Libro libro = libros.get(isbn);

        usuario.devolverLibro(libro);
        
        for (RegistroPrestamo registro : historialPrestamos) {
            if (registro.getUsuario().getId().equals(usuarioId) && 
                registro.getLibro().getIsbn().equals(isbn) && 
                registro.getFechaDevolucion() == null) {
                registro.marcarDevuelto();
                break;
            }
        }
        
        System.out.println("✓ Devolución realizada: " + usuario.getNombre() + 
            " devolvió '" + libro.getTitulo() + "'");
    }

    public void mostrarHistorialPrestamos() {
        System.out.println("\n========== HISTORIAL DE PRÉSTAMOS ==========");
        if (historialPrestamos.isEmpty()) {
            System.out.println("No hay registros de préstamos");
            return;
        }
        for (RegistroPrestamo registro : historialPrestamos) {
            System.out.println(registro);
        }
        System.out.println("=".repeat(42));
    }

    public void mostrarLibrosDisponibles() {
        System.out.println("\n========== LIBROS DISPONIBLES ==========");
        libros.values().stream()
            .filter(Libro::isDisponible)
            .forEach(libro -> System.out.println("- " + libro));
        System.out.println("=".repeat(39));
    }

    public void mostrarLibrosPrestados() {
        System.out.println("\n========== LIBROS PRESTADOS ==========");
        libros.values().stream()
            .filter(l -> !l.isDisponible())
            .forEach(libro -> System.out.println("- " + libro));
        System.out.println("=".repeat(38));
    }

    public void mostrarEstadoUsuarios() {
        System.out.println("\n========== ESTADO DE USUARIOS ==========");
        usuarios.values().forEach(usuario -> {
            System.out.println(usuario);
            if (!usuario.getLibrosPrestados().isEmpty()) {
                System.out.println("  Libros: " + 
                    usuario.getLibrosPrestados().stream()
                        .map(Libro::getTitulo)
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("Ninguno"));
            }
        });
        System.out.println("=".repeat(38));
    }
}
