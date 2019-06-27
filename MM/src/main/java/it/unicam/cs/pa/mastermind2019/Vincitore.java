package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità </b>: Creare un Risultato in caso di vittoria
 * 
 * @author TeamTrustMe
 *
 */
public class Vincitore implements Risultato
{
	private final String winnerId;

	/**
	 * Costruttore di Vincitore
	 * 
	 * @param winnerId Identificatore del vincitore
	 */
	public Vincitore(String winnerId )
	{
		this.winnerId = winnerId;
	}

	/**
	 * Getter dell'ID
	 * 
	 * @return the winnerId
	 */
	@Override
	public String getID()
	{ return winnerId; }

	/**
	 * Overriding del metodo toString per il vincitore.
	 */
	public String toString()
	{
		LogToFile.messaggio("INFO","Stampa del giocatore vincente");
		return "Il giocatore " +
				winnerId +
				" ha vinto!";
	}

}
