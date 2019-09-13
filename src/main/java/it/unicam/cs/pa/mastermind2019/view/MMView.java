package it.unicam.cs.pa.mastermind2019.view;

import java.util.ArrayList;


//import java.util.Observable;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.PlayerType;
import it.unicam.cs.pa.mastermind2019.Risultato;

public interface MMView {


	
	boolean matchAgain();

	String typePlayerSelection(boolean i);

	ArrayList<Integer> getCombination(PlayerType giocatore);

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