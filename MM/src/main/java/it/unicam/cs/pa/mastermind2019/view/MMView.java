package it.unicam.cs.pa.mastermind2019.view;

import java.util.ArrayList;
import java.util.Observable;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.Risultato;

public interface MMView {

	int prendiLunghezza();

	/**
	 * Metodo che consente di prendere in input se avere o no duplicati nel codice.
	 * 
	 * @return True se i duplicati sono accettati, altrimenti False.
	 */
	boolean prendiDuplicati();

	/**
	 * Metodo che restituisce true se il giocatore decide di giocare ancora,
	 * altrimenti false.
	 * 
	 * @return True Se il giocatore gioca ancora, altrimenti False.
	 */
	boolean matchAgain();

	/**
	 * Prende i tipi di giocatore da tastiera e li da come valore di ritorno in una
	 * String.
	 * 
	 * 
	 * @return Tipo del giocatore.
	 */
	String typePlayerSelection(boolean i);

	/**
	 * Prende un numero e lo da come valore di ritorno.
	 * 
	 * @param max Valore massimo.
	 * @return Il numero preso da tastiera.
	 */
	ArrayList<Integer> getCombination();

	/**
	 * Stampa l'ArrayList di suggerimento preso in input.
	 * 
	 * @param sugg ArrayList di pioli suggerimento.
	 */

	void gameInit();

	void attemptResault(ArrayList<Pioli> sugg);

	void update(Observable o, Object arg);

	void getSuggerimento();

	ArrayList<Integer> botGetCombination();

	void vediCodice(ArrayList<Integer> arrayFromCode);

	void matchResault(Risultato esito);

	int sceltaMenu();

	int difficultConfiguration();

	boolean duplicateConfiguration();

}