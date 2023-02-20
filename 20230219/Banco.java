package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Banco {
	// Implementação Agência Bancária com JOptionPane
	static ArrayList<ContaCorrente> contasCorrente;
	static ArrayList<ContaPoupanca> contasPoupanca;
	static ArrayList<Contas> contas;

	public static void main(String[] args) {
		contasCorrente = new ArrayList<ContaCorrente>();
		contasPoupanca = new ArrayList<ContaPoupanca>();
		contas = new ArrayList<Contas>();

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

	// Provavelmente tem que inserir ContaCorrente e ContaPoupanca pra dar certo
	public static void menuCliente(Contas a, ContaCorrente b, ContaPoupanca c) {
		int menu = Integer.parseInt(JOptionPane.showInputDialog(
				"                                   -----------------------------------------------------------------------"
						+ "                                            \n                                   |--------------Bem vindo/a ao Banco Fuctura--------------|"
						+ "                                            \n                                    Cliente: "
						+ a.getPessoa().getNome() + "                                                           "
						+ "                                            \n                                    CPF: "
						+ a.getPessoa().getCpf() + "                                              "
						+ "\n                                    E-mail: " + a.getPessoa().getEmail()
						+ "                                    "
						+ "                                            \n                                   |-----------------------------------------------------------------------|"
						+ "                                            \n                                   |---------------Escolha uma das operações----------------|"
						+ "                                            \n                                   |-----------------------------------------------------------------------|"
						+ "                                            \n                                   |            Opção 1 - Mudar Dados Cadastrais               |"
						+ "                                            \n                                   |            Opção 2 - Acessar Conta Corrente                |"
						+ "                                            \n                                   |            Opção 3 - Acessar Conta Poupança               |"
						+ "                                            \n                                   |            Opção 4 - Sair                                                    |"
						+ "                                            \n                                   -----------------------------------------------------------------------"));
		switch (menu) {
		case 1:
			modificarCadastro(a, b, c);
			break;
		case 2:
			// acessarContaCorrente();
			break;
		case 3:
			// acessarContaPoupanca();
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Obrigado por usar os serviços da nossa agência!");
			menuInicial();
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

	public static void criarConta() {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
		pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
		pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));

		Contas contasC = new Contas(pessoa);
		ContaCorrente cc = new ContaCorrente(contasC);
		ContaPoupanca cp = new ContaPoupanca(contasC);

		contas.add(contasC);
		contasCorrente.add(cc);
		contasPoupanca.add(cp);

		JOptionPane.showMessageDialog(null,
				"Confira seus dados!" + "\nConta Corrente: " + cc.getNumeroConta() + "\nConta Poupança: "
						+ cp.getNumeroConta() + "\nSenha: " + contasC.getSenha() + "\nNome: " + contasC.pessoa.getNome()
						+ "\nCPF: " + contasC.pessoa.getCpf() + "\nE-mail: " + contasC.pessoa.getEmail());
		// Futuramente senha randômica
		JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");

		menuInicial();
		// menu();

	}

	public static void logarConta() {
		Contas conta = null;
		ContaCorrente cc = null;
		ContaPoupanca cp = null;

		String numCPF = JOptionPane.showInputDialog("CPF: ");
		// int senha = Integer.parseInt(JOptionPane.showInputDialog("Senha: "));
		String senha = JOptionPane.showInputDialog("Senha: ");
		// encontrarLogin(numCPF, senha);
		// Conta conta = encontrarSenha(senha);
		conta = encontrarLogin(numCPF, senha);
		cc = encontrarLogi(numCPF, senha);
		cp = encontrarLog(numCPF, senha);
		// Conta c = encontrarCPF(numCPF);

		if (conta != null) {
			menuCliente(conta,cc,cp);
			// System.out.println(conta.getID());

		} else {
			JOptionPane.showMessageDialog(null, "A conta não foi encontrada!");
			menuInicial();
		}

	}

	// Provavelmente tem que inserir ContaCorrente e ContaPoupanca pra dar certo
	public static void modificarCadastro(Contas a, ContaCorrente b, ContaPoupanca c) {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
		pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
		pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));

		a = new Contas(pessoa);
		b = new ContaCorrente(a);
		c = new ContaPoupanca(a);

		// Ou é contasSC.getID - 1,a
		contas.set(a.getID()-1, a);
		contasCorrente.set(b.getID()-1, b);
		contasPoupanca.set(c.getID()-1, c);

		//JOptionPane.showMessageDialog(null, a.getPessoa());

		JOptionPane.showMessageDialog(null,
				"Confira seus dados!" + "\nConta Corrente: " + b.getNumeroConta() + "\nConta Poupança: "
						+ c.getNumeroConta() + "\nSenha: " + a.getSenha() + "\nNome: " + a.pessoa.getNome()
						+ "\nCPF: " + a.pessoa.getCpf() + "\nE-mail: " + a.pessoa.getEmail());

		JOptionPane.showMessageDialog(null, "Sua conta foi modificada com sucesso!");
		menuCliente(a, b, c);

	}

	private static Contas encontrarConta(String numeroConta, ArrayList<Contas> contasBancarias) {
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

	// encontrarLogin tipo "Contas"
	private static Contas encontrarLogin(String numeroCPF, String numeroSenha) {

		Contas conta = null;
		if (contas.size() > 0) {
			for (Contas c : contas) {
				if (c.getPessoa().getCpf().equals(numeroCPF) && c.getSenha().equals(numeroSenha)) {
					conta = c;
				}

			}
		}
		return conta;

	}

	// encontrarLogin tipo "ContaCorrente"
	private static ContaCorrente encontrarLogi(String numeroCPF, String numeroSenha) {

		ContaCorrente conta = null;
		if (contas.size() > 0) {
			for (ContaCorrente c : contasCorrente) {
				if (c.getPessoa().getCpf().equals(numeroCPF) && c.getSenha().equals(numeroSenha)) {
					conta = c;
				}

			}
		}
		return conta;

	}

	// encontrarLogin tipo "Contas"
	private static ContaPoupanca encontrarLog(String numeroCPF, String numeroSenha) {

		ContaPoupanca conta = null;
		if (contasPoupanca.size() > 0) {
			for (ContaPoupanca c : contasPoupanca) {
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
							+ a.getPessoa().getNome()
							+ "                  \n                                   |ContaCorrente:                      |"
							+ a.numeroConta
							+ "                                            \n                                   |CPF: "
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
				a.mostrarSaldo();
				;
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
