import java.util.Arrays;

public class MoverCeros {
    
    public static Object[] moverCeros(Object[] array) {
        // Crear un nuevo array con la misma longitud
        Object[] resultado = new Object[array.length];
        
        int indice = 0;
        int contadorCeros = 0;
        
        // Primera pasada: copiar elementos que no son 0
        for (Object elemento : array) {
            if (!esNumerosCero(elemento)) {
                resultado[indice] = elemento;
                indice++;
            } else if (esNumerosCero(elemento)) {
                contadorCeros++;
            }
        }
        
        // Segunda pasada: rellenar con ceros al final
        while (contadorCeros > 0) {
            resultado[indice] = 0;
            indice++;
            contadorCeros--;
        }
        
        return resultado;
    }
    
    // Método auxiliar para verificar si un elemento es 0 (número, no booleano)
    private static boolean esNumerosCero(Object elemento) {
        // Verificar que sea un número 0, no confundir con false
        return elemento instanceof Integer && (Integer) elemento == 0 ||
               elemento instanceof Double && (Double) elemento == 0.0 ||
               elemento instanceof Float && (Float) elemento == 0.0f ||
               elemento instanceof Long && (Long) elemento == 0L;
    }
    
    public static void main(String[] args) {
        // Ejemplo principal
        Object[] ejemplo1 = {false, 1, 0, 1, 2, 0, 1, 3, "a"};
        System.out.println(Arrays.toString(moverCeros(ejemplo1)));
        // [false, 1, 1, 2, 1, 3, a, 0, 0]
        
        // Más ejemplos
        Object[] ejemplo2 = {0, 0, 1, 2, 3};
        System.out.println(Arrays.toString(moverCeros(ejemplo2)));
        // [1, 2, 3, 0, 0]
        
        Object[] ejemplo3 = {1, 2, 3};
        System.out.println(Arrays.toString(moverCeros(ejemplo3)));
        // [1, 2, 3]
        
        Object[] ejemplo4 = {0, 0, 0};
        System.out.println(Arrays.toString(moverCeros(ejemplo4)));
        // [0, 0, 0]
        
        Object[] ejemplo5 = {false, true, 0, "hello", 0, 5, false, 0};
        System.out.println(Arrays.toString(moverCeros(ejemplo5)));
        // [false, true, hello, 5, false, 0, 0, 0]
    }
}