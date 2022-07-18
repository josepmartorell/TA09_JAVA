package serie_02;

public class Serie implements Entregable {
	
	private String titulo;
	private int numTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;
	
	/**
	 * Constructor default
	 */
	public Serie() {
		
		this.titulo = "";
		this.numTemporadas = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = "";
	}

	/**
	 * Constructor con titulo y creador
	 * 
	 * @param titulo
	 * @param creador
	 */
	public Serie(String titulo, String creador) {
		
		this.titulo = titulo;
		this.numTemporadas = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = creador;
	}
	
	/**
	 * Constructor con todos los parametros
	 * 
	 * @param titulo
	 * @param numTemporadas
	 * @param genero
	 * @param creador
	 */
	public Serie(String titulo, int numTemporadas, String genero, String creador) {
		
		this.titulo = titulo;
		this.numTemporadas = numTemporadas;
		this.entregado = false;
		this.genero = genero;
		this.creador = creador;
	}

	/**
	 * Devuelve el titulo
	 * 
	 * @return
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Settea el titulo
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Devuelve el numero de temporadas
	 * 
	 * @return
	 */
	public int getNumTemporadas() {
		return numTemporadas;
	}

	/**
	 * Settea el numero de temporadas
	 * 
	 * @param numTemporadas
	 */
	public void setNumTemporadas(int numTemporadas) {
		this.numTemporadas = numTemporadas;
	}

	/**
	 * Devuelve el genero
	 * 
	 * @return
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Settea el genero
	 * 
	 * @param genero
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Devuelve el creador
	 * 
	 * @return
	 */
	public String getCreador() {
		return creador;
	}

	/**
	 * Settea el creador
	 * 
	 * @param creador
	 */
	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", numTemporadas=" + numTemporadas + ", entregado=" + entregado + ", genero="
				+ genero + ", creador=" + creador + "]";
	}

	/**
	 * Cambia el estado de entregado a verdadero
	 */
	public void entregar() {
		this.entregado = true;
		
	}

	/**
	 * Cambia el estado de entregado a falso
	 */
	public void devolver() {
		this.entregado = false;
		
	}

	/**
	 * Devuelve el estado de entregado
	 */
	public boolean isEntregado() {
		return entregado;
		
	}

	/**
	 * Metodo que compara numero de temporadas
	 */
	public boolean compareTo(Object a) {
        boolean match = false;
        if (this.numTemporadas == (int) a)
        	match = true;
    	return match;
    	
	}
	
}