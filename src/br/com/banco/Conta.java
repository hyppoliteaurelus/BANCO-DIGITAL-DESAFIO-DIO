package br.com.banco;

// Classe Conta
public abstract class Conta {
    protected double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public abstract boolean transferir(Conta destino, double valor);

    public double getSaldo() {
        return saldo;
    }
}

