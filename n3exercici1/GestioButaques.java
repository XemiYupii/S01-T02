package n3exercici1;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GestioButaques {
	
	private ArrayList<Butaca>butaques;
	
	public GestioButaques() {
		butaques = new ArrayList<>();
	}

	public ArrayList<Butaca> getButaques() {
		return butaques;
	}
	public void afegirButaca (Butaca butaca) throws ButacaOcupadaException{
		if (cercarButaca (butaca.getNumFila(), butaca.getNumSeient()) != -1)
			throw new ButacaOcupadaException ("Aquesta butaca ja està ocupada");
		butaques.add(butaca);
	}
	public void eliminarButaca (int fila, int seient) throws ButacaLliureException{
		int posicioCoincidencia = cercarButaca(fila, seient);
		if (posicioCoincidencia == -1)
			throw new ButacaLliureException ("Aquesta butaca no està reservada");
		else butaques.remove(posicioCoincidencia);
	}
	public int cercarButaca (int fila, int seient) {
		return IntStream.range(0, butaques.size()).filter(i -> getButaques().get(i).getNumFila()== fila && getButaques().get(i).getNumSeient()== seient).findFirst().orElse(-1);
	}

}
