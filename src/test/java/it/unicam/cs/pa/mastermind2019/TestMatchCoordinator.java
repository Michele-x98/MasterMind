package it.unicam.cs.pa.mastermind2019;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import it.unicam.cs.pa.mastermind2019.modelcontroller.ArbitroView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.Campo;
import it.unicam.cs.pa.mastermind2019.modelcontroller.CampoView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniClasse;
import it.unicam.cs.pa.mastermind2019.modelcontroller.Arbitro;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;

public class TestMatchCoordinator {

	@Test
	public void testCheckPC() throws IOException {
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(6, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactory p = new PlayerFactory();
		
		Player bot = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		Player chicco = p.getPlayer(PlayerType.getPlayerType("Carlo"), ciao);
		ArbitroView arbitro = new Arbitro(settings, cam, ciao, bot, chicco);
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
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(4, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player bot = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		Player chicco = p.getPlayer(PlayerType.getPlayerType("Carlo"), ciao);
		ArbitroView arbitro = new Arbitro(settings, cam, ciao, bot, chicco);
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
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(4, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player bot = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		Player chicco = p.getPlayer(PlayerType.getPlayerType("Carlo"), ciao);
		ArbitroView arbitro = new Arbitro(settings, cam, ciao, bot, chicco);
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
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(4, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player bot = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		Player chicco = p.getPlayer(PlayerType.getPlayerType("Carlo"), ciao);
		ArbitroView arbitro = new Arbitro(settings, cam, ciao, bot, chicco);
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
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(4, false);
		CampoView cam = new Campo(settings);

		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player bot = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		Player chicco = p.getPlayer(PlayerType.getPlayerType("Carlo"), ciao);
		Arbitro arbitro = new Arbitro(settings, cam, ciao, bot, chicco);
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		cam.setDecodeArray(app);
		assertTrue(arbitro.isWinner(risultato, cam));
	}

	@Test
	public void testIsWinnerFalse() throws IOException
	{
		LogToFile.init("test");
		ImpostazioniView settings = new ImpostazioniClasse(4, false);
		CampoView cam = new Campo(settings);
		InputOutput ciao = new InputOutput(settings, cam);
		PlayerFactoryView p = new PlayerFactory();
		Player bot = p.getPlayer(PlayerType.getPlayerType("bot"), ciao);
		Player chicco = p.getPlayer(PlayerType.getPlayerType("Carlo"), ciao);
		Arbitro arbitro = new Arbitro(settings, cam, ciao, bot, chicco);
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PE);
		
		assertFalse(arbitro.isWinner(risultato, cam));
	}

}
