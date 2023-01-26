package exercici1;
import java.util.ArrayList;

public class Venda {
	
	private ArrayList <Producte> productes;
	private double preuTotalVenda;
	
	public Venda () {
		productes = new ArrayList<Producte>();
	}
	
	public double getPreuTotalVenda() {
		return preuTotalVenda;
	}
	public void afegirProducte (Producte ingrdient) {
		productes.add(ingrdient);
	}
	public void mostrarNomProductes() throws VendaBuidaException { // IndexOutOfBoundsException al ser una excepcio no comprovada no fa falta especificar k es tirarà
		if (productes.isEmpty()) {
			throw new VendaBuidaException ("Per fer una venda primer has d’afegir productes") ;
		}
		for ( int i = 0; i <= productes.size(); ++i) {   //generarà un error
			System.out.println(productes.get(i).getNom());
		}
	}
	public double calcularTotal() throws VendaBuidaException{
		if (!productes.isEmpty()) {
			for (int i = 0; i < productes.size(); i++) {
				preuTotalVenda += productes.get(i).getPreu();
			}
		}
		else {
			throw new VendaBuidaException("Per fer una venda primer has d’afegir productes");
		}
		return preuTotalVenda;
	}
}
