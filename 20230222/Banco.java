package Programa;

import java.util.ArrayList;

import javax.swing.JOptionPane;

//Atualização: 20/02/2023
//O que falta:
//01 - Tratar erro "java.lang.NumberFormatException", possivelmente com Try e Exception -> OK*
//     *Ver se existe a possibilidade de Ok e Cancel retornarem para seus menus específicos
//02 - Garantir que não existam cadastros com mesmo CPF -> OK
//03 - Garantir que o cpf tenham 11 digitos  que sejam apresentados segundo formato:
//     "000.000.000 - 05". Provavelmente usar Stringbufferr. -> OK
//04 - Transformar Classe Contas para abstract e fazer que os métodos 
//     mostrarSaldo(), depositar() sejam métodos abstratos.
//     Fazendo isso a ArrayList<Contas> e todos os objetos do tipo "Contas", serão eliminados.
/*
 *  if (entrada == null) {
                break;
            } else if (!"1".equals(entrada) && !"2".equals(entrada) && !"3".equals(entrada) && !"4".equals(entrada) && !"0".equals(entrada)) {
                JOptionPane.showMessageDialog(null, "Valor digitado inválido", "Sistema de Cadastro 1.0", 2);
            } else {
                opcao = Integer.parseInt(entrada);
            }
 */
// Links:
// https://www.alura.com.br/artigos/verificar-se-e-letra-ou-numero-no-java?gclid=CjwKCAiAl9efBhAkEiwA4ToripuEY2rk9ro_Ou1qfJNvEVfBgv3G45Xot8sGF6di_NdD_fti7IcPlRoC08QQAvD_BwE
public class Banco {
	// Implementação Agência Bancária com JOptionPane
	static ArrayList<ContaCorrente> contasCorrente;
	static ArrayList<ContaPoupanca> contasPoupanca;
	static ArrayList<Contas> contas;

	public static void main(String[] args) {
		contasCorrente = new ArrayList<ContaCorrente>();
		contasPoupanca = new ArrayList<ContaPoupanca>();
		contas = new ArrayList<Contas>();

		menuInicial();
	}

