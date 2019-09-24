package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.logging.Level;
import java.util.logging.Logger;


import it.unicam.cs.pa.mastermind2019.LogToFile;
import it.unicam.cs.pa.mastermind2019.Player;
//import it.unicam.cs.pa.mastermind2019.PlayerFactory;
//import it.unicam.cs.pa.mastermind2019.PlayerFactoryView;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
//import it.unicam.cs.pa.mastermind2019.view.InputOutput;
import it.unicam.cs.pa.mastermind2019.view.MMView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.Arbitro;

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
	private static final Logger logger = LogToFile.getLogger(ConsoleGame.class);
	
	/** Costruttore di ConsoloGame
	 * 
	 * @param p1 Primo giocatore della partita.
	 * @param p2 Secodno giocatore della partita.
	 * @param vista La vista della View
	 * @param terreno Il terreno di gioco
	 */
	public ConsoleGame(Player p1, Player p2, MMView vista, CampoView terreno)
	{
		this.giocatore1 = p1;
		this.giocatore2 = p2;
		this.vista = vista;
		logger.log(Level.INFO,"Console di gioco creata correttamente");
	}
	
	/**Metodo che crea un arbitro per la partita e la fa iniziare.
	 * 
	 * @param impostazioni Le impostazioni della Partita
	 * @param terrenogioco Il terreno di gioco
	 * @throws IllegalParameterException Eccezione che può essere lanciata dal
	 *                                   metodo generateCode.
	 */
	public void start(ImpostazioniView impostazioni, CampoView terrenogioco) throws IllegalParameterException 
	{
		logger.log(Level.INFO,"Creazione arbitro in corso");
		ArbitroView arbitro = new Arbitro(impostazioni, terrenogioco, vista, this.giocatore1, this.giocatore2);
		vista.matchResault(arbitro.play());
	}
}
