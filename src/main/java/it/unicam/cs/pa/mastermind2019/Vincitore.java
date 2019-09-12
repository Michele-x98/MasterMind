package it.unicam.cs.pa.mastermind2019;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>Responsabilità:</b> Creare un Risultato in caso di vittoria.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public class Vincitore implements Risultato
{
	private static final Logger logger = LogToFile.getLogger(Vincitore.class);
	private final String vincitoreID;

	/**
	 * Costruttore di Vincitore.
	 * 
	 * @param vincitore Identificatore del vincitore.
	 */
	public Vincitore(String vincitore )
	{
		this.vincitoreID = vincitore;
		logger.log(Level.INFO,"Creata un istanza di Vincitore per il giocatore: "+vincitore);
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
		logger.log(Level.INFO, "Restituito Risultato della partita: " + "Il giocatore " + vincitoreID + " ha vinto!");
		return "Il giocatore " +
				vincitoreID +
				" ha vinto!";
	}

}
