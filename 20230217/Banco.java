package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Banco {
	// Implementação Agência Bancária com JOptionPane
	static ArrayList<ContaCorrente> contasBancarias;
	static ArrayList<ContaPoupanca> contaspoupancas;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<ContaCorrente>();
		contaspoupancas = new ArrayList<ContaPoupanca>();

		// menu(); // Opções disponíveis caixa eletrônico
		menuInicial();
	}

	public static void menuInicial() {
		int menuInicial = Integer.parseInt(JOptionPane.showInputDialog(
				"                                   ------------------------------------------------------"
						+ "                                            \n                                   |-----Bem vindos ao Banco Fuctura-----|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |------Escolha uma das operações-------|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |            Opção 1 - Criar Conta               |"
						+ "                                            \n                                   |            Opção 2 - Login                         |"
						+ "                                            \n                                   |            Opção 3 - Sair                            |"
						+ "                                            \n                                   ------------------------------------------------------"));
		switch (menuInicial) {
		case 1:
			criarConta();
			break;
		case 2:
			logarConta();
			break;
		case 3:
			JOptionPane.showMessageDialog(null, "Obrigado por usar os serviços da nossa agência!");
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!!");
			menuInicial();
			break;

		}
	}

	// Método Gerente
	public static void menuGerente() {

		int menu = Integer.parseInt(JOptionPane.showInputDialog(
				"                                   ------------------------------------------------------"
						+ "                                            \n                                   |-----Bem vindos ao Banco Fuctura-----|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |------Escolha uma das operações-------|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |            Opção 1 - Criar Conta               |"
						+ "                                            \n                                   |            Opção 2 - Depositar                  |"
						+ "                                            \n                                   |            Opção 3 - Sacar                         |"
						+ "                                            \n                                   |            Opção 4 - Transferir                 |"
						+ "                                            \n                                   |            Opção 5 - Listar                         |"
						+ "                                            \n                                   |            Opção 6 - Sair                            |"
						+ "                                            \n                                   ------------------------------------------------------"));

		switch (menu) {
		case 1:
			criarConta();
			break;
		case 2:
			// depositar();
			break;
		case 3:
			// sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			// Não foi implementado pelo cara do vídeo
			// Talvez devido o system.exit();
			// sair();
			JOptionPane.showMessageDialog(null, "Obrigado por usar os serviços da nossa agência!");
			menuInicial();
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!!");
			menuGerente();
			break;

		}

	}

	public static void menuCliente(ContaCorrente a) {
		int menu = Integer.parseInt(JOptionPane.showInputDialog(
				"                                   ------------------------------------------------------"
						+ "                                            \n                                   |-----Bem vindos ao Banco Fuctura-----|"
						+ "                                            \n                                   |Cliente: "
						+ a.getPessoa().getNome() + "|"
						+ "                                            \n                                   |CPF: "
						+ a.getPessoa().getEmail() + "|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |------Escolha uma das operações-------|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |            Opção 1 - Mudar Dados Cadastrais               |"
						+ "                                            \n                                   |            Opção 2 - Acessar Conta Corrente                  |"
						+ "                                            \n                                   |            Opção 3 - Acessar Conta Poupança                         |"
						+ "                                            \n                                   |            Opção 4 - Sair                            |"
						+ "                                            \n                                   ------------------------------------------------------"));
		switch (menu) {
		case 1:
			modificarCadastro(a);
			break;
		case 2:
			// acessarContaCorrente();
			break;
		case 3:
			// acessarContaPoupanca();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Obrigado por usar os serviços da nossa agência!");
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!!");
			menuInicial();
			break;

		}
	}

	public static void criarConta() {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
		pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
		pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));

		ContaCorrente conta = new ContaCorrente(pessoa);
		ContaPoupanca cp = new ContaPoupanca();

		String conv = Integer.toString(conta.getNumeroConta());
		StringBuffer buffer = new StringBuffer(conv);
		String a = buffer.insert(5, "-").toString();

		// Verificar erro numa classe teste

		contasBancarias.add(conta);
		// contaspoupancas.add(cp);
		JOptionPane.showMessageDialog(null,
				"Confira seus dados!" + "\nConta Corrente: " + conta.getNumeroConta() + "\nConta Poupança: " + a
						+ "\nSenha: " + conta.getSenha() + "\nNome: " + conta.pessoa.getNome() + "\nCPF: "
						+ conta.pessoa.getCpf() + "\nE-mail: " + conta.pessoa.getEmail());
		// Futuramente senha randômica
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");

		menuInicial();
		// menu();

	}

	public static void logarConta() {
		ContaCorrente conta = null;

		String numCPF = JOptionPane.showInputDialog("CPF: ");
		// int senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
		String senha = JOptionPane.showInputDialog("Senha: ");
		// encontrarLogin(numCPF, senha);
		// Conta conta = encontrarSenha(senha);
		conta = encontrarLogin(numCPF, senha);
		// Conta c = encontrarCPF(numCPF);

		if (conta != null) {
			menuCliente(conta);

		} else {
			JOptionPane.showMessageDialog(null, "A conta não foi encontrada!");
			menuInicial();
		}

	}

	public static void modificarCadastro(ContaCorrente a) {

		Contas conta = encontrarConta(a.getNumeroConta());

		Pessoa pessoa = new Pessoa();

		if (conta != null) {
			pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
			pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
			pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));

			ContaCorrente d = new ContaCorrente();
			contasBancarias.set(d.getID(), a);
			JOptionPane.showMessageDialog(null, a.getPessoa());

			JOptionPane.showMessageDialog(null,
					"Confira seus dados!" + "\nConta Corrente: " + conta.getNumeroConta() + "\nConta Poupança: "
							+ conta.getNumeroConta() + "\nSenha: " + conta.getSenha() + "\nNome: " + pessoa.getNome()
							+ "\nCPF: " + pessoa.getCpf() + "\nE-mail: " + pessoa.getEmail());

			JOptionPane.showMessageDialog(null, "Sua conta foi modificada com sucesso!");
			menuCliente(a);

		} else {
			// JOptionPane.showMessageDialog(null, "A conta " + numConta + " não foi
			// encontrada!");
		}

	}

	private static Contas encontrarConta(int numeroConta) {
		Contas conta = null;
		if (contasBancarias.size() > 0) {
			for (Contas c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c;
				}

			}
		}
		return conta;
	}

	private static Contas encontrarSenha(String senha) {
		Contas conta = null;
		if (contasBancarias.size() > 0) {
			for (Contas c : contasBancarias) {
				if (c.getSenha().equals(senha)) {
					conta = c;
				}

			}
		}
		return conta;
	}

	private static Contas encontrarCPF(String cpf) {
		Contas conta = null;
		if (contasBancarias.size() > 0) {
			for (Contas c : contasBancarias) {
				if (c.getPessoa().getCpf().equals(cpf)) {
					conta = c;
				}

			}
		}
		return conta;
	}

	private static ContaCorrente encontrarLogin(String numeroCPF, String numeroSenha) {

		ContaCorrente conta = null;
		if (contasBancarias.size() > 0) {
			for (ContaCorrente c : contasBancarias) {
				if (c.getPessoa().getCpf().equals(numeroCPF) && c.getSenha().equals(numeroSenha)) {
					conta = c;
				}

			}
		}
		return conta;

	}

	public static void depositar(ContaCorrente a) {

		int numConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
		a = encontrarConta(numConta);

		if (conta != null) {
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar: "));
			conta.depositar();

		} else {
			JOptionPane.showMessageDialog(null, "A conta " + numConta + " não foi encontrada!");
		}
		menuCliente(a);
	}

	public static void sacar(ContaCorrente a) {

		Contas conta = encontrarConta(a.getNumeroConta());

		if (conta != null) {
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar: "));
			if (valorSaque <= a.getSaldo()) {
				a.saldo = a.getSaldo() - valorSaque;
				JOptionPane.showMessageDialog(null,
						"O saque de " + Utils.doubleToString(valorSaque) + " foi realizado!");
				JOptionPane.showMessageDialog(null, "Seu saldo atual é " + Utils.doubleToString(a.getSaldo()));
			}

		} else {
			JOptionPane.showMessageDialog(null, "A conta não foi encontrada!");
		}
		menuCliente(a);

	}

	public static void transferir() {
		int numContaRe = Integer.parseInt(JOptionPane.showInputDialog("Número da conta remetente: "));

		Contas contaRe = encontrarConta(numContaRe);

		if (contaRe != null) {
			int numContaDe = Integer.parseInt(JOptionPane.showInputDialog("Digite a conta do destinatário: "));

			Contas contaDe = encontrarConta(numContaDe);
			if (contaDe != null) {
				Double valorTransferencia = Double
						.parseDouble(JOptionPane.showInputDialog("Qual valor deseja transferir: "));
				contaRe.transferir(contaDe, valorTransferencia);
			} else {
				JOptionPane.showMessageDialog(null, "A conta Destinatário " + numContaDe + " não foi encontrada!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "A conta Remetente " + numContaRe + " não foi encontrada!");
		}
		// Ver pra qual menu vai
		// menu();

	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Contas conta : contasBancarias) {
				JOptionPane.showMessageDialog(null, conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
		}
		menuGerente();
	}

	public void acessarContaCorrente(ContaCorrente a) {
		{
			int menu = Integer.parseInt(JOptionPane.showInputDialog(
					"                                   ------------------------------------------------------"
							+ "                                            \n                                   |-----Bem vindos ao Banco Fuctura-----|"
							+ "                                            \n                                   |Cliente: "
							+ a.getPessoa().getNome() + "                  \n                                   |ContaCorrente:                      |" + a.numeroConta+                                                      
							 "                                            \n                                   |CPF: "
							+ a.getPessoa().getEmail() + "|"
							+ "                                            \n                                   |----------------------------------------------------|"
							+ "                                            \n                                   |------Escolha uma das operações-------|"
							+ "                                            \n                                   |----------------------------------------------------|"
							+ "                                            \n                                   |            Opção 1 - Saldo               |"
							+ "                                            \n                                   |            Opção 2 - Sacar                 |"
							+ "                                            \n                                   |            Opção 3 - Transferir                        |"
							+ "                                            \n                                   |            Opção 4 - Sair                            |"
							+ "                                            \n                                   ------------------------------------------------------"));
			switch (menu) {
			case 1:
				a.mostrarSaldo();;				
				break;
			case 2:
				a.sacar();
				break;
			case 3:
				transferir();
				break;
			case 4:
				JOptionPane.showMessageDialog(null, "Obrigado por usar os serviços da nossa agência!");
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!!");
				menuInicial();
				break;

			}	
		
		}

	}
}
