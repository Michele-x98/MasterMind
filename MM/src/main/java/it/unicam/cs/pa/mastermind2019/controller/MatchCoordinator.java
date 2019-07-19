package it.unicam.cs.pa.mastermind2019.controller;

import java.io.IOException;
import java.util.ArrayList;

import it.unicam.cs.pa.mastermind2019.Perdente;
import it.unicam.cs.pa.mastermind2019.Pioli;
import it.unicam.cs.pa.mastermind2019.Player;
import it.unicam.cs.pa.mastermind2019.Risultato;
import it.unicam.cs.pa.mastermind2019.Vincitore;
import it.unicam.cs.pa.mastermind2019.model.Campo;
import it.unicam.cs.pa.mastermind2019.model.GameParameters;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;

/**
 * <b>Responsabilità:</b> Gestire la partita (Arbitro).
 * 
 * @author Michele Benedetti
 * @author Daniele Moschini
 */

public class MatchCoordinator {
	private Player p1;
	private Player p2;
	private GameParameters parameters;
	private int tentativi;
	private Campo campo;
	private ArrayList<Pioli> suggerimento;

	/**
	 * Metodo Cotruttore del MatchCoordinator.
	 * 
	 * @param parametri Parametri usati nella partita
	 * @param campo     Conserva il codice da decriptare
	 * @param uno       Primo giocatore della partita
	 * @param due       Secondo giocatore della partita
	 */
	public MatchCoordinator(GameParameters parametri, Campo campo, Player uno, Player due) {
		this.parameters = parametri;
		this.p1 = uno;
		this.p2 = due;
		this.tentativi = 0;
		this.campo = campo;
	}

	/**
	 * Con metodo play() le varie fasi della partita vengono svolte.
	 * 
	 * @return Il vincitore o il perdente della partita.
	 * @throws IOException               Eccezione che può essere lanciata da
	 *                                   generateCode.
	 * @throws IllegalParameterException Eccezione che può essere lanciata da
	 *                                   generateCode.
	 */
	public Risultato play() throws IOException, IllegalParameterException {
		campo.setDecodeArray(p1.generateCode(parameters));
		this.tentativi = parameters.attempts;
		Risultato esito;
		do {
			campo.setCodeArray(p2.generateCode(parameters));
			suggerimento = new ArrayList<>(check(campo.getArrayFromCode()));
			if (isWinner(suggerimento, this.campo)) {
				esito = new Vincitore(this.p2.getID());
				return esito;
			}
			this.tentativi--;
			InputOutput.getAttempts(this.tentativi);

		} while (tentativi > 0);
		return esito = new Perdente(this.p2.getID());
	}

	/**
	 * Metodo che si occupa del confronto tra un tentativo e il codice da decriptare.
	 * 
	 * @param tentativo ArrayList contenente il codice.
	 * @return Un ArrayList di Pioli contenente un suggerimento per l'utente.
	 */
	public ArrayList<Pioli> check(ArrayList<Integer> tentativo) {
		// TODO AllowDuplicate da fare
		ArrayList<Pioli> checkResult = new ArrayList<Pioli>();
		int rightNumRightPlace = 0;
		int rightNumWrongPlace = 0;

		for (Integer arr : tentativo) {
			if (campo.getArrayFromDeco().contains(arr)) {
				if (campo.getArrayFromDeco().indexOf(arr) == tentativo.indexOf(arr)) {
					rightNumRightPlace++;
				} else
					rightNumWrongPlace++;
			}
		}

		for (int i = 0; i < rightNumRightPlace; i++) {
			checkResult.add(Pioli.PC);
		}
		for (int i = 0; i < rightNumWrongPlace; i++) {
			checkResult.add(Pioli.PE);
		}
		return checkResult;
	}

	/**
	 * Metodo che controlla se un arrayList è vincente o no.
	 * 
	 * @param tentativo ArrayList in input.
	 * @param campo Campo di gioco attuale.
	 * @return <b>True</b> Se <code>tentativo</code> è vincente (pieno di
	 *         <code>SIMBOLIPOSIZIONI</code>),
	 *         <b>False</b> Se <code>tentativo</code> non è vincente.
	 */
	public static boolean isWinner(ArrayList<Pioli> tentativo, Campo campo) {
		int count = 0;
		for (Pioli c : tentativo) {
			if (c.equals(Pioli.PC)) {
				count++;
			}
		}
		if (count == campo.lunghezza)
			return true;
		else
			return false;
	}

}
