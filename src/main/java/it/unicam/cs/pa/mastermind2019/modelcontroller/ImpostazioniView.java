package it.unicam.cs.pa.mastermind2019.modelcontroller;

public interface ImpostazioniView
{

	
	public boolean isValidNumber(int num);

	public int getCodeLenght();

	public int getAttempts();

	public int getMinCodValue();

	public int getMaxCodValue();

	public boolean isDuplicateAllow();
	
	void setCodeLenght(int code);
	
	void setDuplicate(boolean duplicate);

}