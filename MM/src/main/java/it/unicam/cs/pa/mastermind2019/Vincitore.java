package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità:</b> Creare un Risultato in caso di vittoria.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public class Vincitore implements Risultato
{
	private final String winnerId;

	/**
	 * Costruttore di Vincitore.
	 * 
	 * @param winnerId Identificatore del vincitore.
	 */
	public Vincitore(String winnerId )
	{
		this.winnerId = winnerId;
	}

	/**
	 * Override del metodo getID di player.
	 * 
	 * @return the winnerId.
	 */
	@Override
	public String getID()
	{ return winnerId; }

	/**
	 * Overriding del metodo toString di Player.
	 */
	public String toString()
	{
//		LogToFile.messaggio("INFO","Stampa del giocatore vincente");
		return "Il giocatore " +
				winnerId +
				" ha vinto!";
	}

}
