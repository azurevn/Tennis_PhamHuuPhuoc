import java.util.ArrayList;

public class Tournament {
	private ArrayList<Match> matchs = new ArrayList<Match>();
	private int matchNumber = 0;
	

	public void createAMatchWith2Player(Player First, Player Sencond) {
		matchs.add(new Match(First, Sencond));
		matchNumber++;
	}

	public void createTour() {
		createTourWithNumberPlayer(16);
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

	public int getMatchNumber() {
		return matchNumber;
	}
	public ArrayList<Match> getMatchs() {
		return matchs;
	}

//	public void playOff() {
//		if (matchNumber >= 2) {
//			int playOffMatchs = matchNumber;
//			matchNumber = 0;
//			for (int i = 0; i < playOffMatchs; i++) {
//				matchNumber++;
//				matchs.get(matchNumber - 1).setPlayer1st(
//						matchs.get(i).returnWinnerOfMatch());
//				i++;
//				matchs.get(matchNumber - 1).setPlayer2nd(
//						matchs.get(i).returnWinnerOfMatch());
//			}
//		}
//
//	}

	public void playOffRandom1Time() {
		if (matchNumber >= 2) {
			int playOffMatchs = matchNumber;
			matchNumber = 0;
			for (int i = 0; i < playOffMatchs; i++) {
				matchNumber++;			
				matchs.get(matchNumber - 1).setPlayer1st(
						matchs.get(i).playAndReturnWinerOfMatchRandom());
				i++;	
				matchs.get(matchNumber - 1).setPlayer2nd(
						matchs.get(i).playAndReturnWinerOfMatchRandom());
			}
		}
	}

	public void playTourRandom() {
		while (matchNumber>1) {
			playOffRandom1Time();
			resetForNextMatch();
		}
	}
	public void resetForNextMatch(){
		for(int i = 0 ; i<matchNumber;i++){
			matchs.get(i).resetMatch();
		}
	}

	public Player playAndReturnChampionRandom() {
		Player Champion = new Player("Champion");
		while(matchNumber>1){
			playOffRandom1Time();
			resetForNextMatch();
		}		
		Champion = matchs.get(0).playAndReturnWinerOfMatchRandom();
		System.out.print("#### Champion is " + Champion.getName() + " With " + Champion.getNumberMatchWin() + " Matchs Win");
		return  Champion;
		
	}
	

	public void setMatchNumber(int matchNumber) {
		this.matchNumber = matchNumber;
	}

	public void setMatchs(ArrayList<Match> matchs) {
		this.matchs = matchs;
	}
//	public void setPlayer1stWinAMatchWithRandomScore(int matchNumber) {
//		matchs.get(matchNumber).player1stWinASetWithRandomScore();
//		matchs.get(matchNumber).player1stWinASetWithRandomScore();
//	}
//
//	public void setPlayer2ndWinAMatchWithRandomScore(int matchNumber) {
//		matchs.get(matchNumber).player2ndWinASetWithRandomScore();
//		matchs.get(matchNumber).player2ndWinASetWithRandomScore();
//	}
}
