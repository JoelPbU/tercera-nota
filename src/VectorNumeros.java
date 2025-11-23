public class VectorNumeros {
    public static void main(String[] args) {
        // Definir vector de 10 enteros
        int[] vector_numeros = new int[10];
        
        // Inicializar con valores aleatorios del 1 al 10
        for (int i = 0; i < vector_numeros.length; i++) {
            vector_numeros[i] = (int) (Math.random() * 10) + 1;
        }
        
        // Mostrar en pantalla cada elemento con su cuadrado y cubo
        System.out.println("Número\tCuadrado\tCubo");
        System.out.println("------\t--------\t----");
        
        for (int i = 0; i < vector_numeros.length; i++) {
            int numero = vector_numeros[i];
            int cuadrado = numero * numero;
            int cubo = numero * numero * numero;
            
            System.out.println(numero + "\t" + cuadrado + "\t\t" + cubo);
        }
    }
}