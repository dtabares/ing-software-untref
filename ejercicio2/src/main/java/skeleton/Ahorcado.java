package skeleton;

public class Ahorcado {
	
	private String palabraSecreta;
	private Jugada jugada;
	
	public Ahorcado(){
		this.jugada = new Jugada();
	}
	

	public String getPalabraSecreta() {
		return palabraSecreta;
	}

	public void setPalabraSecreta(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
		jugada.inicializarEstado(palabraSecreta);
	}
	
	public void arriesgarLetra(char letra){
		jugada.arriesgarLetra(letra);
	}
		
	public String getEstado(){
		return new String(jugada.getEstado());
	}
	
	public int getVidas(){
		return jugada.getVidas();
	}
	

	
}
