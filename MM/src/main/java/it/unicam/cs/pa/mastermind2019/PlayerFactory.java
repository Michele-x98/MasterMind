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
	/**
	 * Costruttore vuoto.
	 */
	public PlayerFactory() {}

	/**
	 * Metodo che consente di creare un player data una stringa iniziale.
	 * 
	 * @param c Parametro che inciderà sulla creazione del player.
	 * @return Il player desiderato.
	 */
	public Player getPlayer(String c, MMView vista)
	{
		Player p;
		
		if (c.equalsIgnoreCase("bot"))
		{
			p = new Bot(vista,c);
			logger.log(Level.INFO, "Creato un bot con id: "+ c);
		}
		else
		{
			p = new Human(vista,c);
			logger.log(Level.INFO, "Creato un Human con id: "+ c);
		}
		
		return p;
	}
}
