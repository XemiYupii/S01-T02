package n3exercici1;

import n2exercici1.Entrada;

import java.util.List;
import java.util.Scanner;

public class Cinema {

	private int numFiles;
	private int numSeients;
	private GestioButaques gestionament;
	
	public Cinema () {
		gestionament = new GestioButaques ();
		demanarDadesInicials("Quantes files té el cinema?", "Quants seients per fila té el cinema?");
	}
	public void iniciar() throws NomPersonaIncorrecteException, FilaIncorrectaException, SeientIncorrecteException, ButacaOcupadaException, ButacaLliureException {
		int opcio = 0;
		do {
			opcio = menu("Escull una de les següents opcions: \n"
					+ "1.- Mostrar totes les butaques reservades.\n"
					+ "2.- Mostrar les butaques reservades per una persona.\n"
					+ "3.- Reservar una butaca.\n"
					+ "4.- Anul·lar la reserva d’una butaca.\n"
					+ "5.- Anul·lar totes les reserves d’una persona.\n"
					+ "0.- Sortir.");
			while (opcio < 0 || opcio > 5) {
				opcio = Entrada.llegirInt("Opció incorrecte, torna-ho ha probar");
			}
			switch (opcio) {
				case 0:
					System.out.println("Gràcies per utilitzar la nostra App");
					break;
				case 1:
					mostrarButaques();
					break;
				case 2:
					mostrarButaquesPersona();
					break;
				case 3:
					reservarButaca();
					break;
				case 4:
					anularReserva();
					break;
				case 5:
					anularReservaPersona();
					break;
				default:
			}
		}while (opcio != 0);
	}
	public int menu (String missatge) {
		int opcio = Entrada.llegirInt(missatge);
		return opcio;
	}
	public void mostrarButaques() {
		if (gestionament.getButaques().isEmpty())
			System.out.println("Totes les nostres butaques estan lliures");
		else gestionament.getButaques().stream().forEach(System.out::println);
	}
	public void mostrarButaquesPersona() throws NomPersonaIncorrecteException {
		String nom = introduirPersona ("Quin és el teu nom?");
		List <Butaca> coincidencia = gestionament.getButaques().stream().filter(butaca -> butaca.getNomReserva().equalsIgnoreCase(nom)).toList();
		if (coincidencia.isEmpty())
			System.out.println("No hi han reserves amb el nom "+nom);
		else coincidencia.forEach(System.out::println);
	}
	public void reservarButaca() throws FilaIncorrectaException, SeientIncorrecteException, NomPersonaIncorrecteException, ButacaOcupadaException {
		int fila = introduirFila ("A quina fila vols fer la reserva?");
		int seient = introduirSeient ("Quin seient vols reservar?");
		String nom = introduirPersona ("A nom de qui fem la reserva?");
		gestionament.afegirButaca(new Butaca (fila, seient, nom));
		System.out.println("Reserva efectuada");
	}
	public void anularReserva() throws FilaIncorrectaException, SeientIncorrecteException, ButacaLliureException {
		int fila = introduirFila ("A quina fila es troba la butaca que vols anular?");
		int seient = introduirSeient ("Quin número de seient és?");
		gestionament.eliminarButaca(fila, seient);
		System.out.println("Reserva anul·lada");
	}
	public void anularReservaPersona() throws NomPersonaIncorrecteException, ButacaLliureException {
		String nom = introduirPersona ("A quin nom està la reserva?");
		List<Butaca>coincidencia = gestionament.getButaques().stream().filter(butaca -> butaca.getNomReserva().equalsIgnoreCase(nom)).toList();
		if (coincidencia.isEmpty()) 
			System.out.println("No tenim cap reserva amb el nom "+nom);
		else 
			for (Butaca butaca2 : coincidencia) {
				gestionament.eliminarButaca(butaca2.getNumFila(), butaca2.getNumSeient());
			}
		System.out.println("Totes les reserves de "+nom+" han estat anul·lades");
	}
	public String introduirPersona (String missatge) throws NomPersonaIncorrecteException {
		Scanner input = new Scanner (System.in);
		System.out.println(missatge);
		String nom = input.nextLine();
		if (nom.contains("0") || nom.contains("1") || nom.contains("2") || nom.contains("3") || nom.contains("4") || nom.contains("5") || nom.contains("6") || nom.contains("7") 
				|| nom.contains("8") || nom.contains("9")) 
			throw new NomPersonaIncorrecteException ("Error de format, el nom no pot contenir cap número");
		return nom;
	}
	public void demanarDadesInicials (String missatgeFiles, String missatgeSeients) {
		int numFiles = Entrada.llegirInt(missatgeFiles);
		this.numFiles = numFiles;
		int numSeients = Entrada.llegirInt(missatgeSeients);
		this.numSeients = numSeients;
	}
	public int introduirFila (String missatge) throws FilaIncorrectaException{
		int fila = Entrada.llegirInt(missatge);
		if (fila < 1 || fila > this.numFiles)
			throw new FilaIncorrectaException ("El cinema no disposa de la fila número "+fila);
		return fila;
	}
	public int introduirSeient (String missatge) throws SeientIncorrecteException{
		int seient = Entrada.llegirInt(missatge);
		if (seient < 1 || seient > this.numSeients)
			throw new SeientIncorrecteException ("El cinema no disposa del seient número "+seient);
		return seient;
	}
}

