import java.util.Random;

public class TieBreakSet {
	private Set setNormal = new Set();
	private TieBreakGame gameTieBreak = new TieBreakGame();
	private Player player1st = new Player("player1st");
	private Player player2nd = new Player("player2nd");

	public TieBreakSet(Player player1st, Player player2nd) {
		super();
		this.player1st = player1st;
		this.player2nd = player2nd;
		setNormal.setPlayer1st(player1st);
		setNormal.setPlayer2nd(player2nd);
	}

	public Boolean conditionStartTieBreakGame() {
		Boolean con = false;
		if (setNormal.getGameNumber() == 12)
			con = true;
		return con;
	}

	public TieBreakGame getGameTieBreak() {
		return gameTieBreak;
	}

	public Player getPlayer1st() {
		return player1st;
	}

	public Player getPlayer2nd() {
		return player2nd;
	}

	public Set getSetNormal() {
		return setNormal;
	}

	public void playRandomSetTiBreak() {
		System.out.println("_____Start Set----------------------");
		resetSetTieBreak();
		Random r = new Random();
		while (!conditionEndSetTieBreak()) {
			if (r.nextBoolean())
				player1stWinAGameTieBreak();
			else
				player2ndWinAGameTieBreak();
		}

	}

	public boolean conditionEndSetTieBreak() {
		Boolean con = false;
		if (!conditionStartTieBreakGame()) {
			if (setNormal.returnWinnerOfSet().isWin())
				con = true;
		}
		if (conditionStartTieBreakGame()) {
			if (gameTieBreak.getWiner().isWin())
				con = true;
		}
		return con;
	}

	public void player1stWinAGameTieBreak() {
		if (conditionStartTieBreakGame()) {
			while (!player1st.isWin()) {
				playGameTieBreakRandom();
			}
			player1st.setScore("WinTieBreak");
			player1st.setWin(true);
			player2nd.setScore("Lose");
			printConsole();
		} else
			
			setNormal.addPlayer1stWinAGameWithRandomScore();
	}

	// public void player1stWinASetTieBreak() {
	// while (returnWinerOfSetTieBreak() != player1st) {
	// if(returnWinerOfSetTieBreak()==player2nd) resetSetTieBreak();
	// Random r = new Random();
	// if (r.nextBoolean())
	// player1stWinAGameTieBreak();
	// else
	// player2ndWinAGame();
	//
	// }
	// for(int i = 0;i<setNormal.getGameNumber();i++){
	// // System.out.println("-------------");
	// }
	// }

	public void player2ndWinAGameTieBreak() {
		if (conditionStartTieBreakGame()) {
			while (gameTieBreak.getWiner() != player2nd) {
				playGameTieBreakRandom();
			}
			player1st.setScore("Lose");
			player2nd.setScore("WinTieBreak");
			player2nd.setWin(true);
			printConsole();
			
		} else
			setNormal.addPlayer2ndWinAGameWithRandomScore();
	}

	// public void player2ndWinASetTieBreak() {
	// while (returnWinerOfSetTieBreak() != player2nd) {
	// if(returnWinerOfSetTieBreak()==player1st) resetSetTieBreak();
	// Random r = new Random();
	// if (r.nextBoolean())
	// player1stWinAGameTieBreak();
	// else
	// player2ndWinAGame();
	// }
	//
	// }

