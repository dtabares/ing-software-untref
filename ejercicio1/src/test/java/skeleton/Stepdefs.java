package skeleton;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	Jugador jugador1;
	Jugador jugador2;
	Juego juego;
	
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        Belly belly = new Belly();
        belly.eat(cukes);
    }
    
    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Throwable {
    	
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
    		
    }
    
    @Given("^jugador1 juega PIEDRA$")
    public void jugador1_juega_PIEDRA() {		
    	this.jugador1 = new Jugador("JUGADOR1");
    	this.jugador1.elegirFigura(new Piedra());
    }

    @When("^jugador2 juega PIEDRA$")
    public void jugador2_juega_PIEDRA() {
    	this.jugador2 = new Jugador("JUGADOR2");
    	this.jugador2.elegirFigura(new Piedra());

    }

    
    @Then("^hay empate$")
    public void hay_empate() {
    	this.juego = new Juego(this.jugador1,this.jugador2);
    	Assert.assertEquals("EMPATE", this.juego.jugar());
    }


}
