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

public class ImpostazioniFileConfig implements ImpostazioniView
{

	private Properties prop = new Properties();
	private static final Logger logger = LogToFile.getLogger(ImpostazioniFileConfig.class);

	public ImpostazioniFileConfig() throws FileNotFoundException, IOException
	{
		try (InputStream input = new FileInputStream("src/main/resources/config.properties"))
		{
			prop.load(input);
		}
		catch (FileNotFoundException e)
		{
			createDefaultProperty();
		}
	}

	private void createDefaultProperty()
	{
		logger.log(Level.INFO, "Creazione impostazioni di default");
		try (OutputStream output = new FileOutputStream("src/main/resources/config.properties"))
		{

			prop.setProperty("duplicateAllow", "true");
			prop.setProperty("codeLenght", "4");
			prop.setProperty("attempts", "9");
			prop.setProperty("minCodValue", "1");
			prop.setProperty("maxCodValue", "6");
			prop.store(output, null);
			logger.log(Level.INFO, "Impostazioni di default create correttamente");
		}
		catch (IOException io)
		{
			logger.log(Level.WARNING, "Creazione impostazioni di default non riuscita");
			io.printStackTrace();
		}

	}

	@Override
	public boolean isValidNumber(int num)
	{
		boolean x = num >= Integer.parseInt(prop.getProperty("minCodValue")) && num <= Integer.parseInt(prop.getProperty("maxCodValue"));
		logger.log(Level.INFO, "Effetuato controllo validità sul numero con risultato: " +
								x);
		return x;
	}

	@Override
	public int getCodeLenght()
	{
		logger.log(Level.INFO, "Restituita la lunghezza del codice: " +
								Integer.parseInt(prop.getProperty("codeLenght")));
		return Integer.parseInt(prop.getProperty("codeLenght"));
	}

	@Override
	public int getAttempts()
	{
		logger.log(Level.INFO, "Restituiti il numero dei tentativi: " +
								Integer.parseInt(prop.getProperty("attempts")));
		return Integer.parseInt(prop.getProperty("attempts"));
	}

	@Override
	public int getMinCodValue()
	{
		logger.log(Level.INFO, "Restituita la lunghezza minima del codice: " +
								Integer.parseInt(prop.getProperty("minCodValue")));
		return Integer.parseInt(prop.getProperty("minCodValue"));
	}

	@Override
	public int getMaxCodValue()
	{
		logger.log(Level.INFO, "Restituita la lunghezza massima del codice: " +
								Integer.parseInt(prop.getProperty("maxCodValue")));
		return Integer.parseInt(prop.getProperty("maxCodValue"));
	}

	@Override
	public boolean isDuplicateAllow()
	{
		logger.log(Level.INFO, "Restituito il permesso di avere duplicati nel codice: " +
								Boolean.valueOf(prop.getProperty("duplicateAllow")));
		return Boolean.valueOf(prop.getProperty("duplicateAllow"));
	}

	@Override
	public void setCodeLenght(int code)
	{
		logger.log(Level.CONFIG, "Modificando la lunghezza del codice a: " +
									code);
		try (OutputStream output = new FileOutputStream("src/main/resources/config.properties"))
		{
			if (code == 4)
			{
				prop.setProperty("codeLenght", Integer.toString(code));
				prop.setProperty("attempts", "9");
				prop.setProperty("maxCodValue", "6");
			}
			else if (code == 6)
			{
				prop.setProperty("codeLenght", Integer.toString(code));
				prop.setProperty("attempts", "15");
				prop.setProperty("maxCodValue", "8");
			}
			else if (code == 8)
			{
				prop.setProperty("codeLenght", Integer.toString(code));
				prop.setProperty("attempts", "21");
				prop.setProperty("maxCodValue", "10");
			}
			prop.store(output, null);
			logger.log(Level.CONFIG, "Lunghezza del codice modificata correttamente a: " +
										code);
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
			prop.setProperty("duplicateAllow", Boolean.toString(duplicate));
			prop.store(output, null);
			logger.log(Level.CONFIG, "Permesso per i duplicati modificato correttamente");
		}
		catch (IOException io)
		{
			logger.log(Level.WARNING, "Impossibile modificare il permesso per i duplicati");
			io.printStackTrace();
		}

	}
}
