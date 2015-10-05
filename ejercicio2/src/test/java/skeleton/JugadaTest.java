package skeleton;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class JugadaTest {

	@Test
	public void cuandoSeteamosLaPalabraSecretaComoAutoElEstadoDebeSer4Astericos() {
		Jugada jugada = new Jugada();
		jugada.inicializarEstado("auto");
		String estado = "****";
		
		
		Assert.assertEquals(estado, jugada.getEstado());
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoUnaLetraAMinisculaElEstadoDebeSeraAYTresAsteriscos(){
		Jugada jugada = new Jugada();
		jugada.inicializarEstado("auto");
		jugada.arriesgarLetra('a');
		
		String estado = "a***";
		
		Assert.assertEquals(estado, jugada.getEstado());
		
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoUnaLetraAMinisculaLasVidasDebenSeguirSiendo7(){
		Jugada jugada = new Jugada();
		jugada.inicializarEstado("auto");
		jugada.arriesgarLetra('a');
		
		
		Assert.assertEquals(7, jugada.getVidas());
		
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoUnaLetraAMayusculaLasVidasDebenSeguirSiendo7(){
		Jugada jugada = new Jugada();
		jugada.inicializarEstado("auto");
		jugada.arriesgarLetra('A');
		
		Assert.assertEquals(7, jugada.getVidas());
		
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoConLetrasEquivocadas7VecesIncorrectamenteLasVidasDebenSer0(){
		Jugada jugada = new Jugada();
		jugada.inicializarEstado("auto");
		jugada.arriesgarLetra('q');
		jugada.arriesgarLetra('w');
		jugada.arriesgarLetra('e');
		jugada.arriesgarLetra('r');
		jugada.arriesgarLetra('y');
		jugada.arriesgarLetra('i');
		jugada.arriesgarLetra('p');
		
		Assert.assertEquals(0, jugada.getVidas());
		
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoConLetrasEquivocadas7VecesIncorrectamenteElEstadoDebeSerAhorcado(){
		Jugada jugada = new Jugada();
		jugada.inicializarEstado("auto");
		jugada.arriesgarLetra('q');
		jugada.arriesgarLetra('w');
		jugada.arriesgarLetra('e');
		jugada.arriesgarLetra('r');
		jugada.arriesgarLetra('y');
		jugada.arriesgarLetra('i');
		jugada.arriesgarLetra('p');
		
		Assert.assertEquals("Ahorcado", jugada.getEstado());
		
	}

}
