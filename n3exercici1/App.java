package n3exercici1;

public class App {

	public static void main(String[] args) throws NomPersonaIncorrecteException, FilaIncorrectaException, SeientIncorrecteException, ButacaOcupadaException, ButacaLliureException {
		
		Cinema verdi = new Cinema ();
		boolean iniciat = false;
		while (!iniciat) {
			try {
				verdi.iniciar();
				iniciat = true;
			}catch (NomPersonaIncorrecteException | FilaIncorrectaException | SeientIncorrecteException
					| ButacaOcupadaException | ButacaLliureException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}


