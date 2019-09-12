package it.unicam.cs.pa.mastermind2019;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>Responsabilit�:</b> Creare un Risultato in caso di sconfitta.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class Perdente implements Risultato
{
	private static final Logger logger = LogToFile.getLogger(Perdente.class);
	private final String loserId;
/**
 * Costruttore di Perdente.
 * @param ID del perdente.
 */
	public Perdente(String ID )
	{
		logger.log(Level.INFO,"Creata un istanza di Perdente per il giocatore: "+ID);
		this.loserId = ID;
	}
/**
 * Override del metodo toString di Player.
 */
	@Override
	public String toString()
	{
		logger.log(Level.INFO, "Restituito Risultato della partita: \n"+"Il giocatore " + loserId  + " ha perso!");
		return "Il giocatore " +
				loserId +
				" ha perso!";
	}
/**
 * Override del metodo getID di Player.
 */
	@Override
	public String getID()
	{ return loserId; }
}
