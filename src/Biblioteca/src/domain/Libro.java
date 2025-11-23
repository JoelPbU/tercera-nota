package Biblioteca.src.domain;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private Estado estado;

    public enum Estado {
        DISPONIBLE, PRESTADO
    }

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = Estado.DISPONIBLE;
    }

    public void prestar() {
        this.estado = Estado.PRESTADO;
    }

    public void devolver() {
        this.estado = Estado.DISPONIBLE;
    }

    public boolean isDisponible() {
        return estado == Estado.DISPONIBLE;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public Estado getEstado() { return estado; }

    @Override
    public String toString() {
        return String.format("'%s' por %s (ISBN: %s) - %s", 
            titulo, autor, isbn, estado);
    }
}