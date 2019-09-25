package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.Risultato;

/**
 * <b>Responsabilità:</b> Impostare una base con cui gestire la partita (Arbitro).
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public interface ArbitroView
{

	/**
	 * Con metodo play() le varie fasi della partita vengono svolte.
	 * 
	 * @return Il vincitore o il perdente della partita.
	 * 
	 */
	Risultato play();

	/**
	 * Metodo che si occupa del confronto tra un tentativo e il codice da
	 * decriptare.
	 * 
	 * @param tentativo ArrayList contenente il codice.
	 * @return Un ArrayList di Pioli contenente un suggerimento per l'utente.
	 */
	ArrayList<Pioli> check(ArrayList<Integer> tentativo);
	/**
	 * Metodo interno che attravero un tentativo e un campo in input esegue un
	 * controllo e restituisce se il tentativo è vincente.
	 * 
	 * @param tentativo ArrayList di Pioli restituito dal check.
	 * @param campo2	Campo di gioco attuale.
	 * @return true se il tentativo è vincente, false altrimenti.
	 */
	public boolean isWinner(ArrayList<Pioli> tentativo,
							CampoView campo2);

}