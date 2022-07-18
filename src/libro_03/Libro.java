package libro_03;

public class Libro {
	
	private String isbn;
	private String titulo;
	private String autor;
	private int numPaginas;
	
	/**
	 * Constructor por defecto
	 */
	public Libro() {
		this.isbn = "Default";
		this.titulo = "Ninguno";
		this.autor = "Anonimo";
		this.numPaginas = 100;
	}
	
	/**
	 * Constructor con todos los atributos
	 * 
	 * @param isbn
	 * @param titulo
	 * @param autor
	 * @param numPaginas
	 */
	public Libro(String isbn, String titulo, String autor, int numPaginas) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the numPaginas
	 */
	public int getNumPaginas() {
		return numPaginas;
	}

	/**
	 * @param numPaginas the numPaginas to set
	 */
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	/**
	 * Sobreescribimos el metodo toString
	 */
	@Override
	public String toString() {
		return "El libro " + this.getTitulo() + " con ISBN " + this.getIsbn() + " creado por el autor "
				+ this.getAutor() + " tiene " + this.getNumPaginas() + " paginas.";
	}
	
}
