import java.time.LocalDateTime;

public class PrincipalContaCorrente {
    public static void main(String[] args) {
        // Instanciar a conta1
        Cliente cliente1 = new Cliente("João", "Silva", "123.456.789-00");
        ContaCorrente conta1 = new ContaCorrente(cliente1, 1001, 0.0, LocalDateTime.now());

        // Exibir saldo inicial e fazer um depósito
        System.out.println("Saldo inicial da conta1: " + conta1.getSaldo());
        conta1.depositar(500.0);
        System.out.println("Saldo após depósito da conta1: " + conta1.getSaldo());

        // Instanciar a conta2
        Cliente cliente2 = new Cliente("Maria", "Souza", "987.654.321-00");
        ContaCorrente conta2 = new ContaCorrente(cliente2, 1002, 0.0, LocalDateTime.now());

        // Exibir o nome do cliente da conta1
        System.out.println("Nome do cliente da conta1: " + conta1.getCliente().getNomeCompleto());

        // Fazer um saque na conta1
        conta1.sacar(100.0);
        System.out.println("Saldo após saque da conta1: " + conta1.getSaldo());

        // Tentar transferir valor maior que o saldo disponível
        Double valorTransferencia = 600.0;
        System.out.println("Tentando transferir " + valorTransferencia + " da conta1 para a conta2...");
        if (conta1.getSaldo() < valorTransferencia) {
            System.out.println("Saldo insuficiente para a transferência. Operação cancelada.");
        } else {
            conta1.transferir(conta2, valorTransferencia);
            System.out.println("Saldo após transferência da conta1: " + conta1.getSaldo());
            System.out.println("Saldo após receber transferência da conta2: " + conta2.getSaldo());
        }

        // Exibir extrato das contas
        System.out.println("\nExtrato da conta1:");
        conta1.exibirExtrato();

        System.out.println("\nExtrato da conta2:");
        conta2.exibirExtrato();
    }
}
