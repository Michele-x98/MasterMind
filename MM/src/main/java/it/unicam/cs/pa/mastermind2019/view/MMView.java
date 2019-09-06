package it.unicam.cs.pa.mastermind2019.view;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.Risultato;

public interface MMView
{

	// Iizialmente avevo pensato ad un metodo che restituiva un gameparameters solo
	// che dopo non rispettava la modularità, quindi ho lasciato perde e ho lasciato
	// i due metodi prendiLunghezza e prendiDuplicati
	public int prendiLunghezza();

	public boolean prendiDuplicati();

	public boolean matchAgain();

	public void attemptResault(ArrayList<Pioli> sugg);

	public ArrayList<Integer> getCombination();

	public void gameInit();
	
	public String typePlayerSelection(boolean i);

	public void getSuggerimento();
	
	public ArrayList<Integer> botGetCombination();

	public void vediCodice(ArrayList<Integer> arrayFromCode);
	
	public void matchResault(Risultato esito);

	public int sceltaMenu();

	public int difficultConfiguration();

	public boolean duplicateConfiguration();
	
}
