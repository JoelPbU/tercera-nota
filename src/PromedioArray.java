import java.util.Scanner;

public class PromedioArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] num = new int[5];
        int suma = 0;
        for (int i = 0; i < num.length; i++) {
            System.out.print("Ingresa un número: ");
            num[i] = scanner.nextInt();
            suma += num[i]; 
        }
        
        double promedio = suma / (double) num.length;

        
        System.out.println("El promedio es: " + promedio);

        scanner.close();
    }
}