import java.util.Random;

public class game {
	player winer = new player();
	player server = new player();
	player reciever = new player();
	String result = null;

	public game() {
		super();
		// TODO Auto-generated constructor stub
	}

	public game(player winer, player server, player reciever) {
		super();
		this.winer = winer;
		this.server = server;
		this.reciever = reciever;
	}

	public player getReciever() {
		return reciever;
	}

	public player getServer() {
		return server;
	}

	public player getWiner() {
		return winer;
	}

	public void setReciever(player reciever) {
		this.reciever = reciever;
	}

	public void setServer(player server) {
		this.server = server;
	}

	public void setWiner(player winer) {
		this.winer = winer;
	}

	public String convertAndReturnResultString() {
		String serverScore = "0";
		String recieverScore = "0";
		if (server.score == 1)
			serverScore = "15";
		if (server.score == 2)
			serverScore = "30";
		if (server.score == 3)
			serverScore = "40";
		if (server.score == 4)
			serverScore = "A";
		if (server.score == 4 && reciever.score < 3)
			serverScore = "Win";
		if (reciever.score == 1)
			recieverScore = "15";
		if (reciever.score == 2)
			recieverScore = "30";
		if (reciever.score == 3)
			recieverScore = "40";
		if (reciever.score == 4)
			recieverScore = "A";
		if (reciever.score == 4 && server.score < 3)
			recieverScore = "Win";
		return "Server=" + serverScore + ":Reciever=" + recieverScore;
	}

	public void whenScoreUnder40() {
		if (server.score <= 3 || reciever.score <= 3) {
			result = convertAndReturnResultString();
			if (server.score == 4 && reciever.score < 3) {
				server.win = true;
				winer = server;
			}
			if (reciever.score == 4 && server.score < 3) {
				reciever.win = true;
				winer = reciever;
			}
		}
	}

	public void whenScoreBelow40() {
		if (server.score >= 3 && reciever.score >= 3) {
			if (server.score >= 4 && reciever.score >= 3) {
				server.advantage = "A";
				reciever.advantage = "40";
				if (server.score == 5 && reciever.score == 3) {
					server.advantage = "Win";
					server.win = true;
				}
				if (reciever.score == 4) {
					server.score--;
					server.advantage = "40";
					reciever.score--;
				}
			}
			if (reciever.score >= 4 && server.score >= 3) {
				reciever.advantage = "A";
				server.advantage = "40";
				if (reciever.score == 5 && server.score == 3) {
					reciever.advantage = "Win";
					reciever.win = true;
				}
				if (server.score == 4) {
					reciever.score--;
					reciever.advantage = "40";
					server.score--;
				}
			}
			result = "Server=" + server.advantage + ":Reciever=" + reciever.advantage;
		}
		if (server.win)
			winer = server;
		if (reciever.win)
			winer = reciever;
	}

	public String printGameResult() {
		whenScoreUnder40();
		whenScoreBelow40();
		return result;
	}

	public boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}
	// Hàm này sẽ Random điểm trong 1 Game cho tới khi được Winer
	public void playRandomToGetWiner() {
		while (!winer.win) {
			if (getRandomBoolean()) {
				server.winScore();
			} else
				reciever.winScore();
			whenScoreUnder40();
			whenScoreBelow40();
		}
	}
}
