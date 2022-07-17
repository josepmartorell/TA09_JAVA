package cine_06;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

public class Cine {
	private ArrayList<Butaca> butacas = new ArrayList<Butaca>();
	private Pelicula pelicula;
	private float precioEntrada;
	private ArrayList<Espectador> espectadores = new ArrayList<Espectador>();
	private int aforo;

	/**
	 * Constructor con aforo y pelicula
	 * 
	 * @param pelicula
	 * @param aforo
	 */
	public Cine() {
		crearButacas();
		this.precioEntrada = 10F;
		this.aforo = this.butacas.size();
	}

	// Getters y setters

	/**
	 * @return butacas butacas
	 */
	public ArrayList<Butaca> getButacas() {
		return butacas;
	}

	/**
	 * @param butacas butacas
	 */
	public void setButacas(ArrayList<Butaca> butacas) {
		this.butacas = butacas;
	}

	/**
	 * @return the pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * @param pelicula the pelicula to set
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * @return the espectadores
	 */
	public ArrayList<Espectador> getEspectadores() {
		return espectadores;
	}

	/**
	 * @param espectadores the espectadores to set
	 */
	public void setEspectadores(ArrayList<Espectador> espectadores) {
		this.espectadores = espectadores;
	}

	// Otros metodos

	/**
	 * Metodo que a�ade todas las butacas a un arraylist de butacas (8 columnas * 9
	 * filas = 72 butacas)
	 */
	public void crearButacas() {
		String[] columnas = { "1", "2", "3", "4", "5", "6", "7", "8" };
		String[] filas = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };

