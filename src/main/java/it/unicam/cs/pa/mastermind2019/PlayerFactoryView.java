package it.unicam.cs.pa.mastermind2019;

import it.unicam.cs.pa.mastermind2019.view.MMView;

public interface PlayerFactoryView {

	/**
	 * Metodo che restituisce un player da una stringa e una MMView in ingresso.
	 * 
	 * @return Un nuovo player.
	 */
	Player getPlayer(PlayerType player, MMView vista);

}