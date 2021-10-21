package main.java.MaquinaTickets;

import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.net.URL;

public class maquinaTickets {
	
	private static Logger logger = LogManager.getLogger(maquinaTickets.class);
	
	public static void main(String args[]) {

		// fichero de logs
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);
		
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
			
			logger.info("El usuario ha seleccionado la opcion"+operacion+" en el menu de usuarios");
			
			switch (operacion) {
			
				case 1:
					vagonSitio = tren.primerVagonVacio();
					
					datos1 = tren.vagones[vagonSitio].primerAsientoVacio();
					filaSitio =datos1[0];
					columnaSitio = datos1[1];
					
					
					tren.vagones[vagonSitio].ocuparSitio(filaSitio, columnaSitio);
					menuMain.mostrarTicket(vagonSitio, filaSitio, columnaSitio);
					tren.sitiosLibres = tren.sitiosLibres-1;

					logger.info("Se ha comprado el billete del sitio: vagon["+vagonSitio+"], fila["+filaSitio+"] y columna["+columnaSitio+"]  correctamente, por el metodo de compra de primer sitio libre");
					break;
					
				case 2:
					datos2 = menuMain.pedirSitio();
					
					vagonSitio = datos2[0]-1;
					filaSitio =datos2[1]-1;
					columnaSitio = datos2[2]-1;
					
					if(tren.vagones[vagonSitio].sitioVacio(filaSitio, columnaSitio)== true) {
						tren.vagones[vagonSitio].ocuparSitio(filaSitio, columnaSitio);
						menuMain.mostrarTicket(vagonSitio, filaSitio, columnaSitio);

						logger.info("Se ha comprado el billete del sitio: vagon["+vagonSitio+"], fila["+filaSitio+"] y columna["+columnaSitio+"]  correctamente, por el metodo de compra de sitio a eleccion");
						tren.sitiosLibres = tren.sitiosLibres-1;
					}
					else {
						System.out.print("AVISO: El sitio esta ocupado  \n");
						logger.warn("Se ha pedido el billete del sitio: vagon["+vagonSitio+"], fila["+filaSitio+"] y columna["+columnaSitio+"]  y esta ocupado");
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
					logger.warn("El usuario ha indiado una la opcion"+operacion+", no valida en el menu de usuarios");
					System.out.print("Indica una opción válida  \n");
					break;
			}
			
			if(tren.sitiosLibres == 0) {
				System.out.print("AVISO: TREN LLENO \n");
				logger.warn("El tren esta lleno");
				System.out.print("Fin del programa \n");
				seguir = false;
			}
			
		}while(seguir == true);

		logger.info("Fin de ejecicion");
	}
}
