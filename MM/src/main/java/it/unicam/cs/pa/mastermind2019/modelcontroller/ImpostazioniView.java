package it.unicam.cs.pa.mastermind2019.modelcontroller;

public interface ImpostazioniView
{

	/**
	 * Controlla che il numero in input sia compreso nel range di numeri accettabili
	 * nel contesto del gioco.
	 * 
	 * @param num Numero intero da controllare.
	 * @return <b>True</b> Se il valore è accettabile.
	 *         <b>False</b> Se il valore non è accettabile.
	 */
	public boolean isValidNumber(int num);

	/**
	 * Metodo che restituisce la lunghezze del codice da decodificare.
	 * Metodo di lettura utilizzabile dalla vista.
	 * 
	 * @return lunghezza codice.
	 */
	public int getCodeLenght();

	/**
	 * Metodo che restituisce i tentativi settati.
	 * 
	 * @return tentativi impostati.
	 */
	public int getAttempts();

	public int getMinCodValue();

	public int getMaxCodValue();

	public boolean isDuplicateAllow();
	
	void setCodeLenght(int code);
	
	void setDuplicate(boolean duplicate);

}