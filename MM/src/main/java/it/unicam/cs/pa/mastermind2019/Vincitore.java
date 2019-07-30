package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità:</b> Creare un Risultato in caso di vittoria.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public class Vincitore implements Risultato
{
	private final String vincitoreID;

	/**
	 * Costruttore di Vincitore.
	 * 
	 * @param vincitore Identificatore del vincitore.
	 */
	public Vincitore(String vincitore )
	{
		this.vincitoreID = vincitore;
	}

	/**
	 * Override del metodo getID di player.
	 * 
	 * @return the winnerId.
	 */
	@Override
	public String getID()
	{ return vincitoreID; }

	/**
	 * Overriding del metodo toString di Player.
	 */
	public String toString()
	{
//		LogToFile.messaggio("INFO","Stampa del giocatore vincente");
		return "Il giocatore " +
				vincitoreID +
				" ha vinto!";
	}

}
