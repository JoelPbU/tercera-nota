public class TiendaRopa {
    public static void main(String[] args) {
        double precioCamiseta = 25.0;
        double precioPantalon = 30.0;
        double descuentoInicial = 0.15; 
        double descuentoAdicional = 0.05; 
        
        System.out.println("=== TIENDA DE ROPA - CÁLCULO DE DESCUENTOS ===");
        System.out.println("Precios originales:");
        System.out.printf("Camiseta: $%.2f%n", precioCamiseta);
        System.out.printf("Pantalón: $%.2f%n", precioPantalon);
        System.out.println();
    
        double camiseta1ConDescuento = precioCamiseta * (1 - descuentoInicial);
        System.out.printf("Primera camiseta con 15%% de descuento: $%.2f%n", camiseta1ConDescuento);
        
        double pantalonConDescuento = precioPantalon * (1 - descuentoInicial);
        System.out.printf("Pantalón con 15%% de descuento: $%.2f%n", pantalonConDescuento);
        
        double camiseta2ConDescuento = camiseta1ConDescuento * (1 - descuentoAdicional);
        System.out.printf("Segunda camiseta (15%% + 5%% adicional): $%.2f%n", camiseta2ConDescuento);
        
        double total = camiseta1ConDescuento + pantalonConDescuento + camiseta2ConDescuento;
        
        System.out.println();
        System.out.println("=== RESUMEN DE LA COMPRA ===");
        System.out.printf("Primera camiseta: $%.2f%n", camiseta1ConDescuento);
        System.out.printf("Pantalón: $%.2f%n", pantalonConDescuento);
        System.out.printf("Segunda camiseta: $%.2f%n", camiseta2ConDescuento);
        System.out.println("------------------------");
        System.out.printf("TOTAL A PAGAR: $%.2f%n", total);
        
        double precioSinDescuento = (precioCamiseta * 2) + precioPantalon;
        double ahorroTotal = precioSinDescuento - total;
        System.out.printf("Ahorro total: $%.2f%n", ahorroTotal);
    }
}