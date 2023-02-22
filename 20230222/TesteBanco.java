package Projeto;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class TesteBanco {
	// Implementação com sucesso do método mudarConta
	// Falta criar Login e Senha (Falta gerar senha aleatória)
	// Falta criar ContaPoupança e ContaCorrente

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Digite um número: ");
			int a = sc.nextInt();
		} catch (Exception InputMismatchException) {
			System.out.println("Digite números");
		}

	}

}
