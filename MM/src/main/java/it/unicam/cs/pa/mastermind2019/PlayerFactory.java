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
//		LogToFile.messaggio("INFO","Creazione Player");
		Player p;
		BotCreator bot = Bot::new;
		HumanCreator human = Human::new;
		
		if (c.equalsIgnoreCase("bot"))
		{
			LogToFile.messaggio("INFO","Creato un Bot");
			p = bot.createBot();
		}
		else
		{
			LogToFile.messaggio("INFO","Creato un umano");
			p = human.creatHuman(c);
		}
		return p;
	}
}
