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
 * Costruttore della factory.
 */
	public PlayerFactory() 
	{
		logger.log(Level.INFO,"Factory creata con successo");
	}

/**
 * Metodo che restituisce un player da ub Enum e una MMView in ingresso.
 * 
 * @return Un nuovo player.
 */
	@Override
	public Player getPlayer(PlayerType player, MMView vista)
	{
		Player newPlayer;
		
		if (player == PlayerType.BOT)
		{
			logger.log(Level.INFO, "Creazione di un bot in corso .. ");
			newPlayer = new Bot(vista,"Bot");
		}
		else
		{
			logger.log(Level.INFO, "Creazione di un Human in corso .. ");
			newPlayer = new Human(vista,"Interactive Player");
		}
		
		return newPlayer;
	}
}
