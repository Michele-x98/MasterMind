package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.io.IOException;


/**
 * <b>Responsabilità:</b> Gestire i parametri di gioco.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class GameParameters implements ParametersView
{
	private boolean duplicateAllow;
	private int codeLenght;
	private int attempts;
	private final int minCodValue = 1;
	private int maxCodValue;

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

	public GameParameters(	int lunghezza,
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

	public GameParameters()
	{
		this.codeLenght = 4;
		this.duplicateAllow =false;
		this.attempts = 9;
		this.maxCodValue = 6;
	}

	/**
	 * Controlla che il numero in input sia compreso nel range di numeri accettabili
	 * nel contesto del gioco.
	 * 
	 * @param num Numero intero da controllare.
	 * @return <b>True</b> Se il valore è accettabile.
	 *         <b>False</b> Se il valore non è accettabile.
	 */
	@Override
	public boolean isValidNumber(int num)
	{
		return num >= this.minCodValue && num <= this.maxCodValue;
	}

	/**
	 * Metodo che restituisce la lunghezze del codice da decodificare.
	 * Metodo di lettura utilizzabile dalla vista.
	 * 
	 * @return lunghezza codice.
	 */
	@Override
	public int getCodeLenght()
	{ return codeLenght; }

	/**
	 * Metodo che restituisce i tentativi settati.
	 * 
	 * @return tentativi impostati.
	 */
	@Override
	public int getAttempts()
	{ return attempts; }
	@Override
	public int getMinCodValue()
	{ return minCodValue; }
	@Override
	public int getMaxCodValue()
	{ return maxCodValue; }
	@Override
	public boolean isDuplicateAllow()
	{ return duplicateAllow; }

}
