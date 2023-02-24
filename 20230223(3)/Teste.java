package banco;

import javax.swing.JOptionPane;

public class Teste {

	public static void main(String[] args) {
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Show");
		pessoa.setCpf("102");
		pessoa.setEmail("edi");
		
		ContaCorrente cc = new ContaCorrente(pessoa);
		ContaPoupanca cp = new ContaPoupanca(cc);
		
		System.out.println(cc);
		System.out.println(cc.getNumeroConta());
		System.out.println(cp);
		System.out.println(cp.getNumConta());

	}

}
