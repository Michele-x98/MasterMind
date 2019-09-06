package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.ArrayList;
import java.util.Stack;

import it.unicam.cs.pa.mastermind2019.Pioli;


/**
 * <b>Responsabilità:</b> Gestire il campo di gioco.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Campo implements CampoView
{
	private ArrayList<Integer> decodeArray;
	private ArrayList<Integer> codeArray;
	private Stack<ArrayList<Pioli>> suggerimenti;
	public int lunghezza;

	/**
	 * Costruttore con un oggetto di tipo GameParameters in ingresso.
	 * 
	 * @param settings	Impostazioni della partita.
	 */
	public Campo(ParametersView settings )
	{
		this.lunghezza = settings.getCodeLenght();
		this.decodeArray = new ArrayList<Integer>();
		this.codeArray = new ArrayList<Integer>();
		this.suggerimenti = new Stack<ArrayList<Pioli>>();
	}


//	 ****************** GETTERS ******************
	
	@Override
	public ArrayList<Pioli> getLastSuggerimento()
	{ return suggerimenti.peek(); }
	
	@Override
	public void addSuggerimento(ArrayList<Pioli> sugg)
	{
		suggerimenti.add(sugg);
	}

	/**
	 * Getter della variabile <code>decodeArray</code>.
	 * 
	 * @return Array da decodificare.
	 */
	@Override
	public ArrayList<Integer> getArrayFromDeco()
	{
//		LogToFile.messaggio("INFO","Codice inserito nel campo");
		return this.decodeArray; }

	
	/**
	 * Getter della variabile <code>codeArray</code>.
	 * @return Array tentativo.
	 */
	@Override
	public ArrayList<Integer> getArrayFromCode()
	{ return this.codeArray; }

//	 ****************** SETTERS ******************
	
	
	/**
	 * Setter per la variabile <code>decodeArray</code>.
	 * 
	 * @param arrayList Nuovo <code>decodeArray</code>.
	 */
	@Override
	public void setDecodeArray(ArrayList<Integer> arrayList)
	{ this.decodeArray = arrayList;
	//DEBUG
	System.out.println("DEBUG: "+arrayList);
	}

	
	/**
	 * Setter per la variabile <code>codeArray</code>.
	 * 
	 * @param codeArray Nuovo <code>codeArray</code>.
	 */
	@Override
	public void setCodeArray(ArrayList<Integer> codeArray)
	{ this.codeArray = codeArray; }

}
