package skeleton;

public class BatallaNaval {
	
	private Mapa mapa;
	private BarcoFactory fabricaDeBarcos;
	
	
	public BatallaNaval(){
		this.mapa = new Mapa();
		this.fabricaDeBarcos  = new BarcoFactory();
	}


	public EstadoPosicionamiento posicionarBarco(String tipoDeBarco, char coordenadaEnX1, int coordenadaEnY1, String formaPosicionamiento) {
		EstadoPosicionamiento resultado;
		Barco barco = fabricaDeBarcos.getBarco(tipoDeBarco);
		
		if(formaPosicionamiento.equalsIgnoreCase("horizontal")){
			resultado = this.mapa.posicionarBarcoDeFormaHorizontal(barco, coordenadaEnX1, coordenadaEnY1 - 1 );
		}
		else{
			if(formaPosicionamiento.equalsIgnoreCase("vertical")){
				resultado = this.mapa.posicionarBarcoDeFormaVertical(barco, coordenadaEnX1, coordenadaEnY1 - 1);
			}
			else{
				return null;
			}
		}
		
		return resultado;
		
	}
	
	public EstadoPosicionamiento getEstadoPosicion(char posX, int posY){
		return mapa.getEstadoPosicion(posX, posY - 1);
	}


	public EstadoDisparo disparar(char arg1, int posY) {
		return mapa.recibirDisparo(arg1, posY -1);
	}

}
