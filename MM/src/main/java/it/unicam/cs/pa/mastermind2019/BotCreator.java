package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità:</b> Interfaccia che crea un Player di tipo Bot
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

@FunctionalInterface
public interface BotCreator {

	/**
	 * @return Player di tipo "Bot"
	 */
	public Bot createBot();
	
}
