import javax.swing.JOptionPane;

import cine_06.Cine;
import electrodomestico_01.Electrodomestico;
import electrodomestico_01.Lavadora;
import electrodomestico_01.Television;
import serie_02.Serie;
import serie_02.Videojuego;

public class MainApp {

	/**
	 * Metodo main que llama al menu principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		initializeMenu();
	}

	/**
	 * Menu inicial
	 */
	public static void initializeMenu() {

		// Mensaje con las diferentes opciones del menu
		final String menuOpciones = "Elija una opción." + "\n1 - Aplicación Electrodoméstico" + "\n2 - Aplicación Serie"
				+ "\n3 - Aplicación Libro" + "\n4 - Aplicación Raices" + "\n5 - Aplicación Aula POO"
				+ "\n6 - Aplicación Cine" + "\n0 - SALIR";
		String opcion = "";

		// Bucle infinito del menu hasta que se cierre con el Exit o cancelando
		do {
			opcion = JOptionPane.showInputDialog(menuOpciones);
			switch (opcion) {
			case "0":
				JOptionPane.showMessageDialog(null, "FIN DE PROGRAMA");
				break;
			case "1":
				pruebasPrimerEjercicio();
				break;
			case "2":
				pruebasSegundoEjercicio();
				break;
			case "3":
				// TODO
				break;
			case "4":
				// TODO
				break;
			case "5":
				// TODO
				break;
			case "6":
				Cine cine = new Cine();
				cine.salaProyeccion();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción incorrecta");
			}

		} while (!opcion.equals("0"));
	}
	
	/**
	 * Metodo que hace las pruebas del primer ejercicio
	 */
	public static void pruebasPrimerEjercicio() {
		// Creamos 10 electrodomesticos por defecto
		Electrodomestico[] electrodomesticos = {
				new Electrodomestico(),
				new Electrodomestico(120F, 54),
				new Electrodomestico(),
				new Electrodomestico(300F, 80),
				new Lavadora(),
				new Lavadora(354.99F, 12),
				new Lavadora(),
				new Television(),
				new Television(599.99F, 10),
				new Television(),
		};
		
		// Inicializamos variables para recoger el precio de los electrodomesticos de cada clase
		float precioElec = 0F;
		float precioLavadora = 0F;
		float precioTelevision = 0F;
		
		// Bucle recorriendo el array de electrodomesticos, llamando a la funcion precioFinal() de cada uno y sumandolos al total de cada tipo
		for (int i = 0; i < electrodomesticos.length; i++) {
			if(electrodomesticos[i] instanceof Electrodomestico) {
				precioElec += electrodomesticos[i].precioFinal();
			}
			if (electrodomesticos[i] instanceof Lavadora) {
				precioLavadora += electrodomesticos[i].precioFinal();
			}
			if (electrodomesticos[i] instanceof Television) {
				precioTelevision += electrodomesticos[i].precioFinal();
			}
		}
		
		// Mostrar el resultado por pantalla
		JOptionPane.showMessageDialog(null, "Precio electrodomesticos: " + precioElec + " eur.\nPrecio lavadoras: " + precioLavadora + " eur.\nPrecio televisiones: " + precioTelevision + " eur.");
		}
	
	/**
	 * Metodo que hace pruebas del segundo ejercicio
	 */
	public static void pruebasSegundoEjercicio() {
		// instanciamos 5 objetos Serie y también 5 objetos Videojuego con distintos constructores
		Serie[] serie = {
				new Serie(),
				new Serie("Star Trek", "Gene Roddenberry"),
				new Serie("Blade Runner 2049", 3, "SciFi", "Ridley Scott"),
				new Serie("Mr Robot", 4, "Hackers", "Sam Esmail "),
				new Serie("WestWorld", 4, "Scifi distopic", " Michael Crichton)"),
		};
		Videojuego[] videojuego = {
				new Videojuego(),
				new Videojuego("Invaders", 2),
				new Videojuego("Mandinga", 1),
				new Videojuego("Super Mario", 4, "Acción", "Nintendo"),
				new Videojuego("World of Tanks", 6, "Bélico", "Gianluigi Buffon"),
		};
		
		for (int i = 0; i < serie.length; i++){
			serie[i].entregar();
			videojuego[i].entregar();
			JOptionPane.showMessageDialog(null, "Entregada serie "+serie[i].getTitulo()+" dirigida por "+serie[i].getCreador()
					+ "\nEntregado video juego "+videojuego[i].getTitulo()+" de "+videojuego[i].getCompany());
			JOptionPane.showMessageDialog(null, "Pulsar aceptar para gestionar el préstamo");
			boolean prestamo = seleccionarOpcion();
			if (prestamo != false) {
				serie[i].devolver();
				videojuego[i].devolver();
				JOptionPane.showMessageDialog(null, "Devolución serie "+serie[i].getTitulo()+" dirigida por "+serie[i].getCreador()
						+ "\nDevolución video juego "+videojuego[i].getTitulo()+" de "+videojuego[i].getCompany());					
			}
			System.exit(i);
		}
	}
	
	
	public static boolean seleccionarOpcion() {
		
		boolean gate = false;		
		int n = JOptionPane.showConfirmDialog(null, "Devolver los prestamos","VIDEO CLUB",JOptionPane.YES_NO_OPTION);		
		if (n == JOptionPane.YES_OPTION) {
			gate = true;		
		} else if (n == JOptionPane.NO_OPTION) {
			System.exit(n);
		} else {			
		}
		return gate;				
	}
	
}
