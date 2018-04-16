package senha;

public class MaquinaDeTuring extends Thread{
	
	private int id;
	private String sequencia;
	private long inicio; 
	private long fim;
	
	public MaquinaDeTuring(int id, String sequencia, long inicio, long fim) {
		this.id = id;
		this.sequencia = sequencia;
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public void run() {
		
		System.out.println("Thread " + this.id + "Iniciada de " + this.inicio + " ate " + this.fim);
		
		for(long i = this.inicio; i < this.fim && Main.buscando ; i++) {

			String possivelSenha = String.format("%010d", i);
			
			if(possivelSenha.equals(this.sequencia)) {
				System.out.println("Thread " + this.id + " Encontrou a Senha = " + possivelSenha);
				Main.buscando  = false; //PARANDO TODAS AS OUTRAS THREADS
				break;
			}
			
			System.out.println("Thread " + this.id + " Testou = " + possivelSenha);
		}
	}	
	
}
