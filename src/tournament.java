import java.util.ArrayList;

public class tournament {
	ArrayList<match> matchs = new ArrayList<match>();
	int matchNumber = 0;

	public tournament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public tournament(ArrayList<match> matchs) {
		super();
		this.matchs = matchs;
	}

	public ArrayList<match> getMatchs() {
		return matchs;
	}

	public void setMatchs(ArrayList<match> matchs) {
		this.matchs = matchs;
	}

	public void setFirstPlayerWinMatch(int matchNumber) {
		matchs.get(matchNumber).player1WinASet();
		matchs.get(matchNumber).player1WinASet();
	}

	public void setSecondPlayerWinMatch(int matchNumber) {
		matchs.get(matchNumber).player2WinASet();
		matchs.get(matchNumber).player2WinASet();
	}
	public void createAMatchWith2Player(player First, player Sencond){
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(First);
		matchs.get(matchNumber).setSecondPlayer(Sencond);
		matchNumber++;
	}
	
	public void createTour() {
		player player1 = new player();
		player player2 = new player();
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(player1);
		matchs.get(matchNumber).setSecondPlayer(player2);
		matchNumber++;
		
		player player3 = new player();
		player player4 = new player();
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(player3);
		matchs.get(matchNumber).setSecondPlayer(player4);
		matchNumber++;
		
		player player5 = new player();
		player player6 = new player();
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(player5);
		matchs.get(matchNumber).setSecondPlayer(player6);
		matchNumber++;
		
		player player7 = new player();
		player player8 = new player();
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(player7);
		matchs.get(matchNumber).setSecondPlayer(player8);
		matchNumber++;
		
		player player9 = new player();
		player player10 = new player();
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(player9);
		matchs.get(matchNumber).setSecondPlayer(player10);
		matchNumber++;
		
		player player11 = new player();
		player player12 = new player();
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(player11);
		matchs.get(matchNumber).setSecondPlayer(player12);
		matchNumber++;
		
		player player13 = new player();
		player player14 = new player();
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(player13);
		matchs.get(matchNumber).setSecondPlayer(player14);
		matchNumber++;
		
		player player15 = new player();
		player player16 = new player();
		matchs.add(new match());
		matchs.get(matchNumber).setFirstPlayer(player15);
		matchs.get(matchNumber).setSecondPlayer(player16);
		matchNumber++;
	}

	public void playOff() {
		if (matchNumber >= 2) {
			int playOffMatchs = matchNumber;
			matchNumber = 0;
			for (int i = 0; i <= playOffMatchs; i++) {
				matchs.get(matchNumber).setFirstPlayer(
						matchs.get(i).returnWinnerOfMatch());
				i++;
				matchs.get(matchNumber).setSecondPlayer(
						matchs.get(i).returnWinnerOfMatch());
				matchNumber++;
			}
		}

	}
	
	public player champion(){
		player champion = new player();
		if(matchNumber==1)
			champion = matchs.get(0).returnWinnerOfMatch();
		return champion;
		
	}

}
