package it.unicam.cs.pa.mastermind2019.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.PlayerType;
import it.unicam.cs.pa.mastermind2019.Risultato;
import it.unicam.cs.pa.mastermind2019.modelcontroller.CampoView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;

/**
 * <b>Responsabilit�:</b> Interfacciarsi con l'utente. <b>Fonte:</b>
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 * 
 */

@SuppressWarnings("deprecation")
public class InputOutput implements MMView, Observer
{
	private PrintStream output;
	private BufferedReader input;
	ImpostazioniView currentParameters;
	CampoView terreno;

	public InputOutput(	ImpostazioniView parametri,
						CampoView terreno )
	{
		this.input = new BufferedReader(new InputStreamReader(System.in));
		this.output = System.out;
		this.currentParameters = parametri;
		this.terreno = terreno;
	}

	@Override
	public int prendiLunghezza()
	{
		while (true)
		{
			String s = null;
			try
			{
				output.println("Inserisci la lunghezza del codice da decifrare fra 4, 6 e 8 numeri: ");
				s = input.readLine();
				if (s.equals("4") || s.equals("6") || s.equals("8"))
				{
					output.println("Il codice da decifrare � lungo: " +
									s);
					return Integer.parseInt(s);
				}
				else
					throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				System.err.println("Insersci il numero 4, 6 o 8!");
			}
			catch (IllegalParameterException e)
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
			output.println("Vuoi duplicati nel codice?: (S/N)");
			String s;
			try
			{
				s = input.readLine();
				if (s.equalsIgnoreCase("N"))
				{
					output.println("Non ci saranno duplicati");
					return false;
				}
				else if (s.equalsIgnoreCase("S"))
				{
					output.println("Il codice potr� contenere duplicati");
					return true;
				}
				else
					throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				System.err.println("Inserisci S o N!");
			}
			catch (IllegalParameterException e)
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
	@Override
	public boolean matchAgain()
	{
		while (true)
		{
			output.println("Vuoi uscire? (S/N)");
			String str;
			try
			{
				str = input.readLine();
				if (str.equalsIgnoreCase("S"))
				{
					output.println("Arrivederci");
					return false;
				}
				else if (str.equalsIgnoreCase("N"))
				{
					output.println("Ricominciamo!");
					return true;
				}
				else
					throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				output.println("Inserisci S o N!");
			}
			catch (IllegalParameterException e)
			{
				output.println("Inserisci S o N!");
			}

		}
	}

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
		if (i)
			code = "CodeMaker";
		else
			code = "CodeBreaker";
		while (true)
		{
			PlayerType[] types = PlayerType.class.getEnumConstants();
			output.println("Inserisci chi vuoi che sia il " +
							code +
							":" +
							types);
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
				output.println("Tipo di " +
								code +
								" non valido.");
			}
			catch (IllegalParameterException e)
			{
				output.println("Tipo di " +
								code +
								" non valido.");
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
	 * Prende un numero e lo da come valore di ritorno.
	 * 
	 * @param max Valore massimo.
	 * @return Il numero preso da tastiera.
	 */
	@Override
	public ArrayList<Integer> getCombination()
	{
		boolean validate = false;
		ArrayList<Integer> codice;
		do
		{
			String app = null;
			codice = new ArrayList<Integer>();
			try
			{
				output.print("Inserisci una sequenza di " +
								currentParameters.getCodeLenght() +
								" valori, con numeri compresi tra 1 e " +
								currentParameters.getMaxCodValue() +
								" : ");
				app = input.readLine();
				if (app.length() != currentParameters.getCodeLenght())
					throw new IllegalParameterException("La lunghezza non � corretta");
				char[] app2 = app.toCharArray();
				for (int i = 0; i < app2.length; i++)
				{
					if (Character.getNumericValue(app2[i]) > 0 && Character.getNumericValue(app2[i]) < currentParameters.getMaxCodValue() + 1)
					{
						if (!(currentParameters.isDuplicateAllow()) && codice.contains(Character.getNumericValue(app2[i])))
							throw new IllegalParameterException("Duplicati non ammessi");
						codice.add(Character.getNumericValue(app2[i]));
					}
					else
						throw new IllegalParameterException("Uno o pi� parametri inseriti non sono corretti\n" +
															"I numeri devono essere compresi tra 1 e " +
															currentParameters.getMaxCodValue() +
															", prova di nuovo \n");
				}
				validate = true;
			}
			catch (IllegalParameterException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				System.err.println("Uno o pi� parametri inseriti non sono corretti\n" +
						"I numeri devono essere compresi tra 1 e " +
						currentParameters.getMaxCodValue() +
						", prova di nuovo \n");
			}
		}
		while (!validate);
		output.println("Sequenza di valori accettata");
		return codice;
	}

	/**
	 * Stampa l'ArrayList di suggerimento preso in input.
	 * 
	 * @param sugg ArrayList di pioli suggerimento.
	 */

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
						"secondo giocatore colui che dovr� indovinare il CODICE.\n" +
						"La lunghezza del codice � variabile tra 4, 6 e 8 numeri, e si pu� scegliere se avere duplicati o no nel codice.\n" +
						"Il Suggerimento stampato va interpretato come segue: \n" +
						"PC = Numero Corretto, nella Posizione Corretta \n" +
						"PE = Numero Corretto, nella Posizione Errata \n";
		System.out.println(logo);
		System.out.println(regole);
	}

	@Override
	public void attemptResault(ArrayList<Pioli> sugg)
	{
		output.println(sugg);

	}

	@Override
	public void update(	Observable o,
						Object arg)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void getSuggerimento()
	{
		terreno.getLastSuggerimento();
	}

	@Override
	public ArrayList<Integer> botGetCombination()
	{

		ArrayList<Integer> code = new ArrayList<Integer>();

		while (!(code.size() == currentParameters.getCodeLenght()))
		{
			Random random = new Random();
			int n = currentParameters.getMaxCodValue() - currentParameters.getMinCodValue();
			int k = random.nextInt(n) + currentParameters.getMinCodValue();
			if (!currentParameters.isDuplicateAllow())
				while (code.contains(k))
				{
					k = random.nextInt(n) + currentParameters.getMinCodValue();
				}
			code.add(k);
		}
		return code;
	}

	@Override
	public void vediCodice(ArrayList<Integer> arrayFromCode)
	{
		output.println(arrayFromCode);
	}

	@Override
	public void matchResault(Risultato esito)
	{
	System.out.println(esito);
	}

	@Override
	public int sceltaMenu()
	{
		while(true)
		{
		output.println("1. Gioca\n2. Impostazioni\n3. Esci");
		String str;
		try
		{
			str = input.readLine();
			if (str.equals("1") || str.equals("2") || str.equals("3"))
			{
				return Integer.parseInt(str);
			}
			else
				throw new IllegalParameterException();
		}
		catch (IOException e)
		{
			output.println("Inserisci il numero della risposta !");
		}
		catch (IllegalParameterException e)
		{
			output.println("Inserisci il numero della risposta !");
		}}
	}

	@Override
	public int difficultConfiguration()
	{
		while(true)
		{
		output.println("Seleziona la difficolt�:\n1. Facile\n2. Media\n3. Difficile");
		String str;
		try
		{
			str = input.readLine();
			if (str.equals("1"))
			{
				return 4;
			}
			else if (str.equals("2"))
			{
				return 6;
			}
			else if(str.equals("3"))
			{
				return 8;
			}
				throw new IllegalParameterException();
		}
		catch (IOException e)
		{
			output.println("Inserisci il numero della risposta !");
		}
		catch (IllegalParameterException e)
		{
			output.println("Inserisci il numero della risposta !");
		}}
	}

	@Override
	public boolean duplicateConfiguration()
	{
		while(true)
		{
		output.println("Seleziona:\n1.Duplicati presenti nel codice\n2. Duplicati non presenti nel codice");
		String str;
		try
		{
			str = input.readLine();
			if (str.equals("1"))
			{
				return true;
			}
			else if (str.equals("2"))
			{
				return false;
			}
			else
				throw new IllegalParameterException();
		}
		catch (IOException e)
		{
			output.println("Inserisci il numero della risposta !");
		}
		catch (IllegalParameterException e)
		{
			output.println("Inserisci il numero della risposta !");
		}}
	}

}