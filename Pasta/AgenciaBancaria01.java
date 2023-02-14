package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria01 {

	static Scanner caixaEletronico = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
	    //menu(); // Opções disponíveis caixa eletrônico
		menuInicial();
		//System.out.println(contasBancarias);

	}

	public static void menuInicial() {
		System.out.println("-------------------------------------");
		System.out.println("|----Bem vindos ao Banco Fuctura----|");
		System.out.println("|-----------------------------------|");
		System.out.println("|-----Escolha uma das operações-----|");
		System.out.println("|-----------------------------------|");
		System.out.println("|       Opção 1 - Criar Conta       |");
		System.out.println("|       Opção 2 - Modificar Conta   |");
		System.out.println("|       Opção 3 - Login             |");
		System.out.println("|       Opção 4 - Sair              |");
		System.out.println("-------------------------------------");
		int menu = caixaEletronico.nextInt();
		switch (menu) {
		case 1:
			criarConta();
			break;
		case 2:
			modificarConta();
			break;
		case 3:
			//login();
			break;
		case 4:
			System.out.println("Obrigado por usar os serviços da nossa agência!");
			System.exit(0);
			break;
		default:
			System.out.println("Opção inválida!");
			menu();
			break;
		}
	}

	public static void menu() {
		System.out.println("-------------------------------------");
		System.out.println("|----Bem vindos ao Banco Fuctura----|");
		System.out.println("|-----------------------------------|");
		System.out.println("|-----Escolha uma das operações-----|");
		System.out.println("|-----------------------------------|");
		System.out.println("|       Opção 1 - Criar Conta       |");
		System.out.println("|       Opção 2 - Depositar         |");
		System.out.println("|       Opção 3 - Sacar             |");
		System.out.println("|       Opção 4 - Transferir        |");
		System.out.println("|       Opção 5 - Listar            |");
		System.out.println("|       Opção 6 - Sair              |");
		System.out.println("-------------------------------------");

		int menu = caixaEletronico.nextInt();
		switch (menu) {
		case 1:
			criarConta();
			break;
		/*
		 * case 2: depositar(); break; case 3: sacar(); break; case 4: transferir();
		 * break; case 5: listar(); break;
		 */
		case 6:
			// Não foi implementado pelo cara do vídeo
			// Talvez devido o system.exit();
			// sair();
			System.out.println("Obrigado por usar os serviços da nossa agência!");
			System.exit(0);
		default:
			System.out.println("Opção inválida!");
			menu();
			break;

		}

	}

	public static void criarConta() {
		System.out.println("\nNome: ");
		// Pode ser "caixaEletronico.next()" ou "caixaEletronico.nextLine()"
		String nome = caixaEletronico.next();

		System.out.println("\nCPF: ");
		// Pode ser "caixaEletronico.next()" ou "caixaEletronico.nextLine()"
		String cpf = caixaEletronico.next();

		System.out.println("\nE-mail: ");
		// Pode ser "caixaEletronico.next()" ou "caixaEletronico.nextLine()"
		String email = caixaEletronico.next();

		Pessoa pessoa = new Pessoa(nome, cpf, email);

		Conta conta = new Conta(pessoa);

		contasBancarias.add(conta);
		System.out.println("Sua conta foi criada com sucesso!");
		menuInicial();

	}

	public static void modificarConta() {
		System.out.println("\nNome: ");
		// Pode ser "caixaEletronico.next()" ou "caixaEletronico.nextLine()"
		String nome = caixaEletronico.next();

		System.out.println("\nCPF: ");
		// Pode ser "caixaEletronico.next()" ou "caixaEletronico.nextLine()"
		String cpf = caixaEletronico.next();

		System.out.println("\nE-mail: ");
		// Pode ser "caixaEletronico.next()" ou "caixaEletronico.nextLine()"
		String email = caixaEletronico.next();

		Pessoa pessoa = new Pessoa(nome, cpf, email);

		Conta conta = new Conta(pessoa);

		contasBancarias.set(0, conta);
		System.out.println("Sua conta foi modificada com sucesso!");
		menuInicial();

	}

}
