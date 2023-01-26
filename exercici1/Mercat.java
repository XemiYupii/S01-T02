package exercici1;


public class Mercat {

	public static void main(String[] args) {
		
		Producte producte1 = new Producte ("patates", 25d);
		Venda venda = new Venda();
		
		venda.afegirProducte(producte1);
		venda.afegirProducte(new Producte ("olives", 15.01));
		venda.afegirProducte(new Producte ("tomàquets", 22d));
		
		
		try {
			System.out.println(venda.calcularTotal());
		} catch (VendaBuidaException e) {
		
			System.out.println(e.getMessage());
		}
		
		try {
			venda.mostrarNomProductes();
		} catch (VendaBuidaException  | IndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
