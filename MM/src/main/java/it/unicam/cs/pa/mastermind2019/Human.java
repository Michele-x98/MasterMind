package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;

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
	public String ID;
	ArrayList<ArrayList<Integer>> tentativi;
	MMView currentView = null;

	/**
	 * Metodo costruttore di default di Human
	 * 
	 */
	public Human(MMView view)
	{
		this.ID = "DefaultID";
		this.tentativi = new ArrayList<ArrayList<Integer>>();
		this.currentView = view;
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
		this.tentativi =new ArrayList<ArrayList<Integer>>();
		this.currentView = view;
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
		tentativi.add(code);
		return code;
	}

	@Override
	public void getSuggerimento(ArrayList<Pioli> suggerimento)
	{
		currentView.getSuggerimento();
	}

}
