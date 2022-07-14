public class Electrodomestico {
	private final float DEF_PRECIO = 100.0F;
	private final String DEF_COLOR = "BLANCO";
	private final String DEF_CONENERG = "F";
	private final float DEF_PESO = 5.0F;
	
	protected float precioBase;
	protected String color;
	protected String consumoEnergetico;
	protected float peso;
	
		
	public Electrodomestico() {
		this.precioBase = DEF_PRECIO;
		this.color = DEF_COLOR;
		this.consumoEnergetico  = DEF_CONENERG;
		this.peso = DEF_PESO;
	
	}
	
	public Electrodomestico(float precioBase, float peso) {
		this.precioBase = precioBase;
		this.color = DEF_COLOR;
		this.consumoEnergetico  = DEF_CONENERG;
		this.peso = peso;
	}

	public Electrodomestico(float precioBase, String color, String consumoEnergetico, float peso) {

		this.precioBase = precioBase;
		this.color = comprobarColor(color);
		this.consumoEnergetico = consumoEnergetico;
		this.peso = peso;
	}

	public float getPrecioBase() {
		return precioBase;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getConsumoEnergetico() {
		return consumoEnergetico;
	}
	
	public float getPeso() {
		return peso;
	}
	
	
	
	/**
	 * 
	 * @param color
	 * @return
	 */
	protected String comprobarColor(String color) {
		// VALIDAMOS EL PARAMETRO COLOR
		boolean check = false;
		String checkColor = color.toUpperCase();
		String COLORES_DISPONIBLES[] = { "BLANCO", "NEGRO", "ROJO", "AZUL", "GRIS" };
		for (int i = 0; i < COLORES_DISPONIBLES.length; i++) {
			if (checkColor == COLORES_DISPONIBLES[i]) {
				check = true;
			}
		}
		if (!check) {
			return checkColor;
		} else {
			return "BLANCO";
		}	
	}
}
