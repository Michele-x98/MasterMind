package it.unicam.cs.pa.mastermind2019.model;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.LogToFile;

/**
 * <b>Responsabilità:</b> Gestire il campo di gioco.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Campo
{
	private ArrayList<Integer> decodeArray;
	private ArrayList<Integer> codeArray;
	int lunghezza;

	/**
	 * Costruttore con un oggetto di tipo GameParameters in ingresso.
	 * 
	 * @param settings	Impostazioni della partita.
	 */
	public Campo(GameParameters settings )
	{
		this.lunghezza = settings.codeLenght;
		this.decodeArray = new ArrayList<Integer>();
		this.codeArray = new ArrayList<Integer>();
	}


//	 ****************** GETTERS ******************
	
	/**
	 * Getter della variabile <code>decodeArray</code>.
	 * 
	 * @return Array da decodificare.
	 */
	public ArrayList<Integer> getArrayFromDeco()
	{
//		LogToFile.messaggio("INFO","Codice inserito nel campo");
		return this.decodeArray; }

	
	/**
	 * Getter della variabile <code>codeArray</code>.
	 * @return Array tentativo.
	 */
	public ArrayList<Integer> getArrayFromCode()
	{ return this.codeArray; }

//	 ****************** SETTERS ******************
	
	
	/**
	 * Setter per la variabile <code>decodeArray</code>.
	 * 
	 * @param arrayList Nuovo <code>decodeArray</code>.
	 */
	public void setDecodeArray(ArrayList<Integer> arrayList)
	{ this.decodeArray = arrayList; }

	
	/**
	 * Setter per la variabile <code>codeArray</code>.
	 * 
	 * @param codeArray Nuovo <code>codeArray</code>.
	 */
	public void setCodeArray(ArrayList<Integer> codeArray)
	{ this.codeArray = codeArray; }

}
