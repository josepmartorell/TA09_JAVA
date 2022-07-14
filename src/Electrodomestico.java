

public class Electrodomestico {
	
	private final float precioBase;
	private String color;
	private String consumoEnergetico;
	private final float peso;
	
		
	public Electrodomestico() {
		this.precioBase = 0.0F;
		this.color = "BLANCO";
		this.consumoEnergetico  = "F";
		this.peso = 5.0F;
	
	}
	
	public Electrodomestico(float precioBase, float peso) {
		this.precioBase = precioBase;
		this.color = "BLANCO";
		this.consumoEnergetico  = "F";
		this.peso = peso;
	}

	public Electrodomestico(float precioBase, String color, String consumoEnergetico, float peso) {

		this.precioBase = precioBase;
		
		// VALIDAMOS EL PARAMETRO COLOR
		boolean check = false;
		String checkColor = color.toUpperCase();
		String COLORES_DISPONIBLES[] = {"BLANCO", "NEGRO", "ROJO", "AZUL", "GRIS"};
		for(int i = 0; i<COLORES_DISPONIBLES.length; i++) {
			if (checkColor == COLORES_DISPONIBLES[i]) {
				check = true;
			}		
		}
		if (!check)
			this.color = checkColor; 
		else
			this.color = "BLANCO";

		// VALIDAMOS EL PARAMETRO CONSUMO ENERGÉTICO
		check = false;
        String checkConsumo = consumoEnergetico.toUpperCase();
        String CONSUMO_ENERGETICO[] = {"A", "B", "C", "D", "E", "F"};
		for(int i = 0; i<CONSUMO_ENERGETICO.length; i++) {
			if (checkColor == CONSUMO_ENERGETICO[i]) {
				check = true;
			}		
		}
        if(!check)
        	this.consumoEnergetico = checkConsumo;
        else
        	this.consumoEnergetico = "F";
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
	
	
	
	
	

}
