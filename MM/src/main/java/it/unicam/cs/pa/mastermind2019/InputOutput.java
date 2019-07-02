package it.unicam.cs.pa.mastermind2019;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

/**
 * <b>Responsabilità:</b> Interfacciarsi con l'utente. <b>Fonte:</b>
 * http://pages.di.unipi.it/corradini/Didattica/LIP-07/Tipi-Input/Input/main.html
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 * 
 */

public class InputOutput
{

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Costruttore vuoto.
	 */
	public InputOutput()
	{
	}

	/**
	 * Legge una linea di input. Nell'improbabile caso di una IOException, il
	 * programma termina.
	 * 
	 * @return restituisce la linea di input che l'utente ha battuto.
	 */
	public static String readLine()
	{
		String inputLine = null;
		try
		{
			inputLine = reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println(e);
			System.exit(1);
		}
		return inputLine;
	}

	/**
	 * Legge una linea di input e la converte in un intero. Eventuali spazi bianchi
	 * prima e dopo l'intero vengono ignorati.
	 * 
	 * @return l'intero dato in input dall'utente.
	 */
	public static int readInt()
	{
		String inputString = readLine();
		inputString = inputString.trim();
		int n = Integer.parseInt(inputString);
		return n;
	}

	/**
	 * Legge una linea di input e la converte in un numero in virgola mobile.
	 * Eventuali spazi bianchi prima e dopo il numero vengono ignorati.
	 * 
	 * @return il numero dato in input dall'utente.
	 */
	public static double readDouble()
	{
		String inputString = readLine();
		inputString = inputString.trim();
		double x = Double.parseDouble(inputString);
		return x;
	}

	/**
	 * Legge una linea di input e ne estrae il primo carattere.
	 * 
	 * @return il primo carattere della riga data in input dall'utente.
	 */
	public static char readChar()
	{
		String inputString = readLine();
		char c = inputString.charAt(0);
		return c;
	}

	/**
	 * Metodo che consente di prendere in input una lunghezza iniziale del codice.
	 * 
	 * @return Lunghezza iniziale del codice.
	 */
	public static int prendiLunghezza()
	{
		while (true)
		{
			LogToFile.messaggio("INFO", "Richiesta lunghezza codice");
			System.out.println("Inserisci la lunghezza del codice da decifrare fra 4, 6 e 8 numeri: ");
			String s = InputOutput.readLine();
			if (s.equals("4") || s.equals("6") || s.equals("8"))
			{
				System.out.println("Il codice da decifrare è lungo: " +
									s);
				LogToFile.messaggio("INFO", "Inserita lunghezza codice da decifrare");
				return Integer.parseInt(s);
			}
			LogToFile.messaggio("WARNING", "Lunghezza codice errata");
			System.err.println("Insersci il numero 4, 6 o 8!");
		}
	}

	/**
	 * Metodo che consente di prendere in input se avere o no duplicati nel codice.
	 * 
	 * @return True se i duplicati sono accettati, altrimenti False.
	 */
	public static boolean prendiDuplicati()
	{
		while (true)
		{
			LogToFile.messaggio("INFO", "Richiesta duplicati");
			System.out.println("Vuoi duplicati nel codice?: (S/N)");
			String s = InputOutput.readLine();
			if (s.equalsIgnoreCase("N"))
			{
				System.out.println("Non ci saranno duplicati");
				LogToFile.messaggio("INFO", "Selezionata la partita senza codice duplicato");
				return false;
			}
			if (s.equalsIgnoreCase("S"))
			{
				System.out.println("Il codice potrà contenere duplicati");
				LogToFile.messaggio("INFO", "Selezionata la partita con codice duplicato");
				return true;
			}
			System.err.println("Inserisci S o N!");
		}
	}

	/**
	 * Metodo che restituisce true se il giocatore decide di giocare ancora,
	 * altrimenti false.
	 * 
	 * @return True Se il giocatore gioca ancora, altrimenti False.
	 */
	public static boolean matchAgain()
	{
		while (true)
		{
			System.out.println("Giochi ancora? (S/N)");
			String str = InputOutput.readLine();
			if (str.equalsIgnoreCase("N"))
			{
				System.out.println("Arrivederci");
				LogToFile.messaggio("INFO", "PARTITA TERMINATA");
				return false;
			}
			if (str.equalsIgnoreCase("S"))
			{
				System.out.println("Ricominciamo!");
				LogToFile.messaggio("INFO", "PARTITA RICOMINCIATA");
				return true;
			}
			System.out.println("Inserisci S o N!");
		}
	}

