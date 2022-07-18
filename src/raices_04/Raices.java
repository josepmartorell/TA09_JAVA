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
	 * @return true or false
	 */
	public boolean tieneRaices() {
		if(getDiscriminante() > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Devuelve true si tiene una solucion y false si no.
	 * 
	 * @return true or false
	 */
	public boolean tieneRaiz() {
		if(getDiscriminante() == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Devuelve verdadero o falso si la equacion no tiene raices
	 * 
	 * @return true or false
	 */
	public boolean noTieneRaiz() {
		if (this.getDiscriminante() < 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Calcula la equación de segundo grado
	 */
	public void calcular() {
		// Primero calculamos el discriminante
		double result = this.getDiscriminante();
		
		// En caso que la equacion no tenga solucion (discriminante negativo)
		if (this.noTieneRaiz()) {
			System.out.println("La equacion no tiene raices, por lo tanto no tiene resultado (no existe raiz de un numero negativo");
		} else if(this.tieneRaiz()) {
			// En caso de tener una sola raiz (discriminante == 0)
			result = -b /2*a;
			System.out.println("La equacion solamente tiene un resultado y es: "+result);
		} else {
			// En caso de tener dos raices (discriminante positivo)
			double r1 = (-b + Math.pow(result, 0.5) / (2.0 * a));
            double r2 = (-b - Math.pow(result, 0.5) / (2.0 * a));
            System.out.println("La equacion tiene dos resultados. El primero es " + r1 + " y el segundo es " + r2);
		}
	}
	
	/**
	 * Metodo que imprime las 2 posibles soluciones
	 */
	public void obtenerRaices() {
		// TODO
	}
	
	/**
	 * Metodo que imprime unica raiz, que sera cuando solo tenga una solucion posible
	 */
	public void obtenerRaiz( ) {
		// TODO 
	}
	
}