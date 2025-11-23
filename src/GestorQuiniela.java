import java.util.Scanner;

public class GestorQuiniela {
    private static final int NUM_PARTIDOS = 15;
    
    // Tabla de equipos: 15 partidos, 2 equipos por partido
    private String[][] equipos;
    
    // Tabla de resultados: 15 partidos, 2 columnas (goles equipo 1 y equipo 2)
    private int[][] resultados;
    
    public GestorQuiniela() {
        equipos = new String[NUM_PARTIDOS][2];
        resultados = new int[NUM_PARTIDOS][2];
        inicializarDatos();
    }
    
    // Método para inicializar con datos de ejemplo
    private void inicializarDatos() {
        String[][] equiposEjemplo = {
            {"Real Madrid", "Barcelona"},
            {"Atletico Madrid", "Sevilla"},
            {"Valencia", "Villarreal"},
            {"Real Sociedad", "Betis"},
            {"Celta", "Mallorca"},
            {"Rayo Vallecano", "Osasuna"},
            {"Getafe", "Almería"},
            {"Girona", "Athletic Club"},
            {"Eibar", "Las Palmas"},
            {"Cadiz", "Alaves"},
            {"Juventus", "Milan"},
            {"Inter", "Roma"},
            {"Napoli", "Lazio"},
            {"Fiorentina", "Atalanta"},
            {"Torino", "Genoa"}
        };
        
        int[][] resultadosEjemplo = {
            {2, 1},
            {1, 1},
            {3, 0},
            {2, 2},
            {0, 1},
            {2, 0},
            {1, 2},
            {3, 1},
            {0, 0},
            {2, 1},
            {1, 0},
            {2, 2},
            {3, 1},
            {1, 2},
            {0, 1}
        };
        
        // Copiar datos de ejemplo
        for (int i = 0; i < NUM_PARTIDOS; i++) {
            equipos[i][0] = equiposEjemplo[i][0];
            equipos[i][1] = equiposEjemplo[i][1];
            resultados[i][0] = resultadosEjemplo[i][0];
            resultados[i][1] = resultadosEjemplo[i][1];
        }
    }
    
    // Mostrar todos los partidos y resultados
    public void mostrarPartidos() {
        System.out.println("\n========== RESULTADOS DE LA QUINIELA ==========\n");
        for (int i = 0; i < NUM_PARTIDOS; i++) {
            System.out.printf("Partido %2d: %s %d - %d %s\n", 
                i + 1,
                equipos[i][0],
                resultados[i][0],
                resultados[i][1],
                equipos[i][1]);
        }
    }
    
    // Actualizar resultado de un partido
    public void actualizarResultado(Scanner sc) {
        System.out.print("\nIngrese el número de partido (1-15): ");
        int partido = sc.nextInt() - 1;
        
        if (partido < 0 || partido >= NUM_PARTIDOS) {
            System.out.println("Número de partido inválido.");
            return;
        }
        
        System.out.printf("Partido actual: %s %d - %d %s\n",
            equipos[partido][0],
            resultados[partido][0],
            resultados[partido][1],
            equipos[partido][1]);
        
        System.out.print("Goles de " + equipos[partido][0] + ": ");
        int goles1 = sc.nextInt();
        
        System.out.print("Goles de " + equipos[partido][1] + ": ");
        int goles2 = sc.nextInt();
        
        resultados[partido][0] = goles1;
        resultados[partido][1] = goles2;
        
        System.out.println("Resultado actualizado correctamente.");
    }
    
    // Calcular ganadores (1 = equipo 1, X = empate, 2 = equipo 2)
    public void mostrarPronosticos() {
        System.out.println("\n========== PRONÓSTICOS (1-X-2) ==========\n");
        for (int i = 0; i < NUM_PARTIDOS; i++) {
            String pronostico;
            if (resultados[i][0] > resultados[i][1]) {
                pronostico = "1";
            } else if (resultados[i][0] < resultados[i][1]) {
                pronostico = "2";
            } else {
                pronostico = "X";
            }
            System.out.printf("Partido %2d: %s\n", i + 1, pronostico);
        }
    }
    
    // Buscar partido por nombre de equipo
    public void buscarPorEquipo(Scanner sc) {
        sc.nextLine(); // Limpiar buffer
        System.out.print("\nIngrese el nombre del equipo: ");
        String equipo = sc.nextLine();
        
        System.out.println("\n========== RESULTADOS PARA " + equipo + " ==========\n");
        boolean encontrado = false;
        
        for (int i = 0; i < NUM_PARTIDOS; i++) {
            if (equipos[i][0].equalsIgnoreCase(equipo) || equipos[i][1].equalsIgnoreCase(equipo)) {
                System.out.printf("Partido %2d: %s %d - %d %s\n",
                    i + 1,
                    equipos[i][0],
                    resultados[i][0],
                    resultados[i][1],
                    equipos[i][1]);
                encontrado = true;
            }
        }
        
        if (!encontrado) {
            System.out.println("Equipo no encontrado.");
        }
    }
    
    // Contar victorias, empates y derrotas de un equipo
    public void estadisticasEquipo(Scanner sc) {
        sc.nextLine();
        System.out.print("\nIngrese el nombre del equipo: ");
        String equipo = sc.nextLine();
        
        int victorias = 0, empates = 0, derrotas = 0;
        
        for (int i = 0; i < NUM_PARTIDOS; i++) {
            if (equipos[i][0].equalsIgnoreCase(equipo)) {
                if (resultados[i][0] > resultados[i][1]) victorias++;
                else if (resultados[i][0] == resultados[i][1]) empates++;
                else derrotas++;
            } else if (equipos[i][1].equalsIgnoreCase(equipo)) {
                if (resultados[i][1] > resultados[i][0]) victorias++;
                else if (resultados[i][0] == resultados[i][1]) empates++;
                else derrotas++;
            }
        }
        
        if (victorias + empates + derrotas == 0) {
            System.out.println("Equipo no encontrado.");
        } else {
            System.out.println("\n========== ESTADÍSTICAS DE " + equipo + " ==========");
            System.out.println("Victorias: " + victorias);
            System.out.println("Empates: " + empates);
            System.out.println("Derrotas: " + derrotas);
        }
    }
    
    // Menú principal
    public void mostrarMenu() {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n========== GESTOR DE QUINIELA ==========");
            System.out.println("1. Ver todos los partidos");
            System.out.println("2. Actualizar resultado");
            System.out.println("3. Ver pronósticos (1-X-2)");
            System.out.println("4. Buscar partido por equipo");
            System.out.println("5. Ver estadísticas de equipo");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            
            switch (opcion) {
                case 1:
                    mostrarPartidos();
                    break;
                case 2:
                    actualizarResultado(sc);
                    break;
                case 3:
                    mostrarPronosticos();
                    break;
                case 4:
                    buscarPorEquipo(sc);
                    break;
                case 5:
                    estadisticasEquipo(sc);
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 6);
        
        sc.close();
    }
    
    public static void main(String[] args) {
        GestorQuiniela gestor = new GestorQuiniela();
        gestor.mostrarMenu();
    }
}