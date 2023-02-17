package Projeto;

import java.util.ArrayList;

public class ListasContas {
	static ArrayList<ContaCorrente> contasCorrente;
	static ArrayList<ContaPoupanca> contasPoupanca;

	public static void main(String[] args) {
		contasCorrente = new ArrayList<ContaCorrente>();
		contasPoupanca = new ArrayList<ContaPoupanca>();
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Neto");
		pessoa.setCpf("Bernadino");
		pessoa.setEmail("Bernadino");
		
		
		ContaCorrente cc = new ContaCorrente(pessoa);
		ContaPoupanca cp = new ContaPoupanca(pessoa);
		
		contasCorrente.add(cc);
		
		System.out.println(cc.getNumeroConta());
		System.out.println(cp.getNumeroConta());
		//System.out.println(cp.getNumeroConta());
		System.out.println(cc.getPessoa().getNome());
		//System.out.println(cp.getPessoa().getNome());
		System.out.println(cc.getID());
		System.out.println(cp.getID());
		System.out.println(contasCorrente.get(cc.getID() - 1).numeroConta);
		cp.numeroConta = contasCorrente.get(cc.getID() - 1).numeroConta;
		//System.out.println(cp.getID());
		
		
		//contasPoupanca.add(cp);
		
		System.out.println(contasCorrente);
		System.out.println(contasPoupanca);
	}

}
