import br.com.banco.Banco;
import br.com.banco.ContaCorrente;
import br.com.banco.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        ContaCorrente contaCorrenteJoao = new ContaCorrente(1000);
        ContaPoupanca contaPoupancaMaria = new ContaPoupanca(500);

        banco.adicionarConta("001", contaCorrenteJoao);
        banco.adicionarConta("002", contaPoupancaMaria);

        banco.depositar("001", 200);
        banco.sacar("002", 100);
        banco.transferir("001", "002", 300);

        String extratoContaCorrente = banco.gerarExtrato("001");
        System.out.println(extratoContaCorrente);

        String extratoContaPoupanca = banco.gerarExtrato("002");
        System.out.println(extratoContaPoupanca);
    }
}
