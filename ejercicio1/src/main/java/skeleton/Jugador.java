package skeleton;

public class Jugador {
	
	private String nombre;
	private Figura figura;
	
	public Jugador(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public Figura getFigura() {
		return figura;
	}
	public void elegirFigura(Figura figura) {
		this.figura = figura;
	}
	
}
