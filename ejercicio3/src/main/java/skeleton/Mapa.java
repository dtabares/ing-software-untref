package skeleton;

import java.util.HashMap;

public class Mapa {
	
	private int[][] tablero;
	private char[] posicionEnEjeX;
	private HashMap<Posicion, Barco> mapaDeBarcos;
	
	public Mapa(){
		this.inicializarPosicionEnEjeX();
		this.inicializarTablero();
		this.mapaDeBarcos = new HashMap<>();
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
		int posEnX = this.getPosicionEjeX(x);
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
	

	private int getPosicionEjeX(char x){
		int posicion = -1;
		for(int i=0; i<this.posicionEnEjeX.length;i++){
			if(Character.toUpperCase(x) == this.posicionEnEjeX[i]){
				posicion = i;
			}
		}
		return posicion;
		
	}


	private void agregarBarco(int x, int y, Barco barco) {
			this.tablero[x][y] = 1;	
			this.mapaDeBarcos.put(new Posicion(x, y), barco);
	}
	
	public EstadoPosicionamiento posicionarBarcoDeFormaHorizontal(Barco barco, char posX, int posY){
		int posicionInicialEnEjeX = this.getPosicionEjeX(posX);
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
			this.agregarBarco(posicionEnEjeXAuxiliar, posY, barco);
		}
		
		return EstadoPosicionamiento.OK;
	}
	
	public EstadoPosicionamiento posicionarBarcoDeFormaVertical(Barco barco, char posX, int posY){
		int x = this.getPosicionEjeX(posX);
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
			this.agregarBarco(x, posicionAuxiliarEnEjeY, barco);
		}
		
		return EstadoPosicionamiento.OK;
	}
	
	private Barco getBarcoAtPos(Posicion posicion){
		return this.mapaDeBarcos.get(posicion);
	}
	
	public EstadoDisparo recibirDisparo(char x, int y){
		Barco barco;
		int posX = this.getPosicionEjeX(x);
		if(this.estaDentroDelRango(posX, y)){
			barco = this.getBarcoAtPos(new Posicion(posX, y));
			if (barco == null){
				return EstadoDisparo.Agua;
			}
			else{
				return this.evaluarDanio(barco);
			}
		}
		else{
			return EstadoDisparo.FueraDeRango;
		}
	}
	
	private EstadoDisparo evaluarDanio(Barco barco){
		barco.incrementarDisparosRecibidos();
		if(barco.getDisparosRecibidos() >= barco.getLongitud()){
			return EstadoDisparo.Hundido;
		}
		else{
			return EstadoDisparo.Tocado;
		}
	}
	
	private boolean estaDentroDelRango(int x, int y){
		if (x>10 || x<1 || y>10||y<1){
			return false;
		}
		else{
			return true;
		}
	}
}
