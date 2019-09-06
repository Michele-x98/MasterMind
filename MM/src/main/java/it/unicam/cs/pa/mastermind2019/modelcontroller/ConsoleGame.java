package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.io.IOException;

import it.unicam.cs.pa.mastermind2019.Player;
import it.unicam.cs.pa.mastermind2019.PlayerFactory;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;
import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Creare una partita ed avviarla.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini

 */

public class ConsoleGame
{
	private Player giocatore1;
	private Player giocatore2;
	private MMView vista;
	/**
	 * Costruttore di ConsoleGame.
	 * 
	 * @param p1 Primo giocatore della partita.
	 * @param p2 Secondo giocatore della partita.
	 * @param terreno 
	 */
	public ConsoleGame(	Player p1,
						Player p2,
						MMView vista,
						CampoView terreno)
	{
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
	private void start(ParametersView impostazioni, Campo terrenogioco) throws IOException, IllegalParameterException
	{
		do
		{
			MatchCoordinator arbitro = new MatchCoordinator(impostazioni, terrenogioco, vista,
					this.giocatore1, this.giocatore2);
			System.out.println(arbitro.play());
		}
		while (vista.matchAgain());
	}

	/**
	 * Metodo Main.
	 * 
	 * @param argv	Argomenti passati all'applicazione.
	 * @throws IOException Eccezione che può essere lanciata da start.
	 * @throws IllegalParameterException Eccezione che può essere lanciata da start.
	 */

	public static void main(String argv[]) throws IOException, IllegalParameterException
	{
		ParametersView settings = new ParametersConfig();
		Campo terreno = new Campo(settings);
		MMView uno = new InputOutput(settings, terreno);
		uno.gameInit();
		PlayerFactory player1 = new PlayerFactory();
		PlayerFactory player2 = new PlayerFactory();
		ConsoleGame direttore = new ConsoleGame(player1.getPlayer(uno.typePlayerSelection(true),uno),player2.getPlayer(uno.typePlayerSelection(false),uno),uno,terreno);
		direttore.start(settings, terreno);
	}
}
