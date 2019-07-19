package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità:</b> Creare un Risultato in caso di sconfitta.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class Perdente implements Risultato
{
	private final String loserId;
/**
 * Costruttore di Perdente.
 * @param ID del perdente.
 */
	public Perdente(String ID )
	{
		this.loserId = ID;
	}
/**
 * Override del metodo toString di Player.
 */
	@Override
	public String toString()
	{
//		LogToFile.messaggio("INFO","Stampa del giocatore perdente");
		return "Il giocatore " +
				loserId +
				" ha perso!";
	}
/**
 * Override del metodo getID di Player.
 */
	@Override
	public String getID()
	{ return loserId; }
}
