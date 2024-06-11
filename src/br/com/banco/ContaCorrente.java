package br.com.banco;

// Classe ContaCorrente
public class ContaCorrente extends Conta {
    private static final double TAXA_TRANSFERENCIA = 0.05;

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        double valorComTaxa = valor * (1 + TAXA_TRANSFERENCIA);
        if (valorComTaxa <= saldo && destino != null) {
            saldo -= valorComTaxa;
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
