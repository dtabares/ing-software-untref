package skeleton;

public class Jugada {
	private char[] estado;
	private char[] palabraSecreta;
	private int vida;
	
	public Jugada(){
		this.vida = 7;
	}
	
	
	public void inicializarEstado(String palabraSecreta){
		estado = new char[palabraSecreta.length()];
		for(int i=0; i < estado.length; i++){
			estado[i] = '*';
		}
		this.palabraSecreta = palabraSecreta.toCharArray();
	}
	
	public char[] getEstado(){
		return estado;
	}
	
	public void arriesgarLetra(char letra){
		
		if(this.evaluar(letra) == false){
			vida--;
		}
		
	}
	
	/*
	 * @Pos: Devuelve true si modifico el estado de la palabra secreta y false si no lo hizo.
	 */
	private boolean evaluar(char letra){
		boolean modifico = false;
		for(int i=0; i < this.palabraSecreta.length; i++){
			if(palabraSecreta[i] == Character.toLowerCase(letra) || palabraSecreta[i] == Character.toUpperCase(letra)){
				modifico = true;
				if(Character.isUpperCase(palabraSecreta[i])){
					estado[i] = Character.toUpperCase(letra);
				}
				else{
					estado[i] = Character.toLowerCase(letra);
				}
				
			}
		}
		
		return modifico;
	}
	
	public int getVidas(){
		return this.vida;
	}

}
