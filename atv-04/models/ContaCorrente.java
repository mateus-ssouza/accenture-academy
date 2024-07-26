package models;

import errors.DepositoInvalidoException;
import errors.EstouroSaqueException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContaCorrente {
    private Integer numero;
    private Cliente cliente;
    private Double saldo;
    private LocalDateTime data;
    private List<String> extrato;

    public ContaCorrente() {
        this.saldo = 0.0;
        this.extrato = new ArrayList<>();
    }

    public ContaCorrente(Cliente cliente, Integer numero, Double saldo, LocalDateTime data) {
        this.cliente = cliente;
        this.numero = numero;
        this.saldo = saldo;
        this.data = data;
        this.extrato = new ArrayList<>();
        this.extrato.add("Conta criada em " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                + " com saldo inicial de " + saldo);
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void depositar(Double valor) throws DepositoInvalidoException {
        if (valor <= 0) {
            throw new DepositoInvalidoException("O valor do depósito deve ser positivo.");
        }
        this.saldo += valor;
        this.extrato.add("Depósito de " + valor + " em "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    public void sacar(Double valor) throws EstouroSaqueException {
        if (valor <= 0) {
            throw new EstouroSaqueException("O valor do saque deve ser positivo.");
        }
        if (valor > this.saldo) {
            throw new EstouroSaqueException("Saldo insuficiente.");
        }
        this.saldo -= valor;
        this.extrato.add("Saque de " + valor + " em "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    public void transferir(ContaCorrente contaDestino, Double valor)
            throws EstouroSaqueException, DepositoInvalidoException {
        if (valor <= 0) {
            throw new DepositoInvalidoException("O valor da transferência deve ser positivo.");
        }
        if (valor > this.saldo) {
            throw new EstouroSaqueException("Saldo insuficiente.");
        }
        this.saldo -= valor;
        contaDestino.depositar(valor);
        this.extrato.add("Transferência de " + valor + " para a conta " + contaDestino.getNumero() + " em "
                + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
    }

    public void exibirExtrato() {
        System.out.println("Extrato da conta " + this.numero + ":");
        for (String registro : this.extrato) {
            System.out.println(registro);
        }
    }
}