	private void playGameTieBreakRandom() {
		if (setNormal.games.get(11).getWiner() == player1st) {

			gameTieBreak.setServer(player1st);
			gameTieBreak.setReciever(player2nd);
			gameTieBreak.playRandomGameTieBreak();
			player1st = gameTieBreak.getServer();
			player2nd = gameTieBreak.getReciever();

			gameTieBreak.setServer(player2nd);
			gameTieBreak.setReciever(player1st);
			gameTieBreak.playRandomGameTieBreak();
			player2nd = gameTieBreak.getServer();
			player1st = gameTieBreak.getReciever();

			gameTieBreak.setServer(player2nd);
			gameTieBreak.setReciever(player1st);
			gameTieBreak.playRandomGameTieBreak();
			player2nd = gameTieBreak.getServer();
			player1st = gameTieBreak.getReciever();

			while (!gameTieBreak.getWiner().isWin()) {
				int i = 0;
				if (i % 2 == 0) {
					gameTieBreak.setServer(player1st);
					gameTieBreak.setReciever(player2nd);
					gameTieBreak.playRandomGameTieBreak();
					player1st = gameTieBreak.getServer();
					player2nd = gameTieBreak.getReciever();

					gameTieBreak.setServer(player1st);
					gameTieBreak.setReciever(player2nd);
					gameTieBreak.playRandomGameTieBreak();
					player1st = gameTieBreak.getServer();
					player2nd = gameTieBreak.getReciever();
				} else {
					gameTieBreak.setServer(player2nd);
					gameTieBreak.setReciever(player1st);
					gameTieBreak.playRandomGameTieBreak();
					player2nd = gameTieBreak.getServer();
					player1st = gameTieBreak.getReciever();

					gameTieBreak.setServer(player2nd);
					gameTieBreak.setReciever(player1st);
					gameTieBreak.playRandomGameTieBreak();
					player2nd = gameTieBreak.getServer();
					player1st = gameTieBreak.getReciever();
				}
				i++;
			}
		} else {
			player1st.reset();
			player2nd.reset();
			gameTieBreak.setServer(player2nd);
			gameTieBreak.setReciever(player1st);
			gameTieBreak.playRandomGameTieBreak();
			player2nd = gameTieBreak.getServer();
			player1st = gameTieBreak.getReciever();

			gameTieBreak.setServer(player1st);
			gameTieBreak.setReciever(player2nd);
			gameTieBreak.playRandomGameTieBreak();
			player1st = gameTieBreak.getServer();
			player2nd = gameTieBreak.getReciever();

			gameTieBreak.setServer(player1st);
			gameTieBreak.setReciever(player2nd);
			gameTieBreak.playRandomGameTieBreak();
			player1st = gameTieBreak.getServer();
			player2nd = gameTieBreak.getReciever();

			while (!gameTieBreak.getWiner().isWin()) {
				int i = 0;
				if (i % 2 == 0) {
					gameTieBreak.setServer(player2nd);
					gameTieBreak.setReciever(player1st);
					gameTieBreak.playRandomGameTieBreak();
					player2nd = gameTieBreak.getServer();
					player1st = gameTieBreak.getReciever();

					gameTieBreak.setServer(player2nd);
					gameTieBreak.setReciever(player1st);
					gameTieBreak.playRandomGameTieBreak();
					player2nd = gameTieBreak.getServer();
					player1st = gameTieBreak.getReciever();
				} else {
					gameTieBreak.setServer(player1st);
					gameTieBreak.setReciever(player2nd);
					gameTieBreak.playRandomGameTieBreak();
					player1st = gameTieBreak.getServer();
					player2nd = gameTieBreak.getReciever();

					gameTieBreak.setServer(player1st);
					gameTieBreak.setReciever(player2nd);
					gameTieBreak.playRandomGameTieBreak();
					player1st = gameTieBreak.getServer();
					player2nd = gameTieBreak.getReciever();
				}
				i++;
			}
		}
	}

	public String printResult() {
		return player1st.getName() + "=" + player1st.getScore() + ";"
				+ player2nd.getName() + "=" + player2nd.getScore();
	}

	private void resetSetTieBreak() {
		// System.out.println(player1st.getName()+":"+player1st.getScore()+"-"+player2nd.getName()+":"+player2nd.getScore());
		setNormal.resetSet();
		gameTieBreak.resetGameTieBreak();
		player1st.reset();
		player2nd.reset();

	}

	public Player returnWinerOfSetTieBreak() {

		Player winerSetTieBreak = new Player("winerSetTieBreak");
		if (player1st.isWin())
			winerSetTieBreak = player1st;
		if (player2nd.isWin())
			winerSetTieBreak = player2nd;
		return winerSetTieBreak;
	}

	public void setPlayer1st(Player player1st) {
		this.player1st = player1st;
	}

	public void setPlayer2nd(Player player2nd) {
		this.player2nd = player2nd;
	}

	public void setScorePlayer1stPlayer2nd(int player1stScore,
			int player2ndScore) {
		setNormal.setScoreOfPlayer1stAndPlayer2ndInSet(player1stScore,
				player2ndScore);
	}
	public void printConsole() {
		System.out.println("_____SetTieBreak: " + this.player1st.getName() + "="
				+ this.player1st.getScore() + ";" + this.player2nd.getName()
				+ "=" + this.player2nd.getScore());

	}

}
