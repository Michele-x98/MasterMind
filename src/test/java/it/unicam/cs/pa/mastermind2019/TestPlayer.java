package it.unicam.cs.pa.mastermind2019;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unicam.cs.pa.mastermind2019.modelcontroller.Campo;
import it.unicam.cs.pa.mastermind2019.modelcontroller.CampoView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniClasse;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;

public class TestPlayer
{

	@Test
	public void testHumanGenerateCode()
	{
		LogToFile.init("test");
		ImpostazioniView settingsTest = new ImpostazioniClasse(6, false);
		CampoView campoTest = new Campo(settingsTest);
		InputOutput viewInstanceTest = new InputOutput(settingsTest, campoTest);
		PlayerFactoryView playerGenerator = new PlayerFactory();
		Player humanTest = playerGenerator.getPlayer(PlayerType.getPlayerType("Carlo"), viewInstanceTest);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(5);
		app.add(4);
		app.add(3);
		app.add(7);
		System.out.println("Codice da inserire: 125437");
		assertEquals(app, humanTest.generateCode());

	}

	@Test
	public void testBotGenerateCode()
	{
		LogToFile.init("test");
		ImpostazioniView settingsTest1 = new ImpostazioniClasse(6, false);
		CampoView campoTest1 = new Campo(settingsTest1);
		InputOutput viewInsanceTest1 = new InputOutput(settingsTest1, campoTest1);
		PlayerFactoryView playerGenerator1 = new PlayerFactory();
		Player botTest1 = playerGenerator1.getPlayer(PlayerType.getPlayerType("bot"), viewInsanceTest1);
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
		LogToFile.init("test");
		ImpostazioniView settingsTest2 = new ImpostazioniClasse(4, false);
		CampoView campoTest2 = new Campo(settingsTest2);
		InputOutput viewInstanceTest2 = new InputOutput(settingsTest2, campoTest2);
		PlayerFactoryView playerGenerator2 = new PlayerFactory();
		Player botTest2 = playerGenerator2.getPlayer(PlayerType.getPlayerType("bot"), viewInstanceTest2);
		assertNotNull(botTest2.generateCode());
	}

	@Test
	public void testHumanGenerateCodeNotNull()
	{
		LogToFile.init("test");
		ImpostazioniView settingsTest3 = new ImpostazioniClasse(4, false);
		CampoView campoTest3 = new Campo(settingsTest3);
		InputOutput viewInstance3 = new InputOutput(settingsTest3, campoTest3);
		PlayerFactoryView playerGenerator3 = new PlayerFactory();
		Player botTest3 = playerGenerator3.getPlayer(PlayerType.getPlayerType("bot"), viewInstance3);
		assertNotNull(botTest3.generateCode());

	}
}
