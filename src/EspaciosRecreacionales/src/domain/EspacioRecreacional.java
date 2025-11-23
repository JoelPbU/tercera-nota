package EspaciosRecreacionales.src.domain;

import java.util.ArrayList;
import java.util.List;

public class EspacioRecreacional {
    private String nombre;
    private String tipo;
    private int capacidad;
    private List<String> horariosDisponibles;
    private List<Reserva> reservas;

    public EspacioRecreacional(String nombre, String tipo, int capacidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.horariosDisponibles = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void agregarHorario(String horario) {
        if (!horariosDisponibles.contains(horario)) {
            horariosDisponibles.add(horario);
        }
    }

    public boolean reservar(String horario, Estudiante estudiante) {
        if (!horariosDisponibles.contains(horario)) {
            return false;
        }
        
        int reservasEnHorario = (int) reservas.stream()
            .filter(r -> r.getHorario().equals(horario))
            .count();

        if (reservasEnHorario >= capacidad) {
            return false;
        }

        reservas.add(new Reserva(estudiante, horario));
        return true;
    }

    public boolean cancelarReserva(String horario, Estudiante estudiante) {
        return reservas.removeIf(r -> r.getHorario().equals(horario) && 
                                      r.getEstudiante().getId().equals(estudiante.getId()));
    }

    public void mostrarDisponibilidad() {
        System.out.println("\n=== Disponibilidad: " + nombre + " ===");
        for (String horario : horariosDisponibles) {
            long reservasEnHorario = reservas.stream()
                .filter(r -> r.getHorario().equals(horario))
                .count();
            int disponibles = capacidad - (int) reservasEnHorario;
            System.out.println(horario + " - Disponibles: " + disponibles + "/" + capacidad);
        }
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getCapacidad() { return capacidad; }
    public List<Reserva> getReservas() { return reservas; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ") - Capacidad: " + capacidad;
    }
}
