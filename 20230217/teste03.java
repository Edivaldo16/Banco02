package Programa;

public class teste03 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("beginnersbook");
		StringBuffer a = sb.insert(4, "-");
		String str = a.toString();
		System.out.println(sb.insert(4, "-"));
		System.out.println(sb.insert(4, "-").getClass().getSimpleName());
		System.out.println(str);
		System.out.println(str.getClass().getSimpleName());

	}

}
