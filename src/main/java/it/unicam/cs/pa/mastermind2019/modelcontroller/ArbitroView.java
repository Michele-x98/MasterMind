package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.Risultato;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;

public interface ArbitroView {

	/**
	 * Con metodo play() le varie fasi della partita vengono svolte.
	 * 
	 * @return Il vincitore o il perdente della partita.
	 * 
	 */
	Risultato play();

	/**
	 * Metodo che si occupa del confronto tra un tentativo e il codice da decriptare.
	 * 
	 * @param tentativo ArrayList contenente il codice.
	 * @return Un ArrayList di Pioli contenente un suggerimento per l'utente.
	 */
	ArrayList<Pioli> check(ArrayList<Integer> tentativo);

}