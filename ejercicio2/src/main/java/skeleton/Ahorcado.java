package skeleton;

public class Ahorcado {
	
	private String palabraSecreta;
	private Partida partida;
	
	public Ahorcado(){
		this.partida = new Partida();
	}
	

	public String getPalabraSecreta() {
		return palabraSecreta;
	}

	public void setPalabraSecreta(String palabraSecreta) {
		this.palabraSecreta = palabraSecreta;
		partida.inicializarEstado(palabraSecreta);
	}
	
	public void arriesgarLetra(char letra){
		partida.arriesgarLetra(letra);
	}
		
	public String getEstado(){
		return new String(partida.getEstado());
	}
	
	public int getVidas(){
		return partida.getVidas();
	}
	

	
}
