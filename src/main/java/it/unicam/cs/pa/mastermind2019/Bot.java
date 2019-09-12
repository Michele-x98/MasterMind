package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Gestire un Player indipendente (Bot).
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Bot implements Player {
	private static final Logger logger = LogToFile.getLogger(Bot.class);
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
		logger.log(Level.INFO,"Bot Creato con id: "+id);
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
		ArrayList<Integer> codice = currentView.botGetCombination();
		logger.log(Level.INFO,"Il Bot ha generato il codice: "+ codice);
		return codice;
	}
	/**
	 * Getter di <code>ID</code>.
	 * 
	 * @return L'ID dell'oggetto corrente.
	 */

	@Override
	public String getID() 
	{
		return ID;
	}

}
