package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Gestire un Player indipendente (Bot).
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Bot implements Player{

	public String ID;
	MMView currentView;

	/**
	 * Costruttore con una stringa in ingresso, assegna alla variabile
	 * <code>ID </code> il valore della stringa in ingresso.
	 * 
	 * @param id Identificatore dell'oggetto.
	 */
	public Bot(MMView view,
				String id ) {
		this.currentView =view;
		this.ID = id;
	}

	/**
	 * Costruttore senza parametri in ingresso, il nome di default di un Bot è
	 * "Bot".
	 */


	/**
	 * Metodo che genera un codice random per il bot.
	 * 
	 * @param settings Impostazioni della partita corrente.
	 * @return Array da decodificare o array da controllare.
	 * 
	 **/
	@Override
	public ArrayList<Integer> generateCode() throws IllegalParameterException
	{
		return currentView.botGetCombination();
	}
	/**
	 * Getter di <code>ID</code>.
	 * 
	 * @return L'ID dell'oggetto corrente.
	 */

	@Override
	public String getID() {
//		LogToFile.messaggio("INFO","Stringa ID del Bot restituita");
		return ID;
	}

}
