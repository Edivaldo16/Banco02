package Programa;

import java.util.ArrayList;

public class teste03 {
	//static ArrayList<ContaPoupanca> contasPoupanca = new ArrayList<>();
	//static ArrayList<ContaCorrente> contasCorrente = new ArrayList<>();
	//static ArrayList<Contas> c = new ArrayList<>();

	public static void main(String[] args) {
		/*
		 * StringBuffer sb = new StringBuffer("beginnersbook"); StringBuffer a =
		 * sb.insert(4, "-"); String str = a.toString(); System.out.println(sb.insert(4,
		 * "-")); System.out.println(sb.insert(4, "-").getClass().getSimpleName());
		 * System.out.println(str); System.out.println(str.getClass().getSimpleName());
		 */
		Pessoa p = new Pessoa();
		p.setNome("Valdo");
		Pessoa g = new Pessoa();
		g.setNome("Valdo");
		Contas a = new Contas(p);
		ContaCorrente k = new ContaCorrente(a);
		ContaPoupanca z = new ContaPoupanca(a);
		System.out.println(k);
		System.out.println(z);
		//System.out.println(contasCorrente.getClass().getSimpleName());

	}

}
