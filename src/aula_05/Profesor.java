package aula_05;
import java.util.Random;

public class Profesor extends Persona {
	
	private String materia;
	
	/**
	 * Constructor por defecto
	 * 
	 * @param edadMax
	 */
	public Profesor(int edadMax) {
		super(edadMax);
		String[] chrs = {"Matematicas", "Filosofia", "Fisica"};
		Random random = new Random();
		this.materia = chrs[random.nextInt(3)];
	}

	/**
	 * @param materia
	 * @param edadMax
	 */
	public Profesor(String materia, int edadMax) {
		super(edadMax);
		this.materia = materia;
	}
	
	/**
	 * Constructor por todos los parametros
	 * 
	 * @param nombre
	 * @param edad
	 * @param sexo
	 * @param calificacion
	 */
	public Profesor(String nombre, int edad, char sexo, String materia) {
		super(nombre, edad, sexo);
		this.materia = materia;
	}
	
	/**
	 * @return the materia
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * @param materia the materia to set
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}

	/**
	 * Metodo que calcula la asistencia del profesor, probabilidad: 20%
	 */
	public boolean asistecia() {
		int prob = (int) (Math.random() * (4 - 0)) + 0;
		if (prob == 4) {
			return false;
		}else {
			return true;
		}
	}
}
