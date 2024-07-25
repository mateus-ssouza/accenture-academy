import javax.swing.JOptionPane;

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
        StringBuilder sb = new StringBuilder();
        sb.append("Board atual:\n");
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                sb.append(board[i][j]).append("  ");
            }
            sb.append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
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
                JOptionPane.showMessageDialog(null, "Movimento inválido para o peão. Tente novamente.");
                return  false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Peça inválida, escolha uma peça do tipo peão [p ou P].");
        }
        return false;
    }

    private static void movimentoJogador() {
        int linhaInicial = -1, colunaInicial = -1, linhaFinal = -1, colunaFinal = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(null, "Insira seu movimento EX.: 1 0 2 0 (linhaInicial colunaInicial linhaFinal colunaFinal): ");
                if (input == null || input.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um movimento válido.");
                    continue;
                }

                String[] partes = input.trim().split("\\s+");
                if (partes.length != 4) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira quatro números separados por espaço.");
                    continue;
                }

                linhaInicial = Integer.parseInt(partes[0]);
                colunaInicial = Integer.parseInt(partes[1]);
                linhaFinal = Integer.parseInt(partes[2]);
                colunaFinal = Integer.parseInt(partes[3]);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira números válidos.");
            }
        } while (!movimentoPeca(linhaInicial, colunaInicial, linhaFinal, colunaFinal));
    }
}
