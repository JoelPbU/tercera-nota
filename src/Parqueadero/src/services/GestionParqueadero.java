package Parqueadero.src.services;
import Parqueadero.src.domain.Vehiculo;
import Parqueadero.src.domain.EspacioParqueadero;
import java.util.ArrayList;
import java.util.List;

public class GestionParqueadero {
    private List<Vehiculo> vehiculos;
    private List<EspacioParqueadero> espacios;

    public GestionParqueadero() {
        this.vehiculos = new ArrayList<>();
        this.espacios = new ArrayList<>();
    }

    public Vehiculo registrarVehiculo(String placa, String tipo, String propietario) {
        Vehiculo vehiculo = new Vehiculo(placa, tipo, propietario);
        vehiculos.add(vehiculo);
        return vehiculo;
    }

    public void agregarEspacio(int numeroEspacio, String tipoPermitido) {
        EspacioParqueadero espacio = new EspacioParqueadero(numeroEspacio, tipoPermitido);
        espacios.add(espacio);
    }

    public List<EspacioParqueadero> mostrarEspaciosDisponibles() {
        List<EspacioParqueadero> disponibles = new ArrayList<>();
        for (EspacioParqueadero espacio : espacios) {
            if (espacio.getEstado().equals("disponible")) {
                disponibles.add(espacio);
            }
        }
        return disponibles;
    }

    public String asignarEspacio(String placa, int numeroEspacio) {
        Vehiculo vehiculo = null;
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(placa)) {
                vehiculo = v;
                break;
            }
        }
        if (vehiculo == null) {
            return "Vehículo no registrado";
        }

        EspacioParqueadero espacio = null;
        for (EspacioParqueadero e : espacios) {
            if (e.getNumeroEspacio() == numeroEspacio) {
                espacio = e;
                break;
            }
        }
        if (espacio == null) {
            return "Espacio no existe";
        }

        if (espacio.getEstado().equals("ocupado")) {
            return "Espacio ocupado";
        }

        if (espacio.asignarVehiculo(vehiculo)) {
            return "Espacio " + numeroEspacio + " asignado a " + placa;
        } else {
            return "Error: " + vehiculo.getTipo() + " no puede ocupar espacio para " + espacio.getTipoPermitido();
        }
    }

    public String liberarEspacio(int numeroEspacio) {
        for (EspacioParqueadero espacio : espacios) {
            if (espacio.getNumeroEspacio() == numeroEspacio) {
                espacio.liberarEspacio();
                return "Espacio " + numeroEspacio + " liberado";
            }
        }
        return "Espacio no existe";
    }
}