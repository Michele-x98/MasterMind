package it.unicam.cs.pa.mastermind2019;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * <b>Responsabilità:</b> Gestire i Log dell'applicazione.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class LogToFile
{
	static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
	private static FileHandler fh = null;

	public LogToFile()
	{
	}

	/**
	 * Il metodo statico getLogger restituisce un logger per la classe in ingresso
	 * al metodo con un Handler specifico e con parametri preimpostati.
	 * 
	 * @param classeLog Classe che riceverà il Logger.
	 * @return	Un Logger per la classe.
	 */
	public static Logger getLogger(Class<?> classeLog)
	{
		Logger defaultLogger = Logger.getLogger(classeLog.getName());
		defaultLogger.addHandler(fh);
		defaultLogger.setUseParentHandlers(false);
		return defaultLogger;
	}
	/**
	 * Metodo statico per l'inizializzazione della gestione dei Log
	 */
	public static void init(String type)
	{

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");

		try
		{
			fh = new FileHandler("src/"+type+"/resources/Log-" +
									format.format(Calendar.getInstance().getTime()) +
									".log");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		fh.setFormatter(new SimpleFormatter());

	}
}
