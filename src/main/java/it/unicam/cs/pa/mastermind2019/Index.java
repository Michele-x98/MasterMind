package it.unicam.cs.pa.mastermind2019;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


import it.unicam.cs.pa.mastermind2019.modelcontroller.Campo;
import it.unicam.cs.pa.mastermind2019.modelcontroller.CampoView;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ConsoleGame;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniFileConfig;
import it.unicam.cs.pa.mastermind2019.modelcontroller.ImpostazioniView;
import it.unicam.cs.pa.mastermind2019.view.IllegalParameterException;
import it.unicam.cs.pa.mastermind2019.view.InputOutput;
import it.unicam.cs.pa.mastermind2019.view.MMView;

public class Index
{

	public static void main(String argv[]) throws IOException, IllegalParameterException {
		LogToFile.init();
		Logger logger = LogToFile.getLogger(Index.class);
		logger.log(Level.INFO,"Creazioni delle impostazioni in corso");
		ImpostazioniView settings = new ImpostazioniFileConfig();
		logger.log(Level.INFO,"Creazione del terreno di gioco in corso");
		CampoView terreno = new Campo(settings);
		logger.log(Level.INFO,"Creazione dell' INPUT e dell' OUTPUT con l'utente in corso");
		MMView view = new InputOutput(settings, terreno);
		view.gameInit();
		logger.log(Level.INFO,"Creazione delle factory per i giocatori in corso");
		PlayerFactoryView player1 = new PlayerFactory();
		PlayerFactoryView player2 = new PlayerFactory();
		do {
			boolean finegame = true;
			 do {
				 logger.log(Level.INFO,"Aspettando ordini ..");
				switch (view.sceltaMenu()) {
				case 1: {
					logger.log(Level.INFO,"Creazione di una console di gioco in corso");
					ConsoleGame direttore = new ConsoleGame(player1.getPlayer(view.typePlayerSelection(true), view),
							player2.getPlayer(view.typePlayerSelection(false), view), view, terreno);
					logger.log(Level.INFO,"Inizializzazione della partita");
					direttore.start(settings, terreno);
					logger.log(Level.INFO,"Partita terminata");
					finegame = false;
					break;
				}
				case 2: {
					logger.log(Level.CONFIG,"Aspettando la configurazione della partita");
					settings.setCodeLenght(view.difficultConfiguration());
					settings.setDuplicate(view.duplicateConfiguration());
					logger.log(Level.INFO,"Configurazione avvenuta con successo");
					break;
				}
				case 3:{
					finegame = false;
					logger.log(Level.INFO,"Partita terminata");
					break;
				}
				}
			}while (finegame);

		} while (view.matchAgain());
		logger.log(Level.INFO,"Programma terminato");
	}

}
