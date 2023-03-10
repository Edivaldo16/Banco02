package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Contas {
	// "\nID:" + this.getID() Add ID quando criar Login Gerente

	// Atributos
	public static ArrayList<String> Se = new ArrayList<>();
	public static ArrayList<String> Co = new ArrayList<>();
	public static ArrayList<Integer> Con = new ArrayList<>();
	public static ArrayList<Pessoa> Pe = new ArrayList<>();

	GeradorSenha g = new GeradorSenha();
	GeradorConta gC = new GeradorConta();
	public static int contadorDeContas = 0;

	String geradorDeContas = gC.getRandomString(7);

	protected int ID;
	protected String numeroConta;
	public Pessoa pessoa;
	protected Double saldo;
	protected String senha;

	// Métodos Personalizados:

	// Retornar alguns dados do cliente
	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() + "\nNome: " + this.pessoa.getNome() + "\nCPF: "
				+ this.pessoa.getCpf() + "\nE-mail: " + this.pessoa.getEmail() + "\nSaldo: "
				+ Utils.doubleToString(this.getSaldo()) + "\nSenha: " + this.getSenha() + "\n";
	}

	// Métodos Especiais:
	// Constructor
	public Contas() {
	
	}
		
	public Contas(Pessoa pessoa) {
			this.ID = contadorDeContas;
			this.numeroConta = geradorDeContas;
			this.pessoa = pessoa;
			this.senha = g.getRandomString(5);
			this.saldo = 0.0;
			Se.add(this.senha);
			Co.add(this.numeroConta);
			Con.add(this.ID);
			Pe.add(this.pessoa);
			contadorDeContas += 1;
		}

	// Getters and Setters
	public String getNumeroConta() {
		return numeroConta;
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

	protected void setSaldo(Double saldo) {
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
