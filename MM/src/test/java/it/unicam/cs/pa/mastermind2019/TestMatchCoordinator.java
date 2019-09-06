package it.unicam.cs.pa.mastermind2019;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import it.unicam.cs.pa.mastermind2019.modelcontroller.Campo;
import it.unicam.cs.pa.mastermind2019.modelcontroller.CampoView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.GameParameters;
import it.unicam.cs.pa.mastermind2019.modelcontroller.MatchCoordinator;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ParametersView;

public class TestMatchCoordinator {

	@Test
	public void testCheckPC() throws IOException {
		
		PlayerFactory p = new PlayerFactory();
//		Player bot = p.getPlayer("bot");
//		Player chicco = p.getPlayer("Bot");
		ParametersView settings = new GameParameters(6, false);
		CampoView cam = new Campo(settings);
//		MatchCoordinator arbitro = new MatchCoordinator(settings, cam, bot, chicco);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(5);
		app.add(4);
		app.add(3);
		app.add(7);
		
		cam.setDecodeArray(app);
		
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		
		assertEquals(risultato, arbitro.check(app));
	}
	
	@Test
	public void testCheckPE() throws IOException
	{
		PlayerFactory p = new PlayerFactory();
		Player bot = p.getPlayer("bot");
		Player chicco = p.getPlayer("Bot");
		ParametersView settings = new GameParameters(4, false);
		Campo cam = new Campo(settings);
		MatchCoordinator arbitro = new MatchCoordinator(settings, cam, bot, chicco);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		
		ArrayList<Integer> app2 = new ArrayList<Integer>();
		app2.add(4);
		app2.add(3);
		app2.add(2);
		app2.add(1);		
		
		cam.setDecodeArray(app);
		
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		
		assertEquals(risultato, arbitro.check(app2));
	}
	
	@Test
	public void testCheckBoth() throws IOException
	{
		PlayerFactory p = new PlayerFactory();
		Player bot = p.getPlayer("bot");
		Player chicco = p.getPlayer("Bot");
		ParametersView settings = new GameParameters(4, false);
		Campo cam = new Campo(settings);
		MatchCoordinator arbitro = new MatchCoordinator(settings, cam, bot, chicco);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		
		ArrayList<Integer> app2 = new ArrayList<Integer>();
		app2.add(1);
		app2.add(3);
		app2.add(2);
		app2.add(4);		
		
		cam.setDecodeArray(app);
		
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		
		assertEquals(risultato, arbitro.check(app2));
		
		
	}@Test
	public void testCheckNull() throws IOException
	{
		PlayerFactory p = new PlayerFactory();
		Player bot = p.getPlayer("bot");
		Player chicco = p.getPlayer("Bot");
		ParametersView settings = new GameParameters(4, false);
		Campo cam = new Campo(settings);
		MatchCoordinator arbitro = new MatchCoordinator(settings, cam, bot, chicco);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		
		ArrayList<Integer> app2 = new ArrayList<Integer>();
		app2.add(1);
		app2.add(3);
		app2.add(5);
		app2.add(6);		
		
		cam.setDecodeArray(app);
		
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PE);
		
		assertEquals(risultato, arbitro.check(app2));
	}
	
	@Test
	public void testIsWinnerTrue() throws IOException
	{
		
		ParametersView settings = new GameParameters(4, false);
		Campo cam = new Campo(settings);
		
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		
		assertTrue(MatchCoordinator.isWinner(risultato, cam));
	}

	@Test
	public void testIsWinnerFalse() throws IOException
	{
		
		ParametersView settings = new GameParameters(4, false);
		Campo cam = new Campo(settings);
		
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PE);
		
		assertFalse(MatchCoordinator.isWinner(risultato, cam));
	}

}
