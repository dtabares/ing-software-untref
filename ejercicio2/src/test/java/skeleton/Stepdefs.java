package skeleton;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	Ahorcado ahorcado;
	
	@Given("^la palabra secreta es \"(.*)\"$")
	public void seteoLaPalabraSecreta(String palabraSecreta) {
		ahorcado = new Ahorcado();
		ahorcado.setPalabraSecreta(palabraSecreta);
	}
	
	@When("^arriesgo \"(.*?)\"$")
	public void arriesgo(char letra) {
		ahorcado.arriesgarLetra(letra);
	}
	
	@Then("^estado es \"(.*?)\"$")
	public void estado_es(String estado) {
		Assert.assertEquals(estado, ahorcado.getEstado());
	}
	
	@Then("^me quedan (\\d+) vidas$")
	public void me_quedan_vidas(int cantidadDeVidas)  {
		Assert.assertEquals(cantidadDeVidas, ahorcado.getVidas());
	}


}
