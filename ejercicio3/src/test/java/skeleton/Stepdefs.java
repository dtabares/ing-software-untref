package skeleton;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	BatallaNaval batallaNaval;
	EstadoPosicionamiento estadoPosicionamiento;
	
	@Given("^la posicion \\((.*?),(\\d+)\\) esta libre y la posicion \\((.*?),(\\d+)\\) esta libre$")
	public void la_posicion_C_esta_libre_y_la_posicion_C_esta_libre(char arg1, int arg2, char arg3, int arg4) {
	    batallaNaval = new BatallaNaval();
	    Assert.assertEquals(EstadoPosicionamiento.Libre, batallaNaval.getEstadoPosicion(arg1, arg2));
	    Assert.assertEquals(EstadoPosicionamiento.Libre, batallaNaval.getEstadoPosicion(arg3, arg4));
	    
	}
	
	@Given("^la posicion \\((.*?),(\\d+)\\) esta ocupada$")
	public void la_posicion_C_esta_ocupada(char arg1, int arg2) {
		batallaNaval = new BatallaNaval();
		batallaNaval.posicionarBarco("destructor", arg1, arg2, "horizontal");
	}

	
	@When("^jugador posiciona la figura \"(.*?)\" en la posicion \\((.*?),(\\d+)\\) de forma \"(.*?)\"$")
	public void jugador_posiciona_la_figura_en_la_posicion_C_de_forma(String arg1, char arg2, int arg3, String arg4) {
		estadoPosicionamiento = batallaNaval.posicionarBarco(arg1, arg2, arg3, arg4);
	}
	
	@Then("^la operacion se realiza correctamente$")
	public void la_operacion_se_realiza_correctamente() {
		
		Assert.assertEquals(EstadoPosicionamiento.OK, estadoPosicionamiento);
	}
	
	@Then("^no se puede posicionar un barco en una casilla ocupada$")
	public void no_se_puede_posicionar_un_barco_en_una_casilla_ocupada() {
		Assert.assertEquals(EstadoPosicionamiento.Ocupado, estadoPosicionamiento);
	}







}
