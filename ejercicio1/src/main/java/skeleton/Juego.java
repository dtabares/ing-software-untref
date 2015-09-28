package skeleton;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	
	public Juego(Jugador jugador1, Jugador jugador2){
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	
	public String jugar(){
		String resultado = "";
		
		if (jugador1.getFigura().getNombre().equals(jugador2.getFigura().getNombre())){
			resultado = "EMPATE";
			
		}
		else{
			if (jugador1.getFigura().getNombre().equals("PIEDRA")){
				if (jugador2.getFigura().getNombre().equals("PAPEL")){
					resultado = "Gana JUGADOR2";
				}
				else{
					resultado = "Gana JUGADOR1";
				}
			}
		}
		


		return resultado;
		
	}

}
