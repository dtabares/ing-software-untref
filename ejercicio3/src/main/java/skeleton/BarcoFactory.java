package skeleton;

public class BarcoFactory {
	
	public Barco getBarco(String tipoDeBarco){
		
		if(tipoDeBarco.equalsIgnoreCase("destructor")){
			return new Destructor();
		}
		
		if(tipoDeBarco.equalsIgnoreCase("acorazado")){
			return new Acorazado();
		}
		
		return null;
	}

}
