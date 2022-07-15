package cine_06;

import java.util.ArrayList;

public class Cine {
    private ArrayList<Butaca> butacas = new ArrayList<Butaca>();
    private Pelicula pelicula;
    private final float precioEntrada = 10F;

    

    /**
	 * @param butacas
	 * @param pelicula
	 */
	public Cine(Pelicula pelicula) {
		crearButacas();
		this.pelicula = pelicula;
	}

	public void crearButacas(){
        String[] columnas = {"1", "2", "3", "4", "5", "6", "7", "8"};
        String[] filas = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};

        for (int i = 0; i < columnas.length; i++) {
            for (int j = 0; j < filas.length; j++) {
                String nombre = columnas[i] + filas[j]; 
                Butaca butaca = new Butaca(nombre, false);
                this.butacas.add(butaca);
            }
        }
    }

    public ArrayList<Butaca> getButacas() {
        return butacas;
    }

    public void setButacas(ArrayList<Butaca> butacas) {
        this.butacas = butacas;
    }


}
