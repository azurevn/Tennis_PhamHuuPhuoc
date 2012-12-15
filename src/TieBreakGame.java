import java.util.Random;

public class TieBreakGame {
	 private Player winer = new Player("winer");
	private Player server = new Player("server");
	private Player reciever = new Player("reciever");

	public void resetGameTieBreak() {
		System.out.println("xxxResetGameTieBreakxxx");
		server.reset();
		reciever.reset();
		winer.reset();
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

	public void setScoreServerAndReciever(String serverScore,
			String reciverScore) {
		server.setScore(serverScore);
		reciever.setScore(reciverScore);
	}

	public Boolean conditionEndTieBreak() {
		Boolean condition = false;

		if (Integer.parseInt(server.getScore()) == 7
				&& Integer.parseInt(reciever.getScore()) < 6) {
			condition = true;
			server.setWin(true);
			winer = server;
			
		}
		if (Integer.parseInt(server.getScore()) < 6
				&& Integer.parseInt(reciever.getScore()) == 7) {
			condition = true;
			reciever.setWin(true);
			winer = reciever;
		}

		if (Integer.parseInt(server.getScore()) >= 6
				&& Integer.parseInt(reciever.getScore()) >= 6) {
			int gap = Integer.parseInt(server.getScore())
					- Integer.parseInt(reciever.getScore());
			if (gap == 2) {
				condition = true;
				server.setWin(true);winer = server;
			}
			if (gap == -2) {
				condition = true;
				reciever.setWin(true);winer = reciever;
			}
		}

		return condition;
	}

	public void serverWinScoreTieBreak() {

		if (!conditionEndTieBreak()) {
			int scoreInt = Integer.parseInt(server.getScore());
			scoreInt++;
			server.setScore(Integer.toString(scoreInt));
			printConsole();
		}
		if(conditionEndTieBreak()){

			System.out.println("_End Game TieBreak----------------------");}
		
	}

	public void recieverWinScoreTieBreak() {
		if (!conditionEndTieBreak()) {
			int scoreInt = Integer.parseInt(reciever.getScore());
			scoreInt++;
			reciever.setScore(Integer.toString(scoreInt));
			printConsole();
		}
		if(conditionEndTieBreak()){

			System.out.println("_End Game TieBreak----------------------");}
	}

	public String printGameTieBreakResual() {
		return "Server=" + server.getScore() + ";Reciever="
				+ reciever.getScore();

	}

	public void playRandomGameTieBreak() {
		System.out.println("_Start Game TieBreak----------------------");
		resetGameTieBreak();
		Random r = new Random();
		while (!conditionEndTieBreak()) {
			if (r.nextBoolean())
				serverWinScoreTieBreak();
			else
				recieverWinScoreTieBreak();
		}
		
		
	}

	// public void randomWinScoreTieBreak() {
	// Random random = new Random();
	// if (random.nextBoolean())
	// serverWinScoreTieBreak();
	// else
	// recieverWinScoreTieBreak();
	// }
	public void printConsole() {
		System.out.println("GameTieBreak:" + server.getName() + "=" + server.getScore()
				+ ";" + reciever.getName() + "=" + reciever.getScore());

	}

}
