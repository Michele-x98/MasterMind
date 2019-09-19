package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Gestire un Player indipendente (Bot).
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Bot implements Player
{
	private static final Logger logger = LogToFile.getLogger(Bot.class);
	public String ID;
	MMView currentView;

	/**
	 * Metodo costruttore della classe Bot.
	 * 
	 * @param view Classe che implementa l'interfaccia MMView per interfacciarsi con
	 *             l'utente.
	 * @param id   Identificatore del Bot.
	 */
	public Bot(	MMView view,
				String id )
	{
		this.currentView = view;
		this.ID = id;
		logger.log(Level.INFO, "Bot Creato correttamente con id: " +
								id);
	}

	/**
	 * Override del metodo generateCode() dell'interfaccia Player che genera un
	 * ArrayList parametrizzato ad Integer contenente il codice.
	 * 
	 * @return Array generato dal metodo.
	 */
	@Override
	public ArrayList<Integer> generateCode() throws IllegalParameterException
	{
		ArrayList<Integer> codice = currentView.getCombination(PlayerType.BOT);
		logger.log(Level.INFO, "Il Bot ha generato il codice: " +
								codice);
		return codice;
	}

	/**
	 * Override del metodo getID() dell'interfaccia Player Metodo che restituisce
	 * l'ID che identifica un Bot.
	 * 
	 * @return Stringa che identifica un Bot.
	 */
	@Override
	public String getID()
	{ return ID; }

	@Override
	public ArrayList<Pioli> getSuggerimento() {
		return null;
	}

}
