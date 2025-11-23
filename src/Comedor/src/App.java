package Comedor.src;

import Comedor.src.domain.Comida;
import Comedor.src.domain.Estudiante;
import Comedor.src.services.GestionComedor;

public class App {
    public static void main(String[] args) {
        GestionComedor comedor = new GestionComedor();

        Comida comida1 = new Comida("Arroz con pollo", "Estándar", 20);
        Comida comida2 = new Comida("Ensalada Verde", "Vegetariana", 15);
        Comida comida3 = new Comida("Pasta de Verduras", "Vegana", 10);
        Comida comida4 = new Comida("Carne Asada", "Estándar", 18);

        comedor.registrarComida(comida1);
        comedor.registrarComida(comida2);
        comedor.registrarComida(comida3);
        comedor.registrarComida(comida4);

        Estudiante est1 = new Estudiante("Juan Pérez", "E001");
        Estudiante est2 = new Estudiante("María García", "E002");
        Estudiante est3 = new Estudiante("Carlos López", "E003");
        Estudiante est4 = new Estudiante("Sofia Rodríguez", "E004");
        Estudiante est5 = new Estudiante("Pedro Martínez", "E005");

        comedor.registrarEstudiante(est1);
        comedor.registrarEstudiante(est2);
        comedor.registrarEstudiante(est3);
        comedor.registrarEstudiante(est4);
        comedor.registrarEstudiante(est5);

        comedor.mostrarDisponibilidad();
        comedor.mostrarEstudiantes();

        System.out.println("\n--- Estudiantes seleccionando comidas ---");
        comedor.seleccionarComida("E001", "Arroz con pollo");
        comedor.seleccionarComida("E002", "Ensalada Verde");
        comedor.seleccionarComida("E003", "Pasta de Verduras");
        comedor.seleccionarComida("E004", "Carne Asada");
        comedor.seleccionarComida("E005", "Arroz con pollo");
        comedor.seleccionarComida("E001", "Ensalada Verde");
        comedor.seleccionarComida("E002", "Pasta de Verduras");
        comedor.seleccionarComida("E003", "Arroz con pollo");

        comedor.mostrarDisponibilidad();

        System.out.println("\n--- Intentando seleccionar comida no disponible ---");
        for (int i = 0; i < 12; i++) {
            comedor.seleccionarComida("E001", "Pasta de Verduras");
        }

        System.out.println("\n--- Reaprovisionando comida ---");
        comedor.reponerComida("Pasta de Verduras", 15);
        comedor.mostrarDisponibilidad();

        comedor.mostrarRegistroConsumo();
        comedor.mostrarEstadisticasConsumo();

        est1.mostrarComidaSeleccionada();
        est2.mostrarComidaSeleccionada();
    }
}