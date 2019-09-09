package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.io.IOException;

import it.unicam.cs.pa.mastermind2019.Player;
import it.unicam.cs.pa.mastermind2019.PlayerFactory;
import it.unicam.cs.pa.mastermind2019.PlayerFactoryView;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;
import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Creare una partita ed avviarla.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 * 
 */

public class ConsoleGame {
	private Player giocatore1;
	private Player giocatore2;
	private MMView vista;

	/**
	 * Costruttore di ConsoleGame.
	 * 
	 * @param p1      Primo giocatore della partita.
	 * @param p2      Secondo giocatore della partita.
	 * @param terreno
	 */
	public ConsoleGame(Player p1, Player p2, MMView vista, CampoView terreno) {
		this.giocatore1 = p1;
		this.giocatore2 = p2;
		this.vista = vista;
	}

	/**
	 * Metodo iniziale che prende delle impostazioni, un terreno di gioco ed un
	 * arbitro ed infine stampa un Risultato.
	 * 
	 * @throws IOException               Eccezione che può essere lanciata da
	 *                                   InputOutput.
	 * @throws IllegalParameterException Eccezione che può essere lanciata dal
	 *                                   metodo play().
	 */
	private void start(ImpostazioniView impostazioni, CampoView terrenogioco)
			throws IOException, IllegalParameterException {
		ArbitroView arbitro = new MatchCoordinator(impostazioni, terrenogioco, vista, this.giocatore1, this.giocatore2);
		vista.matchResault(arbitro.play());

	}

	/**
	 * Metodo Main.
	 * 
	 * @param argv Argomenti passati all'applicazione.
	 * @throws IOException               Eccezione che può essere lanciata da start.
	 * @throws IllegalParameterException Eccezione che può essere lanciata da start.
	 */

	public static void main(String argv[]) throws IOException, IllegalParameterException {
		ImpostazioniView settings = new ImpostazioniFileConfig();
		CampoView terreno = new Campo(settings);
		MMView view = new InputOutput(settings, terreno);
		view.gameInit();
		PlayerFactoryView player1 = new PlayerFactory();
		PlayerFactoryView player2 = new PlayerFactory();

		do {
			boolean finegame = true;
			while (finegame) {

				switch (view.sceltaMenu()) {
				case 1: {

					ConsoleGame direttore = new ConsoleGame(player1.getPlayer(view.typePlayerSelection(true), view),
							player2.getPlayer(view.typePlayerSelection(false), view), view, terreno);
					direttore.start(settings, terreno);
					finegame = false;

				}
				case 2: {
					settings.setCodeLenght(view.difficultConfiguration());
					settings.setDuplicate(view.duplicateConfiguration());
					finegame = false;
				}
				}
			}

		} while (view.matchAgain());
	}
}
