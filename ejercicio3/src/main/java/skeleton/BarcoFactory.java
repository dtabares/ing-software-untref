package skeleton;

public class BarcoFactory {
	
	public Barco getBarco(String tipoDeBarco){
		
		if(tipoDeBarco.equalsIgnoreCase("destructor")){
			return new Destructor();
		}
		
		return null;
	}

}
