
import java.util.ArrayList;
import java.util.Scanner;

public class ListaFrutas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> frutas = new ArrayList<>();
        String fruta;
        
        System.out.println("=== PROGRAMA DE LISTA DE FRUTAS ===");
        System.out.println("Ingresa nombres de frutas (escribe 'fin' para terminar):");
        
        while (true) {
            System.out.print("Ingresa una fruta: ");
            fruta = scanner.nextLine().trim();
            
            // Verificar si el usuario quiere terminar
            if (fruta.equalsIgnoreCase("fin")) {
                break;
            }
            
            // Verificar que no sea una cadena vacía
            if (!fruta.isEmpty()) {
                frutas.add(fruta);
                System.out.println("✓ Fruta agregada: " + fruta);
            } else {
                System.out.println("Por favor, ingresa un nombre válido de fruta.");
            }
        }
        
        // Mostrar la lista final de frutas
        System.out.println("\n=== LISTA FINAL DE FRUTAS ===");
        if (frutas.isEmpty()) {
            System.out.println("No se ingresaron frutas.");
        } else {
            System.out.println("Has ingresado " + frutas.size() + " frutas:");
            for (int i = 0; i < frutas.size(); i++) {
                System.out.println((i + 1) + ". " + frutas.get(i));
            }
        }
        
        scanner.close();
        System.out.println("\n¡Gracias por usar el programa!");
    }
}