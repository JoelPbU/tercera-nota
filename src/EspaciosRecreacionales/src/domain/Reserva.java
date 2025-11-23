package EspaciosRecreacionales.src.domain;

public class Reserva {
    private Estudiante estudiante;
    private String horario;

    public Reserva(Estudiante estudiante, String horario) {
        this.estudiante = estudiante;
        this.horario = horario;
    }

    public Estudiante getEstudiante() { return estudiante; }
    public String getHorario() { return horario; }

    @Override
    public String toString() {
        return "Reserva: " + estudiante.getNombre() + " - " + horario;
    }
}