package skeleton;

public class Jugada {
	private char[] estado;
	private int vida;
	
	public Jugada(){
		this.vida = 7;
	}
	
	
	public void inicializarEstado(String palabraSecreta){
		estado = new char[palabraSecreta.length()];
		for(int i=0; i < estado.length; i++){
			estado[i] = '*';
		}
	}
	
	public char[] getEstado(){
		return estado;
	}

}
