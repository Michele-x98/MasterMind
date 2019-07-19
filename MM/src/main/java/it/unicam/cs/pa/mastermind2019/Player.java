package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.model.GameParameters;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;

/**
 * <b>Responsabilità:</b> Impostare le basi per la strategia di un giocatore.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public interface Player
{
	/**
	 * Restituisce l'ID del player corrente.
	 * 
	 * @return L'ID del player
	 */
	public String getID();

	/**
	 * Genera un array di interi che può essere utilizzato sia come codice da
	 * indovinare, sia come tentativo.
	 * 
	 * @param settings Impostazioni della partita corrente.
	 * @return Un ArrayList di interi.
	 * @throws IllegalParameterException Eccezione per parametri non regolari.
	 */
	public ArrayList<Integer> generateCode(GameParameters settings) throws IllegalParameterException;
	
	
	public void getSuggerimento(ArrayList<Pioli> suggerimento);

}
