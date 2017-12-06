package tp3_gest_forum;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		String aff;
		int i, nbPages;
		List<Post> listePt;
		Post ptPpl;
		Fil fil1 = new Fil("Discussion de merde", 2);
		Fil fil2 = new Fil("Reddit /polandball/", 2);

		Post p1 = fil1.createNewPost("bonjour", "michel", 4, null);
		Post p2 = fil1.createNewPost("salut", "henri", 1, p1);
		Post p3 = fil1.createNewPost("ça va?", "michel", 7, p1);
		Post p4 = fil1.createNewPost("oui et toi?", "henri", 1, p1);
		Post p5 = fil1.createNewPost("très bien", "henri", 6, p1);
		
		Post p6 = fil2.createNewPost("Brytania, why you can many friendlys with Ameryka?", "LittlePolen", 4, null);
		Post p7 = fil2.createNewPost("Well, Poland. Myself and the USA share a special and intimate relationship.", "England", 7, p6);
		Post p8 = fil2.createNewPost("what the fuck dad", "USAFUCKYEAH", 8, p6);
		Post p9 = fil2.createNewPost("o kurwa!", "LittlePolen", 6, p6);
		
		listePt = fil1.postesLies(p1);
		for(i = 0; i < listePt.size(); i++){
			System.out.println(listePt.get(i).toString());
		}
		
		ptPpl = fil1.postPlusPopl();
		System.out.println("Le post le plus populaire du fil \"" + fil1.getNomFil() + "\" : \n" + ptPpl.toString());
		ptPpl = fil2.postPlusPopl();
		System.out.println("Le post le plus populaire du fil \"" + fil2.getNomFil() + "\" : \n" + ptPpl.toString());
		
		nbPages = fil1.cclNbPages();
		System.out.println("nb pages : " + nbPages);
		aff = fil1.toString();
		System.out.println(aff);
		
		nbPages = fil2.cclNbPages();
		System.out.println("nb pages : " + nbPages);
		aff = fil2.toString();
		System.out.println(aff);
	}
}
