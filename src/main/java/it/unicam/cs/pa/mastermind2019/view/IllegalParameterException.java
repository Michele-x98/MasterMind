package it.unicam.cs.pa.mastermind2019.view;

/**
 * Eccezione lanciata in caso vengano passati parametri sbagliati al
 * {@link it.unicam.cs.pa.mastermind2019.Player#generateCode()}.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class IllegalParameterException extends Exception
{
	/**
	 * Costruttore senza parametri in ingresso.
	 */
	public IllegalParameterException()
	{
		super("Parametro non corretto");
	}

	/**
	 * Costruttore con una stringa in ingresso
	 * 
	 * @param c Tipo di parametro non corretto.
	 */
	public IllegalParameterException(String c )
	{
		super("Parametro non corretto: " +
				c);
	}

	@Override
	public String toString()
	{
		return getMessage();
	}

	private static final long serialVersionUID = 1L;
}
