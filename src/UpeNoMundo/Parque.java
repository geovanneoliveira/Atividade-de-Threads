package UpeNoMundo;

import java.util.ArrayList;

public class Parque {

	private int quantidadeDeThreads;
	private int quantidadeDeThreadsEsperando;
	private ArrayList<String> parques;
	private int idDoParque;
	
	public Parque(int quantidadeDeThreads, ArrayList<String> parques) {
		this.quantidadeDeThreads = quantidadeDeThreads;
		this.quantidadeDeThreadsEsperando = 0;
		this.parques = parques;
		this.idDoParque = 0;
	}
	
	@SuppressWarnings("static-access")
	public synchronized void andarNoParque(long tempo, String nome, Turma turma) {
		
		System.out.println(nome + " está no parque " + parques.get(idDoParque));
		try {
			turma.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			
			this.Barreira(nome);
		}
		
	}
	
	public synchronized void Barreira(String nome) {
		
		this.quantidadeDeThreadsEsperando++;
		
		if(this.quantidadeDeThreads != quantidadeDeThreadsEsperando) {
			try {
				System.out.println(nome + " está à espera!");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			this.idDoParque++;
			this.quantidadeDeThreadsEsperando = 0;
			System.out.println(nome + " quebrou a Barreira!");
			notifyAll();
		}
		
	}
	
	public boolean proximoParque() {
		
		if(this.idDoParque < parques.size()) {
			return true;
		}else {
			return false;
		}
	}
}
