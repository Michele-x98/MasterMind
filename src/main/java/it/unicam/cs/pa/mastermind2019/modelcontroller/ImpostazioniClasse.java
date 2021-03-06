package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.logging.Logger;
import java.util.logging.Level;

import it.unicam.cs.pa.mastermind2019.LogToFile;

/**
 * <b>ResponsabilitÓ:</b> Gestire i parametri di gioco attraverso la classe stessa.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class ImpostazioniClasse implements ImpostazioniView
{
	/**
	 * Boolean che indica se i duplicati sono permessi o no.
	 */
	private boolean duplicateAllow;
	/**
	 * Lunghezza del codice con cui si gioca.
	 */
	private int codeLenght;
	/**
	 * Numero di tentativi possibili.
	 */
	private int attempts;
	/**
	 * Numero minimo di valori possibili nel codice.
	 */
	private final int minCodValue = 1;
	/**
	 * Numero massimo di valori possibili nel codice.
	 */
	private int maxCodValue;
	/**
	 * Logger della classe ImpostazioniClasse.
	 */
	private static final Logger logger = LogToFile.getLogger(ImpostazioniClasse.class);

/**
 * Costruttore delle Impostazioni.
 * @param lunghezza Lunghezza del codice.
 * @param duplicate Presenza dei duplicati.
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
 * Costruttore di default con lunghezza 4 e duplicati non ammessi.
 */
	public ImpostazioniClasse()
	{
		logger.log(Level.INFO, "Create impostazioni di default");
		this.codeLenght = 4;
		this.duplicateAllow = false;
		this.attempts = 9;
		this.maxCodValue = 6;
	}


	@Override
	public boolean isValidNumber(int num)
	{
		boolean x = num >= this.minCodValue && num <= this.maxCodValue;
		logger.log(Level.INFO, "Effetuato controllo validitÓ sul numero con risultato: " +
								x);
		return x;
	}

	@Override
	public int getCodeLenght()
	{
		logger.log(Level.INFO, "Restituita la lunghezza del codice: " +
								codeLenght);
		return codeLenght;
	}

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
