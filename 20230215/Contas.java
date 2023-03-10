package Programa;

public class Contas {
	// "\nID:" + this.getID() Add ID quando criar Login Gerente

	// Atributos

	GeradorSenha g = new GeradorSenha();
	GeradorConta gC = new GeradorConta();
	private static int contadorDeContas = 0;

	String geradorDeContas = gC.getRandomString(7);

	private int ID;
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo;
	private String senha;

	// Métodos Personalizados:

	// Retornar alguns dados do cliente
	public String toString() {
		return "\nNúmero da Conta: " + this.getNumeroConta() + "\nNome: " + this.pessoa.getNome() + "\nCPF: "
				+ this.pessoa.getCpf() + "\nE-mail: " + this.pessoa.getEmail() + "\nSaldo: "
				+ Utils.doubleToString(this.getSaldo()) + "\nSenha: " + this.getSenha() + "\n";
	}

	public abstract void depositar(Double valor);
	public abstract void dadosDaConta();
	public abstract void mostrarSaldo();
	public abstract void transferir(Contas contaParaDeposito, Double valor);
		
	// Métodos Especiais:
	// Constructor
	
	public Contas() {
		this.ID = contadorDeContas;
		this.numeroConta = Integer.parseInt(geradorDeContas);
		this.pessoa = pessoa;
		this.senha = g.getRandomString(5);
		this.saldo = 0.0;
		contadorDeContas += 1;
	}
	
	public Contas(Pessoa pessoa) {
			this.ID = contadorDeContas;
			this.numeroConta = Integer.parseInt(geradorDeContas);
			this.pessoa = pessoa;
			this.senha = g.getRandomString(5);
			this.saldo = 0.0;
			contadorDeContas += 1;
		}

	// Getters and Setters
	public int getNumeroConta() {
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
