import java.util.ArrayList;

public class set {
	int gameNumber = 0;
	int player1Win = 0;
	int player2Win = 0;
	int gap = 0;
	player player1 = new player();
	player player2 = new player();
	ArrayList<game> games = new ArrayList<game>();

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
			player1Win++;
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
			player2Win++;
			gameNumber++;
		}
	}

	public boolean condition() {
		boolean conditionBoolean = true;

		if (player2Win == 6 && player1Win <= 4)
			conditionBoolean = false;
		if (player1Win == 6 && player2Win <= 4)
			conditionBoolean = false;
		if (player1Win >= 5 && player2Win >= 5) {
			gap = player1Win - player2Win;

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
				player1Win++;
			else
				player2Win++;
			player1.reset();
			player2.reset();
			gameNumber++;
		}
	}

	public String printSetResult() {
		String result = null;
		result = "p1:" + player1Win + ";p2:" + player2Win;
		if (player1Win == 6 && player2Win <= 4)
			result += "=>Win:p1";
		if (player2Win == 6 && player1Win <= 4)
			result += "=>Win:p2";
		if (gap == 2)
			result += "=>Win:p1";
		if (gap == -2)
			result += "=>Win:p2";
		return result;
	}

}
