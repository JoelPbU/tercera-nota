package Biblioteca.src.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroPrestamo {
    private Usuario usuario;
    private Libro libro;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    public RegistroPrestamo(Usuario usuario, Libro libro) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDateTime.now();
        this.fechaDevolucion = null;
    }

    public void marcarDevuelto() {
        this.fechaDevolucion = LocalDateTime.now();
    }

    public Usuario getUsuario() { return usuario; }
    public Libro getLibro() { return libro; }
    public LocalDateTime getFechaPrestamo() { return fechaPrestamo; }
    public LocalDateTime getFechaDevolucion() { return fechaDevolucion; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String devolucion = (fechaDevolucion != null) 
            ? fechaDevolucion.format(formatter) 
            : "Pendiente";
        return String.format("Usuario: %s | Libro: %s | Préstamo: %s | Devolución: %s",
            usuario.getNombre(), libro.getTitulo(), 
            fechaPrestamo.format(formatter), devolucion);
    }
}
