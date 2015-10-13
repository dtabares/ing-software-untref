package skeleton;

import org.junit.Assert;
import org.junit.Test;

public class MapaTest {
	
	@Test
	public void cuandoInstancioUnMapaElTableroDebeEstarVacio(){
		Mapa mapa = new Mapa();
		char[] posicionEnEjeX = new char[10];
		posicionEnEjeX[0] = 'A';
		posicionEnEjeX[1] = 'B';
		posicionEnEjeX[2] = 'C';
		posicionEnEjeX[3] = 'D';
		posicionEnEjeX[4] = 'E';
		posicionEnEjeX[5] = 'F';
		posicionEnEjeX[6] = 'G';
		posicionEnEjeX[7] = 'H';
		posicionEnEjeX[8] = 'I';
		posicionEnEjeX[9] = 'J';
		
		for (int i=0; i<posicionEnEjeX.length;i++){
			for (int j=0; j<10;j++){
				Assert.assertEquals(EstadoPosicionamiento.Libre, mapa.getEstadoPosicion(posicionEnEjeX[i], j));
			}
		}
	}
	
	@Test
	public void cuandoPosicionoUnBarcoHorizontalmeteElEstadoDeEsasPosicionesDebenSerOcupado(){
		Mapa mapa = new Mapa();
		Barco destructor = new Destructor();
		
		mapa.posicionarBarcoDeFormaHorizontal(destructor, 'A', 0);
		
		Assert.assertEquals(EstadoPosicionamiento.Ocupado, mapa.getEstadoPosicion('A', 0));
		Assert.assertEquals(EstadoPosicionamiento.Ocupado, mapa.getEstadoPosicion('B', 0));
		Assert.assertEquals(EstadoPosicionamiento.Ocupado, mapa.getEstadoPosicion('C', 0));

	}
	
	@Test
	public void cuandoPosicionoUnBarcoVerticalmenteElEstadoDeEsasPosicionesDebenSerOcupado(){
		Mapa mapa = new Mapa();
		Barco destructor = new Destructor();
		
		mapa.posicionarBarcoDeFormaVertical(destructor, 'A', 0);
		
		Assert.assertEquals(EstadoPosicionamiento.Ocupado, mapa.getEstadoPosicion('A', 0));
		Assert.assertEquals(EstadoPosicionamiento.Ocupado, mapa.getEstadoPosicion('A', 1));
		Assert.assertEquals(EstadoPosicionamiento.Ocupado, mapa.getEstadoPosicion('A', 2));

	}

}
