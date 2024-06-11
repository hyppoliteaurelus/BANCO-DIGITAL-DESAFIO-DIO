package br.com.banco;

import java.util.HashMap;
import java.util.Map;

// Classe Banco
public class Banco {
    private Map<String, Conta> contas;

    public Banco() {
        this.contas = new HashMap<>();
    }

    public void adicionarConta(String numeroConta, Conta conta) {
        contas.put(numeroConta, conta);
    }

    public Conta obterConta(String numeroConta) {
        return contas.get(numeroConta);
    }

    public void depositar(String numeroConta, double valor) {
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            conta.depositar(valor);
            System.out.println("Depósito de " + valor + " realizado com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void sacar(String numeroConta, double valor) {
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            if (conta.sacar(valor)) {
                System.out.println("Saque de " + valor + " realizado com sucesso na conta " + numeroConta);
            } else {
                System.out.println("Saldo insuficiente na conta " + numeroConta);
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }

    public void transferir(String origem, String destino, double valor) {
        Conta contaOrigem = contas.get(origem);
        Conta contaDestino = contas.get(destino);
        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.transferir(contaDestino, valor)) {
                System.out.println("Transferência de " + valor + " realizada com sucesso da conta " + origem + " para a conta " + destino);
            } else {
                System.out.println("Transferência não realizada. Verifique o saldo da conta de origem.");
            }
        } else {
            System.out.println("Conta de origem ou destino não encontrada.");
        }
    }

    public String gerarExtrato(String numeroConta) {
        Conta conta = contas.get(numeroConta);
        if (conta != null) {
            StringBuilder extrato = new StringBuilder();
            extrato.append("Extrato da Conta ").append(numeroConta).append(":\n");
            // Aqui você pode adicionar mais informações ao extrato, como histórico de transações, saldo atual, etc.
            extrato.append("Saldo Atual: ").append(conta.getSaldo());
            return extrato.toString();
        } else {
            return "Conta não encontrada.";
        }
    }
}
