package skeleton;

public abstract class Barco {

	protected int longitud;
	protected int disparosRecibidos;
	
	
	protected int getLongitud() {
		return longitud;
	}

	protected int getDisparosRecibidos() {
		return disparosRecibidos;
	}
	
	protected void incrementarDisparosRecibidos() {
		this.disparosRecibidos++;
	}
	
	protected EstadoDisparo evaluarDanio(){
		if(this.getDisparosRecibidos() >= this.getLongitud()){
			return EstadoDisparo.Hundido;
		}
		else{
			return EstadoDisparo.Tocado;
		}
	}
	
	
	

}
