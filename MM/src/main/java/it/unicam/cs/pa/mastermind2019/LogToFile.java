package it.unicam.cs.pa.mastermind2019;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
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
	private static final Logger logger = Logger.getLogger(LogToFile.class.getName());
	private static FileHandler fh = null;

	/**
	 * Costruttore vuoto.
	 */
	public LogToFile()
	{
	}

	/**
	 * Metodo iniziale che controlla che la presenza della cartella dove creare il
	 * file di Log, e poi imposta il nome del file di log utilizzando la data e
	 * l'ora. Infine assegna al logger il fileHandler che deve utilizzare.
	 */
	public static void init()
	{
		Path path = Path.of("C:/Log");
		if (Files.exists(path))
		{
			logger.setUseParentHandlers(false);
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
			try
			{
				fh = new FileHandler("C:/Log/Log-" +
										format.format(Calendar.getInstance().getTime()) +
										".log");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			fh.setFormatter(new SimpleFormatter());
			logger.addHandler(fh);
		}
		else
			System.out.println("CARTELLA NON ESISTENTE.LOG STAMPATO A CONSOLE.");
	}

	/**
	 * Stampa un messaggio di Log con livelo di importanza <code>level</code> e
	 * messaggio <code>message</code>.
	 * 
	 * @param level   Stringa che caratterizza il livello di importanza del
	 *                messaggio.
	 * @param message Contenuto del messaggio.
	 */
	public static void messaggio(	String level,
									String message)
	{
		switch (level)
		{
			case "WARNING":
			{
				logger.log(Level.WARNING, message);
				break;
			}
			case "INFO":
			{
				logger.log(Level.INFO, message);
				break;
			}
			case "CONFIG":
			{
				logger.log(Level.CONFIG, message);
				break;
			}
			default:
			{
				logger.log(Level.INFO, message);
			}
		}
	}
}
