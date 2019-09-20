package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;

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
	 * @throws IllegalParameterException Eccezione lanciata in caso di un parametro
	 *                                   in ingresso non valido.
	 */
	public ArrayList<Integer> generateCode();
	
	/**
	 * Metodo che verrą utilizzato dal Player con una strategia, per elaborare
	 * al meglio un codice, attraverso il suggerimento datogli.
	 * @return {@link ArrayList<Pioli>} ultimo suggerimento ottenuto.
	 * 
	 */
	public ArrayList<Pioli> getSuggerimento();

}
