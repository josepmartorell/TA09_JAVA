import javax.swing.JOptionPane;

import cine_06.Pelicula;
import electrodomestico_01.Lavadora;

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
		final String menuOpciones = "Elija una opci贸n." + "\n1 - Aplicaci贸n Electrodom茅stico"
				+ "\n2 - Aplicaci贸n Serie" + "\n3 - Aplicaci贸n Libro" + "\n4 - Aplicaci贸n Raices"
				+ "\n5 - Aplicaci贸n Aula POO" + "\n6 - Aplicaci贸n Cine" + "\n0 - SALIR";
		String opcion = "";

		// Bucle infinito del menu hasta que se cierre con el Exit o cancelando
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
								+ "\nCONSUMO ENERG脡TICO: " + lavadora.getConsumoEnergetico() + "\nPESO: "
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
				salaProyeccion();
				
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opci贸n incorrecta");
			}

		} while (!opcion.equals("0"));
		
	}
	
	/**
	 * Metodo que muestra las caracter韘ticas de la pel韈ula en el cine
	 */
	public static void salaProyeccion() {
		
		// Creamos la pelicula
		Pelicula pelicula = new Pelicula("El club de la lucha", 90, 18, "David Fincher");
		
		// Mostramos sus atributos
		JOptionPane.showMessageDialog(null, "TITULO: "+pelicula.getTitulo()
		+"\nDURACION: "+pelicula.getDuracion()
		+"\nEDAD MINIMA: "+pelicula.getEdadMinima()
		+"\nDIRECTOR: "+pelicula.getDirector()
		+"\nCOSTE: 10�"
		+"\n", "CINE", JOptionPane.INFORMATION_MESSAGE);
	 
		platea();
		
	}
	

	/**
	 * Metodo que ...
	 * 
	 * @param arr
	 * @param chart
	 */
    private static void alignamentJoption(String[][]arr, String chart) {
    	
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
     * Metodo que...
     */
	public static void platea() {
		
		String[][]platea={{"1A","1B","1C","1D","1E","1F","1G","1H","1I"},
						  {"2A","2B","2C","2D","2E","2F","2G","2H","2I"},
						  {"3A","3B","3C","3D","3E","3F","3G","3H","3I"},
						  {"4A","4B","4C","4D","4E","4F","4G","4H","4I"},
						  {"5A","5B","5C","5D","5E","5F","5G","5H","5I"},
						  {"6A","6B","6C","6D","6E","6F","6G","6H","6I"},
						  {"7A","7B","7C","7D","7E","7F","7G","7H","7I"},
						  {"8A","8B","8C","8D","8E","8F","8G","8H","8I"}};    
		alignamentJoption(platea, "PLATEA");
		alignamentJoption(randomizeButacas(platea), "BUTACAS DISPONIBLES");
	}
	
	/**
	 * Metodo que...
	 * 
	 * @param butacas
	 * @return
	 */
	public static String[][] randomizeButacas(String butacas[][]) {
		 
		 int butaca;
		 if (butacas != null) {
			 for(int i = 0; i<butacas.length; i++) {
				 for (int j = 0; j < butacas[0].length; j++) {
					 butaca = (int) ((Math.random() * (9 - 1)) + 1) - 1;
					 if (butaca < 4)
						 butacas[i][j] = "  ";
			    	}			    	
			  }		    
		}
		return butacas;	 
	}    
}
