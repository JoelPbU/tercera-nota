import java.util.Scanner;
import java.util.ArrayList;

public class GestionAlumnos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Usar ArrayList para almacenar nombres y edades (tamaño dinámico)
        ArrayList<String> nombres = new ArrayList<>();
        ArrayList<Integer> edades = new ArrayList<>();
        
        String nombre;
        int edad;
        
        // Leer datos de alumnos hasta que se ingrese "*"
        System.out.println("Ingrese el nombre y edad de cada alumno.");
        System.out.println("(Ingrese '*' como nombre para terminar)\n");
        
        do {
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();
            
            // Si es asterisco, terminar
            if (nombre.equals("*")) {
                break;
            }
            
            System.out.print("Edad: ");
            edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            // Guardar nombre y edad
            nombres.add(nombre);
            edades.add(edad);
            System.out.println();
            
        } while (true);
        
        // Verificar si se ingresaron datos
        if (nombres.size() == 0) {
            System.out.println("\nNo se ingresaron datos de alumnos.");
        } else {
            // Mostrar alumnos mayores de edad
            System.out.println("\n========== ALUMNOS MAYORES DE EDAD ==========");
            boolean hayMayoresDeEdad = false;
            
            for (int i = 0; i < nombres.size(); i++) {
                if (edades.get(i) >= 18) {
                    System.out.println(nombres.get(i) + " - " + edades.get(i) + " años");
                    hayMayoresDeEdad = true;
                }
            }
            
            if (!hayMayoresDeEdad) {
                System.out.println("No hay alumnos mayores de edad.");
            }
            
            // Encontrar la edad máxima
            int edadMaxima = edades.get(0);
            for (int i = 1; i < edades.size(); i++) {
                if (edades.get(i) > edadMaxima) {
                    edadMaxima = edades.get(i);
                }
            }
            
            // Mostrar alumnos mayores (con más edad)
            System.out.println("\n========== ALUMNOS CON MAYOR EDAD ==========");
            System.out.println("Edad máxima: " + edadMaxima + " años\n");
            
            for (int i = 0; i < nombres.size(); i++) {
                if (edades.get(i) == edadMaxima) {
                    System.out.println(nombres.get(i) + " - " + edades.get(i) + " años");
                }
            }
            
            System.out.println("===========================================");
        }
        
        scanner.close();
    }
}