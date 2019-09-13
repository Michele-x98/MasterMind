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
	private static final Logger logger = LogToFile.getLogger(Human.class);
	public String ID;
	ArrayList<ArrayList<Integer>> tentativi;
	MMView currentView = null;

	/**
	 * Metodo costruttore della classe Human di Default con in ingresso un'istanza
	 * di una classe che implementa MMView
	 * 
	 * @param view Classe che implementa l'interfaccia per la View del programma
	 */
	public Human(MMView view )
	{
		this.ID = "Standard Player";
		this.tentativi = new ArrayList<ArrayList<Integer>>();
		this.currentView = view;
		logger.log(Level.INFO, "Player umano di default creato correttamente con id: Standard Player");
	}

	/**
	 * Metodo costruttore della classe Human con una String in ingresso che
	 * identifica identifica l'Human e un'istanza di una classe che implementa
	 * MMView.
	 * 
	 * @param view Istanza di una classe che implementa l'interfaccia MMView.
	 * @param id   String che identifica l'Human.
	 */
	public Human(	MMView view,
					String id )
	{
		this.ID = id;
		this.tentativi = new ArrayList<ArrayList<Integer>>();
		this.currentView = view;
		logger.log(Level.INFO, "Player umano creato correttamente con id: " +
								id);
	}

	/**
	 * Override del metodo dell'interfaccia Player che restituisce l'ID che
	 * identifica l'Human.
	 * 
	 * @return ID Stringa che identifica l'Human.
	 */
	@Override
	public String getID()
	{ return ID; }

	/**
	 * Override del metodo dell'interfaccia Player che genera e restituisce un
	 * codice attraverso la classe che implementa l'interfaccia MMView.
	 * 
	 * @return codice Codice generato dal giocatore interattivo.
	 */
	@Override
	public ArrayList<Integer> generateCode() throws IllegalParameterException
	{
		ArrayList<Integer> code = currentView.getCombination(PlayerType.HUMAN);
		logger.log(Level.INFO, "Il player umano ha generato il codice: " +
								code);
		tentativi.add(code);
		return code;
	}

}
