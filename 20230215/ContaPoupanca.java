package Programa;

public class ContaPoupanca extends Contas {
	public ContaCorrente() {
	}

	public ContaCorrente(String nome, int numero, double saldoInicial) {
	setTitular(nome);
	setNumConta(numero);
	depositar(saldoInicial);
	}

	public ContaCorrente(String nome, int numero) {
	setTitular(nome);
	setNumConta(numero);
	}

	public void sacar(double valor) {
		if (this.getSaldo() < valor) {
			System.out.println("Saque nao Realizado");
		} else {
			this.saldo = this.saldo - valor;
			System.out.println("Saque Realizado");
		}
	}

	@Override
	public void depositar(double valor) {
		this.saldo = this.getSaldo() + valor;
	}

	@Override
	public void mostrarSaldo() {
		System.out.printf("Saldo Atual Conta Corrente: %.2f\n", this.getSaldo());
	}

	public void aplicar(double valor, Poupanca destino) {
		if (this.getSaldo() >= valor) {
			this.saldo = this.getSaldo() - valor;
			destino.depositar(valor);
		}
	}

}
