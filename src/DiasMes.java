import java.util.Scanner;

public class DiasMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Vectores para almacenar nombres y días de los meses
        String[] nombresMeses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        
        int[] diasMeses = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };
        
        // Pedir número de mes al usuario
        System.out.print("Ingrese el número del mes (1-12): ");
        int numeroMes = scanner.nextInt();
        
        // Validar que el número esté entre 1 y 12
        if (numeroMes < 1 || numeroMes > 12) {
            System.out.println("Error: Ingrese un número entre 1 y 12.");
        } else {
            // Obtener información del mes (restar 1 porque los vectores empiezan en 0)
            String nombreMes = nombresMeses[numeroMes - 1];
            int diasDelMes = diasMeses[numeroMes - 1];
            
            // Mostrar resultados
            System.out.println("\n========== INFORMACION DEL MES ==========");
            System.out.println("Mes: " + nombreMes);
            System.out.println("Número: " + numeroMes);
            System.out.println("Días: " + diasDelMes);
            System.out.println("========================================");
        }
        
        scanner.close();
    }
}