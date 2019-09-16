package it.unicam.cs.pa.mastermind2019.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
//import java.util.Observable;
//import java.util.Observer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unicam.cs.pa.mastermind2019.LogToFile;
import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.PlayerType;
import it.unicam.cs.pa.mastermind2019.Risultato;
import it.unicam.cs.pa.mastermind2019.modelcontroller.CampoView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;

/**
 * <b>Responsabilità:</b> Interfacciarsi con l'utente.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 * 
 */

//@SuppressWarnings("deprecation")
public class InputOutput implements MMView// , Observer
{
	private PrintStream output;
	private BufferedReader input;
	ImpostazioniView currentParameters;
	CampoView terreno;
	private static final Logger logger = LogToFile.getLogger(InputOutput.class);
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

	public InputOutput(	ImpostazioniView parametri,
						CampoView terreno )
	{
		this.input = new BufferedReader(new InputStreamReader(System.in));
		this.output = System.out;
		this.currentParameters = parametri;
		this.terreno = terreno;
		logger.log(Level.INFO, "Creazione dell' INPUT e dell' OUTPUT con l'utente avvenuta con successo");
	}

	@Override
	public boolean matchAgain()
	{
		logger.log(Level.INFO, "In attesa della decisione dell'utente ..");
		while (true)
		{
			output.println("Vuoi uscire? (S/N)");
			String str;
			try
			{
				str = input.readLine();
				if (str.equalsIgnoreCase("S"))
				{
					logger.log(Level.INFO, "Decisione accettata: FINE");
					clearScreen();
					output.println("Arrivederci");
					return false;
				}
				else if (str.equalsIgnoreCase("N"))
				{
					logger.log(Level.INFO, "Decisione accettata: REGAME");
					clearScreen();
					output.println("Ricominciamo!");
					return true;
				}
				else
					throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				logger.log(Level.WARNING, "Decisione non valida");
				clearScreen();
				output.println("Vuoi uscire? (S/N)");
				output.println("Inserisci S o N!");
			}
			catch (IllegalParameterException e)
			{
				logger.log(Level.WARNING, "Decisione non valida");
				clearScreen();
				output.println("Vuoi uscire? (S/N)");
				output.println("Inserisci S o N!");
			}

		}
	}

	@Override
	public String typePlayerSelection(boolean i)
	{
		String code = null;
		if (i)
			code = "CodeMaker";
		else
			code = "CodeBreaker";
		logger.log(Level.INFO, "In attesa della decisione dell'utente ..");
		while (true)
		{
			output.println("Inserisci chi vuoi che sia il " +
							code);
			String c;
			try
			{
				c = input.readLine();
				if (c == null)
					throw new IllegalParameterException();
				logger.log(Level.INFO, "Decisione accettata");
				return c;
			}
			catch (IOException e)
			{
				logger.log(Level.WARNING, "Decisione non valida");
				clearScreen();
				output.println("Tipo di " +
								code +
								" non valido.");
			}
			catch (IllegalParameterException e)
			{
				logger.log(Level.WARNING, "Decisione non valida");
				clearScreen();
				output.println("Tipo di " +
								code +
								" non valido.");
			}

		}
	}

	@Override
	public ArrayList<Integer> getCombination(PlayerType giocatore)
	{
		switch (giocatore)
		{
			case HUMAN:
			{
				return humanGetCombination();
			}
			case BOT:
			{
				return botGetCombination();
			}
			default:
			{
				return null;
			}
		}
	}

	@Override
	public void gameInit()
	{
		logger.log(Level.INFO, "Stampa logo e regole in corso");
		System.out.println(logo);
		System.out.println(regole);
		logger.log(Level.INFO, "Logo e regole stampate correttamente");
	}

	@Override
	public void attemptResault(ArrayList<Pioli> sugg)
	{
		logger.log(Level.INFO, "Restituzione del suggerimento: " +
								sugg);
		output.println("Suggerimento: " +
						sugg);
	}

//	@Override
//	public void update(	Observable o,
//						Object arg)
//	{
//		 TODO Auto-generated method stub
//	}

	
	@Override
	public void getSuggerimento()
	{
		logger.log(Level.INFO, "Restituito il suggerimento");
		System.out.println(terreno.getLastSuggerimento());
	}

	@Override
	public void vediCodice(ArrayList<Integer> arrayFromCode)
	{
		logger.log(Level.INFO, "Stampato Array");
		output.println(arrayFromCode);
	}

	@Override
	public void matchResault(Risultato esito)
	{
		logger.log(Level.INFO, "Stampato l'esito della partita");
		System.out.println(esito);
	}

