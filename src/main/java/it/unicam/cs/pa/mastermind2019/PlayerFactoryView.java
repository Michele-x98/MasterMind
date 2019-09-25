package it.unicam.cs.pa.mastermind2019;

import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Impostare le basi per la costruzione di un player.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public interface PlayerFactoryView
{

	/**
	 * Metodo che restituisce un player da una stringa e una MMView in ingresso.
	 * 
	 * @param player Enum del tipo di player.
	 * @param vista  La vista della View.
	 * @return Viene restituito il Player concreto.
	 */
	Player getPlayer(	PlayerType player,
						MMView vista);

}