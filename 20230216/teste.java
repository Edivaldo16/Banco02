package Programa;
import java.util.ArrayList;
import java.util.Scanner;
public class teste {
	static ArrayList<Conta> contasBancarias;
	

	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("A: ");
		String a = sc.next();
		
		System.out.println("B: ");
		String b = sc.next();
		
		if(a.equals("bola") && b.equals("chupeta")) {
			System.out.println("ok");
		}
		else {
			System.out.println("não");
		}
		
		
		//teste02 a = new teste02();
		//GeradorConta b = new GeradorConta();
		
		//System.out.println(a.getRandomString(10));
		//System.out.println(a.getRandomString(10).getClass().getSimpleName());
		//System.out.println(b.getRandomString(7));

	}

}
