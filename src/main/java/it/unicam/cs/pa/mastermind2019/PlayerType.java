package it.unicam.cs.pa.mastermind2019;

public enum PlayerType {
	/*
	 * Enum creato allo scopo di rendere estendibile i tipi di player che possono
	 * essere creati in una partita.
	 */
	BOT, HUMAN;
	// Forse aggiunta di bot medio e IA con knut.

	public static PlayerType getPlayerType(String c) {
		PlayerType player;

		if (c.equalsIgnoreCase("bot")) {
			player = PlayerType.BOT;
		} else {
			player = PlayerType.HUMAN;
		}
		return player;
	}
}