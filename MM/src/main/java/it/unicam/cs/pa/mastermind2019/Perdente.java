package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità </b>: Creare un Risultato in caso di sconfitta
 * 
 * @author Daniele
 *
 */
public class Perdente implements Risultato
{
	private final String loserId;

	public Perdente(String ID )
	{
		this.loserId = ID;
	}

	@Override
	public String toString()
	{
		LogToFile.messaggio("INFO","Stampa del giocatore perdente");
		return "Il giocatore " +
				loserId +
				" ha perso!";
	}

	@Override
	public String getID()
	{ return loserId; }
}
