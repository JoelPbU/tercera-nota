package Parqueadero.src.domain;

public class EspacioParqueadero {
    private int numeroEspacio;
    private String tipoPermitido;
    private String estado;
    private Vehiculo vehiculoAsignado;

    public EspacioParqueadero(int numeroEspacio, String tipoPermitido) {
        this.numeroEspacio = numeroEspacio;
        this.tipoPermitido = tipoPermitido;
        this.estado = "disponible";
        this.vehiculoAsignado = null;
    }

    public boolean asignarVehiculo(Vehiculo vehiculo) {
        if (!vehiculo.getTipo().equals(tipoPermitido)) {
            return false;
        }
        this.estado = "ocupado";
        this.vehiculoAsignado = vehiculo;
        return true;
    }

    public void liberarEspacio() {
        this.estado = "disponible";
        this.vehiculoAsignado = null;
    }

    public int getNumeroEspacio() {
        return numeroEspacio;
    }

    public String getTipoPermitido() {
        return tipoPermitido;
    }

    public String getEstado() {
        return estado;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }
}
