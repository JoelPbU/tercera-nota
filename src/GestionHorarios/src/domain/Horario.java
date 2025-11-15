package GestionHorarios.src.domain;

public class Horario {
    private String dia;
    private String hora;

    public Horario(String dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return dia + " " + hora;
    }

    public boolean conflictoCon(Horario otro) {
        return this.dia.equalsIgnoreCase(otro.dia) && this.hora.equalsIgnoreCase(otro.hora);
    }
}