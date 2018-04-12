package UpeNoMundo;

public class Turma extends Thread{
	
	private String nome;
	private Parque parque;
	
	
	public Turma(int id, Parque parque) {
		this.nome = "Turma " + id;
		this.parque = parque;
	}
	
	public void run() {
		
		while(parque.proximoParque()) {
		
			andarNoParque((long) (Math.random() * 3000));
			
		}
		
		System.err.println("\n Por hoje é só " + this.nome );

	}
	
	private void andarNoParque(long tempo) {
		
		parque.andarNoParque(tempo, this.nome,this);
		
	}
	
}
