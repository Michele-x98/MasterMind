package it.unicam.cs.pa.mastermind2019;
import java.util.ArrayList;

/**
 * <b>Responsabilità </b>: Creare un human
 * @author TeamTrustMe
 * @param ID Stringa che identifica un Player Human
 *
 */

public class Human implements Player
	{

		public String ID;
		
		/**
		 *  Metodo costruttore di default di Human
		 */
		public Human(){this.ID = "DefaultID";}
	
		
		/**
		 * Costruttore Human con una stringa in ingresso, assegna alla variabile
		 * <code>ID </code> il valore della stringa in ingresso.
		 * 
		 * @param id Identificatore dell'oggetto.
		 */
		public Human(String id){this.ID = id;}

		@Override
		public String getID()
			{
				return ID;
			}

		/**
		 * Metodo per prendere da tastiera il codice del giocatore
		 * 
		 * @param
		 * @return array riempito dal giocatore
		 * @throws IOException 
		 * @throws IllegalParameterException 
		 */

		public ArrayList<Integer> generateCode(GameParameters settings) throws IllegalParameterException
			{
				int c;
				ArrayList<Integer> code = new ArrayList<Integer>();
				while(!(code.size() == settings.codeLenght)){
				c = InputOutput.getC(settings.maxCodValue);
				if(!settings.isValidNumber(c))
					throw new IllegalParameterException();
				else
					if(!(settings.duplicateAllow) && code.contains(c))
						throw new IllegalParameterException();
					code.add(c);
					InputOutput.printNumber(c);
				}
				return code;
			}
		
	}
