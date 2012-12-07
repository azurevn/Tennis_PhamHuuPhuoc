public class Player {
	 String name = null;
	 int score = 0;
	 String advantage = "40";
	 boolean win = false;
	public Player() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Player(int score) {
		super();
		this.score = score;
	}
	public Player(String s) {
        name = s;
    }
	public String getScore() {
		String convert = "0";

		if (score == 1)
			convert = "15";
		if (score == 2)
			convert = "30";
		if (score == 3)
			convert = "40";
		if (score == 4)
			convert = "A";
		if (score == 5)
			convert = "Win";

		return convert;
	}

	public void reset(){
		score = 0;
		advantage = "40";
		win = false;
		
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setScore(String score) {
		if (score == "0")
			this.score = 0;
		if (score == "15")
			this.score = 1;
		if (score == "30")
			this.score = 2;
		if (score == "40")
			this.score = 3;
		if (score == "A")
			this.score = 4;

	}

	
	public void winScore() {
		if (score < 5)
			score++;
		

	}
}
