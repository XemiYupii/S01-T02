package n3exercici1;

import java.util.Objects;

public class Butaca {
	
	private int numFila;
	private int numSeient;
	private String nomReserva;
	
	public Butaca (int numFila, int numSeient, String nomReserva) {
		this.numFila = numFila;
		this.numSeient = numSeient;
		this.nomReserva = nomReserva;
	}

	public int getNumFila() {
		return numFila;
	}
	public int getNumSeient() {
		return numSeient;
	}
	public String getNomReserva() {
		return nomReserva;
	}
	@Override
	public int hashCode() {
		return Objects.hash(numFila, numSeient);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Butaca))
			return false;
		Butaca other = (Butaca) obj;
		return numFila == other.numFila && numSeient == other.numSeient;
	}
	@Override
	public String toString() {
		return "Fila: " + numFila + ", Seient: " + numSeient + ", Persona: " + nomReserva;
	}
	

	
}
