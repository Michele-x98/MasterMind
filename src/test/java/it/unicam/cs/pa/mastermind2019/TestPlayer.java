package it.unicam.cs.pa.mastermind2019;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import it.unicam.cs.pa.mastermind2019.modelcontroller.Arbitro;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ArbitroView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.Campo;
import it.unicam.cs.pa.mastermind2019.modelcontroller.CampoView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniClasse;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;
import it.unicam.cs.pa.mastermind2019.view.MMView;

public class TestPlayer
{

	static ImpostazioniView impostazioni;
	static CampoView terrenoTest;
	static MMView vista;
	static Player botTest1;
	static Player botTest2;
	static ArbitroView arbitro;

	@BeforeClass
	public static void newMatch()
	{
		LogToFile.init("test");
		impostazioni = new ImpostazioniClasse(6, false);
		terrenoTest = new Campo(impostazioni);
		vista = new InputOutput(impostazioni, terrenoTest);
		botTest1 = new Bot(vista, "Bot");
		botTest2 = new Bot(vista, "Bot");
		arbitro = new Arbitro(impostazioni, terrenoTest, vista, botTest1, botTest2);
	}
	

	@Test
	public void testBotGenerateCode()
	{
		
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(5);
		app.add(4);
		app.add(3);
		app.add(7);
		assertTrue(app.size() == botTest1.generateCode().size());
	}

	@Test
	public void testBotGenerateCodeNotNull()
	{
		
		assertNotNull(botTest2.generateCode());
	}

	
}
