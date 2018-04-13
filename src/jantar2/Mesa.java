package jantar2;


public class Mesa {
	
	private boolean[] garfos;
	
	public Mesa() {
		this.garfos = new boolean[5];
		for(int i = 0 ; i < 5; i++) garfos[i] = true; //DISPONIVEL
		
	}
	
		
	
	
	private boolean statusGarfoDireito(int id) { //STATUS DO GARFO DIREITO
			
		return this.garfos[id];	
	}
	
	
	private boolean statusGarfoEsquerdo(int id) { //STATUS DO GARFO ESQUERDO

		if(id == 4) return this.garfos[0];
		
		return this.garfos[id+1];
	}
	
		

	private void retornarGarfoDireito(int id) { //COLOCA NA MESA O GARFO DIREITO
		this.garfos[id] = true;
	}
	
	
	private void retornarGarfoEsquerdo(int id) {//COLOCAR NA MESA O GARFO ESQUERDO
		
		if(id == 4) {
			
			this.garfos[0] = true;
		}else {
			
			this.garfos[id+1] = true;
		}
	}
	
	
	
	/*<--METODOS PUBLICOS-->*/
	
	public synchronized boolean testeGarfos(int id){ //TESTE GERAL
		
		if(!(statusGarfoDireito(id) && statusGarfoEsquerdo(id))) {
			return false;
		}
		
		return true;
	}
	
	
	
	public synchronized void pegarGarfoDireito(int id) { //PEGAR GARFO DIREITO
		this.garfos[id] = false;
	}
	
	
	public synchronized void pegarGarfoEsquerdo(int id) { //PEGAR GARFO ESQUERDO
		
		if(id == 4) {
			
			this.garfos[0] = false;
		}else {
			
			this.garfos[id+1] = false;
		}
	}
	
	public synchronized void retornarGarfos(int id) { //RETORNAR OS GARFOS
		
			if((statusGarfoEsquerdo(id))) retornarGarfoEsquerdo(id);
			if((statusGarfoDireito(id)))   retornarGarfoDireito(id);
			
			System.out.println("Filosofo " + id +" Retornou os Garfos");
		
	}
	
}
