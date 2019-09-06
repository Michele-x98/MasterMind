package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ImpostazioniFileConfig implements ImpostazioniView
{

	private Properties prop = new Properties();

	public ImpostazioniFileConfig() throws FileNotFoundException, IOException
	{
		try (InputStream input = new FileInputStream("config.properties"))
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
		try (OutputStream output = new FileOutputStream("config.properties"))
		{
			prop.setProperty("duplicateAllow", "true");
			prop.setProperty("codeLenght", "4");
			prop.setProperty("attempts", "9");
			prop.setProperty("minCodValue", "1");
			prop.setProperty("maxCodValue", "6");
			prop.store(output, null);
		}
		catch (IOException io)
		{
			io.printStackTrace();
		}

	}

	@Override
	public boolean isValidNumber(int num)
	{
		return num >= Integer.parseInt(prop.getProperty("minCodValue")) && num <= Integer.parseInt(prop.getProperty("maxCodValue"));
	}

	@Override
	public int getCodeLenght()
	{ return Integer.parseInt(prop.getProperty("codeLenght")); }

	@Override
	public int getAttempts()
	{ return Integer.parseInt(prop.getProperty("attempts")); }

	@Override
	public int getMinCodValue()
	{ return Integer.parseInt(prop.getProperty("minCodValue")); }

	@Override
	public int getMaxCodValue()
	{ return Integer.parseInt(prop.getProperty("maxCodValue")); }

	@Override
	public boolean isDuplicateAllow()
	{ return Boolean.valueOf(prop.getProperty("duplicateAllow")); }

	@Override
	public void setCodeLenght(int code)
	{
		try (OutputStream output = new FileOutputStream("config.properties"))
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
		}
		catch (IOException io)
		{
			io.printStackTrace();
		}
	}

	@Override
	public void setDuplicate(boolean duplicate)
	{
		try (OutputStream output = new FileOutputStream("config.properties"))
		{
			prop.setProperty("duplicateAllow", Boolean.toString(duplicate));
			prop.store(output, null);
		}
		catch (IOException io)
		{
			io.printStackTrace();
		}

	}
}
