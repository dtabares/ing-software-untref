package skeleton;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

	BatallaNaval batallaNaval;
	EstadoPosicionamiento estadoPosicionamiento;
	EstadoDisparo estadoDisparo;
	
	
	@Given("^la posicion \\((.*?),(\\d+)\\) del mapa esta libre$")
	public void la_posicion_esta_libre(char posX, int posY) {
		batallaNaval = new BatallaNaval();
		Assert.assertEquals(EstadoPosicionamiento.Libre,
				batallaNaval.getEstadoPosicion(posX, posY));
	}

	@Given("^la posicion \\((.*?),(\\d+)\\) esta libre y la posicion \\((.*?),(\\d+)\\) esta libre$")
	public void la_posicion_esta_libre_y_la_posicion_esta_libre(char posX1,
			int posY1, char posX2, int posY2) {
		batallaNaval = new BatallaNaval();
		Assert.assertEquals(EstadoPosicionamiento.Libre,
				batallaNaval.getEstadoPosicion(posX1, posY1));
		Assert.assertEquals(EstadoPosicionamiento.Libre,
				batallaNaval.getEstadoPosicion(posX2, posY2));

	}

	@Given("^la posicion \\((.*?),(\\d+)\\) esta ocupada$")
	public void la_posicion_esta_ocupada(char posX, int posY) {
		batallaNaval = new BatallaNaval();
		batallaNaval.posicionarBarco("destructor", posX, posY, "horizontal");
	}

	@Given("^el tablero es de 10 x 10$")
	public void tablero_es_de_x() {
		batallaNaval = new BatallaNaval();
	}
	
	@Given("^la posicion \\((.*?),(\\d+)\\) del mapa tiene un acorazado$")
	public void la_posicion_del_mapa_tiene_un_acorazado(char posX, int posY) {
		batallaNaval = new BatallaNaval();
		batallaNaval.posicionarBarco("acorazado", posX, posY, "horizontal");
	}


	@When("^jugador posiciona la figura \"(.*?)\" en la posicion \\((.*?),(\\d+)\\) de forma \"(.*?)\"$")
	public void jugador_posiciona_la_figura_en_la_posicion_de_forma(
			String tipoDeBarco, char posX, int posY, String formaDePosicionar) {
		estadoPosicionamiento = batallaNaval.posicionarBarco(tipoDeBarco, posX, posY,
				formaDePosicionar);
	}
	
	@When("^realizo un disparo a la posicion \\((.*?),(\\d+)\\)$")
	public void realizo_un_disparo_a_la_posicion(char posX, int posY){
		estadoDisparo = batallaNaval.disparar(posX,posY);
	}


	@Then("^la operacion se realiza correctamente$")
	public void la_operacion_se_realiza_correctamente() {

		Assert.assertEquals(EstadoPosicionamiento.OK, estadoPosicionamiento);
	}

	@Then("^no se puede posicionar un barco en una casilla ocupada$")
	public void no_se_puede_posicionar_un_barco_en_una_casilla_ocupada() {
		Assert.assertEquals(EstadoPosicionamiento.Ocupado,
				estadoPosicionamiento);
	}

	@Then("^la posicion elegida no pertenece al tablero$")
	public void la_posicion_elegida_no_pertenece_al_tablero() {
		Assert.assertEquals(EstadoPosicionamiento.FueraDelMapa,
				estadoPosicionamiento);
	}
	
	@Then("^el resultado es Agua$")
	public void el_resultado_es_Agua() {
		Assert.assertEquals(EstadoDisparo.Agua, estadoDisparo);
	}
	
	@Then("^el resultado es Disparo Fuera del Tablero No permitido$")
	public void el_resultado_es_Disparo_Fuera_del_Tablero_No_permitido() {
		Assert.assertEquals(EstadoDisparo.FueraDeRango, estadoDisparo);
	}
	
	@Then("^el resultado es Tocado$")
	public void el_resultado_es_Tocado() {
		Assert.assertEquals(EstadoDisparo.Tocado, estadoDisparo);
	}
	
	@Then("^el resultado es Hundido$")
	public void el_resultado_es_Hundido(){
		Assert.assertEquals(EstadoDisparo.Hundido, estadoDisparo);
	}




}
