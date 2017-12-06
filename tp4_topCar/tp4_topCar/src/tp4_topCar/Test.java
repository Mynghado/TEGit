package tp4_topCar;

public class Test {
	public static void main(String[] args) {
		Garage unGarage = new Garage();
		Option op1 = new Option(1, "Airbag", 1000);
		Option op2 = new Option(2, "Toit ouvrant", 1500);
		System.out.println(op1.toString());
		System.out.println(op2.toString());
		
		VoitureOccasion clio = new VoitureOccasion("AB-234-CD", 4800, 153000, 9);
		System.out.println(clio.toString());
		
		VoitureOccasion o1 = new VoitureOccasion("9874IY94",7000,50000,2);
		System.out.println(o1.toString());
		
		VoitureNeuve mini_cooper = new VoitureNeuve("DU-384-HN", 8230);
		mini_cooper.addOption(op1);
		mini_cooper.addOption(op2);
		System.out.println(mini_cooper.toString());
		
		VoitureNeuve v1=new VoitureNeuve("123AZE93",10000);
		VoitureNeuve v2=new VoitureNeuve("986RTY93",15000);
		VoitureNeuve v3=new VoitureNeuve("4567UI75",12000);
		VoitureNeuve v4=new VoitureNeuve("3578PO93",16000);
		VoitureNeuve v5=new VoitureNeuve("9546NB93",20000);
		VoitureOccasion o2= new VoitureOccasion("6548SD93",25000,7000,5);
		VoitureOccasion o3= new VoitureOccasion("1232DF94",35000,6000,4);
		VoitureOccasion o4= new VoitureOccasion("951EIY94",40000,6550,3);
		Option op3 = new Option(3,"Climatisation",1500);
		Option op4 = new Option(4,"Toit ouvrant",700);
		Option op5 = new Option(5,"Alarme",1000);
		unGarage.addVoiture(v1);
		unGarage.addVoiture(v2);
		unGarage.addVoiture(v3);
		unGarage.addVoiture(v4);
		unGarage.addVoiture(v5);
		unGarage.addVoiture(o1);
		unGarage.addVoiture(o2);
		unGarage.addVoiture(o3);
		unGarage.addVoiture(o4);
		unGarage.addOption(op1);
		unGarage.addOption(op2);
		unGarage.addOption(op3);
		unGarage.addOption(op4);
		unGarage.addOption(op5);
	}
}
