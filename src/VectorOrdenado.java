public class VectorOrdenado {
    public static void main(String[] args) {
        // Declarar vector de 10 elementos
        int[] vector = new int[10];
        
        // Inicializar con valores aleatorios entre 1 y 100
        System.out.println("Inicializando vector con valores aleatorios...\n");
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 100) + 1;
        }
        
        // Mostrar vector original
        System.out.println("========== VECTOR ORIGINAL ==========");
        mostrarVector(vector);
        
        // Ordenar de menor a mayor (Método de la Burbuja)
        ordenarBurbuja(vector);
        
        // Mostrar vector ordenado
        System.out.println("\n========== VECTOR ORDENADO ==========");
        mostrarVector(vector);
    }
    
    // Método para mostrar el vector
    public static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }
    
    // Método de ordenamiento por Burbuja (menor a mayor)
    public static void ordenarBurbuja(int[] vector) {
        int n = vector.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Comparar elementos adyacentes
                if (vector[j] > vector[j + 1]) {
                    // Intercambiar si el primero es mayor que el segundo
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                }
            }
        }
    }
}