package it.unicam.cs.pa.mastermind2019.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.Player;
import it.unicam.cs.pa.mastermind2019.PlayerType;

/**
 * <b>Responsabilità:</b> Interfacciarsi con l'utente. <b>Fonte:</b>
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 * 
 */

public class InputOutput implements MMView
{

	BufferedReader input = null;

	/**
	 * Costruttore vuoto.
	 */
	public InputOutput()
	{
	}

	@Override
	public int prendiLunghezza()
	{
		while (true)
		{
			String s = null;
			try
			{
				System.out.println("Inserisci la lunghezza del codice da decifrare fra 4, 6 e 8 numeri: ");
				s = input.readLine();
				if (s.equals("4") || s.equals("6") || s.equals("8"))
				{
					System.out.println("Il codice da decifrare è lungo: " + s);
					return Integer.parseInt(s);
				}
				else throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				System.err.println("Insersci il numero 4, 6 o 8!");
			}
			catch(IllegalParameterException e)
			{
				System.err.println("Insersci il numero 4, 6 o 8!");
			}
			
		}
	}

	/**
	 * Metodo che consente di prendere in input se avere o no duplicati nel codice.
	 * 
	 * @return True se i duplicati sono accettati, altrimenti False.
	 */
	@Override
	public boolean prendiDuplicati()
	{
		while (true)
		{
//			LogToFile.messaggio("INFO", "Richiesta duplicati");
			System.out.println("Vuoi duplicati nel codice?: (S/N)");
			String s;
			try
			{
				s = input.readLine();
				if (s.equalsIgnoreCase("N"))
				{
					System.out.println("Non ci saranno duplicati");
//					LogToFile.messaggio("INFO", "Selezionata la partita senza codice duplicato");
					return false;
				}
				else if (s.equalsIgnoreCase("S"))
				{
					System.out.println("Il codice potrà contenere duplicati");
//					LogToFile.messaggio("INFO", "Selezionata la partita con codice duplicato");
					return true;
				}
				else throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				System.err.println("Inserisci S o N!");
			}
			catch(IllegalParameterException e)
			{
				System.err.println("Inserisci S o N!");
			}


		}
	}

	/**
	 * Metodo che restituisce true se il giocatore decide di giocare ancora,
	 * altrimenti false.
	 * 
	 * @return True Se il giocatore gioca ancora, altrimenti False.
	 */

	/**
	 * Prende i tipi di giocatore da tastiera e li da come valore di ritorno in una
	 * String.
	 * 
	 * 
	 * @return Tipo del giocatore.
	 */
	@Override
	public String typePlayerSelection(boolean i)
	{
		String code = null;
		if(i)
			code = "CodeMaker";
		else
			code ="CodeBreaker";
		while (true)
		{
			System.out.println("Inserisci chi vuoi che sia il "+ code + ":"+ PlayerType.values());
			String c;
			try
			{
				c = input.readLine();
				if (c == null)
					throw new IllegalParameterException();
				return c;
			}
			catch (IOException e)
			{
				System.out.println("Tipo di "+ code +" non valido.");
			}
			catch (IllegalParameterException e)
			{
				System.out.println("Tipo di "+ code +" non valido.");
			}
				
		}
	}

	/**
	 * Prende i tipi di giocatore da tastiera e li da come valore di ritorno in una
	 * String.
	 * 
	 * @return Tipo del giocatore.
	 */
	

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
	public int getC(int max)
	{
		int num = 0;
		boolean validate = false;
		do
		{
			try
			{
				System.out.print("Inserisci un numero compreso tra 1 e " +
									max +
									" : ");
				try
				{
					num = input.read();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				System.err.println("Il valore inserito non è un numero, prova di nuovo");
			}
		}
		while (!validate);
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
//		LogToFile.messaggio("INFO", "Stampato suggerimento");
		System.out.println("Array di sugerimento: " +
							sugg);
	}

	@Override
	public boolean matchAgain()
	{
		while (true)
		{
			System.out.println("Giochi ancora? (S/N)");
			String str = InputOutput.readLine();
			if (str.equalsIgnoreCase("N"))
			{
				System.out.println("Arrivederci");
//				LogToFile.messaggio("INFO", "PARTITA TERMINATA");
				return false;
			}
			if (str.equalsIgnoreCase("S"))
			{
				System.out.println("Ricominciamo!");
//				LogToFile.messaggio("INFO", "PARTITA RICOMINCIATA");
				return true;
			}
			System.out.println("Inserisci S o N!");
		}
	}

	@Override
	public ArrayList<Integer> getAttempt()
	{ // TODO Auto-generated method stub
		return null;
	}

	@Override
	public void gameInit()
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
	}

	@Override
	public Player getPlayerType()
	{ // TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attemptResault(ArrayList<Pioli> sugg)
	{
		// TODO Auto-generated method stub

	}

}