package it.unicam.cs.pa.mastermind2019;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import it.unicam.cs.pa.mastermind2019.modelcontroller.Campo;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniClasse;
import it.unicam.cs.pa.mastermind2019.modelcontroller.Arbitro;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;

public class TestMatchCoordinator
{

	ImpostazioniView settingsTest = new ImpostazioniClasse(6, false);
	Campo terrenoTest = new Campo(settingsTest);
	InputOutput viewInstanceTest = new InputOutput(settingsTest, terrenoTest);
	PlayerFactory playerGenerator = new PlayerFactory();
	Player botTest = playerGenerator.getPlayer(PlayerType.getPlayerType("bot"), viewInstanceTest);
	Player interactiveTest = playerGenerator.getPlayer(PlayerType.getPlayerType("Carlo"), viewInstanceTest);
	Arbitro arbitro = new Arbitro(settingsTest, terrenoTest, viewInstanceTest, botTest, interactiveTest);
	@Test
	public void testCheckPC() 
	{
		LogToFile.init("test");
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(5);
		app.add(4);
		app.add(3);
		app.add(7);
		terrenoTest.setDecodeArray(app);
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
	public void testCheckPE() 
	{
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		app.add(5);
		app.add(6);
		ArrayList<Integer> app2 = new ArrayList<Integer>();
		app2.add(6);
		app2.add(5);
		app2.add(4);
		app2.add(3);
		app2.add(2);
		app2.add(1);

		terrenoTest.setDecodeArray(app);

		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		
		assertEquals(risultato, arbitro.check(app2));
	}

	@Test
	public void testCheckBoth() 
	{
		
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		app.add(5);
		app.add(6);
		ArrayList<Integer> app2 = new ArrayList<Integer>();
		app2.add(1);
		app2.add(2);
		app2.add(4);
		app2.add(3);
		app2.add(5);
		app2.add(6);

		terrenoTest.setDecodeArray(app);

		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);

		assertEquals(risultato, arbitro.check(app2));

	}

	@Test
	public void testCheckNull()
	{
		
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		app.add(5);
		app.add(6);
		
		ArrayList<Integer> app2 = new ArrayList<Integer>();
		app2.add(1);
		app2.add(3);
		app2.add(4);
		app2.add(5);
		app2.add(6);
		app2.add(2);
		terrenoTest.setDecodeArray(app);

		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);
		risultato.add(Pioli.PE);

		assertEquals(risultato, arbitro.check(app2));
	}

	@Test
	public void testIsWinnerTrue() 
	{
		
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		app.add(5);
		app.add(6);
		terrenoTest.setDecodeArray(app);
		assertTrue(arbitro.isWinner(risultato, terrenoTest));
	}

	@Test
	public void testIsWinnerFalse() 
	{
		
		ArrayList<Pioli> risultato = new ArrayList<Pioli>();
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PC);
		risultato.add(Pioli.PE);
		ArrayList<Integer> app = new ArrayList<Integer>();
		app.add(1);
		app.add(2);
		app.add(3);
		app.add(4);
		app.add(5);
		app.add(6);
		terrenoTest.setDecodeArray(app);

		assertFalse(arbitro.isWinner(risultato, terrenoTest));
	}

}