	@Override
	public int sceltaMenu()
	{
		logger.log(Level.INFO, "Aspettando la Decisione del menù dell'utente");
		while (true)
		{
			output.println("1. Gioca\n2. Impostazioni\n3. Esci");
			String str;
			try
			{
				str = input.readLine();
				if (str.equals("1") || str.equals("2") || str.equals("3"))
				{
					logger.log(Level.INFO, "Decisione acquisita correttamente");
					return Integer.parseInt(str);
				}
				else
					throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				logger.log(Level.WARNING, "Decisione non accettata");
				clearScreen();
				output.println("1. Gioca\n2. Impostazioni\n3. Esci");
				output.println("Inserisci il numero della risposta !");
			}
			catch (IllegalParameterException e)
			{
				logger.log(Level.WARNING, "Decisione non accettata");
				clearScreen();
				output.println("1. Gioca\n2. Impostazioni\n3. Esci");
				output.println("Inserisci il numero della risposta !");
			}
		}
	}

	@Override
	public int difficultConfiguration()
	{
		logger.log(Level.INFO, "Aspettando la decisione della difficoltà dell'utente");
		while (true)
		{
			output.println("Seleziona la difficoltà:\n1. Facile\n2. Media\n3. Difficile");
			String str;
			try
			{
				str = input.readLine();
				if (str.equals("1"))
				{
					logger.log(Level.INFO, "Decisione acquisita correttamente");
					return 4;
				}
				else if (str.equals("2"))
				{
					logger.log(Level.INFO, "Decisione acquisita correttamente");
					return 6;
				}
				else if (str.equals("3"))
				{
					logger.log(Level.INFO, "Decisione acquisita correttamente");
					return 8;
				}
				throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				logger.log(Level.WARNING, "Decisione non accettata");
				clearScreen();
				output.println("Seleziona la difficoltà:\n1. Facile\n2. Media\n3. Difficile");
				output.println("Inserisci il numero della risposta !");
			}
			catch (IllegalParameterException e)
			{
				logger.log(Level.WARNING, "Decisione non accettata");
				clearScreen();
				output.println("Seleziona la difficoltà:\n1. Facile\n2. Media\n3. Difficile");
				output.println("Inserisci il numero della risposta !");
			}
		}
	}

	@Override
	public boolean duplicateConfiguration()
	{
		logger.log(Level.INFO, "Aspettando la decisione dell'utente");
		while (true)
		{
			output.println("Seleziona:\n1. Duplicati presenti nel codice\n2. Duplicati non presenti nel codice");
			String str;
			try
			{
				str = input.readLine();
				if (str.equals("1"))
				{
					logger.log(Level.INFO, "Decisione accettata");
					clearScreen();
					System.out.println("Impostazioni aggiornate con successo");
					return true;
				}
				else if (str.equals("2"))
				{
					logger.log(Level.INFO, "Decisione accettata");
					clearScreen();
					System.out.println("Impostazioni aggiornate con successo");
					return false;
				}
				else
					throw new IllegalParameterException();
			}
			catch (IOException e)
			{
				logger.log(Level.WARNING, "Decisione non accettata");
				clearScreen();
				output.println("Inserisci il numero della risposta !");
				output.println("Seleziona:\n1. Duplicati presenti nel codice\n2. Duplicati non presenti nel codice");
			}
			catch (IllegalParameterException e)
			{
				logger.log(Level.WARNING, "Decisione non accettata");
				clearScreen();
				output.println("Inserisci il numero della risposta !");
				output.println("Seleziona:\n1. Duplicati presenti nel codice\n2. Duplicati non presenti nel codice");
			}
		}
	}

	public void clearScreen()
	{
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.println(logo);
		System.out.println(regole);
	}

	private ArrayList<Integer> humanGetCombination()
	{
		logger.log(Level.INFO, "Aspettando la decisione dell'utente");
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
					throw new IllegalParameterException("La lunghezza non è corretta");
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
						throw new IllegalParameterException();
				}
				validate = true;
			}
			catch (IllegalParameterException e)
			{
				logger.log(Level.WARNING, "Decisione non accettata");
				clearScreen();
				System.err.println("Uno o più parametri inseriti non sono corretti\n" +
									"I numeri devono essere compresi tra 1 e " +
									currentParameters.getMaxCodValue() +
									", prova di nuovo \n");
			}
			catch (IOException e)
			{
				logger.log(Level.WARNING, "Decisione non accettata");
				clearScreen();
				System.err.println("Uno o più parametri inseriti non sono corretti\n" +
									"I numeri devono essere compresi tra 1 e " +
									currentParameters.getMaxCodValue() +
									", prova di nuovo \n");

			}
		}
		while (!validate);
		clearScreen();
		output.println("Sequenza di valori accettata");
		logger.log(Level.INFO, "Decisione accettata");
		return codice;

	}

	private ArrayList<Integer> botGetCombination()
	{
		logger.log(Level.INFO, "Aspettando la decisione del Bot");
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
		logger.log(Level.INFO, "Decisione accettata");
		return code;
	}
}