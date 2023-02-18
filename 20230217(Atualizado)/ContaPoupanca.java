package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.util.ArrayList;

public class ContaPoupanca extends Contas {
	
	private String numConta;

	public ContaPoupanca() {

	}

	public ContaPoupanca(Contas conta) {
		this.ID = Con.get(0);
		StringBuffer sb = new StringBuffer(Co.get(0));
		String a = sb.insert(6, "-").toString();
		this.numeroConta = a;
		this.pessoa = Pe.get(0);
		this.senha = Se.get(0);
		this.saldo = 0.0;
	}
	
	// Não esquecer de definir ArrayList do tipo ContaPoupanca como objeto principal
	private static ContaPoupanca encontrarConta(String numeroConta, ArrayList<ContaPoupanca> contasBancarias) {
		ContaPoupanca conta = null;
		if (contasBancarias.size() > 0) {
			for (ContaPoupanca c : contasBancarias) {
				if (c.getNumeroConta().equals(numeroConta)) {
					conta = c;
				}
			}
		}
		return conta;
	}

	public void depositar(ContaPoupanca conta) {
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Depósito: "));
		if (valor > 0) {
			conta.setSaldo(conta.getSaldo() + valor);
			// conta.setSaldo(saldo);
			JOptionPane.showMessageDialog(null,
					"Seu depósito de " + Utils.doubleToString(valor) + " foi realizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Depósito não realizado. Verique o valor inserido!");
		}
	}

	public void mostrarSaldo(ContaPoupanca conta) {
		JOptionPane.showMessageDialog(null, "Saldo Atual: " + Utils.doubleToString(conta.getSaldo()));
	}

	public void transferir(ContaPoupanca conta, ArrayList<ContaPoupanca> contasBancarias) {
		String destinatario = JOptionPane.showInputDialog("Conta Poupanca destinatário: ");
		ContaPoupanca cp = encontrarConta(destinatario,contasBancarias);
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Tranferência de: "));
		if (valor > 0 && valor <= this.getSaldo()) {
			this.setSaldo(this.getSaldo() - valor);
			cp.setSaldo(cp.getSaldo() + valor);
			JOptionPane.showMessageDialog(null, "Valor de " + Utils.doubleToString(valor)
					+ " depositado com sucesso na conta " + cp.getNumeroConta());
		} else {
			JOptionPane.showMessageDialog(null,
					"Impossível transferir. Verifique seu saldo e/ou se o valor digitado é negativo!");
		}

	}

	public void resgatar(ContaCorrente destino) {
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Tranferência de: "));
		if (getSaldo() >= valor) {
			this.saldo = getSaldo() - valor;
			destino.depositar(destino);
		} else {
			JOptionPane.showMessageDialog(null, "Saldo insuficiente! \nSaldo atual: " + getSaldo());
		}
	}

	public String getNumConta() {
		return this.numConta;
	}

	public void setNumConta(String numConta) {

		this.numConta = numConta;
	}

}
