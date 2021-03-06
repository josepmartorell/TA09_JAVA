package electrodomestico_01;


public class Television extends Electrodomestico {

	private float resolucion;
	private boolean sintonizadorTDT;
	final float DEF_RESOLUCION = 20F;
	final boolean DEF_SINTONIZADOR_TDT = false;
	 
	// DEFAULT CONSTRUCTOR
	public Television() {
		super();
		this.resolucion = DEF_RESOLUCION;
		this.sintonizadorTDT = DEF_SINTONIZADOR_TDT;
	}
	
	public Television(float precioBase, float peso) {
		super(precioBase, peso);
		this.resolucion = DEF_RESOLUCION;
		this.sintonizadorTDT = DEF_SINTONIZADOR_TDT;
		
	}
	
	public Television(float precioBase, String color, String consumoEnergetico, float peso, float resolucion, boolean sintonizadorTDT) {
		super(precioBase, color, consumoEnergetico, peso);
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
		
	}
	
	public float precioFinal(String sintonizadorTDT, float resolucion) {
		float precioFinal = super.precioFinal();
		if(this.resolucion > 40) {
			precioFinal *= 1.30;
		}
		if (this.sintonizadorTDT != false) {
			precioFinal += 50;
		}
		
		return precioFinal;
	}

	public float getResolucion() {
		return resolucion;
	}

	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}

	
}
