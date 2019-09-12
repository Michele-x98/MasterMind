package it.unicam.cs.pa.mastermind2019;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
//import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * <b>Responsabilità:</b> Gestire i Log dell'applicazione.
 * 
 * Da rifà quasi tutto
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 *
 */
public class LogToFile
{
	private static final Logger logger = Logger.getLogger(LogToFile.class.getName());
	static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
	private static FileHandler fh =  new FileHandler("C:/Log/Log-" + format.format(Calendar.getInstance().getTime()) + ".log");
	fh.setFormatter(new SimpleFormatter()); 
	x.setUseParentHandlers(false);
	logger.addHandler(fh);
	/**
	 * Costruttore vuoto.
	 */
	public LogToFile()
	{
	}

	public static Logger getLogger(Class<?> ciao)
	{	
		return null;
	}
	
	

	/**
	 * Metodo iniziale che controlla che la presenza della cartella dove creare il
	 * file di Log, e poi imposta il nome del file di log utilizzando la data e
	 * l'ora. Infine assegna al logger il fileHandler che deve utilizzare.
	 */
	public static void init()
	{
		// TODO Modificare path
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
			System.err.println("CARTELLA NON ESISTENTE.LOG STAMPATO A CONSOLE.");
	}
}
