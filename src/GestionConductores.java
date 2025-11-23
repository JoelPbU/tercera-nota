import java.util.Scanner;

public class GestionConductores {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Pedir número de conductores
        System.out.print("¿Cuántos conductores tiene la empresa? ");
        int numConductores = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        
        // Crear vectores y matrices
        String[] nombres = new String[numConductores];
        int[][] kms = new int[numConductores][7];
        int[] total_kms = new int[numConductores];
        
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        
        // Leer nombres de conductores y kilómetros de cada día
        System.out.println("\nIngrese los datos de cada conductor:\n");
        
        for (int i = 0; i < numConductores; i++) {
            System.out.print("Nombre del conductor " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();
            
            System.out.println("Kilómetros para " + nombres[i] + ":");
            
            for (int j = 0; j < 7; j++) {
                System.out.print("  " + dias[j] + ": ");
                kms[i][j] = scanner.nextInt();
            }
            scanner.nextLine(); // Limpiar buffer
            
            System.out.println();
        }
        
        // Calcular el total de kilómetros por conductor
        for (int i = 0; i < numConductores; i++) {
            total_kms[i] = 0;
            for (int j = 0; j < 7; j++) {
                total_kms[i] += kms[i][j];
            }
        }
        
        // Mostrar resultados
        System.out.println("========== RESUMEN DE CONDUCTORES ==========\n");
        mostrarResultados(nombres, kms, total_kms, dias);
        
        // Mostrar estadísticas adicionales
        mostrarEstadisticas(nombres, total_kms);
        
        scanner.close();
    }
    
    // Método para mostrar los resultados
    public static void mostrarResultados(String[] nombres, int[][] kms, int[] total_kms, String[] dias) {
        // Encabezado
        System.out.printf("%-20s", "Conductor");
        for (int j = 0; j < 7; j++) {
            System.out.printf("%-12s", dias[j]);
        }
        System.out.printf("%-12s\n", "TOTAL");
        
        // Línea separadora
        System.out.println("─".repeat(120));
        
        // Datos de cada conductor
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("%-20s", nombres[i]);
            for (int j = 0; j < 7; j++) {
                System.out.printf("%-12d", kms[i][j]);
            }
            System.out.printf("%-12d\n", total_kms[i]);
        }
    }
    
    // Método para mostrar estadísticas
    public static void mostrarEstadisticas(String[] nombres, int[] total_kms) {
        System.out.println("\n========== ESTADÍSTICAS ==========\n");
        
        // Encontrar conductor con más kilómetros
        int maxKms = total_kms[0];
        int indexMax = 0;
        for (int i = 1; i < total_kms.length; i++) {
            if (total_kms[i] > maxKms) {
                maxKms = total_kms[i];
                indexMax = i;
            }
        }
        
        // Encontrar conductor con menos kilómetros
        int minKms = total_kms[0];
        int indexMin = 0;
        for (int i = 1; i < total_kms.length; i++) {
            if (total_kms[i] < minKms) {
                minKms = total_kms[i];
                indexMin = i;
            }
        }
        
        // Calcular promedio de kilómetros
        int sumaTotal = 0;
        for (int i = 0; i < total_kms.length; i++) {
            sumaTotal += total_kms[i];
        }
        double promedio = (double) sumaTotal / total_kms.length;
        
        System.out.println("Conductor con más kilómetros: " + nombres[indexMax] + " (" + maxKms + " km)");
        System.out.println("Conductor con menos kilómetros: " + nombres[indexMin] + " (" + minKms + " km)");
        System.out.println("Promedio de kilómetros por conductor: " + String.format("%.2f", promedio) + " km");
        System.out.println("Kilómetros totales de la empresa: " + sumaTotal + " km");
        System.out.println("==================================");
    }
}