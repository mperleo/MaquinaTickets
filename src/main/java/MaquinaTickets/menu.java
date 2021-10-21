package MaquinaTickets;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
	private static Logger logger = LogManager.getLogger(maquinaTickets.class);
	
	public int[] menuInicioTren() {
		Scanner sc = new Scanner(System.in); //Se crea el lector
		int datos[]= {0,0,0};
		try {
			System.out.print("\n··········· INICIO DE LOS OBJETOS: ··········· \n");

			System.out.print("> Indica el nº de vagones del tren:  \n");
			datos[0]=sc.nextInt();
			System.out.print("\n> Indica el nº de filas de asientos por vagón:  \n");
			datos[1]=sc.nextInt();
			System.out.print("\n> Indica el nº de columnas de asientos por vagón:  \n");
			datos[2]=sc.nextInt();
		}
		catch (InputMismatchException e){
			logger.error("El usuario ha indicado un tipo incorrecto, en el metodo que inicia los valores del tren");
		}
		return datos;
		
	}
	
	public int menuComprarBillete(int nSitiosLibres) {
		Scanner sc = new Scanner(System.in); //Se crea el lector
		int opcion = -1;
		
		System.out.print("\n··········· COMPRA DEL BILLETE: ··········· \n");
		System.out.print("Indica una de las opciones: \n");
		System.out.print("nº sitios libres: "+nSitiosLibres+" \n");
		
		
		System.out.print("> 1. Primer asiento libre:  \n");
		System.out.print("> 2. Asiento a elección  \n");
		System.out.print("> 3. Mostrar tren  \n");
		System.out.print("> 4. Salir del programa  \n");

		try{
			opcion=sc.nextInt();
		}
		catch (InputMismatchException e){
			logger.error("El usuario ha indicado un tipo incorrecto, en el menu de introduccion de datos de la compra del billete");
		}

		
		return opcion;
	}
	
	public int[] pedirSitio() {
		Scanner sc = new Scanner(System.in); //Se crea el lector
		int datos[]= {0,0,0};
		try {
			System.out.print("> Indica el nº de vagon :  \n");
			datos[0] = sc.nextInt();
			System.out.print("\n> Indica el nº de fila n:  \n");
			datos[1] = sc.nextInt();
			System.out.print("\n> Indica el nº de columna:  \n");
			datos[2] = sc.nextInt();
		}
		catch (InputMismatchException e){
			logger.error("El usuario ha indicado un tipo incorrecto, en el metodo de pedir un sitio para comprar el billete");
		}

		return datos;
	}
	
	public void mostrarTicket(int vagon, int fila, int columna) {
		System.out.print("\n");
		
		System.out.print("-----------------------------\n");
		System.out.print("|                           |\n");
		System.out.print("|    Ticket:                |\n" );
		System.out.print("|    Vagon: "+(vagon+1)+"               |\n");
		System.out.print("|    Fila: "+(fila+1)+"                |\n");
		System.out.print("|    columna: "+(columna+1)+"             |\n");
		System.out.print("|                           |\n");
		System.out.print("-----------------------------\n");
	}
}
