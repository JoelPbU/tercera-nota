import java.util.Scanner;

public class ComparacionTresNumeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce el primer número: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Introduce el segundo número: ");
        double num2 = scanner.nextDouble();
        
        System.out.print("Introduce el tercer número: ");
        double num3 = scanner.nextDouble();
        
        
        boolean resultado = (num1 > num2) && (num1 < num3);
        
        System.out.printf("\n¿%.2f > %.2f AND %.2f < %.2f? %s\n", 
                         num1, num2, num1, num3, resultado ? "SÍ" : "NO");
        
        scanner.close();
    }
}