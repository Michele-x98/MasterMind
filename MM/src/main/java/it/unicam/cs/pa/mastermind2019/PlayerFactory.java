package it.unicam.cs.pa.mastermind2019;

import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>ResponsabilitÓ:</b> Creare il Player adatto alla richiesta.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class PlayerFactory
{
	/**
	 * Costruttore vuoto.
	 */
	public PlayerFactory() {}

	/**
	 * Metodo che consente di creare un player data una stringa iniziale.
	 * 
	 * @param c Parametro che inciderÓ sulla creazione del player.
	 * @return Il player desiderato.
	 */
	public Player getPlayer(String c, MMView vista)
	{
		Player p;
		
		if (c.equalsIgnoreCase("bot"))
		{
			p = new Bot(vista,c);
		}
		else
		{
			p = new Human(vista,c);
		}
		return p;
	}
}
