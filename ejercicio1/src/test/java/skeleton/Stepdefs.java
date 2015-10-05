package skeleton;


import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
	
	Jugador jugador1;
	Jugador jugador2;
	Juego juego;
    
    @Given("^jugador1 juega (PIEDRA|PAPEL|TIJERA)$")
    public void jugador1_juega(String nombreFigura) {		
    	this.jugador1 = new Jugador("JUGADOR1");
    	switch(nombreFigura){
	    	case "PIEDRA":	this.jugador1.elegirFigura(new Piedra());
	    					break;
	    	case "PAPEL":	this.jugador1.elegirFigura(new Papel());
	    					break;
	    	case "TIJERA":	this.jugador1.elegirFigura(new Tijera());
							break;
    	}
    	
    }

    @When("^jugador2 juega (PIEDRA|PAPEL|TIJERA)$")
    public void jugador2_juega(String nombreFigura) {
    	this.jugador2 = new Jugador("JUGADOR2");
    	switch(nombreFigura){
	    	case "PIEDRA":	this.jugador2.elegirFigura(new Piedra());
	    					break;
	    	case "PAPEL":	this.jugador2.elegirFigura(new Papel());
	    					break;
	    	case "TIJERA":	this.jugador2.elegirFigura(new Tijera());
							break;
    	}

    }

    
    @Then("^hay empate$")
    public void hay_empate() {
    	this.juego = new Juego(this.jugador1,this.jugador2);
    	Assert.assertEquals("EMPATE", this.juego.jugar());
    }
    
    @Then("^gana jugador(\\d+)$")
    public void gana_jugador(int numJugador) {
    	this.juego = new Juego(this.jugador1,this.jugador2);
    	if(numJugador == 1){
    		Assert.assertEquals("Gana JUGADOR1", this.juego.jugar());
    	}
    	else{
    		Assert.assertEquals("Gana JUGADOR2", this.juego.jugar());
    	}
    	
    }



}
