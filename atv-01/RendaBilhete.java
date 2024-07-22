import java.util.Scanner;

public class RendaBilhete {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preços das classes
        final double CLASSE_A = 50.0;
        final double CLASSE_B = 30.0;
        final double CLASSE_C = 20.0;

        // Pergunta quantos bilhetes de cada classe foram vendidos
        System.out.print("Quantos bilhetes da Classe A foram vendidos? ");
        int bilhetesA = scanner.nextInt();

        System.out.print("Quantos bilhetes da Classe B foram vendidos? ");
        int bilhetesB = scanner.nextInt();

        System.out.print("Quantos bilhetes da Classe C foram vendidos? ");
        int bilhetesC = scanner.nextInt();

        // Calcula a renda gerada pela venda dos ingressos
        double rendaA = bilhetesA * CLASSE_A;
        double rendaB = bilhetesB * CLASSE_B;
        double rendaC = bilhetesC * CLASSE_C;
        double rendaTotal = rendaA + rendaB + rendaC;

        // Exibe a renda gerada por classe e total
        System.out.printf("Renda gerada pela Classe A: R$%.2f%n", rendaA);
        System.out.printf("Renda gerada pela Classe B: R$%.2f%n", rendaB);
        System.out.printf("Renda gerada pela Classe C: R$%.2f%n", rendaC);
        System.out.printf("Renda total: R$%.2f", rendaTotal);

        scanner.close();
    }
}
