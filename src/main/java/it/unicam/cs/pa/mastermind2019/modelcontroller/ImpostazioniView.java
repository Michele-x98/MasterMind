package it.unicam.cs.pa.mastermind2019.modelcontroller;

public interface ImpostazioniView
{

	/**
	 * Metodo che esegue un controllo su di un parametro in ingresso.
	 * 
	 * @param num Numero su cui eseguire il controllo.
	 * @return True se il numero è valido, false altrimenti.
	 */
	public boolean isValidNumber(int num);

	/**
	 * Getter della lunghezza del codice.
	 * 
	 * @return La lunghezza del codice.
	 */
	public int getCodeLenght();

	/**
	 * Getter del numero di tentativi consentiti.
	 * 
	 * @return Il numero di tentativi consentiti.
	 */
	public int getAttempts();

	/**
	 * Getter del numero minimo di valori del codice.
	 * 
	 * @return Il numero minimo di valori nel codice.
	 */
	public int getMinCodValue();

	/**
	 * Getter del numero massimo di valori del codice.
	 * 
	 * @return Il numero massimo di valori nel codice.
	 */
	public int getMaxCodValue();

	/**
	 * Metodo che comunica se i duplicati sono consentiti nel codice
	 * 
	 * @return true se i duplicati sono consentiti, false altrimenti.
	 */
	public boolean isDuplicateAllow();

	/**
	 * Setter della lunghezza del codice.
	 * 
	 * @param newCode La nuova lunghezza del codice.
	 */
	void setCodeLenght(int newCode);
	/**
	 * Setter della presenza dei duplicati nel codice.
	 * @param duplicate True per avere duplicati presenti nel codice, false altrimenti.
	 */
	void setDuplicate(boolean duplicate);

}