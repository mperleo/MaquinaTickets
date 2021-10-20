package MaquinaTickets;
import java.util.Scanner;

public class menu {
	public Scanner sc = new Scanner(System.in); //Se crea el lector
	
	public int[] menuInicioTren() {
		int datos[]= {0,0,0};

		System.out.print("\n··········· INICIO DE LOS OBJETOS: ··········· \n");
		
		System.out.print("> Indica el nº de vagones del tren:  \n");
		datos[0]=sc.nextInt();
		System.out.print("\n> Indica el nº de filas de asientos por vagón:  \n");
		datos[1]=sc.nextInt();
		System.out.print("\n> Indica el nº de columnas de asientos por vagón:  \n");
		datos[2]=sc.nextInt();

		return datos;
		
	}
	
	public int menuComprarBillete(int nSitiosLibres) {
		int opcion;
		
		System.out.print("\n··········· COMPRA DEL BILLETE: ··········· \n");
		System.out.print("Indica una de las opciones: \n");
		System.out.print("nº sitios libres: "+nSitiosLibres+" \n");
		
		
		System.out.print("> 1. Primer asiento libre:  \n");
		System.out.print("> 2. Asiento a elección  \n");
		System.out.print("> 3. Salir del programa  \n");
		System.out.print("> 4. Mostrar tren  \n");
		
		opcion=sc.nextInt();
		
		return opcion;
	}
	
	public int[] pedirSitio() {
		int datos[]= {0,0,0};
		
		System.out.print("> Indica el nº de vagon :  \n");
		datos[0]=sc.nextInt();
		System.out.print("\n> Indica el nº de fila n:  \n");
		datos[1]=sc.nextInt();
		System.out.print("\n> Indica el nº de columna:  \n");
		datos[2]=sc.nextInt();
		
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
