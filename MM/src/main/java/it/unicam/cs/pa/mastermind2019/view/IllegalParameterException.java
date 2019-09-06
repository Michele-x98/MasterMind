package it.unicam.cs.pa.mastermind2019.view;

/**
 *	Eccezione lanciata in caso vengano passati parametri sbagliati al {@code}generateCode()
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class IllegalParameterException extends Exception
{
	public IllegalParameterException() {
		super("Parametro non corretto");
	}
	public IllegalParameterException(String c)
	{
		super("Parametro non corretto: " + c);
	}

	@Override
	public String toString()
	{
		return getMessage();
	}

	private static final long serialVersionUID = 1L;
}
