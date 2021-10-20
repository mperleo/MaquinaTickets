package main.java.MaquinaTickets;

import java.net.URL;

public class maquinaTickets {
	public static void main(String args[]) {
		
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		
		Tren tren;
		menu menuMain = new menu();
		boolean seguir = true;
		
		int datosTren[]= new int[3];
		
		datosTren = menuMain.menuInicioTren();
		
		tren = new Tren(datosTren[0],datosTren[1],datosTren[2]);
		
		do {
			// variables para pedir el sitio del ticket
			int vagonSitio, filaSitio, columnaSitio;
			int datos1[] = new int[2];
			int datos2[] = new int[3];
			
			int operacion;
			operacion = menuMain.menuComprarBillete(tren.sitiosLibres);
			
			switch (operacion) {
			
				case 1:
					vagonSitio = tren.primerVagonVacio();
					
					datos1 = tren.vagones[vagonSitio].primerAsientoVacio();
					filaSitio =datos1[0];
					columnaSitio = datos1[1];
					
					
					tren.vagones[vagonSitio].ocuparSitio(filaSitio, columnaSitio);
					menuMain.mostrarTicket(vagonSitio, filaSitio, columnaSitio);
					tren.sitiosLibres = tren.sitiosLibres-1;
					break;
					
				case 2:
					datos2 = menuMain.pedirSitio();
					
					vagonSitio = datos2[0]-1;
					filaSitio =datos2[1]-1;
					columnaSitio = datos2[2]-1;
					
					if(tren.vagones[vagonSitio].sitioVacio(filaSitio, columnaSitio)== true) {
						tren.vagones[vagonSitio].ocuparSitio(filaSitio, columnaSitio);
						menuMain.mostrarTicket(vagonSitio, filaSitio, columnaSitio);
						tren.sitiosLibres = tren.sitiosLibres-1;
					}
					else {
						System.out.print("AVISO: El sitio esta ocupado  \n");
					}
					
					break;

				case 3:
					tren.imprimirTren();
					break;

				case 4:
					seguir = false;
					System.out.print("Fin del programa \n");
					break;
					
				default:
					System.out.print("Indica una opción válida  \n");
					break;
			}
			
			if(tren.sitiosLibres == 0) {
				System.out.print("AVISO: TREN LLENO \n");
				System.out.print("Fin del programa \n");
				seguir = false;
			}
			
		}while(seguir == true);

		
		
		
	}
}
