package it.unicam.cs.pa.mastermind2019.view;

import java.util.ArrayList;

//import java.util.Observable;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.PlayerType;
import it.unicam.cs.pa.mastermind2019.Risultato;

public interface MMView
{

	/**
	 * Metodo che, secondo la scelta del giocatore, restituisce true se Il giocatore
	 * interattivo vuole continuare a giocare, false altrimenti.
	 * 
	 * @return true se il giocatore vuole giocare ancora, false altrimenti.
	 */
	boolean matchAgain();

	/**
	 * Metodo che prende dal giocatore un codemaker se il parametro <code>i</code> è
	 * true, oppure un codebreaker altrimenti
	 * 
	 * @param i True pre richiedere un CodeMaker, False per richiedere un
	 *          CodeBreaker.
	 * @return Stringa che identifica il tipo di player scelto.
	 */
	String typePlayerSelection(boolean i);

	/**
	 * Metodo che restuisce un ArrayList di Integer ovvero la combinazione di valori
	 * del giocatore.
	 * 
	 * @param giocatore tipo di giocatore che utilizza il metodo.
	 * @return un arrayList con i valori del tentativo.
	 */
	ArrayList<Integer> getCombination(PlayerType giocatore);

	/**
	 * Metodo che inizializza l'Input e l'Output
	 */
	void gameInit();
	/**
	 * Metodo che restituirà in Output il suggerimento ricavato.
	 * @param sugg
	 */
	void attemptResault(ArrayList<Pioli> sugg);

//	void update(Observable o, Object arg);
	/**
	 * metodo che restituisce in output l'ultimo suggerimento.
	 * Da utilizzare in una potenziale AI.
	 */
	void getSuggerimento();
	/**
	 * Metodo che stampa in output il codice in input.
	 * @param arrayFromCode codice da stampare.
	 */
	void vediCodice(ArrayList<Integer> arrayFromCode);

	/**
	 * Metodo che stampa in output l'estito della partita.
	 * @param esito
	 */
	void matchResault(Risultato esito);
	/**
	 * Metodo che prende in Input dall'utente una scelta usata per navigare nel menu.
	 * @return il numero della scelta del'utente.
	 */
	int sceltaMenu();
	/**
	 * Metodo che prende in Input la scelta dell'utente riguardo la configurazione della difficoltà
	 * @return l'intero che corrisponde alla scelta dell'utente.
	 */
	int difficultConfiguration();
	/**
	 * Metodo che prende in Input la scelta dell'utente riguardo la configurazione dei duplicati
	 * @return l'intero che corrisponde alla scelta dell'utente.
	 */
	boolean duplicateConfiguration();

}