import java.util.ArrayList;
import java.util.Random;

public class Set {
	private int gameNumber = 0;
	private int gamesPlayer1stWin = 0;
	private int gamesPlayer2ndWin = 0;
	private int gap = 0;
	private Player player1st = new Player("player1st-Set");
	private Player player2nd = new Player("player2nd-Set");
	ArrayList<Game> games = new ArrayList<Game>();
	private boolean isPlayer1ServeInLastGame = false;

	public boolean isPlayer1ServeInLastGame() {
		return isPlayer1ServeInLastGame;
	}


	public Set(Player player1st, Player player2nd) {
		super();
		this.player1st = player1st;
		this.player2nd = player2nd;
	}

	public Set() {
		// TODO Auto-generated constructor stub
	}


	public void printConsole() {
		System.out.println("_____Set: " + this.player1st.getName() + "="
				+ this.player1st.getScore() + ";" + this.player2nd.getName()
				+ "=" + this.player2nd.getScore());

	}

	public void addPlayer1stWinAGameWithRandomScore() {
//		System.out.println("_____" + player1st.getName() + " win game");
		if (!conditionEndSet()) {
			if (gameNumber % 2 == 0) {
				Game g = new Game(player1st, player2nd);
				games.add(gameNumber, g);
				while (!games.get(gameNumber).getServer().isWin())
					games.get(gameNumber).playGameTieBreakRandom();
			} else {
				Game g = new Game(player2nd, player1st);
				games.add(gameNumber, g);
				while (!games.get(gameNumber).getReciever().isWin())
					games.get(gameNumber).playGameTieBreakRandom();
			}
			checkIsPlayer1stServe();
			gamesPlayer1stWin++;
			player1st.setScore(Integer.toString(gamesPlayer1stWin));
			player2nd.setScore(Integer.toString(gamesPlayer2ndWin));
			gameNumber++;
			printConsole();
		}
		if (conditionEndSet()) {
			printConsole();
			System.out.println("_____End Set----------------------");
		}
	}

	public void addPlayer2ndWinAGameWithRandomScore() {
//		System.out.println("_____" + player2nd.getName() + " win game");
		if (!conditionEndSet()) {
			if (gameNumber % 2 == 0) {
				Game g = new Game(player1st, player2nd);
				games.add(gameNumber, g);
				while (!games.get(gameNumber).getReciever().isWin())
					games.get(gameNumber).playGameTieBreakRandom();
			} else {
				Game g = new Game(player2nd, player1st);
				games.add(gameNumber, g);
				while (!games.get(gameNumber).getServer().isWin())
					games.get(gameNumber).playGameTieBreakRandom();
			}
			checkIsPlayer1stServe();
			gamesPlayer2ndWin++;
			player1st.setScore(Integer.toString(gamesPlayer1stWin));
			player2nd.setScore(Integer.toString(gamesPlayer2ndWin));
			gameNumber++;
			printConsole();
		}
		if (conditionEndSet()) {
			printConsole();
			System.out.println("_____End Set----------------------");
		}
	}

	private void checkIsPlayer1stServe() {
		if (games.get(gameNumber).getServer().getName() == player1st.getName())
			isPlayer1ServeInLastGame = true;
		else
			isPlayer1ServeInLastGame = false;
	}

	public boolean conditionEndSet() {
		boolean conditionBoolean = false;

		if (gamesPlayer1stWin == 6 && gamesPlayer2ndWin <= 4) {
			conditionBoolean = true;
			player1st.setScore("Win");
			player1st.setWin(true);
		}
		if (gamesPlayer2ndWin == 6 && gamesPlayer1stWin <= 4) {
			conditionBoolean = true;
			player2nd.setScore("Win");
			player2nd.setWin(true);
		}

		if (gamesPlayer1stWin >= 5 && gamesPlayer2ndWin >= 5) {
			gap = gamesPlayer1stWin - gamesPlayer2ndWin;
			if (gap == 2) {
				player1st.setScore("Win");
				player1st.setWin(true);
				conditionBoolean = true;
			}
			if (gap == -2) {
				player2nd.setScore("Win");
				player2nd.setWin(true);
				conditionBoolean = true;
			}
		}
		return conditionBoolean;
	}

	public int getGameNumber() {
		return gameNumber;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public int getGamesPlayer1stWin() {
		return gamesPlayer1stWin;
	}

	public int getGamesPlayer2ndWin() {
		return gamesPlayer2ndWin;
	}

	public Player getPlayer1st() {
		return player1st;
	}

	public Player getPlayer2nd() {
		return player2nd;
	}

	public void playRanDomSet() {
		System.out.println("_____Start Set----------------------");
		resetSet();
		Random r = new Random();
		while (!conditionEndSet()) {
			if (r.nextBoolean())
				addPlayer1stWinAGameWithRandomScore();
			else
				addPlayer2ndWinAGameWithRandomScore();
		}
//		if (conditionEndSet()) {
////			printConsole();
//			System.out.println("End Set----------------------");
//		}
	}


	public String printSetResult() {
		return player1st.getName() + "=" + player1st.getScore() + ";"
				+ player2nd.getName() + "=" + player2nd.getScore();
	}

	public void resetSet() {
		gameNumber = 0;
		gap = 0;
		gamesPlayer1stWin = 0;
		gamesPlayer2ndWin = 0;
		games.clear();
		player1st.reset();
		player2nd.reset();
	}

	public Player returnWinnerOfSet() {
		Player winerOfSet = new Player("winerOFset");
		if (player1st.isWin())
			winerOfSet = player1st;
		if (player2nd.isWin())
			winerOfSet = player2nd;
		return winerOfSet;
	}

	public void setGameNumber(int gameNumber) {
		this.gameNumber = gameNumber;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}

	public void setPlayer1st(Player player1st) {
		this.player1st = player1st;
	}


	public void setPlayer2nd(Player player2nd) {
		this.player2nd = player2nd;
	}

	public void setScoreOfPlayer1stAndPlayer2ndInSet(int player1st,
			int player2nd) {
		int sumScore = player1st + player2nd;
		while (sumScore != 0) {
			if (player1st != 0) {
				addPlayer1stWinAGameWithRandomScore();
				player1st--;
			}
			if (player2nd != 0) {
				addPlayer2ndWinAGameWithRandomScore();
				player2nd--;
			}
			sumScore = player1st + player2nd;
		}
	}

}
