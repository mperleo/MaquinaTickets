package main.java.MaquinaTickets;

public class Tren {
	public Vagon vagones[];
	public int sitiosLibres;
	
	// constructor que inicia el array de vagones y que inicia tambien los vagones a sitios libres
		public Tren(int nVagones, int filas, int columnas) {
			Vagon nuevoVagones[]= new Vagon[nVagones];
			int i; // contador
			
			for(i=0; i<nVagones; i++) {
				nuevoVagones[i]= new Vagon(filas,columnas); // creo los objetos vagon
			}
			
			this.sitiosLibres= nVagones * filas * columnas;
			this.vagones = nuevoVagones; // asigno el array con valores al array del objeto
		}
	
	public boolean trenLleno() {
		int i; // variable para hacer el recorrido de los vagones
		 
		// recorro todos los vagones del tren
		for(i=0; i < vagones.length; i++) {
			// si hay un vagon que no este lleno se retorna directamente falso
			if(this.vagones[i].vagonLleno() == false) {
				return false;
			}
		}
		
		// si se recorre todo el array de vagones se devuelve verdadero
		return true;
	}
	
	public int primerVagonVacio() {
		int i; // variable para hacer el recorrido de los vagones
		 
		// recorro todos los vagones del tren
		for(i=0; i < vagones.length; i++) {
			// si hay un vagon que no este lleno se retorna directamente falso
			if(this.vagones[i].vagonLleno() == false) {
				return i;
			}
		}
		
		// si se recorre todo el array de vagones se devuelve verdadero
		return -1;
	}
	
	public void imprimirTren() {
		int i; // variables para hacer el recorrido
		
		for(i=0; i<vagones.length; i++) {
			vagones[i].imprimirVagon();
		}
	}	
}
