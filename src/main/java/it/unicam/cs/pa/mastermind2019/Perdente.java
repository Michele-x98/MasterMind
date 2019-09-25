package it.unicam.cs.pa.mastermind2019;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <b>Responsabilità:</b> Creare un Risultato in caso di sconfitta.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class Perdente implements Risultato
{
	/**
	 * Logger della classe Perdente.
	 */
	private static final Logger logger = LogToFile.getLogger(Perdente.class);
	/**
	 * Identificatore del perdente.
	 */
	private final String loserId;

	/**
	 * Costruttore del Risultato in caso di sconfitta.
	 * 
	 * @param ID Identificatore del perdente.
	 */
	public Perdente(String ID )
	{
		logger.log(Level.INFO, "Creata un istanza di Perdente per il giocatore: " +
								ID);
		this.loserId = ID;
	}

	/**
	 * Override del toString.
	 * 
	 * @return Stringa che identifica l'oggetto.
	 */
	@Override
	public String toString()
	{
		logger.log(Level.INFO, "Restituito Risultato della partita: \n" +
								"Il giocatore " +
								loserId +
								" ha perso!");
		return "Il giocatore " +
				loserId +
				" ha perso!";
	}

	/**
	 * Override del metodo getID dell'interfaccia Risultato.
	 * 
	 * @return L'ID del giocatore perdente.
	 */
	@Override
	public String getID()
	{ return loserId; }
}
