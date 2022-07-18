package aula_05;

public class Estudiante extends Persona {
	
	private float calificacion;
	
	/**
	 * Constructor por defecto
	 * 
	 * @param edadMax
	 */
	public Estudiante(int edadMax) {
		super(edadMax);
		this.calificacion = (float) (Math.random() * (10 - 0)) + 0;
	}

	/**
	 * @param calificacion
	 * @param edadMax
	 */
	public Estudiante(float calificacion, int edadMax) {
		super(edadMax);
		this.calificacion = calificacion;
	}
	
	/**
	 * @param nombre
	 * @param edad
	 * @param sexo
	 * @param calificacion
	 */
	public Estudiante(String nombre, int edad, char sexo, float calificacion) {
		super(nombre, edad, sexo);
		this.calificacion = calificacion;
	}
	
	/**
	 * @return the calificacion
	 */
	public float getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * Metodo que calcula la asistencia del estudiante, probabilidad: 50%
	 */
	public boolean asistecia() {
		
		int prob = (int) (Math.random() * (1 - 0)) + 0;
		if (prob == 1) {
			return true;
		}else {
			return false;
		}
	}

}
