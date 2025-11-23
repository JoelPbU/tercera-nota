import java.util.Scanner;

public class GestionVentas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Declarar arreglos
        double[] precios = new double[5];
        int[][] cantidades = new int[4][5]; // 4 sucursales, 5 artículos
        
        // Leer precios de los 5 artículos
        System.out.println("Ingrese los precios de los 5 articulos:\n");
        for (int i = 0; i < 5; i++) {
            System.out.print("Precio del articulo " + (i + 1) + ": $");
            precios[i] = scanner.nextDouble();
        }
        
        // Leer cantidades vendidas en cada sucursal
        System.out.println("\nIngrese las cantidades vendidas de cada articulo en cada sucursal:\n");
        for (int i = 0; i < 4; i++) {
            System.out.println("--- Sucursal " + (i + 1) + " ---");
            for (int j = 0; j < 5; j++) {
                System.out.print("Cantidad del articulo " + (j + 1) + ": ");
                cantidades[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        
        // Mostrar información solicitada
        System.out.println("\n========== INFORMACION DE VENTAS ==========\n");
        
        // 1. Cantidades totales de cada artículo
        System.out.println("1. CANTIDADES TOTALES DE CADA ARTICULO:");
        int[] totalArticulos = new int[5];
        for (int j = 0; j < 5; j++) {
            totalArticulos[j] = 0;
            for (int i = 0; i < 4; i++) {
                totalArticulos[j] += cantidades[i][j];
            }
            System.out.println("   Articulo " + (j + 1) + ": " + totalArticulos[j] + " unidades");
        }
        
        // 2. Cantidad de artículos en la sucursal 2
        System.out.println("\n2. CANTIDAD TOTAL DE ARTICULOS EN SUCURSAL 2:");
        int totalSucursal2 = 0;
        for (int j = 0; j < 5; j++) {
            totalSucursal2 += cantidades[1][j];
        }
        System.out.println("   Sucursal 2: " + totalSucursal2 + " unidades");
        
        // 3. Cantidad del artículo 3 en la sucursal 1
        System.out.println("\n3. CANTIDAD DEL ARTICULO 3 EN SUCURSAL 1:");
        System.out.println("   Sucursal 1, Articulo 3: " + cantidades[0][2] + " unidades");
        
        // 4. Recaudación total de cada sucursal
        System.out.println("\n4. RECAUDACION TOTAL DE CADA SUCURSAL:");
        double[] recaudacionSucursales = new double[4];
        for (int i = 0; i < 4; i++) {
            recaudacionSucursales[i] = 0;
            for (int j = 0; j < 5; j++) {
                recaudacionSucursales[i] += cantidades[i][j] * precios[j];
            }
            System.out.println("   Sucursal " + (i + 1) + ": $" + String.format("%.2f", recaudacionSucursales[i]));
        }
        
        // 5. Recaudación total de la empresa
        System.out.println("\n5. RECAUDACION TOTAL DE LA EMPRESA:");
        double recaudacionTotal = 0;
        for (int i = 0; i < 4; i++) {
            recaudacionTotal += recaudacionSucursales[i];
        }
        System.out.println("   Total: $" + String.format("%.2f", recaudacionTotal));
        
        // 6. Sucursal de mayor recaudación
        System.out.println("\n6. SUCURSAL DE MAYOR RECAUDACION:");
        double maxRecaudacion = recaudacionSucursales[0];
        int sucursalMax = 0;
        for (int i = 1; i < 4; i++) {
            if (recaudacionSucursales[i] > maxRecaudacion) {
                maxRecaudacion = recaudacionSucursales[i];
                sucursalMax = i;
            }
        }
        System.out.println("   Sucursal " + (sucursalMax + 1) + " con $" + String.format("%.2f", maxRecaudacion));
        
        System.out.println("\n=========================================");
        
        // Mostrar tabla resumen
        mostrarTablaResumen(precios, cantidades, recaudacionSucursales);
        
        scanner.close();
    }
    
    // Método para mostrar tabla resumen
    public static void mostrarTablaResumen(double[] precios, int[][] cantidades, double[] recaudacionSucursales) {
        System.out.println("\n========== TABLA RESUMEN ==========\n");
        
        // Encabezado
        System.out.printf("%-12s", "Sucursal");
        for (int j = 0; j < 5; j++) {
            System.out.printf("Art%d (%.2f)  ", (j + 1), precios[j]);
        }
        System.out.printf("%-15s\n", "RECAUDACION");
        
        // Línea separadora
        System.out.println("─".repeat(85));
        
        // Datos de cada sucursal
        for (int i = 0; i < 4; i++) {
            System.out.printf("%-12s", "Sucursal " + (i + 1));
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-12d", cantidades[i][j]);
            }
            System.out.printf("$%.2f\n", recaudacionSucursales[i]);
        }
    }
}