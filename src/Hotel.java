import java.util.Scanner;

public class Hotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int habitaciones = 5;
        boolean[] ocupada = new boolean[habitaciones];
        String[] nombres = new String[habitaciones];
        int[] noches = new int[habitaciones];
        double[] precios = {50.0, 80.0, 50.0, 100.0, 50.0}; 
        double[] totalPagar = new double[habitaciones];

        
        System.out.println("Precios por habitación:");
        for (int i = 0; i < habitaciones; i++) {
            System.out.println("Habitación " + (i + 1) + ": $" + precios[i] + " por noche");
        }

        int opcion;
        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Reservar habitación");
            System.out.println("2. Cancelar reserva");
            System.out.println("3. Mostrar estado del hotel");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: 
                    System.out.print("Número de habitación (1-" + habitaciones + "): ");
                    int num = scanner.nextInt() - 1; 
                    if (num < 0 || num >= habitaciones) {
                        System.out.println("Número inválido");
                        break;
                    }
                    if (!ocupada[num]) {
                        scanner.nextLine(); 
                        System.out.print("Nombre del cliente: ");
                        nombres[num] = scanner.nextLine();
                        System.out.print("Número de noches: ");
                        noches[num] = scanner.nextInt();
                        totalPagar[num] = noches[num] * precios[num];
                        ocupada[num] = true;
                        System.out.println("Reserva realizada. Total a pagar: $" + totalPagar[num]);
                    } else {
                        System.out.println("La habitación ya está ocupada");
                    }
                    break;

                case 2: 
                    System.out.print("Número de habitación (1-" + habitaciones + "): ");
                    num = scanner.nextInt() - 1;
                    if (num < 0 || num >= habitaciones) {
                        System.out.println("Número inválido");
                        break;
                    }
                    if (ocupada[num]) {
                        ocupada[num] = false;
                        nombres[num] = "";
                        noches[num] = 0;
                        totalPagar[num] = 0.0;
                        System.out.println("Reserva cancelada");
                    } else {
                        System.out.println("La habitación ya estaba libre");
                    }
                    break;

                case 3: 
                    int libres = 0, ocupadas = 0;
                    for (int i = 0; i < habitaciones; i++) {
                        if (ocupada[i]) {
                            System.out.println("Habitación " + (i + 1) + " OCUPADA por " + nombres[i] + ", noches: " + noches[i] +  ", total: $" + totalPagar[i]);
                             
                            ocupadas++;
                        } else {
                            System.out.println("Habitación " + (i + 1) + " DISPONIBLE - Precio: $" + precios[i]);
                            libres++;
                        }
                    }
                    System.out.println("Total ocupadas: " + ocupadas + " | Disponibles: " + libres);
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 4);

        scanner.close();
    }
}