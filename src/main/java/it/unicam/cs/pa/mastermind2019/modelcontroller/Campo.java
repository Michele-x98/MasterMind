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
	/**
	 * Logger della classe Campo.
	 */
	private static final Logger logger = LogToFile.getLogger(Campo.class);
	/**
	 * Array da decodificare.
	 */
	private ArrayList<Integer> decodeArray;
	/**
	 * Array tentativo.
	 */
	private ArrayList<Integer> codeArray;
	/**
	 * Pila (LIFO) contenente i suggerimenti già utilizzati.
	 */
	private Stack<ArrayList<Pioli>> suggerimenti;
	/**
	 * Lunghezza del codice.
	 */
	public int lunghezza;

	/**
	 * Costruttore del Campo
	 * 
	 * @param settings Impostazioni della partita corrente.
	 */
	public Campo(ImpostazioniView settings )
	{
		this.lunghezza = settings.getCodeLenght();
		this.decodeArray = new ArrayList<Integer>();
		this.codeArray = new ArrayList<Integer>();
		this.suggerimenti = new Stack<ArrayList<Pioli>>();
		logger.log(Level.INFO, "Campo creato correttamente");
	}

	@Override
	public void addSuggerimento(ArrayList<Pioli> sugg)
	{
		logger.log(Level.INFO, "Aggiunto il suggerimento " +
								sugg +
								" ai suggerimenti");
		suggerimenti.add(sugg);
	}

//	 ****************** GETTERS ******************

	@Override
	public ArrayList<Pioli> getLastSuggerimento()
	{
		ArrayList<Pioli> lastSugg = suggerimenti.peek();
		logger.log(Level.INFO, "Restituito il suggerimento: " +
								lastSugg.toString());
		return lastSugg;
	}

	@Override
	public ArrayList<Integer> getArrayFromDeco()
	{
		logger.log(Level.INFO, "Restituito array" +
								this.decodeArray +
								" da decodificare");
		return this.decodeArray;
	}

	@Override
	public ArrayList<Integer> getArrayFromCode()
	{
		logger.log(Level.INFO, "Restituito l'array " +
								this.codeArray +
								" da codificare");
		return this.codeArray;
	}

//	 ****************** SETTERS ******************

	@Override
	public void setDecodeArray(ArrayList<Integer> arrayList)
	{
		logger.log(Level.INFO, "Impostando " +
								arrayList +
								" come tentativo");
		this.decodeArray = arrayList;
	}

	@Override
	public void setCodeArray(ArrayList<Integer> codeArray)
	{
		logger.log(Level.INFO, "Impostando " +
								codeArray +
								" come array da codificare");
		this.codeArray = codeArray;
	}

}
