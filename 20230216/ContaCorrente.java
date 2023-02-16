package Programa;

import javax.swing.JOptionPane;

public abstract class ContaCorrente extends Contas{
	public ContaCorrente() {
	}

	public ContaCorrente(Pessoa pessoa, int numero, double saldoInicial) {
		this.ID = contadorDeContas;
		this.numeroConta = Integer.parseInt(geradorDeContas);
		this.pessoa = pessoa;
		//Gerar mesma senha
		this.senha = g.getRandomString(5);
		this.saldo = 0.0;
		contadorDeContas += 1;
	}

	public ContaCorrente(Pessoa pessoa, int numero) {
		this.ID = contadorDeContas;
		this.numeroConta = Integer.parseInt(geradorDeContas);
		this.pessoa = pessoa;
		//Gerar mesma senha
		this.senha = g.getRandomString(5);
		this.saldo = 0.0;
		contadorDeContas += 1;
	}

	public void sacar(Double valor) {
		if (valor > 0 && valor <= this.getSaldo()) {
			this.setSaldo(this.getSaldo() - valor);
			JOptionPane.showMessageDialog(null,
					"Seu saque de " + Utils.doubleToString(valor) + " foi realizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Impossível sacar valores maiores que o saldo disponível!");
		}
	}

	@Override
	public void depositar(Double valor) {
		if (valor > 0) {
			this.setSaldo(this.getSaldo() + valor);
			JOptionPane.showMessageDialog(null,
					"Seu depósito de " + Utils.doubleToString(valor) + " foi realizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Depósito não realizado. Verique o valor inserido!");
		}
	}
	
	@Override
	public void dadosDaConta(Contas conta) {
		//Criar classe feito Utils: Conta Poupança: 24589-0 Conta Corrente: 245890 
		JOptionPane.showMessageDialog(null,"Conta Corrente: "+conta.getNumeroConta());
	}

	@Override
	public void mostrarSaldo() {
		JOptionPane.showMessageDialog(null,"Saldo Atual: " + Utils.doubleToString(this.getSaldo()));
	}

	public void aplicar(double valor, ContaPoupanca destino) {
		if (this.getSaldo() >= valor) {
			this.saldo = this.getSaldo() - valor;
			destino.depositar(valor);
		}
	}
	@Override
	public void transferir(Contas contaParaDeposito, Double valor) {
		if (valor > 0 && valor <= this.getSaldo()) {
			this.setSaldo(this.getSaldo() - valor);
			contaParaDeposito.setSaldo(contaParaDeposito.getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Valor de " + Utils.doubleToString(valor)
					+ " depositado com sucesso na conta " + contaParaDeposito.getNumeroConta());
		} else {
			JOptionPane.showMessageDialog(null,
					"Impossível transferir. Verifique seu saldo e/ou se o valor digitado é negativo!");
		}

	}

}
