package aula_05;

import java.util.ArrayList;
import java.util.Iterator;

public class Aula {
	
	private int id;
	private int numMaxEstudiantes;
	private String materia;
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
	private Profesor profesor;
	private boolean aulaValida;
	
	/**
	 * Constructor con todos los atributos
	 * 
	 * @param id
	 * @param numMaxEstudiantes
	 * @param materia
	 * @param estudiantes
	 */
	public Aula(int id, int numMaxEstudiantes, String materia) {
		
		this.id = id;
		this.numMaxEstudiantes = numMaxEstudiantes;
		this.materia = materia;
		crearEstudiantesRandom(numMaxEstudiantes);
		this.profesor = crearProfesorRandom();
		this.aulaValida = validarAula();
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the numMaxEstudiantes
	 */
	public int getNumMaxEstudiantes() {
		return numMaxEstudiantes;
	}

	/**
	 * @param numMaxEstudiantes the numMaxEstudiantes to set
	 */
	public void setNumMaxEstudiantes(int numMaxEstudiantes) {
		this.numMaxEstudiantes = numMaxEstudiantes;
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
	 * @return the estudiantes
	 */
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	/**
	 * @param estudiantes the estudiantes to set
	 */
	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	/**
	 * @return the profesor
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * @param profesor the profesor to set
	 */
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	/**
	 * @return the aulaValida
	 */
	public boolean isAulaValida() {
		if(this.aulaValida) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param aulaValida the aulaValida to set
	 */
	public void setAulaValida(boolean aulaValida) {
		this.aulaValida = aulaValida;
	}

	/**
	 * Metodo que crea el maximo de estudiantes aleatoriamente
	 */
	public void crearEstudiantesRandom(int max) {
		// Creamos tantos estudiantes como se indique en el argumento
		for (int i = 0; i < max; i++) {
			// Creamos un estudiante con atributos aleatorios entre 11 y 25 de edad
			Estudiante e = new Estudiante(25, 11);

			// Lo insertamos en la lista de estudiantes del aula
			this.estudiantes.add(e);
		}
	}

	/**
	 * Metodo que crea un profesor aleatorio
	 */
	public Profesor crearProfesorRandom() {
		int maxEdad = 67;
		
		// Creamos un profesor con atributos aleatorios entre 18 y el max de edad (jubilacion de 66)
		Profesor p = new Profesor(maxEdad, 18);
		
		return p;
	}

	/**
	 * Metodo que valida si la aula es valida para dar clase
	 */
	public boolean validarAula() {
		// Primero comprobamos que el profesor asiste y imparte la materia del aula
		if (this.profesor.isAsistencia() && this.profesor.getMateria().equals(this.materia)) {
			// En ese caso inicializamos la comprobacion de la asistencia del alumnado
			Iterator<Estudiante> it = this.estudiantes.iterator();
			Estudiante e = null;
			int count = 0;
			while (it.hasNext()) {
				e = it.next();
				if (e.isAsistencia()) {
					// Contamos alumnos que han asistido
					count++;
					System.out.println("hola");
				}
			}
			// Si la asistencia de alumnos llega al 50% del maximo el aula es valida
			if((this.numMaxEstudiantes/2)<=count) {
				this.aulaValida = true;
				return this.aulaValida;
			}
		}
		// Sino devolvemos false
		this.aulaValida = false;
		return this.aulaValida;
	}
}