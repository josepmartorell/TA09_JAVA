import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		initializeMenu();
	}
	
	public static void initializeMenu(){
		final String menuOpciones = "Elija una opción."
				+ "\n1 - Aplicación Electrodoméstico"
				+ "\n2 - Aplicación Serie"
				+ "\n3 - Aplicación Libro"
				+ "\n4 - Aplicación Raices"
				+ "\n5 - Aplicación Aula POO"
				+ "\n5 - Aplicación Cine"
				+ "\n0 - SALIR";
		String opcion = "";
		
		do {
			opcion = JOptionPane.showInputDialog(menuOpciones);
			switch(opcion) {
			case "0":
				JOptionPane.showMessageDialog(null, "FIN DE PROGRAMA");
				break;
			case "1":
				Lavadora lavadora = new Lavadora();
				JOptionPane.showMessageDialog(null, "PRECIO BASE: "+lavadora.getPrecioBase()
						+"\nCOLOR: "+lavadora.getColor()
						+"\nCONSUMO ENERGÉTICO: "+lavadora.getConsumoEnergetico()
						+"\nPESO: "+lavadora.getPeso()
						+"\nCARGA: "+lavadora.getCarga()
						+"\nPRECIO FINAL: "+lavadora.precioFinal("E", 7.00F)
						+"\n", "CLASE LAVADORA", JOptionPane.INFORMATION_MESSAGE);
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
