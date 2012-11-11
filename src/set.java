import java.util.ArrayList;
import java.util.Random;

public class set {
	int gameNumber = 0;
	int gamesPlayer1Win = 0;
	int gamesPlayer2Win = 0;
	int gap = 0;
	player player1 = new player();
	player player2 = new player();
	
	ArrayList<game> games = new ArrayList<game>();
	Random randomGenerator = new Random();

	public set() {
		super();
		// TODO Auto-generated constructor stub
	}

	public set(player p1, player p2, ArrayList<game> games) {
		super();
		this.player1 = p1;
		this.player2 = p2;
		this.games = games;
	}

	public ArrayList<game> getGames() {
		return games;
	}

	public player getPlayer1() {
		return player1;
	}

	public player getPlayer2() {
		return player2;
	}

	public void setGames(ArrayList<game> games) {
		this.games = games;
	}

	public void setPlayer1(player p1) {
		this.player1 = p1;
	}

	public void setPlayer2(player p2) {
		this.player2 = p2;
	}

	public void setScoreOfPlayer1AndPlayer2InSet(int p1, int p2) {
		int sumScore = p1+p2;
		
		while (sumScore != 0) {
			if (p1 != 0) {
				player1WinAGame();
				p1--;
			}
			if (p2 != 0) {
				player2WinAGame();
				p2--;
			}
			sumScore = p1+p2;
		}
	}


	public void player1WinAGame() {
		if (condition()) {
			game g = new game();
			if (gameNumber % 2 == 0) {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player1);
				games.get(gameNumber).setReciever(player2);
				games.get(gameNumber).setWiner(player1);
			} else {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player2);
				games.get(gameNumber).setReciever(player1);
				games.get(gameNumber).setWiner(player1);
			}
			games.get(gameNumber).setWiner(player1);
			gamesPlayer1Win++;
			gameNumber++;
		}
	}

	public void player2WinAGame() {
		if (condition()) {
			game g = new game();
			if (gameNumber % 2 == 0) {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player1);
				games.get(gameNumber).setReciever(player2);
				games.get(gameNumber).setWiner(player2);
			} else {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player2);
				games.get(gameNumber).setReciever(player1);
				games.get(gameNumber).setWiner(player2);
			}
			games.get(gameNumber).setWiner(player2);
			gamesPlayer2Win++;
			gameNumber++;
		}
	}

	public boolean condition() {
		boolean conditionBoolean = true;

		if (gamesPlayer2Win == 6 && gamesPlayer1Win <= 4)
			conditionBoolean = false;
		if (gamesPlayer1Win == 6 && gamesPlayer2Win <= 4)
			conditionBoolean = false;
		if (gamesPlayer1Win >= 5 && gamesPlayer2Win >= 5) {
			gap = gamesPlayer1Win - gamesPlayer2Win;

			if (gap == 2 || gap == -2)
				conditionBoolean = false;
		}
		return conditionBoolean;
	}

	public void playRanDomSet() {
		while (condition()) {
			game g = new game();
			if (gameNumber % 2 == 0) {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player1);
				games.get(gameNumber).setReciever(player2);

			} else {
				games.add(gameNumber, g);
				games.get(gameNumber).setServer(player2);
				games.get(gameNumber).setReciever(player1);
			}
			games.get(gameNumber).playRandomToGetWiner();

			if (games.get(gameNumber).getWiner() == player1)
				gamesPlayer1Win++;
			else
				gamesPlayer2Win++;
			player1.reset();
			player2.reset();
			gameNumber++;
		}
	}

	public String printSetResult() {
		String result = null;
		result = "p1:" + gamesPlayer1Win + ";p2:" + gamesPlayer2Win;
		if (gamesPlayer1Win == 6 && gamesPlayer2Win <= 4)
			result += "=>Win:p1";
		if (gamesPlayer2Win == 6 && gamesPlayer1Win <= 4)
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
			setScoreOfPlayer1AndPlayer2InSet(randomGamesPlayer1Win, randomGamesPlayer1Win-2);
		}
		else{
			setScoreOfPlayer1AndPlayer2InSet(randomGamesPlayer1Win, myRandomGameWinForLoser());
		}
	}

	public void setPlayer2WinSetWithRandomScore() {
		int randomGamesPlayer2Win = myRandomGameWinForWiner();
		if(randomGamesPlayer2Win>6){
			setScoreOfPlayer1AndPlayer2InSet(randomGamesPlayer2Win-2, randomGamesPlayer2Win);
		}
		else{
			setScoreOfPlayer1AndPlayer2InSet(myRandomGameWinForLoser(),randomGamesPlayer2Win);
		}
	}
	public player returnWinnerOfSet(){
		player winerOfSet = new player();
		if (gamesPlayer1Win == 6 && gamesPlayer2Win <= 4)
			winerOfSet = player1;
		if (gamesPlayer2Win == 6 && gamesPlayer1Win <= 4)
			winerOfSet = player2;
		if (gap == 2)
			winerOfSet = player1;
		if (gap == -2)
			winerOfSet = player2;
		return winerOfSet;
	}
	

}
