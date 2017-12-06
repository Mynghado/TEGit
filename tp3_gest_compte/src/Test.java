import java.util.List;

public class Test {
	public static void main(String[] args) {
		String aff;
		Compte_courant ctc = new Compte_courant(1234, "von Habsbourg", 10000, 1500);
		Compte_epargne cte = new Compte_epargne(1235, "Jagiellon", 3450, 3.0);
		
		aff = ctc.toString();
		System.out.println(aff);
		aff = cte.toString();
		System.out.println(aff);
		
		ctc.retirerArgent(2000);
		aff = ctc.toString();
		System.out.println(aff);
		ctc.retirerArgent(10000);
		aff = ctc.toString();
		System.out.println(aff);
		
		cte.cclInterets();
		aff = cte.toString();
		System.out.println(aff);
	}
}