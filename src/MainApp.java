import java.security.SecureRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

import cine_06.Cine;
import cine_06.Espectador;
import cine_06.Pelicula;
import cine_06.Butaca;

import electrodomestico_01.Lavadora;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		initializeMenu();
	}

	public static void initializeMenu() {
		final String menuOpciones = "Elija una opción." + "\n1 - Aplicación Electrodoméstico"
				+ "\n2 - Aplicación Serie" + "\n3 - Aplicación Libro" + "\n4 - Aplicación Raices"
				+ "\n5 - Aplicación Aula POO" + "\n6 - Aplicación Cine" + "\n0 - SALIR";
		String opcion = "";

		do {
			opcion = JOptionPane.showInputDialog(menuOpciones);
			switch (opcion) {
			case "0":
				JOptionPane.showMessageDialog(null, "FIN DE PROGRAMA");
				break;
			case "1":
				Lavadora lavadora = new Lavadora();
				JOptionPane.showMessageDialog(null,
						"PRECIO BASE: " + lavadora.getPrecioBase() + "\nCOLOR: " + lavadora.getColor()
								+ "\nCONSUMO ENERGÉTICO: " + lavadora.getConsumoEnergetico() + "\nPESO: "
								+ lavadora.getPeso() + "\nCARGA: " + lavadora.getCarga() + "\nPRECIO FINAL: "
								+ lavadora.precioFinal() + "\n",
						"CLASE LAVADORA", JOptionPane.INFORMATION_MESSAGE);
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
				// TODO
				Pelicula pelicula = new Pelicula("El club de la lucha", 90, 18, "David Fincher");
				JOptionPane.showMessageDialog(null, "TITULO: "+pelicula.getTitulo()
				+"\nDURACION: "+pelicula.getDuracion()
				+"\nEDAD MINIMA: "+pelicula.getEdadMinima()
				+"\nDIRECTOR: "+pelicula.getDirector()
				+"\n", "CINE", JOptionPane.INFORMATION_MESSAGE);

				Cine cine = new Cine(pelicula, true);
				int numEspectadores = Integer.parseInt(JOptionPane.showInputDialog(
						"Introduce el numero de espectadores que iran a ver la pelicula de culto EL CLUB DE LA LUCHA:"));
				cine.crearEspectadoresAleatorios(numEspectadores, cine);				
				cine.asignarEspectadoresAleatoriamente();		

				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción incorrecta");
			}

		} while (!opcion.equals("0"));
	}
}
