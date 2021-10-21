package MaquinaTickets;

public class Vagon {
	
	/*
	 * 	Cuando un sitio se ocupa pasa a ser flase
	 * 	Cuando esta libre esta en valor true
	 */
	public boolean asientos[][];
	
	// constructor que inicia el array de datos a sitios libres
	public Vagon(int filas, int columnas) {
		boolean nuevoAsientos[][]= new boolean[filas][columnas];
		int i,j; // contadores
		
		for(i=0; i<filas; i++) {
			for(j=0; j < columnas; j++) {
				
				nuevoAsientos[i][j]= true;
			}
		}
		this.asientos = nuevoAsientos; // asigno el array con valores al array del objeto
	}
	
	
	// funcion que busca el primer asiento vacio en el array
	public int[] primerAsientoVacio() {
		int i, j; // variables para hacer el recorrido
		
		int sitio[] = {-1,-1}; //array que guardara los datos del primer sitio libre, se inicia a -1,-1 como posición no valida
		
		// recorro los datos del array de asientos
		for(i=0; i<asientos.length; i++) {
			for(j=0; j < asientos[i].length; j++) {
				
				// si un sitio esta el true == vacio, entonces guardo el valor en la variable
				if( asientos[i][j] == true ) {
					// guardo los datos de la posición
					sitio[0]=i;
					sitio[1]=j;
					
					return sitio; // devuelvo los datos y acabo el bucle
				}
			}
		}
		
		return sitio; // devuelvo los datos al salir del bucle, si se llega aqui no hay sitios libres
	}
	
	
	// metodo que comprueba si un vagon esta vacio
	public boolean vagonLleno() {
		int i, j; // variables para hacer el recorrido
		
		// recorro los datos del array de asientos
		for(i=0; i<asientos.length; i++) {
			for(j=0; j < asientos[i].length; j++) {
				// si un sitio esta el true == vacio, se sale del bucle el vagon tiene sitios libres
				if( asientos[i][j] == true ) {
					return false; // devuelvo los datos y acabo el bucle
				}
			}
		}
		
		return true; // devuelvo true el vagon esta lleno si se llega aqui no hay sitios libres
	}
	
	// metodo que comprueba que un sitio esta vacio o no
	public boolean sitioVacio(int i, int j) {
		if( asientos[i][j] == true ) {
			return true; // si el sitio esta vacio
		}
		else {
			return false; // si el sitio esta ocupado
		}
	}
	
	public void ocuparSitio(int i, int j) {
		asientos[i][j]=false;
	}
	
	public void imprimirVagon() {
		int i, j; // variables para hacer el recorrido
		
		System.out.print("----------------\n"); 
		for(i=0; i<asientos.length; i++) {
			for(j=0; j < asientos[i].length; j++) {
				if( asientos[i][j] == true ) {
					System.out.print("O "); // si el sitio esta vacio
				}
				else {
					System.out.print("X "); // si el sitio esta ocupado
				}
			}
			System.out.print("\n");
		}
		System.out.print("----------------\n"); 
	}	
}
