import javax.swing.JOptionPane;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// INSTANCIAMOS UN OBJETO TIPO ELECTRODOMÉSTICO MOSTRANDO POR PANTALLA LOS ATRIBUTOS PARAMETRIZADOS Y VALIDADOS EN EL TERCER CONSTRUCTOR
		Electrodomestico electrodomestico = new Electrodomestico(300, "rojo", "b", 10);
		JOptionPane.showMessageDialog(null, "PRECIO BASE: "+electrodomestico.getPrecioBase()
				+"\nCOLOR: "+electrodomestico.getColor()
				+"\nCONSUMO ENERGÉTICO: "+electrodomestico.getConsumoEnergetico()
				+"\nPESO: "+electrodomestico.getPeso(), "CLASE ELECTRODOMESTICO", JOptionPane.INFORMATION_MESSAGE);	

		
	}
}
