package it.unicam.cs.pa.mastermind2019;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogToFile 
{
	private static final Logger logger = Logger.getLogger(LogToFile.class.getName());
    private static FileHandler fh = null;
    
    


    public LogToFile() {}
    public static void init()
    {
    	logger.setUseParentHandlers(false);
    	//just to make our log file nicer :)
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fh = new FileHandler("C:/Users/Daniele/git/MasterMind/MM/src/main/java/Log/Log-"
                + format.format(Calendar.getInstance().getTime()) + ".log");
        } catch (Exception e) {
            e.printStackTrace();
        }

        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }
    
    
    public static void messaggio(String level, String message) 
    {
    	switch(level)
    	{
    		case "WARNING":
    			{
    				logger.log(Level.WARNING,message);
    				break;
    			}
    		case "INFO":
    			{
    				logger.log(Level.INFO,message);
    			break;
    			}
    		case "CONFIG":
    			{
    				logger.log(Level.CONFIG,message);
    			break;
    			}
    		default:
    			{
    				logger.log(Level.INFO,message);
    			}
    	}
    }
}
    