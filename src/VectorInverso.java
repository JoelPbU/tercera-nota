import java.util.Scanner;

public class VectorInverso {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear vector de 5 elementos de cadenas
        String[] vector_original = new String[5];
        String[] vector_inverso = new String[5];
        
        // Leer datos del teclado
        System.out.println("Ingrese 5 cadenas de caracteres:");
        for (int i = 0; i < vector_original.length; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector_original[i] = scanner.nextLine();
        }
        
        // Copiar elementos en orden inverso
        for (int i = 0; i < vector_original.length; i++) {
            vector_inverso[i] = vector_original[vector_original.length - 1 - i];
        }
        
        // Mostrar vector original
        System.out.println("\n--- Vector Original ---");
        for (int i = 0; i < vector_original.length; i++) {
            System.out.println("Posición " + i + ": " + vector_original[i]);
        }
        
        // Mostrar vector inverso
        System.out.println("\n--- Vector Inverso ---");
        for (int i = 0; i < vector_inverso.length; i++) {
            System.out.println("Posición " + i + ": " + vector_inverso[i]);
        }
        
        scanner.close();
    }
}