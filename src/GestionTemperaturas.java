import java.util.Scanner;

public class GestionTemperaturas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Declarar vectores para almacenar temperaturas mínimas y máximas
        double[] tempMinima = new double[5];
        double[] tempMaxima = new double[5];
        double[] tempMedia = new double[5];
        
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        
        // Leer temperaturas mínimas y máximas para cada día
        System.out.println("Ingrese las temperaturas mínima y máxima para cada día:\n");
        
        for (int i = 0; i < 5; i++) {
            System.out.println(dias[i] + ":");
            System.out.print("  Temperatura mínima: ");
            tempMinima[i] = scanner.nextDouble();
            
            System.out.print("  Temperatura máxima: ");
            tempMaxima[i] = scanner.nextDouble();
            
            // Calcular temperatura media
            tempMedia[i] = (tempMinima[i] + tempMaxima[i]) / 2;
            System.out.println();
        }
        
        // Mostrar temperatura media de cada día
        System.out.println("========== TEMPERATURA MEDIA DE CADA DÍA ==========");
        for (int i = 0; i < 5; i++) {
            System.out.println(dias[i] + ": " + String.format("%.2f", tempMedia[i]) + "°C");
        }
        
        // Encontrar la temperatura mínima más baja
        double tempMinBaja = tempMinima[0];
        for (int i = 1; i < 5; i++) {
            if (tempMinima[i] < tempMinBaja) {
                tempMinBaja = tempMinima[i];
            }
        }
        
        // Mostrar días con menos temperatura (temperatura mínima más baja)
        System.out.println("\n========== DÍAS CON MENOS TEMPERATURA ==========");
        System.out.println("Temperatura mínima más baja: " + tempMinBaja + "°C\n");
        for (int i = 0; i < 5; i++) {
            if (tempMinima[i] == tempMinBaja) {
                System.out.println(dias[i] + " - Mín: " + tempMinima[i] + "°C, Máx: " + tempMaxima[i] + "°C");
            }
        }
        
        // Leer una temperatura por teclado
        System.out.println("\n========== BÚSQUEDA DE TEMPERATURA MÁXIMA ==========");
        System.out.print("Ingrese una temperatura para buscar días con esa temperatura máxima: ");
        double tempBuscada = scanner.nextDouble();
        
        // Mostrar días cuya temperatura máxima coincide
        boolean encontrado = false;
        System.out.println();
        for (int i = 0; i < 5; i++) {
            if (tempMaxima[i] == tempBuscada) {
                System.out.println(dias[i] + " - Mín: " + tempMinima[i] + "°C, Máx: " + tempMaxima[i] + "°C");
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("No hay días con temperatura máxima de " + tempBuscada + "°C");
        }
        
        System.out.println("=================================================");
        
        scanner.close();
    }
}