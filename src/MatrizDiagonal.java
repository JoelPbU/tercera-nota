public class MatrizDiagonal {
    public static void main(String[] args) {
        
        // Crear matriz bidimensional 5x5
        int[][] diagonal = new int[5][5];
        
        // Cargar la matriz: diagonal = 1, resto = 0
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Si la fila es igual a la columna, es parte de la diagonal
                if (i == j) {
                    diagonal[i][j] = 1;
                } else {
                    diagonal[i][j] = 0;
                }
            }
        }
        
        // Mostrar el contenido de la tabla en pantalla
        System.out.println("========== MATRIZ DIAGONAL 5x5 ==========\n");
        mostrarMatriz(diagonal);
        System.out.println("\n=========================================");
    }
    
    // Método para mostrar la matriz
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}