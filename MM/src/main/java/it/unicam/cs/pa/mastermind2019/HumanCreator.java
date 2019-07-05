package it.unicam.cs.pa.mastermind2019;

/**
 * <b>Responsabilità:</b> Interfaccia che crea un Player di tipo Human
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
@FunctionalInterface
public interface HumanCreator {

	/**
	 * @param name Nome del Player di tipo Human
	 * @return Player di tipo Human
	 */
	public Human createHuman(String name);
}
