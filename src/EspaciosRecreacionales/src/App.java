package EspaciosRecreacionales.src;

import EspaciosRecreacionales.src.domain.EspacioRecreacional;
import EspaciosRecreacionales.src.services.GestionRecreacional;
import EspaciosRecreacionales.src.domain.Estudiante;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        GestionRecreacional gestion = new GestionRecreacional();

        EspacioRecreacional cancha1 = new EspacioRecreacional("Cancha Tenis 1", "Cancha", 2);
        cancha1.agregarHorario("8:00-9:00");
        cancha1.agregarHorario("9:00-10:00");
        cancha1.agregarHorario("10:00-11:00");

        EspacioRecreacional salaJuegos = new EspacioRecreacional("Sala Juegos A", "Sala de juegos", 3);
        salaJuegos.agregarHorario("14:00-15:00");
        salaJuegos.agregarHorario("15:00-16:00");
        salaJuegos.agregarHorario("16:00-17:00");

        gestion.registrarEspacio(cancha1);
        gestion.registrarEspacio(salaJuegos);

        Estudiante est1 = new Estudiante("Juan Pérez", "E001");
        Estudiante est2 = new Estudiante("María García", "E002");
        Estudiante est3 = new Estudiante("Carlos López", "E003");

        gestion.registrarEstudiante(est1);
        gestion.registrarEstudiante(est2);
        gestion.registrarEstudiante(est3);

        gestion.mostrarEspacios();

        System.out.println("\n--- Reservando espacios ---");
        gestion.reservarEspacio("E001", "Cancha Tenis 1", "8:00-9:00");
        gestion.reservarEspacio("E002", "Cancha Tenis 1", "8:00-9:00");
        gestion.reservarEspacio("E003", "Cancha Tenis 1", "8:00-9:00");

        gestion.reservarEspacio("E001", "Sala Juegos A", "14:00-15:00");
        gestion.reservarEspacio("E002", "Sala Juegos A", "14:00-15:00");
        gestion.reservarEspacio("E003", "Sala Juegos A", "14:00-15:00");

        gestion.mostrarDisponibilidad("Cancha Tenis 1");
        gestion.mostrarDisponibilidad("Sala Juegos A");

        est1.mostrarMisReservas();
        est2.mostrarMisReservas();

        System.out.println("\n--- Cancelando reserva ---");
        gestion.cancelarReserva("E001", "Cancha Tenis 1", "8:00-9:00");

        est1.mostrarMisReservas();
    }
}

