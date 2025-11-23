import java.util.Scanner;

public class Raya {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        char[] board = new char[9];
        int boardLength = board.length;
        for(int i = 0; i<boardLength ; i++){
            board[i] = ' ';
        }

        char player = 'X';
        boolean isPlaying = true;

        while (isPlaying) {
            System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2]);
            System.out.println("---+---+---");
            System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5]);
            System.out.println("---+---+---");
            System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8]);

            // Pedirle por pantalla al jugar
            System.out.println("Jugador " + player + " elige una posicion del [1-9]");
            int position = scanner.nextInt() - 1;

            if (position < 0 || position > boardLength-1) {
                System.out.println("Posición no existe, intente de nuevo.");
                continue;
            }
            if (board[position] != ' ') {
                System.out.println("Esa casilla está ocupada, intente de nuevo.");
                continue;
            }

            board[position] = player;

            // comprobar si gana el player
            if (
                (board[0] == player && board[1] == player && board[2] == player) ||
                (board[3] == player && board[4] == player && board[5] == player) ||
                (board[6] == player && board[7] == player && board[8] == player) ||
                (board[0] == player && board[3] == player && board[6] == player) ||
                (board[1] == player && board[4] == player && board[7] == player) ||
                (board[2] == player && board[5] == player && board[8] == player) ||
                (board[0] == player && board[4] == player && board[8] == player) ||
                (board[2] == player && board[4] == player && board[6] == player)
            ) {
                System.out.println("!Jugador " + player + ", ha ganado!");
                isPlaying = false;
                break;
            }

            // Revisar empate
            boolean full = true;            
            for (int i = 0; i < boardLength; i++) {
                if (board[i] == ' ') {
                    full = false;
                    break;
                }
            }
            if (full) {
                System.out.println("¡Empate!");
                isPlaying = false;
                break;
            }

            // cambiar de jugar
            if (player == 'X') {
                player = 'O';
            } else {
                player = 'X';
            }
        }
        scanner.close();
    }
}