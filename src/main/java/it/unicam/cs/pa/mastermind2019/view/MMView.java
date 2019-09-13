package it.unicam.cs.pa.mastermind2019.view;

import java.util.ArrayList;


//import java.util.Observable;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.PlayerType;
import it.unicam.cs.pa.mastermind2019.Risultato;

public interface MMView {


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
	ArrayList<Integer> getCombination(PlayerType giocatore);

	/**
	 * Stampa l'ArrayList di suggerimento preso in input.
	 * 
	 * @param sugg ArrayList di pioli suggerimento.
	 */

	void gameInit();

	void attemptResault(ArrayList<Pioli> sugg);

//	void update(Observable o, Object arg);

	void getSuggerimento();

	void vediCodice(ArrayList<Integer> arrayFromCode);

	void matchResault(Risultato esito);

	int sceltaMenu();

	int difficultConfiguration();

	boolean duplicateConfiguration();

}