import java.util.ArrayList;


public class tournament {
	ArrayList<match> matchs = new ArrayList<match>();

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
	
}
