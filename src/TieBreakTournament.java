import java.util.ArrayList;

public class TieBreakTournament {
	private ArrayList<TieBreakMatch> matchsTieBreak = new ArrayList<TieBreakMatch>();
	private int matchNumber = 0;
	

	public void createAMatchWith2Player(Player First, Player Sencond) {
		matchsTieBreak.add(new TieBreakMatch(First, Sencond));
		matchNumber++;
	}
	public int getMatchNumber() {
		return matchNumber;
	}
	
	public ArrayList<TieBreakMatch> getMatchTieBreak() {
		return matchsTieBreak;
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
	
	public void playOff() {
		if (matchNumber >= 2) {
			int playOffMatchs = matchNumber;
			matchNumber = 0;
			for (int i = 0; i < playOffMatchs; i++) {
				matchNumber++;
				matchsTieBreak.get(matchNumber - 1).setPlayer1st(
						matchsTieBreak.get(i).returnWinnerOfMatchTieBreak());
						
				i++;
				matchsTieBreak.get(matchNumber - 1).setPlayer2nd(
						matchsTieBreak.get(i).returnWinnerOfMatchTieBreak());
			}
		}

	}
	
	public void playOffRandom() {
		if (matchNumber >= 2) {
			int playOffMatchs = matchNumber;
			matchNumber = 0;
			for (int i = 0; i < playOffMatchs; i++) {
				matchNumber++;
				matchsTieBreak.get(matchNumber - 1).setPlayer1st(
						matchsTieBreak.get(i).returnWinnerOfMatchTieBreakRandom());
				
				i++;
				matchsTieBreak.get(matchNumber - 1).setPlayer2nd(
						matchsTieBreak.get(i).returnWinnerOfMatchTieBreakRandom());
			}
		}

	}
	public void playOffRandom2() {
		if (matchNumber >= 2) {
			int playOffMatchs = matchNumber;
			matchNumber = 0;
			for (int i = 0; i < playOffMatchs; i++) {
				matchNumber++;
				matchsTieBreak.get(matchNumber - 1).setPlayer1st(
						matchsTieBreak.get(i).returnWinnerOfMatchTieBreakRandom());
				
				i++;
				matchsTieBreak.get(matchNumber - 1).setPlayer2nd(
						matchsTieBreak.get(i).returnWinnerOfMatchTieBreakRandom());
			}
		}

	}
	public void playTourRandomToFinal() {
		while(matchNumber>1)
		{
			
			
			playOffRandom();
			for(int i =0 ; i<matchNumber;i++){
//				System.out.println(matchsTieBreak.get(i).getPlayer1st().getName()+":"+matchsTieBreak.get(i).getPlayer2nd().getScore());
			}
			resetTour();
		}
	
	}
	private void resetTour(){
		for(int i = 0 ; i<matchNumber;i++){
			matchsTieBreak.get(i).resetMatch();
		}
	}
	public Player returnChampion() {
		playTourRandomToFinal();
		
		return matchsTieBreak.get(0).returnWinnerOfMatchTieBreakRandom();
		
	}

}
