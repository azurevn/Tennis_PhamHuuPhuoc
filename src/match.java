import java.util.ArrayList;

public class match {

	ArrayList<set> sets = new ArrayList<set>();

	int setNumber = 0;

	int setsPlayer1Win = 0;

	int setsPlayer2Win = 0;

	player player1 = new player();
	player player2 = new player();

	public match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public match(ArrayList<set> sets) {
		super();
		this.sets = sets;
	}

	public player getPlayer1() {
		return player1;
	}

	public player getPlayer2() {
		return player2;
	}

	public ArrayList<set> getSets() {
		return sets;
	}

	public void player1WinASet() {
		set s = new set();
		sets.add(setNumber, s);
		sets.get(setNumber).setPlayer1(player1);
		sets.get(setNumber).setPlayer1WinSetWithRandomScore();
		setsPlayer1Win++;
		setNumber++;

	}

	public void player2WinASet() {
		set s = new set();
		sets.add(setNumber, s);
		sets.get(setNumber).setPlayer2(player2);
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

	public player returnWinnerOfMatch() {
		player winnerOfMatch = new player();
		if (setsPlayer1Win == 2)
			winnerOfMatch = player1;
		if (setsPlayer2Win == 2)
			winnerOfMatch = player2;
		return winnerOfMatch;
	}

	public void setFirstPlayer(player player1) {
		this.player1 = player1;
	}

	public void setSecondPlayer(player player2) {
		this.player2 = player2;
	}

	public void setSets(ArrayList<set> sets) {
		this.sets = sets;
	}

}
