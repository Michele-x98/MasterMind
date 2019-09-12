package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unicam.cs.pa.mastermind2019.LogToFile;
import it.unicam.cs.pa.mastermind2019.Pioli;


/**
 * <b>Responsabilità:</b> Gestire il campo di gioco.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Campo implements CampoView
{
	private static final Logger logger = LogToFile.getLogger(Campo.class);
	private ArrayList<Integer> decodeArray;
	private ArrayList<Integer> codeArray;
	private Stack<ArrayList<Pioli>> suggerimenti;
	public int lunghezza;

	/**
	 * Costruttore con un oggetto di tipo GameParameters in ingresso.
	 * 
	 * @param settings	Impostazioni della partita.
	 */
	public Campo(ImpostazioniView settings )
	{
		this.lunghezza = settings.getCodeLenght();
		this.decodeArray = new ArrayList<Integer>();
		this.codeArray = new ArrayList<Integer>();
		this.suggerimenti = new Stack<ArrayList<Pioli>>();
	}


//	 ****************** GETTERS ******************
	
	@Override
	public ArrayList<Pioli> getLastSuggerimento()
	{ 
		ArrayList<Pioli> lastSugg = suggerimenti.peek();
		logger.log(Level.INFO, "Restituito il suggerimento: " + lastSugg.toString());
		return lastSugg; 
	}
	
	@Override
	public void addSuggerimento(ArrayList<Pioli> sugg)
	{
		logger.log(Level.INFO, "Aggiunto il suggerimento " + sugg + " ai suggerimenti");
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
		logger.log(Level.INFO, "Restituito array"+ this.decodeArray + " da decodificare");
		return this.decodeArray; }

	
	/**
	 * Getter della variabile <code>codeArray</code>.
	 * @return Array tentativo.
	 */
	@Override
	public ArrayList<Integer> getArrayFromCode()
	{ 
		logger.log(Level.INFO, "Restituito l'array " + this.codeArray + " da codificare");
		return this.codeArray; 
	}

//	 ****************** SETTERS ******************
	
	
	/**
	 * Setter per la variabile <code>decodeArray</code>.
	 * 
	 * @param arrayList Nuovo <code>decodeArray</code>.
	 */
	@Override
	public void setDecodeArray(ArrayList<Integer> arrayList)
	{ 
		logger.log(Level.INFO, "Impostando " + arrayList + " come tentativo");
		this.decodeArray = arrayList;
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
	{ 
		logger.log(Level.INFO, "Impostando " + codeArray + " come array da codificare");
		this.codeArray = codeArray; }

}
