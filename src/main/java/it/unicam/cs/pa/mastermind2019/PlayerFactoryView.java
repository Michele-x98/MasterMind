package it.unicam.cs.pa.mastermind2019;

import it.unicam.cs.pa.mastermind2019.view.MMView;

public interface PlayerFactoryView {

	/**
	 * Metodo che consente di creare un player data una stringa iniziale e l'interfaccia della View
	 * 
	 * @param c Parametro che incider� sulla creazione del player.
	 * @param vista Sar� la view del gioco.
	 * @return Il player desiderato.
	 */
	Player getPlayer(String c, MMView vista);

}