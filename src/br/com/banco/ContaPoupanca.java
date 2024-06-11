package br.com.banco;


// Classe ContaPoupanca
public class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (valor <= saldo && destino != null) {
            saldo -= valor;
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}
