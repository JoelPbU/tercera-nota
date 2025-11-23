import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvenOccurrenceFilter {
    
    public static <T> List<T> filterEvenOccurrences(T[] array) {
        // Mapa para contar ocurrencias de cada elemento
        Map<T, Integer> contador = new HashMap<>();
        
        // Contar ocurrencias de cada elemento
        for (T elemento : array) {
            contador.put(elemento, contador.getOrDefault(elemento, 0) + 1);
        }
        
        // Lista para almacenar elementos con ocurrencias pares
        List<T> resultado = new ArrayList<>();
        
        // Agregar elementos con ocurrencias pares (mantener orden de primera aparición)
        for (T elemento : array) {
            if (contador.get(elemento) % 2 == 0 && !resultado.contains(elemento)) {
                resultado.add(elemento);
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        // Ejemplo con Strings
        String[] ejemplo1 = {"A", "B", "A", "C", "C", "C", "C"};
        System.out.println(filterEvenOccurrences(ejemplo1));  // [A, C]
        
        // Ejemplo con Integers
        Integer[] ejemplo2 = {1, 2, 3, 1, 2};
        System.out.println(filterEvenOccurrences(ejemplo2));  // [1, 2]
        
        // Más ejemplos
        String[] ejemplo3 = {"X", "Y", "Z", "X", "Y", "Z"};
        System.out.println(filterEvenOccurrences(ejemplo3));  // [X, Y, Z]
        
        Integer[] ejemplo4 = {1, 1, 1, 2, 2, 3};
        System.out.println(filterEvenOccurrences(ejemplo4));  // [2]
        
        String[] ejemplo5 = {"a", "a"};
        System.out.println(filterEvenOccurrences(ejemplo5));  // [a]
    }
}