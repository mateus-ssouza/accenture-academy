import javax.swing.JOptionPane;

public class JogoDaVelha {
    private static final int TAM = 3;
    private static char[][] tabuleiro = new char[TAM][TAM];
    private static char jogadorAtual = 'X';

    public static void main(String[] args) {
        inicializarTabuleiro();
        imprimirTabuleiro();

        while (true) {
            jogadorMovimento();
            imprimirTabuleiro();

            if (verificarVencedor()) {
                JOptionPane.showMessageDialog(null, "Jogador " + jogadorAtual + " venceu!");
                break;
            }

            if (tabuleiroCompleto()) {
                JOptionPane.showMessageDialog(null, "O jogo terminou empatado!");
                break;
            }

            mudarJogador();
        }
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private static void imprimirTabuleiro() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tabuleiro atual:\n");
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                sb.append(tabuleiro[i][j]);
                if (j < TAM - 1) sb.append(" | ");
            }
            sb.append("\n");
            if (i < TAM - 1) sb.append("--+---+--\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static void jogadorMovimento() {
        int linha = -1, coluna = -1;
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(null, "Jogador " + jogadorAtual + ", insira seu movimento EX.: [1 2]: ");
                if (input == null || input.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um movimento válido.");
                    continue;
                }

                String[] partes = input.trim().split("\\s+");
                if (partes.length != 2) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira dois números separados por espaço.");
                    continue;
                }

                linha = Integer.parseInt(partes[0]) - 1; // ajusta para índice baseado em zero
                coluna = Integer.parseInt(partes[1]) - 1; // ajusta para índice baseado em zero

                if (linha >= 0 && linha < TAM && coluna >= 0 && coluna < TAM && tabuleiro[linha][coluna] == ' ') {
                    tabuleiro[linha][coluna] = jogadorAtual;
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "Não é um movimento válido, insira novamente.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira números válidos.");
            }
        }
    }

    private static boolean verificarVencedor() {
        // Verificando linhas e colunas
        for (int i = 0; i < TAM; i++) {
            if ((tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) ||
                    (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)) {
                return true;
            }
        }

        // Verificando diagonais
        if ((tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
                (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)) {
            return true;
        }

        return false;
    }

    private static boolean tabuleiroCompleto() {
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void mudarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}
