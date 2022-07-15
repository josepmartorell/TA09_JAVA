package electrodomestico_01;
import java.util.Hashtable;

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
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
	}
	
	public String comprobarConsumoEnergetico(String letra) {
		
		String[] letras = {"A", "B", "C", "D", "E", "F"};
		boolean contains = false;
		
		for (String c : letras) {
		    if (c.equals(letra)) {
		        contains = true;
		        this.consumoEnergetico = letra; 
		        break;
		    }
		}
		if (!contains) {
			this.consumoEnergetico = "F"; 
		}
		return letra;
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
	
	public float precioFinal(){
		
		float finalPrice = this.precioBase;
		
		Hashtable<String, Float> consumptionEnergy = new Hashtable<String, Float>();
		consumptionEnergy.put("A", 100F);
		consumptionEnergy.put("B", 80F);
		consumptionEnergy.put("C", 60F);
		consumptionEnergy.put("D", 50F);
		consumptionEnergy.put("E", 30F);
		consumptionEnergy.put("F", 10F);
		
		finalPrice += consumptionEnergy.get(this.consumoEnergetico);
				
		if((peso >= 0) && (peso <= 19)) {
			finalPrice += 10F;
		} else if ((peso >= 20) && (peso <= 49)) {
			finalPrice += 50F;
		} else if ((peso >= 50) && (peso <= 79)) {
			finalPrice += 80F;
		} else if (peso >= 80) {
			finalPrice += 100F;			
		} else {
			return -1;
		}
		
		return finalPrice;
		
			
	}

}
