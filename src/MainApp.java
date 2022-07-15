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
				Pelicula peli = new Pelicula("Thor: Love and Thunder", 119, 12, "Taika Waititi");
				Cine cine = new Cine(peli);
				int numEspectadores = Integer.parseInt(JOptionPane.showInputDialog(
						"Introduce el n�mero de espectadores que ir�n a ver la nueva pel�cula de Thor:"));
				crearEspectadoresAleatorios(numEspectadores, cine);
				cine.asignarEspectadoresAleatoriamente();

				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción incorrecta");
			}

		} while (!opcion.equals("0"));
	}

	public static void crearEspectadoresAleatorios(int num, Cine cine) {

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
			cine.nuevoEspectador(e);
		}
	}
}
