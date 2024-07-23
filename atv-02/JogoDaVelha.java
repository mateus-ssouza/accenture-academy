import java.util.Scanner;

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
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }

            if (tabuleiroCompleto()) {
                System.out.println("O jogo terminou empatado!");
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
        System.out.println("Tabuleiro atual:");
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < TAM - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < TAM - 1) System.out.println("--+---+--");
        }
    }

    private static void jogadorMovimento() {
        Scanner scanner = new Scanner(System.in);
        int linha, coluna;

        while (true) {
            System.out.println("Jogador " + jogadorAtual + ", insira seu movimento EX.: [1 2]: ");
            linha = scanner.nextInt();
            coluna = scanner.nextInt();

            if (linha >= 0 && linha < TAM && coluna >= 0 && coluna < TAM && tabuleiro[linha][coluna] == ' ') {
                tabuleiro[linha][coluna] = jogadorAtual;
                break;
            } else {
                System.out.println("Não é um movimento válido, insira novamente.");
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

        // verificando diagonais
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
