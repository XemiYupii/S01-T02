
package n1exercici1;


public class Mercat {

	public static void main(String[] args) {
		
		Producte producte1 = new Producte ("patates", 25d);
		Venda venda = new Venda();
		
		venda.afegirProducte(producte1);
		venda.afegirProducte(new Producte ("olives", 15.01));
		venda.afegirProducte(new Producte ("tomàquets", 22d));
		
		
<<<<<<< HEAD
		try {
			System.out.println(venda.calcularTotal());
		} catch (VendaBuidaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			venda.mostrarNomProductes();
		} catch (VendaBuidaException  | IndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
	}

}
=======
//		try {
//			System.out.println(venda.calcularTotal());
//		} catch (VendaBuidaException e) {
//		
//			System.out.println(e.getMessage());
//		}
		
		try {
			venda.mostrarNomProductes();
		} catch (VendaBuidaException e /* | IndexOutOfBoundsException e*/) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		catch (IndexOutOfBoundsException f) {
			System.out.println(f.getMessage());
		}
		
	}

}
/*Al capturar les excepcions el k fem és que el programa segueixi funcionant.
 * si el metode mostrarNomProducte es posés abans que el mètode
 * calcularTotal i no capturessim l'excepció, el programa finalitzaria en el moment
 * k es llancés l'excepcio*/
>>>>>>> 61147b90e46c41211ba00cc91c43dfe42c96ffe0
