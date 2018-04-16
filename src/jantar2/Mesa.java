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
	
	public synchronized boolean podePegarOs2(int id){
		if(!statusGarfoEsquerdo(id)){
			System.err.println("garfo DIREITO esta sendo usado");
			return false;
		} else if(!statusGarfoDireito(id)){
			System.err.println("garfo ESQUERDO esta sendo usado");
			return false;
		}
		return true;
	}
	
	/*<--METODOS PUBLICOS-->*/
	
	public synchronized boolean pegarGarfoDireito(int id) { //PEGAR GARFO DIREITO
		if(this.garfos[id] == false){
			System.out.println("garfo ESQUERDO esta sendo usado -TEM ALGO ERRADO BROW-");
			return false;
		}else{
			this.garfos[id] = false;
			System.out.println(id + " pegou garfo ESQUERDO");
			return true;
		}
		
	}
	
	
	public synchronized boolean pegarGarfoEsquerdo(int id) { //PEGAR GARFO ESQUERDO
		int id_ = id;
		if(id == 4) {
			id_ = 0;
		}else {
			id_ +=1;
		}

		if(this.garfos[id_] == false){
			System.err.println("garfo DIREITO esta sendo usado -TEM ALGO ERRADO BROW-");
			return false;
		}else{
			this.garfos[id_] = false;
			System.err.println(id + " pegou garfo DIREITO");
			return true;
		}
	}
	
	public synchronized void retornarGarfos(int id) { //RETORNAR OS GARFOS
		
			retornarGarfoEsquerdo(id);
			retornarGarfoDireito(id);
			
			System.out.println("Filosofo " + id +" Retornou os Garfos");
		
	}

	
}