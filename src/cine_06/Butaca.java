package cine_06;

public class Butaca {
	private String nombre;
	private boolean ocupado;
	
	/**
	 * Constructor con todos los atributos
	 * 
	 * @param nombre
	 * @param ocupado
	 */
	public Butaca(String nombre, boolean ocupado) {
		this.nombre = nombre;
		this.ocupado = ocupado;
	}

	
	// Getters y setters
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}