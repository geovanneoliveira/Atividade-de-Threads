package senha;

public class Main {

	public static boolean buscando = true;
	private static void init(int quantidades_thread, long senha_max, String senha) {
		
		int acumulador = 0;           
        int inicio = 0;
        int termino = (int) Math.ceil((senha_max / quantidades_thread)); //RANGE DE PESQUISA POR THREAD
        acumulador = termino; 

        for(int i = 0; i < quantidades_thread ; i++){
            new MaquinaDeTuring(i, senha, inicio, termino ).start(); 
            inicio = termino + 1;  //DEFINICAO DE INICIO DO RANGE
            termino += acumulador; //DEFINICAO DE TERMINO DO RANGE
        }
	}
		
	public static void main(String[] args) {
		
		String senha = "0000770000";  //SENHA A SER DESCOBRETA
		int quantidades_thread = 4;   //QUANTIDADE DE THREADS
        long senha_max = 999999999;   //TAMANHO MAXIMO

        init(quantidades_thread, senha_max,senha); //CHAMAR INICIALIZADOR
		
	}

}
