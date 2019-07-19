package it.unicam.cs.pa.mastermind2019.controller;

import java.io.IOException;

import it.unicam.cs.pa.mastermind2019.LogToFile;
import it.unicam.cs.pa.mastermind2019.Player;
import it.unicam.cs.pa.mastermind2019.PlayerFactory;
import it.unicam.cs.pa.mastermind2019.model.Campo;
import it.unicam.cs.pa.mastermind2019.model.GameParameters;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;

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

	/**
	 * Costruttore di ConsoleGame.
	 * 
	 * @param p1 Primo giocatore della partita.
	 * @param p2 Secondo giocatore della partita.
	 */
	public ConsoleGame(	Player p1,
						Player p2 )
	{
		this.giocatore1 = p1;
		this.giocatore2 = p2;
		LogToFile.messaggio("INFO", "Creata una console di gioco");
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
	private void start() throws IOException, IllegalParameterException
	{
		do
		{
			GameParameters settings = new GameParameters(InputOutput.prendiLunghezza(), InputOutput.prendiDuplicati());
			Campo terreno = new Campo(settings);
			MatchCoordinator arbitro = new MatchCoordinator(settings, terreno, this.giocatore1, this.giocatore2);
//			LogToFile.messaggio("INFO", "PARTITA INIZIATA !");
			System.out.println(arbitro.play());
		}
		while (InputOutput.matchAgain());
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
//		LogToFile.init();
		InputOutput.stampaLogo();
		PlayerFactory player1 = new PlayerFactory();
		PlayerFactory player2 = new PlayerFactory();
		ConsoleGame direttore = new ConsoleGame(player1.getPlayer(InputOutput.typePlayerSelection()), player2.getPlayer(InputOutput.typePlayerCodeBreaker()));
		direttore.start();
	}
}
