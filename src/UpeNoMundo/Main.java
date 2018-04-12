package UpeNoMundo;

import java.util.ArrayList;


public class Main {
	
	private static void init(int quantidadeDeThreads) {
		
		Parque parque = new Parque(quantidadeDeThreads, initParques());
		
		for(int i = 0 ; i < quantidadeDeThreads; i++) {
			new Turma(i, parque).start();
		}
		
	}
	
	private static ArrayList<String> initParques(){
		
		ArrayList<String> parques = new ArrayList<String>();
		parques.add("Carrocel");
		parques.add("Roda Gigante");
		parques.add("Auto Pista");
		parques.add("Montanha Russa");
		parques.add("Kamikase");
		return parques;
	}

	public static void main(String[] args) {
		
		int quantidadeDeThreads = 7;
		
		init(quantidadeDeThreads);
		
	}

}
