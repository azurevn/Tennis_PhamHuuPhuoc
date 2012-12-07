import java.util.ArrayList;
import java.util.Random;

public class Set {
	int gameNumber = 0;
	int gamesPlayer1stWin = 0;
	int gamesPlayer2ndWin = 0;
	int gap = 0;
	Player player1st = new Player();
	Player player2nd = new Player();
	
	ArrayList<Game> games = new ArrayList<Game>();
	Random randomGenerator = new Random();

	public Set() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Set(Player player1st, Player player2nd) {
		super();
		this.player1st = player1st;
		this.player2nd = player2nd;
	}

	public ArrayList<Game> getGames() {
		return games;
	}

	public Player getPlayer1st() {
		return player1st;
	}

	public Player getPlayer2nd() {
		return player2nd;
	}

	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}

	public void setPlayer1st(Player player1st) {
		this.player1st = player1st;
	}

	public void setPlayer2(Player player2nd) {
		this.player2nd = player2nd;
	}

	public void setScoreOfPlayer1stAndPlayer2ndInSet(int player1st, int player2nd) {
		int sumScore = player1st+player2nd;
		while (sumScore != 0) {
			if (player1st != 0) {
				addPlayer1stWinAGame();
				player1st--;
			}
			if (player2nd != 0) {
				addPlayer2ndWinAGame();
				player2nd--;
			}
			sumScore = player1st+player2nd;
		}
	}


	public void addPlayer1stWinAGame() {
		if (conditionAdd()) {
			Game g = new Game();
			if (gameNumber % 2 == 0) {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player1st);
				games.get(gameNumber).setReciever(player2nd);
				games.get(gameNumber).setWiner(player1st);
			} else {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player2nd);
				games.get(gameNumber).setReciever(player1st);
				games.get(gameNumber).setWiner(player1st);
			}
			games.get(gameNumber).setWiner(player1st);
			gamesPlayer1stWin++;
			gameNumber++;
		}
	}

	public void addPlayer2ndWinAGame() {
		if (conditionAdd()) {
			Game g = new Game();
			if (gameNumber % 2 == 0) {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player1st);
				games.get(gameNumber).setReciever(player2nd);
				games.get(gameNumber).setWiner(player2nd);
			} else {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player2nd);
				games.get(gameNumber).setReciever(player1st);
				games.get(gameNumber).setWiner(player2nd);
			}
			games.get(gameNumber).setWiner(player2nd);
			gamesPlayer2ndWin++;
			gameNumber++;
		}
	}

	public boolean conditionAdd() {
		boolean conditionBoolean = true;

		if (gamesPlayer2ndWin == 6 && gamesPlayer1stWin <= 4)
			conditionBoolean = false;
		if (gamesPlayer1stWin == 6 && gamesPlayer2ndWin <= 4)
			conditionBoolean = false;
		if (gamesPlayer1stWin >= 5 && gamesPlayer2ndWin >= 5) {
			gap = gamesPlayer1stWin - gamesPlayer2ndWin;

			if (gap == 2 || gap == -2)
				conditionBoolean = false;
		}
		return conditionBoolean;
	}

	public void playRanDomSet() {
		while (conditionAdd()) {
			Game g = new Game();
			if (gameNumber % 2 == 0) {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player1st);
				games.get(gameNumber).setReciever(player2nd);

			} else {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player2nd);
				games.get(gameNumber).setReciever(player1st);
			}
			games.get(gameNumber).playRandomToGetWiner();

			if (games.get(gameNumber).getWiner() == player1st)
				gamesPlayer1stWin++;
			else
				gamesPlayer2ndWin++;
			player1st.reset();
			player2nd.reset();
			gameNumber++;
		}
	}

	public String printSetResult() {
		String result = null;
		result = "p1:" + gamesPlayer1stWin + ";p2:" + gamesPlayer2ndWin;
		if (gamesPlayer1stWin == 6 && gamesPlayer2ndWin <= 4)
			result += "=>Win:p1";
		if (gamesPlayer2ndWin == 6 && gamesPlayer1stWin <= 4)
			result += "=>Win:p2";
		if (gap == 2)
			result += "=>Win:p1";
		if (gap == -2)
			result += "=>Win:p2";
		return result;
	}
	public int myRandomGameWinForWiner(){
		int gameWinScore = 0;
		while (gameWinScore<5||gameWinScore>30)
		{
			gameWinScore = randomGenerator.nextInt(30);
		}
		return gameWinScore;
	}
	public int myRandomGameWinForLoser(){
		int gameWinScore = -1;
		while (gameWinScore<=0||gameWinScore>5)
		{
			gameWinScore = randomGenerator.nextInt(4);
		}
		return gameWinScore;
	}
	

	public void setPlayer1WinSetWithRandomScore() {
		int randomGamesPlayer1Win = myRandomGameWinForWiner();
		if(randomGamesPlayer1Win>6){
			setScoreOfPlayer1stAndPlayer2ndInSet(randomGamesPlayer1Win, randomGamesPlayer1Win-2);
		}
		else{
			setScoreOfPlayer1stAndPlayer2ndInSet(randomGamesPlayer1Win, myRandomGameWinForLoser());
		}
	}

	public void setPlayer2WinSetWithRandomScore() {
		int randomGamesPlayer2Win = myRandomGameWinForWiner();
		if(randomGamesPlayer2Win>6){
			setScoreOfPlayer1stAndPlayer2ndInSet(randomGamesPlayer2Win-2, randomGamesPlayer2Win);
		}
		else{
			setScoreOfPlayer1stAndPlayer2ndInSet(myRandomGameWinForLoser(),randomGamesPlayer2Win);
		}
	}
	public Player returnWinnerOfSet(){
		Player winerOfSet = new Player();
		if (gamesPlayer1stWin == 6 && gamesPlayer2ndWin <= 4)
			winerOfSet = player1st;
		if (gamesPlayer2ndWin == 6 && gamesPlayer1stWin <= 4)
			winerOfSet = player2nd;
		if (gap == 2)
			winerOfSet = player1st;
		if (gap == -2)
			winerOfSet = player2nd;
		return winerOfSet;
	}
	

}
