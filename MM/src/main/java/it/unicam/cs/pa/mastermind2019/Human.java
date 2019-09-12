package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Gestire un Player Interattivo (Human).
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Human implements Player
{
	private static final Logger logger = Logger.getLogger(Human.class.getName());
	public String ID;
	ArrayList<ArrayList<Integer>> tentativi;
	MMView currentView = null;

	/**
	 * Metodo costruttore di default di Human
	 * 
	 */
	public Human(MMView view)
	{
		this.ID = "Standard Player";
		this.tentativi = new ArrayList<ArrayList<Integer>>();
		this.currentView = view;
		logger.log(Level.INFO,"Creato un player umano con id: Standard Player");
	}

	/**
	 * Costruttore Human con una stringa in ingresso, assegna alla variabile
	 * <code>ID </code> il valore della stringa in ingresso.
	 * 
	 * @param id Identificatore dell'oggetto.
	 */
	public Human(	MMView view,
					String id )
	{
		this.ID = id;
		this.tentativi = new ArrayList<ArrayList<Integer>>();
		this.currentView = view;
		logger.log(Level.INFO,"Creato un player umano con id: "+ id);
	}

	/**
	 * Override del metodo gedID di Player.
	 * 
	 * @return ID dell'Human.
	 */
	@Override
	public String getID()
	{ return ID; }

	/**
	 * Metodo per prendere da tastiera il codice del giocatore.
	 * 
	 * @param settings Impostazioni della partita corrente.
	 * @return ArrayList riempito dal giocatore.
	 * @throws IllegalParameterException Eccezione per parametri non regolari.
	 */
	@Override
	public ArrayList<Integer> generateCode() throws IllegalParameterException
	{
		ArrayList<Integer> code = currentView.getCombination();
		logger.log(Level.INFO,"Il player umano ha generato il codice: "+code);
		tentativi.add(code);
		return code;
	}

}
