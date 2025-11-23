package Comedor.src.services;

import Comedor.src.domain.Comida;
import Comedor.src.domain.Estudiante;
import Comedor.src.domain.Consumo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionComedor {
    private Map<String, Comida> comidas;
    private Map<String, Estudiante> estudiantes;
    private List<Consumo> registroConsumo;

    public GestionComedor() {
        this.comidas = new HashMap<>();
        this.estudiantes = new HashMap<>();
        this.registroConsumo = new ArrayList<>();
    }

    public void registrarComida(Comida comida) {
        comidas.put(comida.getNombre(), comida);
        System.out.println("✓ Comida registrada: " + comida);
    }

    public void registrarEstudiante(Estudiante estudiante) {
        estudiantes.put(estudiante.getId(), estudiante);
        System.out.println("✓ Estudiante registrado: " + estudiante);
    }

    public void mostrarDisponibilidad() {
        System.out.println("\n=== Disponibilidad de Comidas ===");
        if (comidas.isEmpty()) {
            System.out.println("No hay comidas registradas");
            return;
        }
        for (Comida comida : comidas.values()) {
            System.out.println("- " + comida);
        }
    }

    public void seleccionarComida(String estudianteId, String nombreComida) {
        if (!estudiantes.containsKey(estudianteId)) {
            System.out.println("✗ Estudiante no encontrado");
            return;
        }
        if (!comidas.containsKey(nombreComida)) {
            System.out.println("✗ Comida no encontrada");
            return;
        }

        Estudiante estudiante = estudiantes.get(estudianteId);
        Comida comida = comidas.get(nombreComida);

        if (estudiante.seleccionarComida(comida)) {
            Consumo consumo = new Consumo(estudiante, comida);
            registroConsumo.add(consumo);
            System.out.println("✓ " + estudiante.getNombre() + " seleccionó " + comida.getNombre());
        } else {
            System.out.println("✗ La comida " + nombreComida + " no está disponible");
        }
    }

    public void reponerComida(String nombreComida, int cantidad) {
        if (!comidas.containsKey(nombreComida)) {
            System.out.println("✗ Comida no encontrada");
            return;
        }
        Comida comida = comidas.get(nombreComida);
        comida.reponer(cantidad);
        System.out.println("✓ " + nombreComida + " reaprovisionada. Disponibles: " + comida.getDisponibilidad());
    }

    public void mostrarRegistroConsumo() {
        System.out.println("\n=== Registro de Consumo Diario ===");
        if (registroConsumo.isEmpty()) {
            System.out.println("No hay registros de consumo");
            return;
        }
        for (Consumo consumo : registroConsumo) {
            System.out.println("- " + consumo);
        }
    }

    public void mostrarEstadisticasConsumo() {
        System.out.println("\n=== Estadísticas de Consumo ===");
        Map<String, Integer> estadisticas = new HashMap<>();
        
        for (Consumo consumo : registroConsumo) {
            String nombreComida = consumo.getComida().getNombre();
            estadisticas.put(nombreComida, estadisticas.getOrDefault(nombreComida, 0) + 1);
        }

        if (estadisticas.isEmpty()) {
            System.out.println("No hay datos para mostrar");
            return;
        }

        for (Map.Entry<String, Integer> entrada : estadisticas.entrySet()) {
            System.out.println("- " + entrada.getKey() + ": " + entrada.getValue() + " porciones");
        }
    }

    public void mostrarEstudiantes() {
        System.out.println("\n=== Estudiantes Registrados ===");
        estudiantes.values().forEach(System.out::println);
    }
}