package it.unicam.cs.pa.mastermind2019;

import java.io.IOException;
import java.util.ArrayList;

/**
 * <b>Responsabilità </b>: Gestire la strategia di un giocatore
 * 
 * @author TeamTrustMe
 */
public interface Player
{
	/**
	 * Restituisce l'ID del player corrente
	 * 
	 * @return L'ID del player
	 */
	public String getID();

	/**
	 * Genera un array di interi che può essere utilizzato sia come codice da
	 * indovinare, sia come tentativo
	 * 
	 * @param settings
	 * @return Un array di interi
	 * @throws IOException
	 * @throws IllegalParameterException
	 */
	public ArrayList<Integer> generateCode(GameParameters settings) throws IOException, IllegalParameterException;

}
