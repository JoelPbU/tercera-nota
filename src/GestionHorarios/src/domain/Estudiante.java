package GestionHorarios.src.domain;

import java.util.*;

public class Estudiante {
    private String nombre;
    private String id;
    private List<Materia> materiasInscritas;
    private List<Horario> horariosOcupados;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.materiasInscritas = new ArrayList<>();
        this.horariosOcupados = new ArrayList<>();
    }

    public void inscribirMateria(Materia materia, Horario horario) throws Exception {
        if (!materia.getHorariosDisponibles().contains(horario)) {
            throw new Exception("El horario no está disponible para esta materia.");
        }

        for (Horario ocupado : horariosOcupados) {
            if (ocupado.conflictoCon(horario)) {
                throw new Exception("Conflicto de horario con otra materia.");
            }
        }

        materiasInscritas.add(materia);
        horariosOcupados.add(horario);
        System.out.println("Materia " + materia.getNombre() + " inscrita en horario: " + horario);
    }

    public void mostrarHorarioCompleto() {
        System.out.println("\nHorario de " + nombre + ":");
        for (int i = 0; i < materiasInscritas.size(); i++) {
            System.out.println("- " + materiasInscritas.get(i).getNombre() + " -> " + horariosOcupados.get(i));
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public List<Materia> getMateriasInscritas() {
        return materiasInscritas;
    }

    public List<Horario> getHorariosOcupados() {
        return horariosOcupados;
    }

}