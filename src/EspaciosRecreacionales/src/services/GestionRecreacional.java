package EspaciosRecreacionales.src.services;

import EspaciosRecreacionales.src.domain.EspacioRecreacional;
import EspaciosRecreacionales.src.domain.Estudiante;
import java.util.HashMap;
import java.util.Map;

public class GestionRecreacional {
    private Map<String, EspacioRecreacional> espacios;
    private Map<String, Estudiante> estudiantes;

    public GestionRecreacional() {
        this.espacios = new HashMap<>();
        this.estudiantes = new HashMap<>();
    }

    public void registrarEspacio(EspacioRecreacional espacio) {
        espacios.put(espacio.getNombre(), espacio);
        System.out.println("✓ Espacio registrado: " + espacio);
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getId(), estudiante);
        System.out.println("✓ Estudiante registrado: " + estudiante);
    }

    public boolean verificarDisponibilidad(String espacioNombre, String horario) {
        if (!espacios.containsKey(espacioNombre)) {
            return false;
        }
        EspacioRecreacional espacio = espacios.get(espacioNombre);
        long reservasEnHorario = espacio.getReservas().stream()
            .filter(r -> r.getHorario().equals(horario))
            .count();
        return reservasEnHorario < espacio.getCapacidad();
    }

    public void reservarEspacio(String estudianteId, String espacioNombre, String horario) {
        if (!estudiantes.containsKey(estudianteId)) {
            System.out.println("✗ Estudiante no encontrado");
            return;
        }
        if (!espacios.containsKey(espacioNombre)) {
            System.out.println("✗ Espacio no encontrado");
            return;
        }

        Estudiante estudiante = estudiantes.get(estudianteId);
        EspacioRecreacional espacio = espacios.get(espacioNombre);

        if (espacio.reservar(horario, estudiante)) {
            estudiante.agregarReserva(espacio, horario);
            System.out.println("✓ Reserva confirmada: " + estudiante.getNombre() + 
                " en " + espacioNombre + " a las " + horario);
        } else {
            System.out.println("✗ No se pudo reservar. Espacio no disponible o horario inválido");
        }
    }

    public void cancelarReserva(String estudianteId, String espacioNombre, String horario) {
        if (!estudiantes.containsKey(estudianteId)) {
            System.out.println("✗ Estudiante no encontrado");
            return;
        }
        if (!espacios.containsKey(espacioNombre)) {
            System.out.println("✗ Espacio no encontrado");
            return;
        }

        Estudiante estudiante = estudiantes.get(estudianteId);
        EspacioRecreacional espacio = espacios.get(espacioNombre);

        if (espacio.cancelarReserva(horario, estudiante)) {
            estudiante.cancelarReserva(espacio, horario);
            System.out.println("✓ Reserva cancelada: " + estudiante.getNombre() + 
                " en " + espacioNombre);
        } else {
            System.out.println("✗ No se encontró la reserva para cancelar");
        }
    }

    public void mostrarEspacios() {
        System.out.println("\n=== Espacios Registrados ===");
        espacios.values().forEach(System.out::println);
    }

    public void mostrarDisponibilidad(String espacioNombre) {
        if (espacios.containsKey(espacioNombre)) {
            espacios.get(espacioNombre).mostrarDisponibilidad();
        }
    }
}