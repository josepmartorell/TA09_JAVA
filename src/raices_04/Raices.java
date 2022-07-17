package raices_04;

public class Raices {

	private double a;
	private double b;
	private double c;
	
	/**
	 * @param a
	 * @param b
	 * @param c
	 */
	public Raices(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	/**
	 * Calcula y devuelve el discriminante.
	 * 
	 * @return
	 */
	public double getDiscriminante() {		
		double discriminante = (Math.pow(b, 2)) - 4 * a * c;
		
		return discriminante;
	}
	
	/**
	 * Devuelve true si tiene dos soluciones y false si no.
	 * 
	 * @return
	 */
	public boolean tieneRaices() {
		if(getDiscriminante() >= 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Devuelve true si tiene una solucion y false si no.
	 * 
	 * @return
	 */
	public boolean tieneRaiz() {
		if(getDiscriminante() >= 0) {
			return false;
		}else {
			return true;
		}
	}
		
	// TODO metodo calcular() mostrara por consola las posibles soluciones que en caso de no existir solucion, mostrarlo tambien.
		// Utilizar en este metodo el resto de metodos en la medida de lo posible!!
	
	// TODO metodo obtenerRaices() imprime las 2 posibles soluciones
	
	// TODO metodo obtenerRaiz() imprime unica raiz, que sera cuando solo tenga una solucion posible
}