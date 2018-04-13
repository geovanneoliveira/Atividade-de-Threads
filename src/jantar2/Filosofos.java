package jantar2;

public class Filosofos extends Thread{

	private int id;
	private String nome;
	private Mesa mesa;
	
	
	public Filosofos(Mesa mesa, int id) {
		this.mesa = mesa;
		this.id = id;
		this.nome = "Filosofo " + id;
	}
	
	public void run(){
		
		while(true) {
			this.pensar();
			this.pegarGarfos();
			this.comer();
			this.retornarGarfos(this.id);
		}
	}
	
	public void pegarGarfos() {
		mesa.pe
	}
	
	
	public void pensar() {
		System.out.println(nome + " Está pensando...");
		try {
			sleep((this.id + 1) * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void comer() {
		System.out.println(nome + " Está comendo....");
		try {
			sleep((this.id + 1) * 3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getIdd(){
		return this.id;
	}
	
	
}
