package Programa;

import java.security.SecureRandom;

import javax.swing.JOptionPane;

public class Conta {

	// "\nID:" + this.getID() Add ID quando criar Login Gerente

	// Atributos

	GeradorSenha g = new GeradorSenha();
	private static int contadorDeContas = 0;
	SecureRandom rand = new SecureRandom();
	// Setting the upper bound to generate
	// the random numbers between the specific range
	int upperbound = 1000000;
	// Generating random values from 0 - 999
	// using nextInt()
	int geradorDeContas = rand.nextInt(upperbound);

	private int ID;
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	String senha = g.getRandomString(5);

	// Métodos Personalizados:

	// Retornar alguns dados do cliente
	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() + "\nNome: " + this.pessoa.getNome() + "\nCPF: "
				+ this.pessoa.getCpf() + "\nE-mail: " + this.pessoa.getEmail() + "\nSaldo: "
				+ Utils.doubleToString(this.getSaldo()) + "\nSenha: " + this.getSenha() + "\n";
	}

	public void depositar(Double valor) {
		if (valor > 0) {
			this.setSaldo(this.getSaldo() + valor);
			JOptionPane.showMessageDialog(null,
					"Seu depósito de " + Utils.doubleToString(valor) + " foi realizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Impossível depositar valores negativos!");
		}
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

	public void transferir(Conta contaParaDeposito, Double valor) {
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

	// Métodos Especiais:
	// Constructor
	public Conta(Pessoa pessoa) {
		this.ID = contadorDeContas;
		this.numeroConta = geradorDeContas;
		this.pessoa = pessoa;
		contadorDeContas += 1;
	}

	// Getters and Setters
	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	private void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public int getID() {
		return ID;
	}

	private void setID(int iD) {
		ID = iD;
	}

	public String getSenha() {
		return senha;
	}

}
