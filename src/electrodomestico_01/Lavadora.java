package electrodomestico_01;


public class Lavadora extends Electrodomestico {
	
	final float CARGA_DEFAULT = 5; // en kg
	private float carga; // en kg
	
	public Lavadora() {
		super();
		this.carga = this.CARGA_DEFAULT;
	}
	
	public Lavadora(float precioBase, float peso) {
		super(precioBase, peso);
		this.carga = this.CARGA_DEFAULT;
	}
	
	public Lavadora(float precioBase, String color, String consumoEnergetico, float peso, float carga) {
		super(precioBase, color, consumoEnergetico, peso);
		this.carga = carga;
	}

	public void setCarga(float carga) {
		this.carga = carga;
	}

	public float getCarga() {
		return carga;
	}
	
	public float precioFinal() {
		float precioFinal = super.precioFinal();
		if(this.carga > 30) {
			precioFinal = this.precioBase + 50;
		}
		
		return precioFinal;
	}

}
