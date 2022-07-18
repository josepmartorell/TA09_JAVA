import javax.swing.JOptionPane;

import cine_06.Cine;
import electrodomestico_01.Electrodomestico;
import electrodomestico_01.Lavadora;
import electrodomestico_01.Television;
import libro_03.Libro;
import raices_04.Raices;
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
		final String menuOpciones = "Elija una opcion." + "\n1 - Aplicacion Electrodomestico" + "\n2 - Aplicacion Serie"
				+ "\n3 - Aplicacion Libro" + "\n4 - Aplicacion Raices" + "\n5 - Aplicacion Aula POO"
				+ "\n6 - Aplicacion Cine" + "\n0 - SALIR";
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
				pruebasTercerEjercicio();
				break;
			case "4":
				pruebasCuartoEjercicio();
				break;
			case "5":
				// TODO
				break;
			case "6":
				Cine cine = new Cine();
				cine.salaProyeccion();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcionn incorrecta");
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
		// instanciamos 5 objetos Serie y tambien 5 objetos Videojuego con distintos constructores
		Serie[] serie = {
				new Serie(),
				new Serie("Star Trek", "Gene Roddenberry"),
				new Serie("Blade Runner 2049", 3, "SciFi", "Ridley Scott"),
				new Serie("Mr Robot", 4, "Hackers", "Sam Esmail "),
				new Serie("WestWorld", 4, "Scifi distopic", " Michael Crichton"),
		};
		Videojuego[] videojuego = {
				new Videojuego(),
				new Videojuego("Invaders", 2),
				new Videojuego("Mandinga", 1),
				new Videojuego("Super Mario", 4, "Accion", "Nintendo"),
				new Videojuego("World of Tanks", 6, "Belico", "Gianluigi Buffon"),
		};
		
		// Preguntamos si queremos devolver la serie mostrada
		for (int i = 0; i < serie.length; i++){
			serie[i].entregar();
			videojuego[i].entregar();
			JOptionPane.showMessageDialog(null, "Serie entregada  "+serie[i].getTitulo()+"  dirigida por  "+serie[i].getCreador());
			JOptionPane.showMessageDialog(null, "Videojuego entregado  "+videojuego[i].getTitulo()+"  de  "+videojuego[i].getCompany());
			JOptionPane.showMessageDialog(null, "Pulsar aceptar para gestionar el prestamo.");
			boolean prestamo = seleccionarOpcion();
			if (prestamo) {
				serie[i].devolver();
				videojuego[i].devolver();
				JOptionPane.showMessageDialog(null, "Devolucion de la serie "+serie[i].getTitulo()+" dirigida por "+serie[i].getCreador()
						+ "\nDevolucion del videojuego "+videojuego[i].getTitulo()+" de "+videojuego[i].getCompany());					
			}
		}
		
		// Contamos cuantas series entregadas hay 
		int count1 = 0;
		System.out.println("-------------");
		System.out.println("Series entregadas");
		for (int i = 0; i< serie.length; i++) {
			if (serie[i].isEntregado()) {
				count1++;
				System.out.println(count1+"- "+serie[i].getTitulo());
			}
		}
		System.out.println("Total de "+count1+" series entregadas.");
		
		// Contamos cuantos videojuegos entregados hay
		int count2 = 0;
		System.out.println("-------------");
		System.out.println("Videojuegos entregados");
		for (int i = 0; i< videojuego.length; i++) {
			if (videojuego[i].isEntregado()) {
				count2++;
				System.out.println(count2+"- "+videojuego[i].getTitulo());
			}
		}
		System.out.println("Total de "+count2+" videojuegos entregados.");
		
		// Indicamos el videojuego con mas horas estimadas
		Videojuego videojuegoMasHoras = videojuego[0];
		for (int i = 0; i< videojuego.length; i++) {
			if(videojuego[i].getHorasEstimadas()>videojuegoMasHoras.getHorasEstimadas()) {
				videojuegoMasHoras = videojuego[i];
			}
		}
		System.out.println("-------------");
		System.out.println("El siguiente videojuego es el que cuenta con mas horas estimadas: ");
		System.out.println(videojuegoMasHoras.toString());
		
		// Indicamos la serie con mas temporadas
		Serie s = serie[0];
		for (int i = 0; i< serie.length; i++) {
			if(serie[i].getNumTemporadas()>s.getNumTemporadas()) {
				s = serie[i];
			}
		}
		System.out.println("-------------");
		System.out.println("La siguiente serie es la que cuenta con mas temporadas: ");
		System.out.println(s.toString());
	}
	
	/**
	 * Este metodo pregunta si el usuario quiere devolver los prestamos
	 * @return
	 */
	public static boolean seleccionarOpcion() {
		
		boolean gate = false;		
		int n = JOptionPane.showConfirmDialog(null, "Quieres devolver los titulos mostrados anteriormente?","VIDEO CLUB",JOptionPane.YES_NO_OPTION);		
		if (n == JOptionPane.YES_OPTION) {
			gate = true;		
		} else if (n == JOptionPane.NO_OPTION) {
			gate = false;
		}
		return gate;				
	}
	
	/**
	 * Metodo de prueba del tercer ejercicio
	 */
	public static void pruebasTercerEjercicio() {
		
		Libro[] libro = new Libro[2];
		libro[0] = new Libro("ISBN75648334", "Psicología casera para todos", "Bonifacio Autier Casanova", 367);
		libro[1] = new Libro("ISBN66687888", "Principios de psicología aplicada", "Autier Sanromán Amer", 457);
			
		String chart = compararNumPaginas(libro);  
		
		JOptionPane.showMessageDialog(null, "TÍTULO "+libro[0].getTitulo()+"- Autor "+libro[0].getAutor()+"- ISBN "+libro[0].getIsbn()+libro[0].getNumPaginas()+"\n"
				+"TÍTULO "+libro[1].getTitulo()+"- Autor "+libro[1].getAutor()+"- ISBN "+libro[1].getIsbn()+libro[1].getNumPaginas() , "LIBRARY", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, libro[0].getTitulo()+chart+libro[0].getTitulo());
	}
	
	
	/**
	 * metodo auxiliar del tercer ejercicio que compara dos libros y devuelve una cadena con el resultado
	 * @param libro
	 * @return String opt
	 */
	public static String compararNumPaginas(Libro[] libro) {
		String opt = "";
		int numPag1 = libro[0].getNumPaginas();
		int numPag2 = libro[1].getNumPaginas();
		String mensaje[] = {" Tiene más paginas que ", " Tiene menos paginas que ", " Tiene tantas páginas como "};
		if(numPag1 > numPag2) {
			opt = mensaje[0];
		} else if (numPag1 < numPag2) {
			opt = mensaje[1];
		}else {
			opt = mensaje[2];
		};
		return opt;
	}
	
	/**
	 * Metodo de prueba del tercer ejercicio
	 */
	public static void pruebasCuartoEjercicio() {
		Raices[] raices = {
				new Raices(12, 45, 7), 
				new Raices(72, 13.56F,777),
				new Raices(-1, 47, 0.4178)
		};
		
		int numPrueba = 1;
		
		for (Raices r : raices) {
			r.calcular(numPrueba);
			
			numPrueba++;
			
		}
		
		JOptionPane.showMessageDialog(null, "¡Prueba finalizada!");
		
	}
	
}
