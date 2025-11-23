package Biblioteca.src.domain;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String id;
    private List<Libro> librosPrestados;
    private static final int LIMITE_LIBROS = 3;

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
    }

    public boolean puedePrestarLibro() {
        return librosPrestados.size() < LIMITE_LIBROS;
    }

    public void prestarLibro(Libro libro) {
        if (!puedePrestarLibro()) {
            throw new IllegalStateException(
                "Usuario ha alcanzado el límite de " + LIMITE_LIBROS + " libros prestados");
        }
        if (!libro.isDisponible()) {
            throw new IllegalStateException(
                "El libro '" + libro.getTitulo() + "' no está disponible");
        }
        libro.prestar();
        librosPrestados.add(libro);
    }

    public void devolverLibro(Libro libro) {
        if (!librosPrestados.contains(libro)) {
            throw new IllegalArgumentException(
                "El usuario no tiene el libro '" + libro.getTitulo() + "' en su posesión");
        }
        libro.devolver();
        librosPrestados.remove(libro);
    }

    public int getCantidadLibrosPrestados() {
        return librosPrestados.size();
    }

    public int getLibrosDisponibles() {
        return LIMITE_LIBROS - librosPrestados.size();
    }

    public List<Libro> getLibrosPrestados() {
        return new ArrayList<>(librosPrestados);
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }

    @Override
    public String toString() {
        return String.format("Usuario: %s (ID: %s) | Libros prestados: %d/%d",
            nombre, id, librosPrestados.size(), LIMITE_LIBROS);
    }
}
