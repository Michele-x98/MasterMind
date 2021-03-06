package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;


/**
 * <b>Responsabilitą:</b> Impostare le basi per la strategia di un giocatore.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public interface Player
{
	/**
	 * Metodo che restituisce la variabile che identifica un player.
	 * 
	 * @return ID che identifica il player.
	 */
	public String getID();

	/**
	 * Metodo che genera un codice da criptare/decriptare.
	 * 
	 * @return Un arrayList di interi, ovvero il codice generato.
	 * 
	 */
	public ArrayList<Integer> generateCode();
	
	/**
	 * Metodo che verrą utilizzato dal Player con una strategia, per elaborare
	 * al meglio un codice, attraverso il suggerimento datogli.
	 * @return ultimo suggerimento ottenuto.
	 * 
	 */
	public ArrayList<Pioli> getSuggerimento();

}
