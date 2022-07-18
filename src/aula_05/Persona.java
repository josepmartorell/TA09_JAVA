package aula_05;
import java.security.SecureRandom;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

abstract class Persona {
	
	protected String nombre;
	protected int edad;
	protected char sexo;
	
	protected Persona(int edadMax){
		crearAtributosAleatorios(edadMax);
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
	protected String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the edad
	 */
	protected int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	protected void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the sexo
	 */
	protected char getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	protected void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Crea y aplica de forma aleatoria atributos para el objeto persona
	 */
	private void crearAtributosAleatorios(int edadMax) {
		
		// Nombre random
		final String chars = "abcdefghijklmnopqrstuvwxyz";
		
		SecureRandom random = new SecureRandom();
		this.nombre = IntStream.range(0, ((int) (Math.random() * (10 - 3)) + 3))
				.map(k -> random.nextInt(chars.length()))
				.mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex))).collect(Collectors.joining());
		
		// Edad random
		this.edad = (int) (Math.random() * (edadMax - 12)) + 12;
		
		// Sexo random
		char[] chrs = {'H', 'M'};
		Random random1 = new Random();
		this.sexo = chrs[random1.nextInt(2)];
	}
	
	/**
	 * @return
	 */
	public abstract boolean asistecia();
}
