package jantar2;


public class Mesa {
	
	private boolean[] garfos;
	
	public Mesa() {
		this.garfos = new boolean[5];
		for(int i = 0 ; i < 5; i++) garfos[i] = true; //DISPONIVEL
		
	}
	
		
	private boolean testeGarfos(int id){
		
		if(!(garfoDireito(id) && garfoEsquerdo(id))) {
			return false;
		}
		
		return true;
	}
	
	
	private boolean garfoDireito(int id) { //STATUS DO GARFO DIREITO
			
		return this.garfos[id];	
	}
	
	
	private boolean garfoEsquerdo(int id) { //STATUS DO GARFO ESQUERDO

		if(id == 4) return this.garfos[0];
		
		return this.garfos[id+1];
	}
	
		
	private void pegarGarfoDireito(int id) { //PEGAR GARFO DIREITO
		this.garfos[id] = false;
	}
	
	
	private void pegarGarfoEsquerdo(int id) { //PEGAR GARFO ESQUERDO
		
		if(id == 4) {
			
			this.garfos[0] = false;
		}else {
			
			this.garfos[id+1] = false;
		}
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
	
	
	public  void pegarGarfos(Filosofos f) {
		int id = f.getIdd();
	
			if(!testeGarfos(id)) {
				//retornarGarfos(id);
				System.out.println("Filosofo " + id +" Não conseguiu pegar os garfos!");
				//f.pensar();
			} else{
				System.out.println("Filosofo " + id +" Pegou os garfos");
				pegarGarfoEsquerdo(id);
				pegarGarfoDireito(id);
				f.comer();				//depois que ele pegou os garfos ele  mesmo q come
				this.retornarGarfos(id); 
			}
		
	}
	
	public synchronized void retornarGarfos(int id) {
		
			retornarGarfoEsquerdo(id);
			retornarGarfoDireito(id);
			System.out.println("Filosofo " + id +" Acabou de Comer");
			notify();
		
	}
	
}
