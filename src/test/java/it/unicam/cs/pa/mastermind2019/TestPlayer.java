package it.unicam.cs.pa.mastermind2019;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import it.unicam.cs.pa.mastermind2019.modelcontroller.Campo;
import it.unicam.cs.pa.mastermind2019.modelcontroller.CampoView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniClasse;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;

public class TestPlayer
{

	@Test
	public void testHumanGenerateCode() throws IOException, IllegalParameterException
	{
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(6, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player chicco = p.getPlayer(PlayerType.getPlayerType("Carlo"), ciao);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(5);
		app.add(4);
		app.add(3);
		app.add(7);
		System.out.println("Codice da inserire: 125437");
		assertEquals(app, chicco.generateCode());

	}

	@Test
	public void testBotGenerateCode() throws IOException, IllegalParameterException
	{
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(6, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player chicco = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(5);
		app.add(4);
		app.add(3);
		app.add(7);
		assertTrue(app.size() == chicco.generateCode().size());
	}

	@Test
	public void testBotGenerateCodeNotNull() throws IOException, IllegalParameterException
	{
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(4, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player chicco = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		assertNotNull(chicco.generateCode());
	}

	@Test
	public void testHumanGenerateCodeNotNull() throws IOException, IllegalParameterException
	{
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(4, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player chicco = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		assertNotNull(chicco.generateCode());

	}
}
