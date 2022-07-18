package serie_02;

public class Videojuego implements Entregable{
	
	private String titulo;
	private int horasEstimadas;
	private boolean entregado;
	private String genero;
	
	// Cambiamos el nombre a ingles para ahorrar errores
	private String company;
	
	/**
	 * Constructor de videojuego default
	 */
	public Videojuego() {
		this.titulo = "Default";
		this.horasEstimadas = 0;
		this.entregado = false;
		this.genero = "Default";
		this.company = "Default";
	}

	/**
	 * Constructor de videojuego solamente con titulo y horas
	 * 
	 * @param titulo
	 * @param horasEstimadas
	 */
	public Videojuego(String titulo, int horasEstimadas) {
		
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.genero = "Default";
		this.company = "Default";
	}
	
	/**
	 * Constructor de videojuego con todos los parametros
	 * 
	 * @param titulo
	 * @param horasEstimadas
	 * @param genero
	 * @param company
	 */
	public Videojuego(String titulo, int horasEstimadas, String genero, String company) {
		
		this.titulo = titulo;
		this.horasEstimadas = horasEstimadas;
		this.entregado = false;
		this.genero = genero;
		this.company = company;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the horasEstimadas
	 */
	public int getHorasEstimadas() {
		return horasEstimadas;
	}

	/**
	 * @param horasEstimadas the horasEstimadas to set
	 */
	public void setHorasEstimadas(int horasEstimadas) {
		this.horasEstimadas = horasEstimadas;
	}

	/**
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * Sobreescribimos el metodo toString
	 */
	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", horasEstimadas=" + horasEstimadas + ", entregado=" + entregado
				+ ", genero=" + genero + ", compañia=" + company + "]";
	}

	
	/**
	 * Metodo que cambia el estado de entregado a cierto
	 */
	public void entregar() {
		this.entregado = true;
		
	}

	/**
	 * Metodo que cambia el estado de entregado a falso
	 */
	public void devolver() {
		this.entregado = false;
		
	}

	/**
	 * Metodo que devuelve el estado de entregado
	 * 
	 * @return entregado verdadero o falso
	 */
	public boolean isEntregado() {
		return entregado;

	}

	/**
	 * Metodo que compara horas estimadas
	 */
	public boolean compareTo(Object a) {
        boolean match = false;
        if (this.horasEstimadas == (int) a)
        	match = true;
    	return match;
	}	
}
