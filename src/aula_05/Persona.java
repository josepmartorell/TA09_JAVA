package aula_05;
import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

abstract class Persona {
	
	protected String nombre;
	protected int edad;
	protected boolean asistencia;
	
	//M para mujer y H para hombre
	protected char sexo;
	
	protected Persona(int edadMax, int edadMin){
		crearAtributosAleatorios(edadMax, edadMin);
	}
	
	/**
	 * @param nombre
	 * @param edad
	 * @param sexo
	 */
	protected Persona(String nombre, int edad, char sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Metodo abstracto que implementan las clases hijas
	 * 
	 * @return
	 */
	public abstract boolean asistecia();

	/**
	 * @return the asistencia
	 */
	public boolean isAsistencia() {
		if (this.asistencia) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param asistencia the asistencia to set
	 */
	public void setAsistencia(boolean asistencia) {
		this.asistencia = asistencia;
	}
	
	/**
	 * Crea y aplica de forma aleatoria atributos para el objeto persona
	 */
	private void crearAtributosAleatorios(int edadMax, int edadMin) {
		
		// Nombre random
		final String chars = "abcdefghijklmnopqrstuvwxyz";
		
		SecureRandom random = new SecureRandom();
		this.nombre = IntStream.range(0, ((int) (Math.random() * (10 - 3)) + 3))
				.map(k -> random.nextInt(chars.length()))
				.mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex))).collect(Collectors.joining());
		
		// Edad random
		this.edad = (int) (Math.random() * (edadMax - edadMin)) + edadMin;
		
		// Sexo random
		char[] chrs = {'H', 'M'};
		Random random1 = new Random();
		this.sexo = chrs[random1.nextInt(2)];
	}
}
