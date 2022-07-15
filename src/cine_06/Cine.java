package cine_06;

import java.util.ArrayList;
import java.util.Iterator;

public class Cine {
    private ArrayList<Butaca> butacas = new ArrayList<Butaca>();
    private Pelicula pelicula;
    private final float precioEntrada = 10F;
    private ArrayList<Espectador> espectadores = new ArrayList<Espectador>();

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

	/**
	 * @return the pelicula
	 */
	public Pelicula getPelicula() {
		return pelicula;
	}

	/**
	 * @param pelicula the pelicula to set
	 */
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	/**
	 * @return the espectadores
	 */
	public ArrayList<Espectador> getEspectadores() {
		return espectadores;
	}

	/**
	 * @param espectadores the espectadores to set
	 */
	public void setEspectadores(ArrayList<Espectador> espectadores) {
		this.espectadores = espectadores;
	}
	
	/**
	 * Este método asigna aleatoriamente espectadores
	 */
	public void asignarEspectadoresAleatoriamente() {
        Iterator<Espectador> itr = this.espectadores.iterator();
        while(itr.hasNext()){
            Espectador espectador=itr.next();
            int butaca = (int) ((Math.random() * (this.butacas.size() - 1)) + 1) - 1;
            while(this.butacas.get(butaca).isOcupado()) {
                butaca = (int) ((Math.random() * (this.butacas.size() - 1)) + 1) - 1;
            }
            
            espectador.setButacaAsignada(this.butacas.get(butaca).getNombre());
        }
    }
	
	/**
	 * Este método inserta espectadores en la lista de espectadores
	 * 
	 * @param e el espectador
	 */
	public void nuevoEspectador(Espectador e) {
		this.espectadores.add(e);
	}
}
