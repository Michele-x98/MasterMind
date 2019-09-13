package it.unicam.cs.pa.mastermind2019;

import java.util.logging.Level;
import java.util.logging.Logger;

import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Creare il Player adatto alla richiesta.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class PlayerFactory implements PlayerFactoryView
{
	private static final Logger logger = LogToFile.getLogger(PlayerFactory.class);

	public PlayerFactory() 
	{
		logger.log(Level.INFO,"Factory creata con successo");
	}


	public Player getPlayer(String c, MMView vista)
	{
		Player p;
		
		if (c.equalsIgnoreCase("bot"))
		{
			logger.log(Level.INFO, "Creazione di un bot in corso .. ");
			p = new Bot(vista,c);
		}
		else
		{
			logger.log(Level.INFO, "Creazione di un Human in corso .. ");
			p = new Human(vista,c);
		}
		
		return p;
	}
}
