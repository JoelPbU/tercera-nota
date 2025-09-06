public class CuentaBancaria {
    public static void main(String[] args) {
    
        double saldoInicial = 1000.0;
        double retiroSemanal = 200.0;
        int numeroSemanas = 4;
        
        System.out.println("=== SIMULACIÓN DE RETIROS BANCARIOS ===");
        System.out.printf("Saldo inicial: $%.2f%n", saldoInicial);
        System.out.printf("Retiro semanal: $%.2f%n", retiroSemanal);
        System.out.printf("Período: %d semanas%n", numeroSemanas);
        System.out.println();
        
        double saldoActual = saldoInicial;
        
        System.out.println("=== DETALLE SEMANAL ===");
        for (int semana = 1; semana <= numeroSemanas; semana++) {
            System.out.printf("Semana %d:%n", semana);
            System.out.printf("  Saldo antes del retiro: $%.2f%n", saldoActual);
            
          
            saldoActual -= retiroSemanal;
            
            System.out.printf("  Retiro realizado: $%.2f%n", retiroSemanal);
            System.out.printf("  Saldo después del retiro: $%.2f%n", saldoActual);
            System.out.println();
        }
        
  
        double totalRetirado = retiroSemanal * numeroSemanas;
        
        System.out.println("=== RESUMEN FINAL ===");
        System.out.printf("Saldo inicial: $%.2f%n", saldoInicial);
        System.out.printf("Total retirado en %d semanas: $%.2f%n", numeroSemanas, totalRetirado);
        System.out.printf("Saldo final: $%.2f%n", saldoActual);
        
        
        if (saldoActual >= 0) {
            System.out.println("✓ Los retiros se completaron exitosamente");
        } else {
            System.out.println("⚠ ADVERTENCIA: El saldo se volvió negativo");
        }
    }
}