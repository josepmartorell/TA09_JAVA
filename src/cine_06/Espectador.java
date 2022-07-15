package cine_06;

public class Espectador {
	
	private String nombre;
	private int edad;
	private float dinero;
	private String butacaAsignada;
	
	public Espectador() {
		
		this.nombre = "Pepe";
		this.edad = 18;
		this.dinero = 10F;
		this.butacaAsignada = "";
	}

	public Espectador(String nombre, int edad, float dinero, String butacaAsignada) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.dinero = dinero;
		this.butacaAsignada = butacaAsignada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getDinero() {
		return dinero;
	}

	public void setDinero(float dinero) {
		this.dinero = dinero;
	}

	public String getButacaAsignada() {
		return butacaAsignada;
	}

	public void setButacaAsignada(String butacaAsignada) {
		this.butacaAsignada = butacaAsignada;
	}	
}
