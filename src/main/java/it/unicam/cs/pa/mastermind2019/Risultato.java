package it.unicam.cs.pa.mastermind2019;

/**
 * <b>ResponsabilitÓ:</b> Base da implementare per Vincitore e Perdente.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public interface Risultato
{
	/**
	 * Metodo che restituisce l'ID del vincitore o perdente.
	 * @return LID del vincitore/perdente
	 */
	public String getID();
}