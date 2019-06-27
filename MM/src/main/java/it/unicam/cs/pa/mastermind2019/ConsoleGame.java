package it.unicam.cs.pa.mastermind2019;

import java.io.IOException;

/**
 * <b>Responsabilità </b>: Far partire il gioco (direttore)
 * 
 * @author TeamTrustMe
 *
 */

public class ConsoleGame
{

	/**
	 * @param output     Stringa in output.
	 * @param input      Stringa in input.
	 * @param giocatore1 Primo {@link}Player della partita,
	 * @param giocatore2 Secondo {@link}Player della partita.
	 */

	private Player giocatore1;
	private Player giocatore2;

	/**
	 * Costruttore di ConsoleGame
	 * 
	 * @param p1 Primo giocatore della partita.
	 * @param p2 Secondo giocatore della partita.
	 */
	public ConsoleGame(	Player p1,
						Player p2 )
	{
		this.giocatore1 = p1;
		this.giocatore2 = p2;
		LogToFile.messaggio("INFO","Creata una console di gioco");
	}

	/**
	 * Metodo iniziale
	 * 
	 * 1) Prendo i parametri di gioco 2) Creo i 2 ArrayList in Campo in base ai
	 * parametri di gioco 3) Creo Arbitro a cui passo, parametri, campo, e i 2
	 * giocatori 4) Faccio partire la partita e restituisco il risultato
	 * 
	 * @throws IOException
	 * @throws IllegalParameterException
	 */
	private void start() throws IOException, IllegalParameterException
	{
		do
		{
			LogToFile.messaggio("INFO","PARTITA INIZIATA !");
			GameParameters settings = new GameParameters(InputOutput.prendiLunghezza(), InputOutput.prendiDuplicati());
			Campo terreno = new Campo(settings);
			MatchCoordinator arbitro = new MatchCoordinator(settings, terreno, this.giocatore1, this.giocatore2);
			System.out.println(arbitro.play());
			arbitro.play();
		}
		while (InputOutput.matchAgain());
	}

	/**
	 * Metodo Main
	 * 
	 * @param argv
	 * @throws IOException
	 * @throws IllegalParameterException
	 */

	public static void main(String argv[]) throws IOException, IllegalParameterException
	{		
		LogToFile.init();
		InputOutput.stampaLogo();
		PlayerFactory player1 = new PlayerFactory();
		PlayerFactory player2 = new PlayerFactory();
		ConsoleGame direttore = new ConsoleGame(player1.getPlayer(InputOutput.typePlayer()), player2.getPlayer(InputOutput.typePlayer()));
		direttore.start();
	}
}
