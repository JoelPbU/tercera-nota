package EspaciosRecreacionales.src.domain;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private String id;
    private List<ReservaEstudiante> misReservas;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.misReservas = new ArrayList<>();
    }

    public void agregarReserva(EspacioRecreacional espacio, String horario) {
        misReservas.add(new ReservaEstudiante(espacio, horario));
    }

    public void cancelarReserva(EspacioRecreacional espacio, String horario) {
        misReservas.removeIf(r -> r.getEspacio().getNombre().equals(espacio.getNombre()) && 
                                  r.getHorario().equals(horario));
    }

    public void mostrarMisReservas() {
        System.out.println("\nReservas de " + nombre + ":");
        if (misReservas.isEmpty()) {
            System.out.println("  Sin reservas");
        } else {
            for (ReservaEstudiante r : misReservas) {
                System.out.println("  - " + r.getEspacio().getNombre() + " a las " + r.getHorario());
            }
        }
    }

    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public List<ReservaEstudiante> getMisReservas() { return misReservas; }

    @Override
    public String toString() {
        return nombre + " (ID: " + id + ")";
    }
}
