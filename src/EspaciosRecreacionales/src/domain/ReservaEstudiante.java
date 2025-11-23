package EspaciosRecreacionales.src.domain;

public class ReservaEstudiante {
    private EspacioRecreacional espacio;
    private String horario;

    public ReservaEstudiante(EspacioRecreacional espacio, String horario) {
        this.espacio = espacio;
        this.horario = horario;
    }

    public EspacioRecreacional getEspacio() { return espacio; }
    public String getHorario() { return horario; }
}