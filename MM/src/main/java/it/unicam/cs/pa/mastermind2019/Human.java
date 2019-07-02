package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;

/**
 * <b>Responsabilità:</b> Gestire un Player Interattivo (Human).
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Human implements Player
{
	public String ID;

	/**
	 * Metodo costruttore di default di Human
	 * 
	 */
	public Human()
	{
		this.ID = "DefaultID";
	}

	/**
	 * Costruttore Human con una stringa in ingresso, assegna alla variabile
	 * <code>ID </code> il valore della stringa in ingresso.
	 * 
	 * @param id Identificatore dell'oggetto.
	 */
	public Human(String id )
	{
		this.ID = id;
	}
/**
 * Override del metodo gedID di Player.
 * @return ID dell'Human.
 */
	@Override
	public String getID()
	{ return ID; }

	/**
	 * Metodo per prendere da tastiera il codice del giocatore.
	 * 
	 * @param settings Impostazioni della partita corrente.
	 * @return ArrayList riempito dal giocatore.
	 * @throws IllegalParameterException Eccezione per parametri non regolari.
	 */

	public ArrayList<Integer> generateCode(GameParameters settings) throws IllegalParameterException
	{
		int c;
		ArrayList<Integer> code = new ArrayList<Integer>();

		while (!(code.size() == settings.codeLenght))
		{
			try
			{
				c = InputOutput.getC(settings.maxCodValue);
				if (!settings.isValidNumber(c))
					throw new IllegalParameterException();
				else if (!(settings.duplicateAllow) && code.contains(c))
					throw new IllegalParameterException();
				code.add(c);
				InputOutput.printNumber(c);

				LogToFile.messaggio("INFO", "Codice generato dal player interattivo");


			}
			catch (IllegalParameterException e)
			{
				LogToFile.messaggio("WARNING", "Inserito un numero non valido");
				System.err.println("Numero inserito non valido");
			}
			
		}
		return code;
	}

}
