package skeleton;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class JugadaTest {

	@Test
	public void cuandoSeteamosLaPalabraSecretaComoAutoElEstadoDebeSer4Astericos() {
		Jugada jugada = new Jugada();
		jugada.inicializarEstado("auto");
		char[] estado = new char[4];
		estado[0] = '*';
		estado[1] = '*';
		estado[2] = '*';
		estado[3] = '*';
		
		Assert.assertArrayEquals(estado, jugada.getEstado());
	}
	
/*	@Test
	public void cuandoLaPalabraEsAutoYArriesgoUnaLetraAMinisculaElEstadoDebeSeraAYTresAsteriscos(){
		Jugada jugada = new Jugada();
		jugada.inicializarEstado("auto");
		jugada.arriesgarLetra('a');
		
		char[] estado = new char[4];
		estado[0] = 'a';
		estado[1] = '*';
		estado[2] = '*';
		estado[3] = '*';
		
		Assert.assertArrayEquals(estado, jugada.getEstado());
		
	}*/

}
