import java.util.ArrayList;
import java.util.Random;

public class Match {
	private ArrayList<Set> sets = new ArrayList<Set>();
	private int setNumber = 0;
	private int setsPlayer1Win = 0;
	private int setsPlayer2Win = 0;
	private Player player1st = new Player();
	private Player player2nd = new Player();

	public Match() {
		super();
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

	public ArrayList<Set> getSets() {
		return sets;
	}

	public void printConsole() {
		System.out.println("_________Match: " + this.player1st.getName() + "="
				+ this.player1st.getScore() + ";" + this.player2nd.getName()
				+ "=" + this.player2nd.getScore());
	}

	public void player1stWinASetWithRandomScore() {
		if (!conditionEndMatch()) {
			if (setNumber >= 1) {
				if (sets.get(setNumber - 1).isPlayer1ServeInLastGame()) {
					Set s = new Set(player2nd, player1st);
					sets.add(s);
					while (!sets.get(setNumber).getPlayer2nd().isWin())
						sets.get(setNumber).playRanDomSet();
				} else {
					Set s = new Set(player1st, player2nd);
					sets.add(s);
					while (!sets.get(setNumber).getPlayer1st().isWin())
						sets.get(setNumber).playRanDomSet();
				}
			} else {
				Set s = new Set(player1st, player2nd);
				sets.add(s);
				while (!sets.get(setNumber).getPlayer1st().isWin())
					sets.get(setNumber).playRanDomSet();
			}
			setsPlayer1Win++;

			player1st.setScore(Integer.toString(setsPlayer1Win));
			player2nd.setScore(Integer.toString(setsPlayer2Win));
			setNumber++;
			printConsole();
		}
		if (conditionEndMatch()) {
			printConsole();
			System.out
					.println("_________End match--------------------------------");
		}
	}

	public void player2ndWinASetWithRandomScore() {
		if (!conditionEndMatch()) {
			if (setNumber >= 1) {
				if (sets.get(setNumber - 1).isPlayer1ServeInLastGame()) {
					Set s = new Set(player2nd, player1st);
					sets.add(s);
					while (!sets.get(setNumber).getPlayer1st().isWin())
						sets.get(setNumber).playRanDomSet();
				} else {
					Set s = new Set(player1st, player2nd);
					sets.add(s);
					while (!sets.get(setNumber).getPlayer2nd().isWin())
						sets.get(setNumber).playRanDomSet();
				}
			} else {
				Set s = new Set(player1st, player2nd);
				sets.add(s);
				while (!sets.get(setNumber).getPlayer2nd().isWin())
					sets.get(setNumber).playRanDomSet();
			}
			setsPlayer2Win++;
			player1st.setScore(Integer.toString(setsPlayer1Win));
			player2nd.setScore(Integer.toString(setsPlayer2Win));
			setNumber++;
			printConsole();
		}
		if (conditionEndMatch()) {
			printConsole();
			System.out
					.println("_________End match--------------------------------");
		}
	}

	public String printResultOfMatch() {
		return player1st.getName() + "=" + player1st.getScore() + ";"
				+ player2nd.getName() + "=" + player2nd.getScore();
	}

	public String printWinnerOfMatch() {
		return returnWinnerOfMatch().getName();
	}

	private Player returnWinnerOfMatch() {
		Player winnerOfMatch = new Player("winnerOfMatch");
		if (player1st.isWin()) {
			winnerOfMatch = player1st;
			player1st.addNumberMatchWin();
		}
		if (player2nd.isWin()) {
			winnerOfMatch = player2nd;
			player2nd.addNumberMatchWin();
		}
		return winnerOfMatch;
	}

	private Boolean conditionEndMatch() {
		Boolean con = false;
		if (setsPlayer1Win == 2) {
			con = true;
			player1st.setScore("Win");
			player1st.setWin(true);
		}
		if (setsPlayer2Win == 2) {
			con = true;
			player2nd.setScore("Win");
			player2nd.setWin(true);
		}

		return con;
	}

	public Player playAndReturnWinerOfMatchRandom() {
		playMatchRandom();
		return returnWinnerOfMatch();
	}

	// public Player returnWinnerOfMatchRandom() {
	// playMatchRandom();
	// return returnWinnerOfMatch();
	// }

	public void resetMatch() {
		setsPlayer1Win = 0;
		setsPlayer2Win = 0;
		setNumber = 0;
		sets.clear();
	}

	public void playMatchRandom() {
		System.out
				.println("_________Start match--------------------------------");
		resetMatch();
		Random r = new Random();
		while (!conditionEndMatch()) {
			if (r.nextBoolean())
				player1stWinASetWithRandomScore();
			else
				player2ndWinASetWithRandomScore();
		}
		// if(conditionEndMatch()) {
		// printConsole();
		// System.out.println("End match--------------------------------");
		// }
	}
}
