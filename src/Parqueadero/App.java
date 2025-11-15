package Parqueadero;
import Parqueadero.src.services.GestionParqueadero;
import Parqueadero.src.domain.EspacioParqueadero;

public class App {
    public static void main(String[] args) {
        GestionParqueadero gestion = new GestionParqueadero();

        gestion.agregarEspacio(1, "carro");
        gestion.agregarEspacio(2, "carro");
        gestion.agregarEspacio(3, "moto");
        gestion.agregarEspacio(4, "moto");

        gestion.registrarVehiculo("ABC123", "carro", "Juan Pérez");
        gestion.registrarVehiculo("XYZ789", "moto", "María García");

        System.out.println("=== Sistema de Gestión de Parqueadero ===\n");

        System.out.println("Intentando asignar carro a espacio de carro:");
        System.out.println(gestion.asignarEspacio("ABC123", 1));

        System.out.println("\nIntentando asignar moto a espacio de carro (debe fallar):");
        System.out.println(gestion.asignarEspacio("XYZ789", 2));

        System.out.println("\nIntentando asignar moto a espacio de moto:");
        System.out.println(gestion.asignarEspacio("XYZ789", 3));

        System.out.println("\nEspacios disponibles:");
        for (EspacioParqueadero esp : gestion.mostrarEspaciosDisponibles()) {
            System.out.println("  Espacio " + esp.getNumeroEspacio() + " - Tipo: " + esp.getTipoPermitido());
        }

        System.out.println("\nLiberando espacio 1:");
        System.out.println(gestion.liberarEspacio(1));

        System.out.println("\nEspacios disponibles después de liberar:");
        for (EspacioParqueadero esp : gestion.mostrarEspaciosDisponibles()) {
            System.out.println("  Espacio " + esp.getNumeroEspacio() + " - Tipo: " + esp.getTipoPermitido());
        }
    }
}