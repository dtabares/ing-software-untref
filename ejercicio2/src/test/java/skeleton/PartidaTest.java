package skeleton;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PartidaTest {

	@Test
	public void cuandoSeteamosLaPalabraSecretaComoAutoElEstadoDebeSer4Astericos() {
		Partida partida = new Partida();
		partida.inicializarEstado("auto");
		String estado = "****";
		
		
		Assert.assertEquals(estado, partida.getEstado());
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoUnaLetraAMinisculaElEstadoDebeSeraAYTresAsteriscos(){
		Partida partida = new Partida();
		partida.inicializarEstado("auto");
		partida.arriesgarLetra('a');
		
		String estado = "a***";
		
		Assert.assertEquals(estado, partida.getEstado());
		
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoUnaLetraAMinisculaLasVidasDebenSeguirSiendo7(){
		Partida partida = new Partida();
		partida.inicializarEstado("auto");
		partida.arriesgarLetra('a');
		
		
		Assert.assertEquals(7, partida.getVidas());
		
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoUnaLetraAMayusculaLasVidasDebenSeguirSiendo7(){
		Partida partida = new Partida();
		partida.inicializarEstado("auto");
		partida.arriesgarLetra('A');
		
		Assert.assertEquals(7, partida.getVidas());
		
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoConLetrasEquivocadas7VecesIncorrectamenteLasVidasDebenSer0(){
		Partida partida = new Partida();
		partida.inicializarEstado("auto");
		partida.arriesgarLetra('q');
		partida.arriesgarLetra('w');
		partida.arriesgarLetra('e');
		partida.arriesgarLetra('r');
		partida.arriesgarLetra('y');
		partida.arriesgarLetra('i');
		partida.arriesgarLetra('p');
		
		Assert.assertEquals(0, partida.getVidas());
		
	}
	
	@Test
	public void cuandoLaPalabraEsAutoYArriesgoConLetrasEquivocadas7VecesIncorrectamenteElEstadoDebeSerAhorcado(){
		Partida partida = new Partida();
		partida.inicializarEstado("auto");
		partida.arriesgarLetra('q');
		partida.arriesgarLetra('w');
		partida.arriesgarLetra('e');
		partida.arriesgarLetra('r');
		partida.arriesgarLetra('y');
		partida.arriesgarLetra('i');
		partida.arriesgarLetra('p');
		
		Assert.assertEquals("Ahorcado", partida.getEstado());
		
	}

}
