import java.time.LocalDateTime;

import models.Cliente;
import models.ContaCorrente;
import errors.DepositoInvalidoException;
import errors.EstouroSaqueException;

public class PrincipalContaCorrente {
    public static void main(String[] args) {
        // Instanciar a conta1
        Cliente cliente1 = new Cliente("João", "Silva", "123.456.789-00");
        ContaCorrente conta1 = new ContaCorrente(cliente1, 1001, 0.0, LocalDateTime.now());

        // Exibir saldo inicial
        System.out.println("\n******* EXIBINDO SALDO INICIAL ********");
        System.out.println("Saldo inicial da conta1: " + conta1.getSaldo());
        System.out.println("***************************************\n");
        
        // Fazendo um depósito
        System.out.println("\n******** FAZENDO UM DEPÓSITO **********");
        try {
            conta1.depositar(500.0);
            System.out.println("Saldo após depósito da conta1: " + conta1.getSaldo());
        } catch (DepositoInvalidoException e) {
            System.out.println("Erro ao depositar: " + e.getMessage());
        }
        System.out.println("***************************************\n");

        // Criando instancia de conta2
        Cliente cliente2 = new Cliente("Maria", "Souza", "987.654.321-00");
        ContaCorrente conta2 = new ContaCorrente(cliente2, 1002, 0.0, LocalDateTime.now());

        // Exibir o nome do cliente da conta1
        System.out.println("\n****** EXIBINDO NOME CLIENTE 1 ********");
        System.out.println("Nome do cliente da conta1: " + conta1.getCliente().getNomeCompleto());
        System.out.println("***************************************\n");
        
        // Fazer um saque na conta1
        System.out.println("\n***** REALIZANDO SAQUE CONTA 1 ********");
        try {
            conta1.sacar(100.0);
            System.out.println("Saldo após saque da conta1: " + conta1.getSaldo());
        } catch (EstouroSaqueException e) {
            System.out.println("Erro ao sacar: " + e.getMessage());
        }
        System.out.println("***************************************\n");
        
        // Tentar transferir valor maior que o saldo disponível
        System.out.println("\n************ TRANS. MAIOR QUE O SALDO **************");
        Double valorTransferencia = 600.0;
        System.out.println("Tentando transferir " + valorTransferencia + " da conta1 para a conta2...");
        try {
            conta1.transferir(conta2, valorTransferencia);
            System.out.println("Saldo após transferência da conta1: " + conta1.getSaldo());
            System.out.println("Saldo após receber transferência da conta2: " + conta2.getSaldo());
        } catch (EstouroSaqueException | DepositoInvalidoException e) {
            System.out.println("Erro na transferência: " + e.getMessage());
        }
        System.out.println("****************************************************\n");

        // Tentar depósito valor negativo
        System.out.println("\n************ FAZENDO UM DEPÓSITO NEGATIVO ***************");
        try {
            conta1.depositar(-500.0);
            System.out.println("Saldo após depósito da conta1: " + conta1.getSaldo());
        } catch (DepositoInvalidoException e) {
            System.out.println("Erro ao depositar: " + e.getMessage());
        }
        System.out.println("*********************************************************\n");
        
        // Exibir extrato da conta1
        System.out.println("\n********************* EXTRATO CONTA 1 ************************");
        conta1.exibirExtrato();
        System.out.println("**************************************************************\n");
        

        // Exibir extrato da conta2
        System.out.println("\n********************* EXTRATO CONTA 2 ************************");
        conta2.exibirExtrato();
        System.out.println("**************************************************************\n");
    }
}
