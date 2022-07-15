package cine_06;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

public class Cine {
    private ArrayList<Butaca> butacas = new ArrayList<Butaca>();
    private Pelicula pelicula;
    private final float precioEntrada = 10F;
    private ArrayList<Espectador> espectadores = new ArrayList<Espectador>();
    private int aforo;

    /**
	 * @param butacas
	 * @param pelicula
	 */
	public Cine(Pelicula pelicula, boolean aforo) {
		crearButacas();
		this.pelicula = pelicula;
		this.aforo = this.butacas.size();
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
	
	public void crearEspectadoresAleatorios(int num, Cine cine) {

		final String chars = "abcdefghijklmnopqrstuvwxyz";

		for (int i = 0; i < num; i++) {
			// Edad random
			int edad = (int) (Math.random() * (110 - 4)) + 4;

			// Dinero random
			float dinero = (float) (Math.random() * (100 - 0)) + 0;

			// Nombre random
			SecureRandom random = new SecureRandom();
			String name = IntStream.range(0, ((int) (Math.random() * (10 - 3)) + 3))
					.map(k -> random.nextInt(chars.length()))
					.mapToObj(randomIndex -> String.valueOf(chars.charAt(randomIndex))).collect(Collectors.joining());

			// Creamos un espectador
			Espectador e = new Espectador(name, edad, dinero, "");

			// Lo insertamos en la lista de espectadores del cine
			this.espectadores.add(e);
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
	 * Este m�todo asigna aleatoriamente espectadores
	 */
	public void asignarEspectadoresAleatoriamente() {
        Iterator<Espectador> itr = this.espectadores.iterator();
        while(itr.hasNext()){
            Espectador espectador=itr.next();
            
            // CREAR IF CON EL EL METODO VALIDAR COMO CONDICION, METER DENTRO DEL IF TODO EL BLOQUE INFERIOR.
            //-----------------------------------------
            
	            // Busca una butaca aleatoria, comprueba que no este ocupada, asigna la primera que encuentra libre
	            int butaca = (int) ((Math.random() * (this.butacas.size() - 1)) + 1) - 1;
	            while(this.butacas.get(butaca).isOcupado()) {
	                butaca = (int) ((Math.random() * (this.butacas.size() - 1)) + 1) - 1;
	            }
	            this.butacas.get(butaca).setOcupado(true);
	            
	            espectador.setButacaAsignada(this.butacas.get(butaca).getNombre());
	            
	        //-----------------------------------------
        }
    }
	/**
	 * valida que exista localidad libre, la edad permitida para la pelicula y el dinero del espectador
	 * @param aforo
	 * @param edad
	 * @param dinero
	 * @return
	 */
	public boolean validar(boolean aforo, int edad, float dinero) {
		
		if((aforo != true) && (edad < edad) && (dinero < precioEntrada)) {		
			return false;				
		}
	
		return true;	
	}

	public String mostrarEspectadores() {
		// TODO POR PANTALLA espectadores, nombre, dinero, edad
			ArrayList<Espectador> gente = this.getEspectadores();
			JOptionPane.showMessageDialog(null, "ESPECTADORES: "+this.getEspectadores(), null, JOptionPane.INFORMATION_MESSAGE);
		
		return null;
	}
	
	
}
