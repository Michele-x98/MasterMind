package it.unicam.cs.pa.mastermind2019;

import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;

/**
 * <b>Responsabilità:</b> Impostare le basi per la strategia di un giocatore.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public interface Player
{

	public String getID();


	public ArrayList<Integer> generateCode() throws IllegalParameterException;

}
