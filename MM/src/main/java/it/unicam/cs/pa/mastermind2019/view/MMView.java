package it.unicam.cs.pa.mastermind2019.view;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.Player;

public interface MMView
{

	// Iizialmente avevo pensato ad un metodo che restituiva un gameparameters solo
	// che dopo non rispettava la modularità, quindi ho lasciato perde e ho lasciato
	// i due metodi prendiLunghezza e prendiDuplicati
	public int prendiLunghezza();

	public boolean prendiDuplicati();

	public boolean matchAgain();

	public Player getPlayerType();

	public void attemptResault(ArrayList<Pioli> sugg);

	public ArrayList<Integer> getAttempt();

	public void gameInit();
	
	public String typePlayerSelection(boolean i);

}
