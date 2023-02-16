package Programa;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Contas {
	
	private StringBuffer numConta;
	
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
	
	public void resgatar(double valor, ContaCorrente destino) {
		if (getSaldo() >= valor) {
		this.saldo = getSaldo() - valor;
		destino.depositar(valor);
		} else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente! \nSaldo atual: " + getSaldo());
		}
	}

	public StringBuffer getNumConta() {
		return numConta;
	}

	public void setNumConta(StringBuffer numConta) {
		this.numConta = numConta;
	}

}
