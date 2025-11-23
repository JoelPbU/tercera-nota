import java.util.Scanner;

public class AnalisisNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear vector para almacenar las 5 notas
        double[] notas = new double[5];
        
        // Leer las 5 notas del teclado
        System.out.println("Ingrese las 5 notas del alumno (0-10):");
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            
            // Validar que la nota esté entre 0 y 10
            while (notas[i] < 0 || notas[i] > 10) {
                System.out.print("Nota inválida. Ingrese una nota entre 0 y 10: ");
                notas[i] = scanner.nextDouble();
            }
        }
        
        // Calcular nota media
        double suma = 0;
        for (int i = 0; i < notas.length; i++) {
            suma += notas[i];
        }
        double media = suma / notas.length;
        
        // Encontrar nota más alta
        double notaAlta = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] > notaAlta) {
                notaAlta = notas[i];
            }
        }
        
        // Encontrar nota más baja
        double notaBaja = notas[0];
        for (int i = 1; i < notas.length; i++) {
            if (notas[i] < notaBaja) {
                notaBaja = notas[i];
            }
        }
        
        // Mostrar resultados
        System.out.println("\n========== RESULTADOS ==========");
        System.out.println("\nNotas del alumno:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("  Nota " + (i + 1) + ": " + notas[i]);
        }
        
        System.out.println("\nNota Media: " + String.format("%.2f", media));
        System.out.println("Nota Más Alta: " + notaAlta);
        System.out.println("Nota Más Baja: " + notaBaja);
        System.out.println("================================");
        
        scanner.close();
    }
}