public class MatrizMarco {
    public static void main(String[] args) {
        
        // Crear matriz bidimensional 5x15
        int[][] marco = new int[5][15];
        
        // Cargar la matriz: 1 en el marco externo, 0 en el interior
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 15; j++) {
                // Si está en la primera o última fila
                if (i == 0 || i == 4) {
                    marco[i][j] = 1;
                }
                // Si está en la primera o última columna
                else if (j == 0 || j == 14) {
                    marco[i][j] = 1;
                }
                // En caso contrario (interior)
                else {
                    marco[i][j] = 0;
                }
            }
        }
        
        // Mostrar el contenido de la matriz en pantalla
        System.out.println("========== MATRIZ MARCO 5x15 ==========\n");
        mostrarMatriz(marco);
        System.out.println("\n=====================================");
    }
    
    // Método para mostrar la matriz
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
}