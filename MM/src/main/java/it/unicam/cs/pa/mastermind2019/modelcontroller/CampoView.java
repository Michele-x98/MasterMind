package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.Pioli;

public interface CampoView
{

	ArrayList<Pioli> getLastSuggerimento();

	void addSuggerimento(ArrayList<Pioli> sugg);

	/**
	 * Getter della variabile <code>decodeArray</code>.
	 * 
	 * @return Array da decodificare.
	 */
	ArrayList<Integer> getArrayFromDeco();

	/**
	 * Getter della variabile <code>codeArray</code>.
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