import java.util.Scanner;

public class MediaTresNumeros {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CALCULADORA DE MEDIA DE TRES NÚMEROS ===");
        System.out.println("Por favor, introduce tres números para calcular su media:");
        System.out.println();
        
      
        System.out.print("Introduce el primer número: ");
        double numero1 = scanner.nextDouble();
        
        System.out.print("Introduce el segundo número: ");
        double numero2 = scanner.nextDouble();
        
        System.out.print("Introduce el tercer número: ");
        double numero3 = scanner.nextDouble();
        
        
        double media = (numero1 + numero2 + numero3) / 3;
        
    
        System.out.println();
        System.out.println("=== RESULTADOS ===");
        System.out.printf("Primer número: %.2f%n", numero1);
        System.out.printf("Segundo número: %.2f%n", numero2);
        System.out.printf("Tercer número: %.2f%n", numero3);
        System.out.println("------------------------");
        System.out.printf("Suma total: %.2f%n", (numero1 + numero2 + numero3));
        System.out.printf("Media aritmética: %.2f%n", media);
        
     
        System.out.println();
        System.out.println("Fórmula utilizada: Media = (n1 + n2 + n3) / 3");
        
    
        scanner.close();
    }
}