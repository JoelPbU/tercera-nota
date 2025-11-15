package GestionHorarios.src.domain;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;
    private List<Horario> horariosDisponibles;

    public Materia(String nombre, String codigo, int creditos) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.creditos = creditos;
        this.horariosDisponibles = new ArrayList<>();
    }

    public void agregarHorario(Horario horario) {
        horariosDisponibles.add(horario);
    }

    public void mostrarHorariosDisponibles() {
        System.out.println("Horarios disponibles para " + nombre + ":");
        for (Horario h : horariosDisponibles) {
            System.out.println(" - " + h);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public List<Horario> getHorariosDisponibles() {
        return horariosDisponibles;
    }
}