import java.util.ArrayList;

public class Tournament {
	ArrayList<Match> matchs = new ArrayList<Match>();
	int matchNumber = 0;

	public Tournament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tournament(ArrayList<Match> matchs) {
		super();
		this.matchs = matchs;
	}

	public Player returnChampionRandom() {
		while(matchNumber>1){
			playOffRandom();
			resetPlayerWin();
		}		
		return  matchs.get(0).returnWinnerOfMatchRandom();

	}

	public void createAMatchWith2Player(Player First, Player Sencond) {
		matchs.add(new Match(First, Sencond));
		matchNumber++;
	}
	public void createTourWithNumberPlayer(int numberPlayer){
		for(int i = 1; i<=numberPlayer;i++){
			String player1stname = "player"+i;
			Player player1st = new Player(player1stname);
			i++;
			String player2ndname = "player"+i;
			Player player2nd = new Player(player2ndname);
			createAMatchWith2Player(player1st, player2nd);
		}
			
	}

	public void createTour() {
		
		Player player1 = new Player("p1");
		Player player2 = new Player("p2");
		matchs.add(new Match());
		matchs.get(matchNumber).setPlayer1st(player1);
		matchs.get(matchNumber).setPlayer2nd(player2);

		matchNumber++;
		Player player3 = new Player("p3");
		Player player4 = new Player("p4");
		matchs.add(new Match());
		matchs.get(matchNumber).setPlayer1st(player3);
		matchs.get(matchNumber).setPlayer2nd(player4);

		matchNumber++;
		Player player5 = new Player("p5");
		Player player6 = new Player("p6");
		matchs.add(new Match());
		matchs.get(matchNumber).setPlayer1st(player5);
		matchs.get(matchNumber).setPlayer2nd(player6);

		matchNumber++;
		Player player7 = new Player("p7");
		Player player8 = new Player("p8");
		matchs.add(new Match());
		matchs.get(matchNumber).setPlayer1st(player7);
		matchs.get(matchNumber).setPlayer2nd(player8);

		matchNumber++;
		Player player9 = new Player("p9");
		Player player10 = new Player("p10");
		matchs.add(new Match());
		matchs.get(matchNumber).setPlayer1st(player9);
		matchs.get(matchNumber).setPlayer2nd(player10);

		matchNumber++;
		Player player11 = new Player("p11");
		Player player12 = new Player("p12");
		matchs.add(new Match());
		matchs.get(matchNumber).setPlayer1st(player11);
		matchs.get(matchNumber).setPlayer2nd(player12);

		matchNumber++;
		Player player13 = new Player("p13");
		Player player14 = new Player("p14");
		matchs.add(new Match());
		matchs.get(matchNumber).setPlayer1st(player13);
		matchs.get(matchNumber).setPlayer2nd(player14);

		matchNumber++;
		Player player15 = new Player("p15");
		Player player16 = new Player("p16");
		matchs.add(new Match());
		matchs.get(matchNumber).setPlayer1st(player15);
		matchs.get(matchNumber).setPlayer2nd(player16);

	}

	public ArrayList<Match> getMatchs() {
		return matchs;
	}



	public void playOff() {
		if (matchNumber >= 2) {
			int playOffMatchs = matchNumber;
			matchNumber = 0;
			for (int i = 0; i < playOffMatchs; i++) {
				matchNumber++;
				matchs.get(matchNumber - 1).setPlayer1st(
						matchs.get(i).returnWinnerOfMatch());
				i++;
				matchs.get(matchNumber - 1).setPlayer2nd(
						matchs.get(i).returnWinnerOfMatch());
			}
		}

	}
	public void resetPlayerWin(){
		for(int i = 0 ; i<matchNumber;i++){
			matchs.get(i).setsPlayer1Win=0;
			matchs.get(i).setsPlayer2Win=0;
		}
	}

	public void playOffRandom() {
		if (matchNumber >= 2) {
			int playOffMatchs = matchNumber;
			matchNumber = 0;
			for (int i = 0; i < playOffMatchs; i++) {
				matchNumber++;			
				matchs.get(matchNumber - 1).setPlayer1st(
						matchs.get(i).returnWinnerOfMatchRandom());
				i++;	
				matchs.get(matchNumber - 1).setPlayer2nd(
						matchs.get(i).returnWinnerOfMatchRandom());
			}
		}
	}

	public void playTourRandom() {
		while (matchNumber>1) {
			playOffRandom();
			resetPlayerWin();
		}
	}

	public void setFirstPlayerWinMatch(int matchNumber) {
		matchs.get(matchNumber).player1WinASet();
		matchs.get(matchNumber).player1WinASet();
	}
	public void setMatchs(ArrayList<Match> matchs) {
		this.matchs = matchs;
	}

	public void setSecondPlayerWinMatch(int matchNumber) {
		matchs.get(matchNumber).player2WinASet();
		matchs.get(matchNumber).player2WinASet();
	}

	

}
