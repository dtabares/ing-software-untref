package skeleton;

import org.junit.*;

public class BarcoFactoryTest {
	
	@Test
	public void cuandoElParametroEsDestructorEnMinusculasDebeDevolvermeUnObjetoDeTipoDestructor(){
		BarcoFactory fabricaDeBarcos = new BarcoFactory();
		
		Barco destructor = fabricaDeBarcos.getBarco("destructor");
		
		Assert.assertEquals(Destructor.class, destructor.getClass());
	}
	
	@Test
	public void cuandoElParametroEsAcorazadoEnMinusculasDebeDevolvermeUnObjetoDeTipoDestructor(){
		BarcoFactory fabricaDeBarcos = new BarcoFactory();
		
		Barco destructor = fabricaDeBarcos.getBarco("acorazado");
		
		Assert.assertEquals(Acorazado.class, destructor.getClass());
	}
	
	@Test
	public void cuandoElParametroEsLanchaEnMinusculasDebeDevolvermeUnObjetoDeTipoDestructor(){
		BarcoFactory fabricaDeBarcos = new BarcoFactory();
		
		Barco destructor = fabricaDeBarcos.getBarco("lancha");
		
		Assert.assertEquals(Lancha.class, destructor.getClass());
	}
	
	@Test
	public void cuandoElParametroEsDestructorEnMayusculasDebeDevolvermeUnObjetoDeTipoDestructor(){
		BarcoFactory fabricaDeBarcos = new BarcoFactory();
		
		Barco destructor = fabricaDeBarcos.getBarco("DESTRUCTOR");
		
		Assert.assertEquals(Destructor.class, destructor.getClass());
	}
	
	@Test
	public void cuandoElParametroEsDestructorMezclandoMayusculasYMinusculasDebeDevolvermeUnObjetoDeTipoDestructor(){
		BarcoFactory fabricaDeBarcos = new BarcoFactory();
		
		Barco destructor = fabricaDeBarcos.getBarco("DeSTrUCtOR");
		
		Assert.assertEquals(Destructor.class, destructor.getClass());
	}

}
