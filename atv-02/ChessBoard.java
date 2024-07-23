import java.util.Scanner;

public class ChessBoard {
    private static final int TAM = 8;
    private static String[][] board = {
            {"R", "N", "B", "Q", "K", "B", "N", "R"},
            {"P", "P", "P", "P", "P", "P", "P", "P"},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {" ", " ", " ", " ", " ", " ", " ", " "},
            {"p", "p", "p", "p", "p", "p", "p", "p"},
            {"r", "n", "b", "q", "k", "b", "n", "r"}
    };

    public static void main(String[] args) {
        imprimirBoard();
        movimentoJogador();
        imprimirBoard();
    }

    private static void imprimirBoard() {
        System.out.println("Board atual:");
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean movimentoPeaoValido(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal) {
        if (linhaInicial < 0 || linhaInicial >= TAM || colunaInicial < 0 || colunaInicial >= TAM ||
                linhaFinal < 0 || linhaFinal >= TAM || colunaFinal < 0 || colunaFinal >= TAM) {
            return false;
        }

        String peca = board[linhaInicial][colunaInicial];

        // Verificar se a peça escolhida é vazia
        if (peca.equals(" ")) {
            return false;
        }

        // Movimento para peões brancos
        if (peca.equals("P")) {
            if (colunaInicial == colunaFinal) { // Movimento vertical
                if (linhaInicial == 1) { // Primeira jogada do peão branco
                    return (linhaFinal == linhaInicial + 1 || linhaFinal == linhaInicial + 2) && board[linhaFinal][colunaFinal].equals(" ");
                } else { // Movimentos subsequentes do peão branco
                    return linhaFinal == linhaInicial + 1 && board[linhaFinal][colunaFinal].equals(" ");
                }
            }
        }

        // Movimento para peões pretos
        if (peca.equals("p")) {
            if (colunaInicial == colunaFinal) { // Movimento vertical
                if (linhaInicial == 6) { // Primeira jogada do peão preto
                    return (linhaFinal == linhaInicial - 1 || linhaFinal == linhaInicial - 2) && board[linhaFinal][colunaFinal].equals(" ");
                } else { // Movimentos subsequentes do peão preto
                    return linhaFinal == linhaInicial - 1 && board[linhaFinal][colunaFinal].equals(" ");
                }
            }
        }

        return false;
    }

    private static boolean movimentoPeca(int linhaInicial, int colunaInicial, int linhaFinal, int colunaFinal) {
        String peca = board[linhaInicial][colunaInicial];
        if (peca.equalsIgnoreCase("p")) {
            if (movimentoPeaoValido(linhaInicial, colunaInicial, linhaFinal, colunaFinal)) {
                board[linhaFinal][colunaFinal] = board[linhaInicial][colunaInicial];
                board[linhaInicial][colunaInicial] = " ";
                return true;
            } else {
                System.out.println("Movimento inválido para o peão. Tente novamente.");
                return  false;
            }
        }
        else {
            System.out.println("Peça inválida, escolha uma peça do tipo peão [p ou P].");
        }
        return  false;
    }

    private static void movimentoJogador() {
        Scanner scanner = new Scanner(System.in);
        int linhaInicial, colunaInicial, linhaFinal, colunaFinal;

        do {
            System.out.println("Insira seu movimento EX.: [1 0 2 0]: ");
            linhaInicial = scanner.nextInt();
            colunaInicial = scanner.nextInt();
            linhaFinal = scanner.nextInt();
            colunaFinal = scanner.nextInt();

        } while (!movimentoPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal));
    }
}
