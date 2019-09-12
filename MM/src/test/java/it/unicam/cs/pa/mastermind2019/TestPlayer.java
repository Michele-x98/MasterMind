package it.unicam.cs.pa.mastermind2019;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

//import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniClasse;
//import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
//import it.unicam.cs.pa.mastermind2019.view.MMView;

public class TestPlayer
{

//	@Test
	public void testHumanGenerateCode() throws IOException, IllegalParameterException
	{
//		GameParameters settings = new GameParameters(6, false);
//		PlayerFactory p = new PlayerFactory();
//		Player chicco = p.getPlayer("Prova");
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(5);
		app.add(4);
		app.add(3);
		app.add(7);
//		System.out.println("Codice da inserire: 125437");
//		assertEquals(app, chicco.generateCode(settings));
		
	}
	@Test
	public void testBotGenerateCode() throws IOException, IllegalParameterException
	{
//		ImpostazioniView settings = new ImpostazioniClasse(6, false);
		PlayerFactoryView p = new PlayerFactory();
		Player chicco = p.getPlayer("BOT", null);
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
//		ImpostazioniView settings = new ImpostazioniClasse(6, false);
		PlayerFactoryView p = new PlayerFactory();
		Player chicco = p.getPlayer("Bot", null);
		assertNotNull(chicco.generateCode());
	}
	
//	@Test
	public void testHumanGenerateCodeNotNull() throws IOException, IllegalParameterException
	{
//		ImpostazioniView settings = new ImpostazioniClasse(6, false);
		PlayerFactoryView p = new PlayerFactory();
		Player chicco = p.getPlayer("Prova", null);
		assertNotNull(chicco.generateCode());
		
	}
}
