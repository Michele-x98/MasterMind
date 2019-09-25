package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità:</b> Rendere estendibile i tipi di player che possono
 * essere creati in una partita.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public enum PlayerType
{

	/**
	 * Bot indipendente di basso livello.
	 */
	BOT,
	/**
	 * Giocatore interattivo
	 */
	HUMAN;
	// Possibile aggiunta di bot medio e IA con knut.

	/**
	 * Metodo statico che restituisce un tipo di player da una stringa in input.
	 * 
	 * @param c Stringa che identifica un player.
	 * @return Il tipo di player associato alla stringa.
	 */
	public static PlayerType getPlayerType(String c)
	{
		PlayerType player;

		if (c.equalsIgnoreCase("bot"))
		{
			player = PlayerType.BOT;
		}
		else
		{
			player = PlayerType.HUMAN;
		}
		return player;
	}
}