package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unicam.cs.pa.mastermind2019.LogToFile;

/**
 * <b>Responsabilità:</b> Gestire i parametri di gioco attraverso un file
 * properties.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */
public class ImpostazioniFileConfig implements ImpostazioniView
{
	/**
	 * Oggetto properties che contiene le impostazioni del gioco.
	 */
	private Properties currentProperties = new Properties();
	/**
	 * Logger della classe ImpostazioniFileConfig
	 */
	private static final Logger logger = LogToFile.getLogger(ImpostazioniFileConfig.class);

	/**
	 * Costruttore di {@link ImpostazioniFileConfig}
	 * 
	 * @throws FileNotFoundException File non presente nella directory.
	 * @throws IOException           Il file caricato non rispetta i parametri.
	 */
	public ImpostazioniFileConfig() throws FileNotFoundException, IOException
	{
		try (InputStream input = new FileInputStream("src/main/resources/config.properties"))
		{
			currentProperties.load(input);
		}
		catch (FileNotFoundException e)
		{
			createDefaultProperty();
		}
	}

	/**
	 * Metodo che crea un file di impostazioni nel caso in cui non ce ne fosse uno
	 * presente.
	 */
	private void createDefaultProperty()
	{
		logger.log(Level.INFO, "Creazione impostazioni di default");
		try (OutputStream output = new FileOutputStream("src/main/resources/config.properties"))
		{

			currentProperties.setProperty("duplicateAllow", "true");
			currentProperties.setProperty("codeLenght", "4");
			currentProperties.setProperty("attempts", "9");
			currentProperties.setProperty("minCodValue", "1");
			currentProperties.setProperty("maxCodValue", "6");
			currentProperties.store(output, null);
			logger.log(Level.INFO, "Impostazioni di default create correttamente");
		}
		catch (IOException io)
		{
			logger.log(Level.WARNING, "Creazione impostazioni di default non riuscita");
			io.printStackTrace();
		}

	}

	@Override
	public boolean isValidNumber(int number)
	{
		boolean x = number >= Integer.parseInt(currentProperties.getProperty("minCodValue")) && number <= Integer.parseInt(currentProperties.getProperty("maxCodValue"));
		logger.log(Level.INFO, "Effetuato controllo validità sul numero con risultato: " +
								x);
		return x;
	}

	@Override
	public int getCodeLenght()
	{
		logger.log(Level.INFO, "Restituita la lunghezza del codice: " +
								Integer.parseInt(currentProperties.getProperty("codeLenght")));
		return Integer.parseInt(currentProperties.getProperty("codeLenght"));
	}

	@Override
	public int getAttempts()
	{
		logger.log(Level.INFO, "Restituiti il numero dei tentativi: " +
								Integer.parseInt(currentProperties.getProperty("attempts")));
		return Integer.parseInt(currentProperties.getProperty("attempts"));
	}

	@Override
	public int getMinCodValue()
	{
		logger.log(Level.INFO, "Restituita la lunghezza minima del codice: " +
								Integer.parseInt(currentProperties.getProperty("minCodValue")));
		return Integer.parseInt(currentProperties.getProperty("minCodValue"));
	}

	@Override
	public int getMaxCodValue()
	{
		logger.log(Level.INFO, "Restituita la lunghezza massima del codice: " +
								Integer.parseInt(currentProperties.getProperty("maxCodValue")));
		return Integer.parseInt(currentProperties.getProperty("maxCodValue"));
	}

	@Override
	public boolean isDuplicateAllow()
	{
		logger.log(Level.INFO, "Restituito il permesso di avere duplicati nel codice: " +
								Boolean.valueOf(currentProperties.getProperty("duplicateAllow")));
		return Boolean.valueOf(currentProperties.getProperty("duplicateAllow"));
	}

	@Override
	public void setCodeLenght(int newCodeLenght)
	{
		logger.log(Level.CONFIG, "Modificando la lunghezza del codice a: " +
									newCodeLenght);
		try (OutputStream output = new FileOutputStream("src/main/resources/config.properties"))
		{
			if (newCodeLenght == 4)
			{
				currentProperties.setProperty("codeLenght", Integer.toString(newCodeLenght));
				currentProperties.setProperty("attempts", "9");
				currentProperties.setProperty("maxCodValue", "6");
			}
			else if (newCodeLenght == 6)
			{
				currentProperties.setProperty("codeLenght", Integer.toString(newCodeLenght));
				currentProperties.setProperty("attempts", "15");
				currentProperties.setProperty("maxCodValue", "8");
			}
			else if (newCodeLenght == 8)
			{
				currentProperties.setProperty("codeLenght", Integer.toString(newCodeLenght));
				currentProperties.setProperty("attempts", "21");
				currentProperties.setProperty("maxCodValue", "10");
			}
			currentProperties.store(output, null);
			logger.log(Level.CONFIG, "Lunghezza del codice modificata correttamente a: " +
										newCodeLenght);
		}
		catch (IOException io)
		{
			logger.log(Level.WARNING, "Impossibile modificare la lunghezza del codice");
			io.printStackTrace();
		}
	}

	@Override
	public void setDuplicate(boolean duplicate)
	{
		logger.log(Level.CONFIG, "Modificando il permesso per i duplicati a: " +
									duplicate);
		try (OutputStream output = new FileOutputStream("src/main/resources/config.properties"))
		{
			currentProperties.setProperty("duplicateAllow", Boolean.toString(duplicate));
			currentProperties.store(output, null);
			logger.log(Level.CONFIG, "Permesso per i duplicati modificato correttamente");
		}
		catch (IOException io)
		{
			logger.log(Level.WARNING, "Impossibile modificare il permesso per i duplicati");
			io.printStackTrace();
		}

	}
}
