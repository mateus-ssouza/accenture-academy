import java.util.Scanner;

public class LocalizaNumero {
    public static void main(String[] args) {
        int vetor[] = {1, 3, 5, 8, 9, 10};
        Scanner scanner = new Scanner(System.in);

        // Pergunta o número a ser procurado no vetor
        System.out.print("Digite o número a ser procurado: ");
        int numero = scanner.nextInt();

        boolean achou = false;
        int posicao = -1;

        // Laço para percorrer o vetor
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                achou = true;
                posicao = i;
                break;
            }
        }

        // Verificar se encontrou o número buscado
        if (achou) {
            System.out.println("Achei");
            System.out.printf("Na posição %d está localizado o número %d.", posicao, numero);
        } else {
            System.out.println("Não achei");
        }

        scanner.close();
    }
}