	public static void menuInicial() {
		String m = JOptionPane.showInputDialog(
				"                                   ------------------------------------------------------"
						+ "                                            \n                                   |-----Bem vindos ao Banco Fuctura-----|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |------Escolha uma das operações-------|"
						+ "                                            \n                                   |----------------------------------------------------|"
						+ "                                            \n                                   |            Opção 1 - Criar Conta               |"
						+ "                                            \n                                   |            Opção 2 - Login                         |"
						+ "                                            \n                                   |            Opção 3 - Sair                            |"
						+ "                                            \n                                   ------------------------------------------------------");

		if (m == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuInicial();
		} else if (m.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuInicial();
		} else {
			try {
				int menuInicial = Integer.parseInt(m);
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
					JOptionPane.showMessageDialog(null, "Opção inválida!");
					menuInicial();
					break;
				}
			} catch (Exception NumberFormatException) {
				JOptionPane.showMessageDialog(null, "Cancelado!");
				menuInicial();
			}
		}

	}

	// Provavelmente tem que inserir ContaCorrente e ContaPoupanca pra dar certo
	public static void menuCliente(Contas a, ContaCorrente b, ContaPoupanca c) {
		String m = JOptionPane.showInputDialog(
				"                                   -----------------------------------------------------------------------"
						+ "                                            \n                                   |--------------Bem vindo/a ao Banco Fuctura--------------|"
						+ "                                            \n                                    Cliente: "
						+ a.getPessoa().getNome() + "                                                           "
						+ "                                            \n                                    CPF: "
						+ a.getPessoa().modCpf() + "                                              "
						+ "\n                                    E-mail: " + a.getPessoa().getEmail()
						+ "                                    "
						+ "                                            \n                                   |-----------------------------------------------------------------------|"
						+ "                                            \n                                   |---------------Escolha uma das operações----------------|"
						+ "                                            \n                                   |-----------------------------------------------------------------------|"
						+ "                                            \n                                   |            Opção 1 - Mudar Dados Cadastrais               |"
						+ "                                            \n                                   |            Opção 2 - Acessar Conta Corrente                |"
						+ "                                            \n                                   |            Opção 3 - Acessar Conta Poupança               |"
						+ "                                            \n                                   |            Opção 4 - Sair                                                    |"
						+ "                                            \n                                   -----------------------------------------------------------------------");
		int menu = Integer.parseInt(m);
		if (m == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuInicial();
		} else if (m.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuInicial();
		}
		switch (menu) {
		case 1:
			modificarCadastro(a, b, c);
			break;
		case 2:
			acessarContaCorrente(a, b, c);
			break;
		case 3:
			acessarContaPoupanca(a, b, c);
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
	public static void menuGerente(Contas a, ContaCorrente b, ContaPoupanca c) {

		int menu = Integer.parseInt(JOptionPane.showInputDialog(
				"                                   -------------------------------------------------------------------"
						+ "                                            \n                                   |---------------Gerência Banco Fuctura-----------------|"
						+ "                                            \n                                   |------------------------------------------------------------------|"
						+ "                                            \n                                   |-------------Escolha uma das operações--------------|"
						+ "                                            \n                                   |------------------------------------------------------------------|"
						+ "                                            \n                                   |            Opção 1 - Criar Conta                                 |"
						+ "                                            \n                                   |            Opção 2 - Mudar Dados Cadastrais          |"
						+ "                                            \n                                   |            Opção 3 - Listar                                           |"
						+ "                                            \n                                   |            Opção 4 - Sair                                              |"
						+ "                                            \n                                   -------------------------------------------------------------------"
						+ ""));

		switch (menu) {
		case 1:
			criarConta();
			break;
		case 2:
			modificarCadastro(a, b, c);
			break;
		case 3:
			listarContas(a, b, c);
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Obrigado por usar os serviços da nossa agência!");
			menuInicial();
		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!!");
			menuGerente(a, b, c);
			break;
		}
	}

	public static void criarConta() {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
		if (pessoa.getNome() == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuInicial();
		} else if (pessoa.getNome().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuInicial();
		} else if (!pessoa.getNome().toUpperCase().matches("[A-Z]*")) {
			JOptionPane.showMessageDialog(null, "Nome deve ser composto por letras!");
			menuInicial();
		}
		pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
		if (pessoa.getCpf() == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuInicial();
		} else if (pessoa.getCpf().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuInicial();
		} else if (pessoa.getCpf().length() != 11) {
			JOptionPane.showMessageDialog(null, "CPF deve ser composto por 11 digitos numéricos!");
			menuInicial();
		} else if (!pessoa.getCpf().matches("[0-9]*")) {
			JOptionPane.showMessageDialog(null, "CPF deve ser composto por 11 digitos numéricos!");
			menuInicial();
		} else if (encontrarCpf(pessoa.getCpf(),contas)) {
			JOptionPane.showMessageDialog(null, "CPF já existente no banco de dados!");
			menuInicial();
		}
		pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));
		if (pessoa.getEmail() == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuInicial();
		} else if (pessoa.getEmail().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuInicial();
		}

		Contas contasC = new Contas(pessoa);
		ContaCorrente cc = new ContaCorrente(contasC);
		ContaPoupanca cp = new ContaPoupanca(contasC);

		contas.add(contasC);
		contasCorrente.add(cc);
		contasPoupanca.add(cp);

		JOptionPane.showMessageDialog(null,
				"Confira seus dados!" + "\nConta Corrente: " + cc.getNumeroConta() + "\nConta Poupança: "
						+ cp.getNumeroConta() + "\nSenha: " + contasC.getSenha() + "\nNome: " + contasC.pessoa.getNome()
						+ "\nCPF: " + contasC.pessoa.modCpf() + "\nE-mail: " + contasC.pessoa.getEmail());
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
		if (numCPF == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuInicial();
		} else if (numCPF.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuInicial();
		} else if (numCPF.length() != 11) {
			JOptionPane.showMessageDialog(null, "CPF deve ser composto por 11 digitos numéricos!");
			menuInicial();
		} else if (!numCPF.matches("[0-9]*")) {
			JOptionPane.showMessageDialog(null, "CPF deve ser composto por 11 digitos numéricos!");
			menuInicial();
		}
		String senha = JOptionPane.showInputDialog("Senha: ");
		if (senha == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuInicial();
		} else if (senha.equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuInicial();
		}

		conta = encontrarLogin(numCPF, senha);
		cc = encontrarLogi(numCPF, senha);
		cp = encontrarLog(numCPF, senha);
		// Login Gerente
		if (numCPF.equals("000") && senha.equals("FUCTURA")) {
			menuGerente(conta, cc, cp);
			// Login Cliente
		} else if (conta != null) {
			menuCliente(conta, cc, cp);
		} else {
			JOptionPane.showMessageDialog(null, "CPF e/ou senha incorreto(s)!");
			menuInicial();
		}

	}

	// Provavelmente tem que inserir ContaCorrente e ContaPoupanca pra dar certo
	public static void modificarCadastro(Contas a, ContaCorrente b, ContaPoupanca c) {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome(JOptionPane.showInputDialog("Nome: "));
		if (pessoa.getNome() == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuCliente(a, b, c);
		} else if (pessoa.getNome().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuCliente(a, b, c);
		}
		pessoa.setCpf(JOptionPane.showInputDialog("CPF: "));
		if (pessoa.getCpf() == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuCliente(a, b, c);
		} else if (pessoa.getCpf().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuCliente(a, b, c);
		} else if (pessoa.getCpf().length() != 11) {
			JOptionPane.showMessageDialog(null, "CPF deve ser composto por 11 digitos numéricos!");
			menuCliente(a, b, c);
		} else if (!pessoa.getCpf().matches("[0-9]*")) {
			JOptionPane.showMessageDialog(null, "CPF deve ser composto por 11 digitos numéricos!");
			menuCliente(a, b, c);
		}
		pessoa.setEmail(JOptionPane.showInputDialog("E-mail: "));
		if (pessoa.getEmail() == null) {
			JOptionPane.showMessageDialog(null, "Cancelado!");
			menuCliente(a, b, c);
		} else if (pessoa.getEmail().equalsIgnoreCase("")) {
			JOptionPane.showMessageDialog(null, "Campo Vazio!");
			menuCliente(a, b, c);
		}

		double saldoC = a.getSaldo();
		double saldoCc = b.getSaldo();
		double saldoCp = c.getSaldo();

		a = new Contas(pessoa);
		b = new ContaCorrente(a);
		c = new ContaPoupanca(a);

		a.setSaldo(saldoC);
		b.setSaldo(saldoCc);
		c.setSaldo(saldoCp);

		// Ou é contasSC.getID - 1,a
		contas.set(a.getID() - 1, a);
		contasCorrente.set(b.getID() - 1, b);
		contasPoupanca.set(c.getID() - 1, c);

		// JOptionPane.showMessageDialog(null, a.getPessoa());

		JOptionPane.showMessageDialog(null,
				"Confira seus dados!" + "\nConta Corrente: " + b.getNumeroConta() + "\nConta Poupança: "
						+ c.getNumeroConta() + "\nSenha: " + a.getSenha() + "\nNome: " + a.pessoa.getNome() + "\nCPF: "
						+ a.pessoa.modCpf() + "\nE-mail: " + a.pessoa.getEmail());

		JOptionPane.showMessageDialog(null, "Sua conta foi modificada com sucesso!");
		menuCliente(a, b, c);

	}

	private static boolean encontrarCpf(String numeroCpf, ArrayList<Contas> contasBancarias) {
		Contas conta = null;
		if (contasBancarias.size() > 0) {
			for (Contas c : contasBancarias) {
				if (c.getPessoa().getCpf().equals(numeroCpf)) {
					conta = c;
				}
			}
			return true;
		}else {
			return false;
		}
		
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

	// NÃO ESQUECER DE IMPLEMENTAR O MÉTODO "LISTAR CONTAS".
	// ELE SERÁ USADO NO "MENU GERENTE"

	public static void listarContas(Contas a, ContaCorrente b, ContaPoupanca c) {
		if (contas.size() > 0) {
			for (Contas conta : contas) {
				JOptionPane.showMessageDialog(null, conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há contas cadastradas!");
		}
		menuGerente(a, b, c);
	}

	public static void acessarContaCorrente(Contas contas, ContaCorrente cc, ContaPoupanca cp) {
		{
			int menu = Integer.parseInt(JOptionPane.showInputDialog(
					"                                   ------------------------------------------------------"
							+ "                                            \n                                   |-----Bem vindo/a ao Banco Fuctura-----|"
							+ "                                            \n                                    Cliente: "
							+ cc.getPessoa().getNome()
							+ "                  \n                                   ContaCorrente:  "
							+ cc.getNumeroConta()
							+ "                                            \n                                    CPF: "
							+ cc.getPessoa().modCpf() + " "
							+ "                                            \n                                   |-----------------------------------------------------|"
							+ "                                            \n                                   |-------Escolha uma das operações-------|"
							+ "                                            \n                                   |-----------------------------------------------------|"
							+ "                                            \n                                   |            Opção 1 - Saldo                           |"
							+ "                                            \n                                   |            Opção 2 - Sacar                           |"
							+ "                                            \n                                   |            Opção 3 - Depositar                    |"
							+ "                                            \n                                   |            Opção 4 - Transferir                   |"
							+ "                                            \n                                   |            Opção 5 - Aplicar                         |"
							+ "                                            \n                                   |            Opção 6 - Sair                              |"
							+ "                                            \n                                   ------------------------------------------------------"));
			switch (menu) {
			case 1:
				cc.mostrarSaldo();
				acessarContaCorrente(contas, cc, cp);
				break;
			case 2:
				cc.sacar();
				acessarContaCorrente(contas, cc, cp);
				break;
			case 3:
				cc.depositar();
				acessarContaCorrente(contas, cc, cp);
				break;
			case 4:
				cc.transferir(contasCorrente);
				acessarContaCorrente(contas, cc, cp);
				break;
			case 5:
				cc.aplicar(cp);
				acessarContaCorrente(contas, cc, cp);
				break;
			case 6:
				menuCliente(contas, cc, cp);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!!");
				menuCliente(contas, cc, cp);
				break;

			}

		}

	}

	public static void acessarContaPoupanca(Contas contas, ContaCorrente cc, ContaPoupanca cp) {
		{
			int menu = Integer.parseInt(JOptionPane.showInputDialog(
					"                                   ------------------------------------------------------"
							+ "                                            \n                                   |-----Bem vindo/a ao Banco Fuctura-----|"
							+ "                                            \n                                    Cliente: "
							+ cp.getPessoa().getNome()
							+ "                  \n                                   ContaCorrente:  "
							+ cp.getNumeroConta()
							+ "                                            \n                                    CPF: "
							+ cp.getPessoa().modCpf() + " "
							+ "                                            \n                                   |-----------------------------------------------------|"
							+ "                                            \n                                   |-------Escolha uma das operações-------|"
							+ "                                            \n                                   |-----------------------------------------------------|"
							+ "                                            \n                                   |            Opção 1 - Saldo                           |"
							+ "                                            \n                                   |            Opção 2 - Transferir                   |"
							+ "                                            \n                                   |            Opção 3 - Resgatar                      |"
							+ "                                            \n                                   |            Opção 4 - Sair                              |"
							+ "                                            \n                                   ------------------------------------------------------"));
			switch (menu) {
			case 1:
				cp.mostrarSaldo();
				acessarContaPoupanca(contas, cc, cp);
				break;
			case 2:
				cp.transferir(contasPoupanca);
				acessarContaPoupanca(contas, cc, cp);
				break;
			case 3:
				cp.resgatar(cc);
				acessarContaPoupanca(contas, cc, cp);
				break;
			case 4:
				menuCliente(contas, cc, cp);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!!");
				menuCliente(contas, cc, cp);
				break;

			}

		}

	}

}
