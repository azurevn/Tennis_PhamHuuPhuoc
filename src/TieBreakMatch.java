import java.util.ArrayList;
import java.util.Random;

public class TieBreakMatch {
	private ArrayList<TieBreakSet> sets = new ArrayList<TieBreakSet>();
	private int setNumber = 0;
	private int setsPlayer1Win = 0;
	private int setsPlayer2Win = 0;
	private Player player1st = new Player();
	private Player player2nd = new Player();

	public TieBreakMatch(Player player1st, Player player2nd) {
		super();
		this.player1st = player1st;
		this.player2nd = player2nd;
	}

	public Player getPlayer1st() {
		return player1st;
	}

	public Player getPlayer2nd() {
		return player2nd;
	}

	public int getSetNumber() {
		return setNumber;
	}

	public int getSetsPlayer1Win() {
		return setsPlayer1Win;
	}

	public int getSetsPlayer2Win() {
		return setsPlayer2Win;
	}

	public void setPlayer1st(Player player1st) {
		this.player1st = player1st;
	}

	public void setPlayer2nd(Player player2nd) {
		this.player2nd = player2nd;
	}

	public void setSetNumber(int setNumber) {
		this.setNumber = setNumber;
	}

	public void setSetsPlayer1Win(int setsPlayer1Win) {
		this.setsPlayer1Win = setsPlayer1Win;
	}

	public void setSetsPlayer2Win(int setsPlayer2Win) {
		this.setsPlayer2Win = setsPlayer2Win;
	}

	// ///////////////
	public Player getPlayerServeFirstInTieBreak() {
		return sets.get(setNumber - 1).getGameTieBreak().getServer();
	}

	public void setServerReciver() {
		if (setNumber == 0)
			sets.add(new TieBreakSet(player1st, player2nd));
		if (setNumber >= 1) {
			if (getPlayerServeFirstInTieBreak() == player1st)
				sets.add(new TieBreakSet(player2nd, player1st));
			if (getPlayerServeFirstInTieBreak() == player2nd)
				sets.add(new TieBreakSet(player1st, player2nd));
		}
	}

	// //////////////////// Trýong hop không thang bang tiebreak thi ai se là
	// ngýoi giao banh ðau tiên?
	public void player1stWinASet() {
		if (!conditionEndMatch()) {

			sets.add(new TieBreakSet(player1st, player2nd));
			sets.get(setNumber).player1stWinASetTieBreak();
			setsPlayer1Win++;
			setNumber++;
			player1st.setScore(Integer.toString(setsPlayer1Win));
			player2nd.setScore(Integer.toString(setsPlayer2Win));
			
		}
		if (setsPlayer1Win == 2) {
			player1st.setScore("Win");
			player2nd.setScore("Lose");
		}
		
//			System.out.println(player1st.getName()+":"+player1st.getScore()+"-"+player2nd.getName()+":"+player2nd.getScore());
		
	}

	public void player2ndWinASet() {
		if (!conditionEndMatch()) {
			sets.add(new TieBreakSet(player1st, player2nd));
			sets.get(setNumber).player2ndWinASetTieBreak();
			setsPlayer2Win++;
			setNumber++;
			player1st.setScore(Integer.toString(setsPlayer1Win));
			player2nd.setScore(Integer.toString(setsPlayer2Win));
		}
		if (setsPlayer2Win == 2) {
			player1st.setScore("Lose");
			player2nd.setScore("Win");
		}
//		System.out.println(player1st.getName()+":"+player1st.getScore()+"-"+player2nd.getName()+":"+player2nd.getScore());
	}

	public String printMatchResult() {
		
		return player1st.getName() + "=" + player1st.getScore() + ";"
				+ player2nd.getName() + "=" + player2nd.getScore();
	}

	private Boolean conditionEndMatch() {
		Boolean con = false;
		if (setsPlayer1Win == 2) {
			con = true;
			player1st.setScore("Win");
			player2nd.setScore("Lose");
		}
		if (setsPlayer2Win == 2) {
			con = true;
			player1st.setScore("Lose");
			player2nd.setScore("Win");
		}
		return con;
	}

	public Player returnWinnerOfMatchTieBreak() {
		
		Player winerOfMatchTieBreak = new Player("winnerOfMatchTieBreak");
		if (player1st.isWin())
			winerOfMatchTieBreak = player1st;
		if (player2nd.isWin())
			;
		winerOfMatchTieBreak = player2nd;
	
		return winerOfMatchTieBreak;
	}

	public Player returnWinnerOfMatchTieBreakRandom() {
		while (returnWinnerOfMatchTieBreak() == null) {
			Random r = new Random();
			if (r.nextBoolean())
				player1stWinASet();
			else
				player2ndWinASet();
			
		}
		System.out.println(player1st.getName()+":"+player1st.getScore()+"-"+player2nd.getName()+":"+player2nd.getScore());
		return returnWinnerOfMatchTieBreak();
	}

	public void resetMatch() {
		
		setsPlayer1Win = 0;
		setsPlayer2Win = 0;
		setNumber = 0;
		sets.clear();
	}
}
