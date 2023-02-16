package n2exercici1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		llegirByte ("Escriu un byte");
		llegirInt ("Escriu un int");
		llegirFloat ("Escriu un float");
		llegirDouble ("Escriu un double");
		llegirChar ("Escriu un char");
		llegirString ("Escriu un String");
		llegirSiNo ("Escriu S si es true o N si es false");
		

	}
	public static byte llegirByte (String missatge) {
		System.out.println(missatge);
		byte resposta = 0;
		boolean isValid = false;
		while (! isValid) {
			try {
				resposta = input.nextByte();
				isValid = true;
			}catch(InputMismatchException e) {
				System.out.println("ERROR de format, torna a introduir el valor");
				input.next();
			}
		}
		return resposta;
	}
	public static int llegirInt (String missatge) {
		System.out.println(missatge);
		int resposta = 0;
		boolean isValid = false;
		while (! isValid) {
			try {
				resposta = input.nextInt();
				isValid = true;
			}catch(InputMismatchException e) {
				System.out.println("ERROR de format, torna a introduir el valor");
				input.next();
			}
		}
		return resposta;
	}
	public static float llegirFloat (String missatge) {
		System.out.println(missatge);
		float resposta = 0;
		boolean isValid = false;
		while (! isValid) {
			try {
				resposta = input.nextFloat();
				isValid = true;
			}catch(InputMismatchException e) {
				System.out.println("ERROR de format, torna a introduir el valor");
				input.next();
			}
		}
		return resposta;
	}
	public static double llegirDouble (String missatge) {
		System.out.println(missatge);
		double resposta = 0;
		boolean isValid = false;
		while (! isValid) {
			try {
				resposta = input.nextDouble();
				isValid = true;
			}catch(InputMismatchException e) {
				System.out.println("ERROR de format, torna a introduir el valor");
				input.next();
			}
		}
		return resposta;
	}
	public static char llegirChar (String missatge) {
		System.out.println(missatge);
		char resposta = ' ';
		boolean isValid = false;
		while (! isValid) {
			try {
				String answer = input.nextLine();;
				if (answer.length() != 1)
					throw new IndexOutOfBoundsException();
				resposta = answer.charAt(0);
				isValid = true;
			}catch(IndexOutOfBoundsException e) {
				System.out.println("ERROR, has d'introduir un únic caràcter");
			}catch(Exception e) {
				System.out.println("Error de lectura "+e.getMessage());
			}
		}
		return resposta;
	}
	public static String llegirString (String missatge) {
		System.out.println(missatge);
		String resposta ="";
		boolean isValid = false;
		while (! isValid) {
			try {
				resposta = input.nextLine();
				isValid = true;
			}catch(Exception e) {
				System.out.println("Error de lectura");
			}
		}
		return resposta;
	}
	public static boolean llegirSiNo (String missatge) {
		System.out.println(missatge);
		String resposta = "";
		boolean isValid = false;
		while (! isValid) {
			try {
				resposta = input.nextLine();
				if (resposta.equalsIgnoreCase("s") || resposta.equalsIgnoreCase("n"))
					isValid = true;
				else System.out.println("Has d'introduir S o N");
			}catch(Exception e) {
				System.out.println("Error de lectura");
			}
		}
		return resposta.equalsIgnoreCase("s") ? true : false;
	}

}
