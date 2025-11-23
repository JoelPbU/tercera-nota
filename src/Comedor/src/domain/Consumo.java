package Comedor.src.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consumo {
    private Estudiante estudiante;
    private Comida comida;
    private LocalDateTime fechaHora;

    public Consumo(Estudiante estudiante, Comida comida) {
        this.estudiante = estudiante;
        this.comida = comida;
        this.fechaHora = LocalDateTime.now();
    }

    public Estudiante getEstudiante() { return estudiante; }
    public Comida getComida() { return comida; }
    public LocalDateTime getFechaHora() { return fechaHora; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return estudiante.getNombre() + " - " + comida.getNombre() + " - " + fechaHora.format(formatter);
    }
}
