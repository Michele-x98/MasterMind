package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità:</b> Creare il Player adatto alla richiesta.
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
	 * @param c Parametro che inciderà sulla creazione del player.
	 * @return Il player desiderato.
	 */
	public Player getPlayer(String c)
	{
		LogToFile.messaggio("INFO","Creazione Player");
		Player p;
		if (c.equalsIgnoreCase("bot"))
		{
			LogToFile.messaggio("INFO","Creato un Bot");
			p = new Bot();
		}
		else
		{
			LogToFile.messaggio("INFO","Creato un umano");
			p = new Human(c);
		}
		return p;
	}
}
