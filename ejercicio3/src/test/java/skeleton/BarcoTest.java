package skeleton;

import org.junit.*;

public class BarcoTest {
	
	@Test
	public void siIncrementoElDanioDeUnAcorazadoSanoElEstadoDebeSerTocado(){
		Barco barco = new Acorazado();
		barco.incrementarDisparosRecibidos();
		
		Assert.assertEquals(EstadoDisparo.Tocado, barco.evaluarDanio());
	}
	
	@Test
	public void siIncrementoElDanioDeUnaLanchaSanoElEstadoDebeSerHundido(){
		Barco barco = new Lancha();
		barco.incrementarDisparosRecibidos();
		
		Assert.assertEquals(EstadoDisparo.Hundido, barco.evaluarDanio());
	}

}
