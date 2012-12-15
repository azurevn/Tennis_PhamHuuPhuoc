import java.util.Random;

public class Game {
	private Player winer = new Player("winer");
	private Player server = new Player("server");
	private Player reciever = new Player("reciever");

	public Game() {
		super();
	}

	public void resetGame() {
		System.out.println("xxx_ResetGame_xxx");
		winer.reset();
		server.reset();
		reciever.reset();
	}

	public Game(Player server, Player reciever) {
		super();
		this.server = server;
		this.reciever = reciever;
	}

	public Player getReciever() {
		return reciever;
	}

	public Player getServer() {
		return server;
	}

	public Player getWiner() {
		return winer;
	}

	public void setReciever(Player reciever) {
		this.reciever = reciever;
	}

	public void setServer(Player server) {
		this.server = server;
	}

	public void setWiner(Player winer) {
		this.winer = winer;
	}


	public void setScoreServerAndRecieverInGame(String serverScore,
			String recieverScore) {
		server.setScore(serverScore);
		reciever.setScore(recieverScore);
	}

	public Boolean conditionEndGame() {
		Boolean con = false;
		if (server.isWin()&&!reciever.isWin())
			con = true;
		if (reciever.isWin()&&!server.isWin())
			con = true;
		return con;
	}

	public void playGameTieBreakRandom() {
		System.out.println("_Start Game----------------------");
		resetGame();
		Random r = new Random();
		while (!conditionEndGame()) {
			if (r.nextBoolean())
				serverWinScore();
			else
				recieverWinScore();
		}
		if (conditionEndGame()) {
			
			System.out.println("_End Game----------------------");
		}
	}

	public void serverWinScore() {
//		System.out.println(server.getName() + " Score");
		if (!conditionEndGame()) {
			String scoreServerAndReciever = server.getScore()
					+ reciever.getScore();
			switch (scoreServerAndReciever) {
			case "00":
				server.setScore("15");
				break;
			case "015":
				server.setScore("15");
				break;
			case "030":
				server.setScore("15");
				break;
			case "040":
				server.setScore("15");
				break;

			case "150":
				server.setScore("30");
				break;
			case "1515":
				server.setScore("30");
				break;
			case "1530":
				server.setScore("30");
				break;
			case "1540":
				server.setScore("30");
				break;

			case "300":
				server.setScore("40");
				break;
			case "3015":
				server.setScore("40");
				break;
			case "3030":
				server.setScore("40");
				break;
			case "3040":
				server.setScore("40");
				break;

			case "400":
				server.setScore("Win");
				server.setWin(true);
				winer = server;
				break;
			case "4015":
				server.setScore("Win");
				server.setWin(true);
				winer = server;
				break;
			case "4030":
				server.setScore("Win");
				server.setWin(true);
				winer = server;
				break;

			case "4040":
				server.setScore("A");
				break;

			case "A40":
				server.setScore("Win");
				server.setWin(true);
				winer = server;
				break;

			case "40A":
				reciever.setScore("40");
				break;
			}
		}
		printConsole();
	}

	public void recieverWinScore() {

//		System.out.println(reciever.getName() + " Score");

		if (!conditionEndGame()) {

			String scoreServerAndReciever = reciever.getScore()
					+ server.getScore();
			switch (scoreServerAndReciever) {
			case "00":
				reciever.setScore("15");
				break;
			case "015":
				reciever.setScore("15");
				break;
			case "030":
				reciever.setScore("15");
				break;
			case "040":
				reciever.setScore("15");
				break;

			case "150":
				reciever.setScore("30");
				break;
			case "1515":
				reciever.setScore("30");
				break;
			case "1530":
				reciever.setScore("30");
				break;
			case "1540":
				reciever.setScore("30");
				break;

			case "300":
				reciever.setScore("40");
				break;
			case "3015":
				reciever.setScore("40");
				break;
			case "3030":
				reciever.setScore("40");
				break;
			case "3040":
				reciever.setScore("40");
				break;

			case "400":
				reciever.setScore("Win");
				reciever.setWin(true);
				winer = reciever;
				break;
			case "4015":
				reciever.setScore("Win");
				reciever.setWin(true);
				winer = reciever;
				break;
			case "4030":
				reciever.setScore("Win");
				reciever.setWin(true);
				winer = reciever;
				break;

			case "4040":
				reciever.setScore("A");
				break;

			case "A40":
				reciever.setScore("Win");
				reciever.setWin(true);
				winer = reciever;
				break;

			case "40A":
				server.setScore("40");
				break;
			}
		}
		printConsole();
	}

	public String printResultGame() {
		return "Server=" + server.getScore() + ":Reciever="
				+ reciever.getScore();

	}
	public void printConsole() {
		System.out.println("Game:" + server.getName() + "=" + server.getScore()
				+ ";" + reciever.getName() + "=" + reciever.getScore());

	}
}
