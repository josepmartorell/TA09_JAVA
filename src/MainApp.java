import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initializeMenu();
	}
	
	public static void initializeMenu(){
		final String menuOpciones = "Elija una opción."
				+ "\n1 - Clase Electrodoméstico"
				+ "\n2 - Clase Serie"
				+ "\n3 - Clase Libro"
				+ "\n4 - Clase Raices"
				+ "\n5 - Programa Aula POO"
				+ "\n5 - Programa Cine"
				+ "\n0 - SALIR";
		String opcion = "";
		
		do {
			opcion = JOptionPane.showInputDialog(menuOpciones);
			switch(opcion) {
			case "0":
				JOptionPane.showMessageDialog(null, "FIN DE PROGRAMA");
				break;
			case "1":
				// TODO
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
			default:
				JOptionPane.showMessageDialog(null, "Opción incorrecta");
			}

		}while(!opcion.equals("0"));
	}
	

}
