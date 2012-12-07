import java.util.ArrayList;
import java.util.Random;

public class Match {
	ArrayList<Set> sets = new ArrayList<Set>();
	int setNumber = 0;
	int setsPlayer1Win = 0;
	int setsPlayer2Win = 0;
	Player player1st = new Player();
	Player player2nd = new Player();
	public Match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Match(ArrayList<Set> sets) {
		super();
		this.sets = sets;
	}

	public Match(Player player1st, Player player2nd) {
		this.player1st = player1st;
		this.player2nd = player2nd;
	}

	public Player getPlayer1st() {
		return player1st;
	}

	public Player getPlayer2nd() {
		return player2nd;
	}
	public void setPlayer1st(Player player1) {
		this.player1st = player1;
	}

	public void setPlayer2nd(Player player2) {
		this.player2nd = player2;
	}

	public void setSets(ArrayList<Set> sets) {
		this.sets = sets;
	}

	public boolean getRandomBoolean() {
		Random random = new Random();
		return random.nextBoolean();
	}

	public ArrayList<Set> getSets() {
		return sets;
	}

	
	public void player1WinASet() {
		Set s = new Set();
		sets.add(setNumber, s);
		sets.get(setNumber).setPlayer1st(player1st);
		sets.get(setNumber).setPlayer1WinSetWithRandomScore();
		setsPlayer1Win++;
		setNumber++;
	}

	public void player2WinASet() {
		Set s = new Set();
		sets.add(setNumber, s);
		sets.get(setNumber).setPlayer2(player2nd);
		sets.get(setNumber).setPlayer2WinSetWithRandomScore();
		setsPlayer2Win++;
		setNumber++;

	}

	public String printResultOfMatch() {
		String result = "player1=" + String.valueOf(setsPlayer1Win)
				+ ";player2=" + String.valueOf(setsPlayer2Win);
		if (setsPlayer1Win == 2 && setsPlayer2Win < 2)
			result += ";Winner=player1";
		if (setsPlayer2Win == 2 && setsPlayer1Win < 2)
			result += ";Winner=player2";
		return result;
	}

	public String printWinnerOfMatch() {
		String result = "";
		if (setsPlayer1Win == 2 && setsPlayer2Win < 2)
			result = "player1";
		if (setsPlayer2Win == 2 && setsPlayer1Win < 2)
			result = "player2";
		return result;
	}
	
	public Player returnWinnerOfMatch() {
		Player winnerOfMatch = new Player("winnerOfMatch");
		if (setsPlayer1Win == 2)
			winnerOfMatch = player1st;
		if (setsPlayer2Win == 2)
			winnerOfMatch = player2nd;
		return winnerOfMatch;
	}
	
	public Player returnWinnerOfMatchRandom(){
		if(getRandomBoolean()){
			player1WinASet();
			player1WinASet();
		}
		else
		{
			player2WinASet();
			player2WinASet();
		}
		return returnWinnerOfMatch();
	}



}
