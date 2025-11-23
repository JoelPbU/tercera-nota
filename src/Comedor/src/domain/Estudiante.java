package Comedor.src.domain;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private String id;
    private List<Comida> comidaSeleccionada;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.comidaSeleccionada = new ArrayList<>();
    }

    public boolean seleccionarComida(Comida comida) {
        if (!comida.estaDisponible()) {
            return false;
        }
        comida.servir();
        comidaSeleccionada.add(comida);
        return true;
    }

    public void mostrarComidaSeleccionada() {
        System.out.println("Comida seleccionada por " + nombre + ":");
        if (comidaSeleccionada.isEmpty()) {
            System.out.println("  Sin comida seleccionada");
        } else {
            for (Comida c : comidaSeleccionada) {
                System.out.println("  - " + c.getNombre() + " (" + c.getTipo() + ")");
            }
        }
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public List<Comida> getComidaSeleccionada() { return comidaSeleccionada; }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
