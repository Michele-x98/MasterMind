package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;

import it.unicam.cs.pa.mastermind2019.LogToFile;

/**
 * <b>Responsabilità:</b> Gestire i parametri di gioco.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class ImpostazioniClasse implements ImpostazioniView
{
	private boolean duplicateAllow;
	private int codeLenght;
	private int attempts;
	private final int minCodValue = 1;
	private int maxCodValue;
	private static final Logger logger = LogToFile.getLogger(ImpostazioniClasse.class);

	/**
	 * Costruttore con valori in ingresso. Il numero di tentativi e il numero
	 * massimo di caratteri viene impostato a seconda della lunghezza del codice.
	 * 
	 * @param lunghezza Lunghezza del codice da indovinare.
	 * @param duplicate Booleano che consente di avere duplicati nel codice.
	 * @throws IOException Viene lanciata se <code>lunghezza</code> non è un numero
	 *                     tra 4-6-8.
	 * 
	 */

	public ImpostazioniClasse(	int lunghezza,
								boolean duplicate )
	{
		this.codeLenght = lunghezza;
		if (codeLenght == 4)
		{
			this.attempts = 9;
			this.maxCodValue = 6;
		}
		else if (codeLenght == 6)
		{
			this.attempts = 15;
			this.maxCodValue = 8;
		}
		else if (codeLenght == 8)
		{
			this.attempts = 21;
			this.maxCodValue = 10;
		}
	}

	/**
	 * Costruttore di default con parametri preimpostati.
	 * 
	 */

	public ImpostazioniClasse()
	{
		logger.log(Level.INFO, "Create impostazioni di default");
		this.codeLenght = 4;
		this.duplicateAllow = false;
		this.attempts = 9;
		this.maxCodValue = 6;
	}

	/**
	 * Controlla che il numero in input sia compreso nel range di numeri accettabili
	 * nel contesto del gioco.
	 * 
	 * @param num Numero intero da controllare.
	 * @return <b>True</b> Se il valore è accettabile. <b>False</b> Se il valore non
	 *         è accettabile.
	 */
	@Override
	public boolean isValidNumber(int num)
	{
		boolean x = num >= this.minCodValue && num <= this.maxCodValue;
		logger.log(Level.INFO, "Effetuato controllo validità sul numero con risultato: " +
								x);
		return x;
	}

	/**
	 * Metodo che restituisce la lunghezze del codice da decodificare. Metodo di
	 * lettura utilizzabile dalla vista.
	 * 
	 * @return lunghezza codice.
	 */
	@Override
	public int getCodeLenght()
	{
		logger.log(Level.INFO, "Restituita la lunghezza del codice: " +
								codeLenght);
		return codeLenght;
	}

	/**
	 * Metodo che restituisce i tentativi settati.
	 * 
	 * @return tentativi impostati.
	 */
	@Override
	public int getAttempts()
	{
		logger.log(Level.INFO, "Restituiti il numero dei tentativi: " +
								attempts);
		return attempts;
	}

	@Override
	public int getMinCodValue()
	{
		logger.log(Level.INFO, "Restituita la lunghezza minima del codice: " +
								minCodValue);
		return minCodValue;
	}

	@Override
	public int getMaxCodValue()
	{
		logger.log(Level.INFO, "Restituita la lunghezza massima del codice: " +
								maxCodValue);
		return maxCodValue;
	}

	@Override
	public boolean isDuplicateAllow()
	{
		logger.log(Level.INFO, "Restituito il permesso di avere duplicati nel codice: " +
								duplicateAllow);
		return duplicateAllow;
	}

	@Override
	public void setCodeLenght(int code)
	{
		logger.log(Level.CONFIG, "Modificata la lunghezza del codice a: " +
									code);
		this.codeLenght = code;
	}

	@Override
	public void setDuplicate(boolean duplicate)
	{
		logger.log(Level.CONFIG, "Modificato il permesso per i duplicati a: " +
									duplicate);
		this.duplicateAllow = duplicate;
	}

}
