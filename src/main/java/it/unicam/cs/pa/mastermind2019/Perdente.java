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
	private static final Logger logger = LogToFile.getLogger(Perdente.class);
	private final String loserId;

	public Perdente(String ID )
	{
		logger.log(Level.INFO,"Creata un istanza di Perdente per il giocatore: "+ID);
		this.loserId = ID;
	}

	/**
	 * Override del toString.
	 * @return Stringa che identifica l'oggetto.
	 */
	@Override
	public String toString()
	{
		logger.log(Level.INFO, "Restituito Risultato della partita: \n"+"Il giocatore " + loserId  + " ha perso!");
		return "Il giocatore " +
				loserId +
				" ha perso!";
	}
	/**Override del metodo getID dell'interfaccia Risultato.
	 * @return L'ID del giocatore perdente
	 */
	@Override
	public String getID()
	{ return loserId; }
}
