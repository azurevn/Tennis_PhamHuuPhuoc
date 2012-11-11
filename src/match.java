import java.util.ArrayList;

public class match {

	ArrayList<set> sets = new ArrayList<set>();
	int setNumber = 0;
	int setsPlayer1Win = 0;
	int setsPlayer2Win = 0;

	public match() {
		super();
		// TODO Auto-generated constructor stub
	}

	public match(ArrayList<set> sets) {
		super();
		this.sets = sets;
	}

	public ArrayList<set> getSets() {
		return sets;
	}

	public void setSets(ArrayList<set> sets) {
		this.sets = sets;
	}

	public String printWinnerOfMatch() {
		String result = "";
		if (setsPlayer1Win == 2 && setsPlayer2Win < 2)
			result = "player1";
		if (setsPlayer2Win == 2 && setsPlayer1Win < 2)
			result = "player2";
		return result;
	}
	public String printResultOfMatch() {
		String result = "player1="+String.valueOf(setsPlayer1Win)+";player2="+String.valueOf(setsPlayer2Win);
		if (setsPlayer1Win == 2 && setsPlayer2Win < 2)
			result+= ";Winner=player1";
		if (setsPlayer2Win == 2 && setsPlayer1Win < 2)
			result+= ";Winner=player2";
		return result;
	}

	public void player1WinASet() {
		set s = new set();
		sets.add(setNumber, s);
		sets.get(setNumber).setPlayer1WinSetWithRandomScore();
		setsPlayer1Win++;
		
	}

	public void player2WinASet() {
		set s = new set();
		sets.add(setNumber, s);
		sets.get(setNumber).setPlayer2WinSetWithRandomScore();
		setsPlayer2Win++;

	}

}
