public class AreaPoligono {

    public static double calcularArea(String poligono, double medida1, double medida2) {

        poligono = poligono.toLowerCase(); 

        switch (poligono) {
            case "triangulo":
                return (medida1 * medida2) / 2;

            case "cuadrado":
                return medida1 * medida1;

            case "rectangulo":
                return medida1 * medida2;

            default:
                System.out.println("Polígono no válido.");
                return -1; 
        }
    }

    public static void main(String[] args) {

        System.out.println("Área triángulo: " + calcularArea("triangulo", 10, 5));
        System.out.println("Área cuadrado: " + calcularArea("cuadrado", 4, 0));
        System.out.println("Área rectángulo: " + calcularArea("rectangulo", 8, 6));
    }
}