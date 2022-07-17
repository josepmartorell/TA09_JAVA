import javax.swing.JOptionPane;

import cine_06.Cine;
import electrodomestico_01.Electrodomestico;
import electrodomestico_01.Lavadora;
import electrodomestico_01.Television;

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
					float precioFinal = 0;
					precioFinal = electrodomesticos[i].precioFinal();
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
				break;
			case "2":
				// TODO
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
}
