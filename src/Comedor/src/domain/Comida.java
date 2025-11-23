package Comedor.src.domain;

import java.time.LocalDate;

public class Comida {
    private String nombre;
    private String tipo;
    private int disponibilidad;
    private LocalDate fecha;

    public Comida(String nombre, String tipo, int disponibilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
        this.fecha = LocalDate.now();
    }

    public void servir() {
        if (disponibilidad > 0) {
            disponibilidad--;
        }
    }

    public void reponer(int cantidad) {
        if (cantidad > 0) {
            disponibilidad += cantidad;
        }
    }

    public boolean estaDisponible() {
        return disponibilidad > 0;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getDisponibilidad() { return disponibilidad; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Disponibles: " + disponibilidad;
    }
}