		// Recorremos el array de columnas y por cada posicion recorremos el de filas
		for (int i = 0; i < columnas.length; i++) {
			for (int j = 0; j < filas.length; j++) {
				String nombre = columnas[i] + filas[j];
				Butaca butaca = new Butaca(nombre, false);
				this.butacas.add(butaca);
			}
		}
	}

	/**
	 * Metodo que crea "num" de espectadores con atributos aleatorios
	 * 
	 * @param num
	 * @param cine
	 */
	public void crearEspectadoresAleatorios(int num) {

		final String chars = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < num; i++) {
			// Edad random
			int edad = (int) (Math.random() * (110 - 4)) + 4;

			// Dinero random
			float dinero = (float) (Math.random() * (100 - 0)) + 0;

			// Nombre random
			SecureRandom random = new SecureRandom();
			String name = IntStream.range(0, ((int) (Math.random() * (10 - 3)) + 3))
					.map(k -> random.nextInt(chars.length()))
					.mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex))).collect(Collectors.joining());

			// Creamos un espectador
			Espectador e = new Espectador(name, edad, dinero, "");

			// Lo insertamos en la lista de espectadores del cine
			this.espectadores.add(e);
		}
	}

	/**
	 * Este metodo asigna aleatoriamente espectadores a las butacas a partir del
	 * array de espectadores
	 */
	public void asignarEspectadoresAleatoriamente() {
		ArrayList<Espectador> espectadoresAptos = new ArrayList<Espectador>();
		Iterator<Espectador> itr = this.espectadores.iterator();
		int espectadoresSentados = 0;

		// Iteramos por cada espectador del contenedor espectadores
		while (itr.hasNext()) {
			Espectador espectador = itr.next();

			if (validar(espectador.getEdad(), espectador.getDinero()) && espectadoresSentados < this.aforo) {
				// Incrementamos contador de espectadores sentados
				espectadoresSentados++;

				// Busca una butaca aleatoria, comprueba que no este ocupada, asigna la primera
				// que encuentra libre
				int butaca;
				do {
					butaca = (int) (Math.random() * ((this.butacas.size()) - 0)) + 0;
				} while (this.butacas.get(butaca).isOcupado());

				// Butaca cambia a ocupada
				this.butacas.get(butaca).setOcupado(true);

				// Se asigna el nombre de la butaca a la variable butaca del espectador
				espectador.setButacaAsignada(this.butacas.get(butaca).getNombre());

				espectadoresAptos.add(espectador);
			}
		}

		this.espectadores = espectadoresAptos;
	}

	/**
	 * Metodo que valida que exista localidad libre, la edad permitida para la
	 * pelicula y el dinero del espectador
	 * 
	 * @param edad
	 * @param dinero
	 * @return
	 */
	public boolean validar(int edad, float dinero) {
		// Si se cumplen los requisitos el espectador puede sentarse
		if ((this.pelicula.getEdadMinima() > edad) || (dinero < precioEntrada)) {

			return false;
		}
		return true;
	}

	/**
	 * M�todo que muestra los espectadores y sus atributos en sus respectivas
	 * butacas
	 * 
	 * @return
	 */
	public String mostrarEspectadores() {
		String infoGente = "";
		Iterator<Espectador> itrEspectadores = this.espectadores.iterator();
		while (itrEspectadores.hasNext()) {
			Espectador espectador = itrEspectadores.next();
			infoGente += "Nombre: " + espectador.getNombre() + " | Edad: " + espectador.getEdad() + " | Butaca: "
					+ espectador.getButacaAsignada() + "\n";
		}
		JOptionPane.showMessageDialog(null, infoGente, "ESPECTADORES", JOptionPane.INFORMATION_MESSAGE);

		return null;
	}

	/**
	 * Metodo que muestra por pantalla todas las butacas y luego las disponibles
	 */
	public void mostrarPlatea() {

		String[][] platea = { { "1A", "1B", "1C", "1D", "1E", "1F", "1G", "1H", "1I" },
				{ "2A", "2B", "2C", "2D", "2E", "2F", "2G", "2H", "2I" },
				{ "3A", "3B", "3C", "3D", "3E", "3F", "3G", "3H", "3I" },
				{ "4A", "4B", "4C", "4D", "4E", "4F", "4G", "4H", "4I" },
				{ "5A", "5B", "5C", "5D", "5E", "5F", "5G", "5H", "5I" },
				{ "6A", "6B", "6C", "6D", "6E", "6F", "6G", "6H", "6I" },
				{ "7A", "7B", "7C", "7D", "7E", "7F", "7G", "7H", "7I" },
				{ "8A", "8B", "8C", "8D", "8E", "8F", "8G", "8H", "8I" } };
		alignamentJoption(platea, "PLATEA");

		String[][] plateaAsientosDisponibles = platea;
		Iterator<Butaca> itrButaca = this.butacas.iterator();

		for (int i = 0; i < platea.length; i++) {
			for (int j = 0; j < platea[i].length; j++) {
				Butaca butaca = itrButaca.next();
				if (butaca.isOcupado()) {
					plateaAsientosDisponibles[i][j] = "  ";
				}
			}
		}
		alignamentJoption(plateaAsientosDisponibles, "BUTACAS DISPONIBLES");
	}

	/**
	 * Metodo que crea el JOptionPanel que la funcion mostrarPlatea() mostrara por
	 * pantalla
	 * 
	 * @param arr
	 * @param chart
	 */
	private void alignamentJoption(String[][] arr, String chart) {

		String output;
		StringBuilder sb = new StringBuilder();
		sb.append("<html><table cellspacing=15>");
		for (int i = 0; i < arr.length; i++) {
			sb.append("<tr>");
			for (int j = 0; j < arr.length + 1; j++) {
				sb.append("<td>").append(arr[i][j]).append(" ").append("</td>");
			}
		}
		sb.append("</tr></table></html>");
		output = sb.toString();

		JOptionPane.showMessageDialog(null, output, chart, JOptionPane.PLAIN_MESSAGE);

	}

	/**
	 * Metodo que crea y muestra las caracter�sticas de la pel�cula en el cine,
	 * pregunta cuanta gente intentara ver la pelicula, filtra a la gente entre los
	 * que pueden ser o no espectadores, les asigna butaca y muestra toda la info
	 * por pantalla
	 */
	public void salaProyeccion() {

		// Creamos la pelicula
		this.pelicula = new Pelicula("El club de la lucha", 90, 18, "David Fincher");

		// Mostramos sus atributos
		JOptionPane.showMessageDialog(null,
				"TITULO: " + this.pelicula.getTitulo() + "\nDURACION: " + this.pelicula.getDuracion()
						+ "\nEDAD MINIMA: " + this.pelicula.getEdadMinima() + "\nDIRECTOR: "
						+ this.pelicula.getDirector() + "\nCOSTE: 10�" + "\n",
				"CINE", JOptionPane.INFORMATION_MESSAGE);

		int numEspectadores = Integer.parseInt(
				JOptionPane.showInputDialog("Introduce el numero de espectadores que iran a ver la pelicula de culto "
						+ pelicula.getTitulo() + " (max. aforo 72):"));
		crearEspectadoresAleatorios(numEspectadores);
		asignarEspectadoresAleatoriamente();
		mostrarPlatea();
		mostrarEspectadores();
	}
}
