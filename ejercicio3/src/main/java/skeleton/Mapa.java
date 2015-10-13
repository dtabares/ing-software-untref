package skeleton;

import javax.xml.ws.soap.AddressingFeature.Responses;

public class Mapa {
	
	private int[][] tablero;
	private char[] posicionEnEjeX;
	
	public Mapa(){
		this.inicializarPosicionEnEjeX();
		this.inicializarTablero();
	}
	
	/*
	 * @El Tablero contiene un 0 en la posicion si esta vacio o disponible y un
	 * 1 si esta ocupado.
	 * Esta funcion lo inicia poniendo todo en 0.
	 */
	private void inicializarTablero() {
		this.tablero = new int[10][10];
		for (int i=0; i < this.tablero.length;i++){
			for (int j=0; j < this.tablero[i].length;j++){
				this.tablero[i][j] = 0;
			}
		}
		
	}

	private void inicializarPosicionEnEjeX(){
		this.posicionEnEjeX = new char[10];
		this.posicionEnEjeX[0] = 'A';
		this.posicionEnEjeX[1] = 'B';
		this.posicionEnEjeX[2] = 'C';
		this.posicionEnEjeX[3] = 'D';
		this.posicionEnEjeX[4] = 'E';
		this.posicionEnEjeX[5] = 'F';
		this.posicionEnEjeX[6] = 'G';
		this.posicionEnEjeX[7] = 'H';
		this.posicionEnEjeX[8] = 'I';
		this.posicionEnEjeX[9] = 'J';
	}

	public EstadoPosicionamiento getEstadoPosicion(char x, int y){
		int posEnX = this.getPosX(x);
		if (posEnX < 10 && y < 10){
			
			if(this.tablero[posEnX][y] == 0){
				return EstadoPosicionamiento.Libre;
			}
			else{
				return EstadoPosicionamiento.Ocupado;
			}
		}
		else{
			return EstadoPosicionamiento.FueraDelMapa;
		}
		
	}
	
	private EstadoPosicionamiento getEstadoPosicion(int x, int y){
		if (x < 10 && y < 10){
			
			if(this.tablero[x][y] == 0){
				return EstadoPosicionamiento.Libre;
			}
			else{
				return EstadoPosicionamiento.Ocupado;
			}
		}
		else{
			return EstadoPosicionamiento.FueraDelMapa;
		}
		
	}
	

	private int getPosX(char x){
		int posicion = -1;
		for(int i=0; i<this.posicionEnEjeX.length;i++){
			if(Character.toUpperCase(x) == this.posicionEnEjeX[i]){
				posicion = i;
			}
		}
		return posicion;
		
	}


	private void marcarComoOcupado(int x, int y) {
			this.tablero[x][y] = 1;	
	}
	
	public EstadoPosicionamiento posicionarBarcoDeFormaHorizontal(Barco barco, char posX, int posY){
		int posicionInicialEnEjeX = this.getPosX(posX);
		int posicionEnEjeXAuxiliar = posicionInicialEnEjeX;
		int longitudBarco = barco.getLongitud();
		EstadoPosicionamiento estadoPosicionamiento;
		
		for(int i=0; i<longitudBarco;i++){
			posicionEnEjeXAuxiliar = posicionInicialEnEjeX +  i ;
			estadoPosicionamiento = this.getEstadoPosicion(posicionEnEjeXAuxiliar, posY);
			if (estadoPosicionamiento.equals(EstadoPosicionamiento.FueraDelMapa) || estadoPosicionamiento.equals(EstadoPosicionamiento.Ocupado)){
				return estadoPosicionamiento;
			}
		}
		
		posicionEnEjeXAuxiliar = posicionInicialEnEjeX;
		for(int i=0; i<longitudBarco;i++){
			posicionEnEjeXAuxiliar = posicionInicialEnEjeX + i;
			this.marcarComoOcupado(posicionEnEjeXAuxiliar, posY);
		}
		
		return EstadoPosicionamiento.OK;
	}
	
	public EstadoPosicionamiento posicionarBarcoDeFormaVertical(Barco barco, char posX, int posY){
		int x = this.getPosX(posX);
		int posicionInicialEnEjeY = posY;
		int posicionAuxiliarEnEjeY = posicionInicialEnEjeY;
		int longitudBarco = barco.getLongitud();
		EstadoPosicionamiento estadoPosicionamiento;
		
		for (int i=0; i<longitudBarco;i++){
			posicionAuxiliarEnEjeY = posicionInicialEnEjeY + i;
			estadoPosicionamiento = this.getEstadoPosicion(x, posicionAuxiliarEnEjeY);
			if (estadoPosicionamiento.equals(EstadoPosicionamiento.FueraDelMapa) || estadoPosicionamiento.equals(EstadoPosicionamiento.Ocupado)){
				return estadoPosicionamiento;
			}
		}
		
		posicionAuxiliarEnEjeY = posicionInicialEnEjeY;
		
		for(int i=0; i<longitudBarco;i++){
			posicionAuxiliarEnEjeY = posicionInicialEnEjeY + i;
			this.marcarComoOcupado(x, posicionAuxiliarEnEjeY);
		}
		
		return EstadoPosicionamiento.OK;
	}
	
	

}
