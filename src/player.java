public class Player {
	private String name = null;
	private String score = "0";
	private boolean win = false;
	private int numberMatchWin = 0;

	public int getNumberMatchWin() {
		return numberMatchWin;
	}
	public void addNumberMatchWin() {
		numberMatchWin++;
	}
	public Player() {
		super();

	}
	public Player(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

	public String getScore() {
		return score;
	}

	public boolean isWin() {
		return win;
	}

	public void reset() {
		
		score = "0";
		win = false;
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

}
