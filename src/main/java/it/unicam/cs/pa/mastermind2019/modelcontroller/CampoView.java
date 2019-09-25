package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.Pioli;

/**
 * <b>Responsabilità:</b> Impostare una base con cui gestire il campo da gioco.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public interface CampoView
{
	/**
	 * Metodo che restituisce l'ultimo suggerimento creato.
	 * 
	 * @return {@link ArrayList} di Pioli contenente il suggerimento.
	 */
	ArrayList<Pioli> getLastSuggerimento();

	/**
	 * Aggiunge l'ultimo suggetimento alla lista di seggerimenti.
	 *
	 * @param sugg Ultimo suggerimento creato.
	 */
	void addSuggerimento(ArrayList<Pioli> sugg);

	/**
	 * Getter della variabile <code>decodeArray</code>.
	 * 
	 * @return Array da decodificare.
	 */
	ArrayList<Integer> getArrayFromDeco();

	/**
	 * Getter della variabile <code>codeArray</code>.
	 * 
	 * @return Array tentativo.
	 */
	ArrayList<Integer> getArrayFromCode();

	/**
	 * Setter per la variabile <code>decodeArray</code>.
	 * 
	 * @param arrayList Nuovo <code>decodeArray</code>.
	 */
	void setDecodeArray(ArrayList<Integer> arrayList);

	/**
	 * Setter per la variabile <code>codeArray</code>.
	 * 
	 * @param codeArray Nuovo <code>codeArray</code>.
	 */
	void setCodeArray(ArrayList<Integer> codeArray);

}