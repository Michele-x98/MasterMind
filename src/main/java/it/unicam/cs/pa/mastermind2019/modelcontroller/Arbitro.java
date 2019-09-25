package it.unicam.cs.pa.mastermind2019.modelcontroller;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import it.unicam.cs.pa.mastermind2019.LogToFile;
import it.unicam.cs.pa.mastermind2019.Perdente;
import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.Player;
import it.unicam.cs.pa.mastermind2019.Risultato;
import it.unicam.cs.pa.mastermind2019.Vincitore;
import it.unicam.cs.pa.mastermind2019.view.MMView;

/**
 * <b>Responsabilità:</b> Gestire la partita.
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class Arbitro implements ArbitroView
{
	/**
	 * Primo giocatore della partita.
	 */
	private Player p1;
	/**
	 * Secondo giocatore della partita.
	 */
	private Player p2;
	/**
	 * Modalità di Input/Output utilizzata nella partita corrente.
	 */
	private MMView vista;
	/**
	 * Modalità di impostazioni utilizzate nella partita corrente.
	 */
	private ImpostazioniView parameters;
	/**
	 * Numero di tentativi
	 */
	private int tentativi;
	/**
	 * Modalità di campo utilizzato nella partita corrente.
	 */
	private CampoView campo;
	/**
	 * Array contenente il suggerimento per il giocatore.
	 */
	private ArrayList<Pioli> suggerimento;
	/**
	 * Logger della classe Arbitro.
	 */
	private static final Logger logger = LogToFile.getLogger(Arbitro.class);
/**
 * Costruttore dell'arbitro
 * @param parametri Impostazioni della partita.
 * @param campo Campo della partita.
 * @param vista Input/Output della partita.
 * @param firstPlayer Primo player della partita
 * @param secondPlayer Secondo player della partita.
 */
	public Arbitro(ImpostazioniView parametri,
							CampoView campo,
							MMView vista,
							Player firstPlayer,
							Player secondPlayer )
	{
		this.parameters = parametri;
		this.vista = vista;
		this.p1 = firstPlayer;
		this.p2 = secondPlayer;
		this.tentativi = 0;
		this.campo = campo;
		logger.log(Level.INFO, "Arbitro creato correttamente");
	}

	@Override
	public Risultato play()
	{
		logger.log(Level.INFO, "Match started!");
		campo.setDecodeArray(p1.generateCode());
		this.tentativi = parameters.getAttempts();
		Risultato esito;
		do
		{
			campo.setCodeArray(p2.generateCode());
			vista.vediCodice(campo.getArrayFromCode());
			suggerimento = new ArrayList<>(check(campo.getArrayFromCode()));
			vista.attemptResault(suggerimento);
			campo.addSuggerimento(suggerimento);
			if (isWinner(suggerimento, this.campo))
			{
				esito = new Vincitore(this.p2.getID());
				return esito;
			}
			this.tentativi--;
			logger.log(Level.INFO, tentativi +
									" turni alla fine");
		}
		while (tentativi > 0);
		logger.log(Level.INFO, "Match finished!");
		return esito = new Perdente(this.p2.getID());
	}

	@Override
	public ArrayList<Pioli> check(ArrayList<Integer> tentativo)
	{
		logger.log(Level.INFO, "Inizio controllo dei dati");
		ArrayList<Integer> codice = campo.getArrayFromDeco();
		ArrayList<Integer> tempNums = tentativo;
		ArrayList<Integer> tempCode = new ArrayList<>();
		for (int i = 0; i < parameters.getCodeLenght(); i++)
		{
			tempCode.add(codice.get(i));
		}

		ArrayList<Pioli> checkResult = new ArrayList<Pioli>();
		int rightNumRightPlace = 0;

		for (int i = 0; i < parameters.getCodeLenght(); i++)
		{
			if (tempCode.get(i) == tempNums.get(i))
			{
				rightNumRightPlace++;
				tempCode.set(i, -1);
				tempNums.set(i, -1);
			}
		}
		int rightNumWrongPlace = 0;
		for (int i = 0; i < parameters.getCodeLenght(); i++)
		{
			if (tempCode.get(i) == -1)
			{
				continue;
			}
			for (int j = 0; j < parameters.getCodeLenght(); j++)
			{
				if (tempNums.get(j) == -1)
				{
					continue;
				}
				if (tempCode.get(i) == tempNums.get(j))
				{
					rightNumWrongPlace++;
					tempCode.set(i, -1);
					tempNums.set(j, -1);
				}
			}
		}

		for (int i = 0; i < rightNumRightPlace; i++)
		{
			checkResult.add(Pioli.PC);
		}
		for (int i = 0; i < rightNumWrongPlace; i++)
		{
			checkResult.add(Pioli.PE);
		}
		logger.log(Level.INFO, "Controllo eseguito correttamente");
		return checkResult;
	}

	@Override
	public boolean isWinner(ArrayList<Pioli> tentativo,
									CampoView campo2)
	{
		int count = 0;
		for (Pioli c : tentativo)
		{
			if (c.equals(Pioli.PC))
			{
				count++;
			}
		}
		if (count == campo2.getArrayFromDeco().size())
		{
			logger.log(Level.INFO, "Tentativo vincente");
			return true;
		}
		else
		{
			logger.log(Level.INFO, "Tentativo non vincente");
			return false;
		}
	}

}
