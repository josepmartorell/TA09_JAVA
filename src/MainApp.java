import javax.swing.JOptionPane;

import cine_06.Pelicula;
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
				salaProyeccion();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción incorrecta");
			}

		} while (!opcion.equals("0"));
		
		
	}
	
	public static void salaProyeccion() {
		
		Pelicula pelicula = new Pelicula("El club de la lucha", 90, 18, "David Fincher");
		
		JOptionPane.showMessageDialog(null, "TITULO: "+pelicula.getTitulo()
		+"\nDURACION: "+pelicula.getDuracion()
		+"\nEDAD MINIMA: "+pelicula.getEdadMinima()
		+"\nDIRECTOR: "+pelicula.getDirector()
		+"\n", "CINE", JOptionPane.INFORMATION_MESSAGE);
	 
		platea();
		

	}
	

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
