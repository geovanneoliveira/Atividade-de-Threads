package senha;

public class Main {

	public static boolean buscando = true;
	private static void init(int quantidades_thread, long senha_max, String senha) {
		
		long acumulador = 0;           
        long inicio = 0;
        long termino = (long) Math.ceil((senha_max / quantidades_thread)); //RANGE DE PESQUISA POR THREAD
        acumulador = termino; 

        for(int i = 0; i < quantidades_thread ; i++){
        	if( i == (quantidades_thread - 1)) {
                new MaquinaDeTuring(i, senha, inicio, senha_max ).start(); 
        	}else {
        		new MaquinaDeTuring(i, senha, inicio, termino ).start(); 
        	}
            inicio = termino + 1;  //DEFINICAO DE INICIO DO RANGE
            termino += acumulador; //DEFINICAO DE TERMINO DO RANGE
        }
	}
		
	public static void main(String[] args) {
		
		String senha = "9000070000";  //SENHA A SER DESCOBRETA
		int quantidades_thread = 10;   //QUANTIDADE DE THREADS
        long senha_max = 9999999999l;   //TAMANHO MAXIMO

        init(quantidades_thread, senha_max,senha); //CHAMAR INICIALIZADOR
		
	}

}