	/**
	 * Prende i tipi di giocatore da tastiera e li da come valore di ritorno in una
	 * String.
	 * 
	 * @return Tipo del giocatore.
	 */
	public static String typePlayer()
	{
		while (true)
		{
			LogToFile.messaggio("INFO", "Richiesta di un giocatore");
			System.out.println("Inserisci il tipo di giocatore: 'Bot' o 'Umano' ");
			String c = InputOutput.readLine();
			if (c != null)
				return c;
			System.out.println("Tipo di giocatore non valido.");
			LogToFile.messaggio("WARNING", "Inserito un giocatore non valido");
		}
	}

	/**
	 * Stampa il numero in ingresso.
	 * 
	 * @param num Numero da stampare.
	 */
	public static void printNumber(int num)
	{
		System.out.println("Numero inserito: " +
							num);
	}

	/**
	 * Prende un numero e lo da come valore di ritorno.
	 * 
	 * @param max Valore massimo.
	 * @return Il numero preso da tastiera.
	 */
	public static int getC(int max)
	{
		int num = 0;
		boolean validate = false;
		do
		{
			try
			{
				LogToFile.messaggio("INFO", "Richiesta di un numero");
				System.out.print("Inserisci un numero compreso tra 1 e " +
									max +
									" : ");
				num = readInt();
				if (num >= 1 && num <= max)
					validate = true;
				else
				{

					System.err.println("Il numero deve essere compreso tra 1 e " +
										max +
										" ,prova di nuovo \n");
				}

			}
			catch (NumberFormatException e)
			{
				LogToFile.messaggio("WARNING", "Inserito un numero non valido");
				System.err.println("Il valore inserito non è un numero, prova di nuovo");
			}
		}
		while (!validate);
		LogToFile.messaggio("INFO", "Valore riconosciuto e restituito");
		return num;
	}

	/**
	 * Stampa il numero in ingresso.
	 * 
	 * @param num Tentativi rimasti.
	 */
	public static void getAttempts(int num)
	{
		System.out.println("Tentativi rimasti: " +
							num);
	}

	/**
	 * Stampa l'ArrayList di suggerimento preso in input.
	 * 
	 * @param sugg ArrayList di pioli suggerimento.
	 */
	public static void getSuggerimento(ArrayList<Pioli> sugg)
	{
		LogToFile.messaggio("INFO", "Stampato suggerimento");
		System.out.println("Array di sugerimento: " +
							sugg);
	}

	/**
	 * Metodo per stampare a video il logo e le regole del gioco.
	 */
	public static void stampaLogo()
	{
		String logo = "  __  __           _                      _           _  \n" +
						" |  \\/  |         | |                    (_)         | | \n" +
						" | \\  / | __ _ ___| |_ ___ _ __ _ __ ___  _ _ __   __| | \n" +
						" | |\\/| |/ _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` | \n" +
						" | |  | | (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| | \n" +
						" |_|  |_|\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_| \n" +
						"                                                         \n" +
						"                                                         ";

		String regole = "Benvenuti in MasterMind di Moschini Daniele e Benedetti Michele \n" +
						"In questa verione di MasterMind inserire come primo giocatore colui che crea il codice da DECODIFICARE, e come\n" +
						"secondo giocatore colui che dovrà indovinare il CODICE.\n" +
						"La lunghezza del codice è variabile tra 4, 6 e 8 numeri, e si può scegliere se avere duplicati o no nel codice.\n" +
						"Il Suggerimento stampato va interpretato come segue: \n" +
						"PC = Numero Corretto, nella Posizione Corretta \n" +
						"PE = Numero Corretto, nella Posizione Errata \n";
		System.out.println(logo);
		System.out.println(regole);
		LogToFile.messaggio("INFO", "Logo stampato");

	}

}