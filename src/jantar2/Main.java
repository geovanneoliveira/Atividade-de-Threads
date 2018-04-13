package jantar2;


public class Main {

	private static void init(Mesa mesa) {
		
		for(int i = 0 ; i < 5; i++) {
			
			new Filosofos(mesa, i).start();
		}
	}
	
	
	public static void main(String[] args) {
		
		Mesa mesa = new Mesa();
		
		init(mesa);
		
		
	}
}
