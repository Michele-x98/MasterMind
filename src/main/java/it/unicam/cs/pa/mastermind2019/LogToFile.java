package it.unicam.cs.pa.mastermind2019;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
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
	static SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
	private static FileHandler fh = null;
	
	public LogToFile(){}

	public static Logger getLogger(Class<?> ciao)
	{	
		Logger x = Logger.getLogger(ciao.getName());
		x.addHandler(fh);
		x.setUseParentHandlers(false);
		return x;
	}
	
	public static void init()
	{
	
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy--HH-mm-ss");
			
			try
			{
				fh = new FileHandler("src/main/resources/Log-" + format.format(Calendar.getInstance().getTime()) + ".log");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

			fh.setFormatter(new SimpleFormatter());
			
		
	}
}
