package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Banco {
	// Implementação Agência Bancária com JOptionPane
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();

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
						+ "                                            \n                                   |            Opção 2 - Login       |"
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
			menu();
			break;

		}
	}
	
	public static void menuCliente01() {
		int menuCliente01 = Integer.parseInt(JOptionPane.showInputDialog(
				"                                   ------------------------------------------------------"
						+ "                                            \n                                   |-----Bem vindos ao Banco Fuctura-----|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |------Escolha uma das operações-------|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |            Opção 1 - Criar Conta               |"
						+ "                                            \n                                   |            Opção 2 - Login       |"
						+ "                                            \n                                   |            Opção 3 - Sair                            |"
						+ "                                            \n                                   ------------------------------------------------------"));
		switch (menuCliente01) {
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
			menu();
			break;
		}
		
		modificarCadastro();
	}

	//Método Gerente
	public static void menu() {

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
			depositar();
			break;
		case 3:
			sacar();
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
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!!");
			menu();
			break;

		}

	}
	
	public static void menuCliente02(Conta a) {
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
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
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
			System.exit(0);
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!!");
			menu();
			break;

		}
	}

	public static void criarConta() {
		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
		pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
		pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));

		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);
		JOptionPane.showMessageDialog(null,
				"Confira seus dados!" + "\nConta Corrente: " + conta.getNumeroConta() + "\nConta Poupança: "
						+ conta.getNumeroConta() + "\nSenha: " + conta.getSenha() + "\nNome: " + pessoa.getNome()
						+ "\nCPF: " + pessoa.getCpf() + "\nE-mail: " + pessoa.getEmail());
		// Futuramente senha randômica
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");

		menuInicial();
		// menu();

	}

	public static void logarConta() {

		String numCPF = JOptionPane.showInputDialog("CPF: ");
		// int senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
		String senha = JOptionPane.showInputDialog("Senha: ");
		// encontrarLogin(numCPF, senha);
		// Conta conta = encontrarSenha(senha);
		Conta conta = encontrarLogin(numCPF, senha);
		// Conta c = encontrarCPF(numCPF);

		if (conta != null) {
			menuCliente02(conta);	

		} else {
			JOptionPane.showMessageDialog(null, "A conta não foi encontrada!");
			menuInicial();
		}

	}

	public static void modificarCadastro() {
		int numConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
		Conta conta = encontrarConta(numConta);

		Pessoa pessoa = new Pessoa();

		if (conta != null) {
			pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
			pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
			pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));

			Conta c = new Conta(pessoa);
			contasBancarias.set(conta.getID(), c);
			JOptionPane.showMessageDialog(null, c.getPessoa());

			JOptionPane.showMessageDialog(null,
					"Confira seus dados!" + "\nConta Corrente: " + conta.getNumeroConta() + "\nConta Poupança: "
							+ conta.getNumeroConta() + "\nSenha: " + conta.getSenha() + "\nNome: " + pessoa.getNome()
							+ "\nCPF: " + pessoa.getCpf() + "\nE-mail: " + pessoa.getEmail());
			// Futuramente senha randômica
			JOptionPane.showMessageDialog(null, "Sua conta foi modificada com sucesso!");

			menu();

		} else {
			JOptionPane.showMessageDialog(null, "A conta " + numConta + " não foi encontrada!");
		}

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta) {
					conta = c;
				}

			}
		}
		return conta;
	}

	private static Conta encontrarSenha(String senha) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getSenha().equals(senha)) {
					conta = c;
				}

			}
		}
		return conta;
	}

	private static Conta encontrarCPF(String cpf) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getPessoa().getCpf().equals(cpf)) {
					conta = c;
				}

			}
		}
		return conta;
	}

	private static Conta encontrarLogin(String numeroCPF, String numeroSenha) {

		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getPessoa().getCpf().equals(numeroCPF) && c.getSenha().equals(numeroSenha)) {
					conta = c;
				}

			}
		}
		return conta;

	}

	public static void depositar() {

		int numConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
		Conta conta = encontrarConta(numConta);

		if (conta != null) {
			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar: "));
			conta.depositar(valorDeposito);

		} else {
			JOptionPane.showMessageDialog(null, "A conta " + numConta + " não foi encontrada!");
		}
		menu();
	}

	public static void sacar() {
		int numConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta: "));
		Conta conta = encontrarConta(numConta);

		if (conta != null) {
			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar: "));
			conta.sacar(valorSaque);

		} else {
			JOptionPane.showMessageDialog(null, "A conta " + numConta + " não foi encontrada!");
		}
		menu();

	}

	public static void transferir() {
		int numContaRe = Integer.parseInt(JOptionPane.showInputDialog("Número da conta remetente: "));

		Conta contaRe = encontrarConta(numContaRe);

		if (contaRe != null) {
			int numContaDe = Integer.parseInt(JOptionPane.showInputDialog("Digite a conta do destinatário: "));

			Conta contaDe = encontrarConta(numContaDe);
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
		menu();

	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				JOptionPane.showMessageDialog(null, conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
		}
		menu();
	}

}
