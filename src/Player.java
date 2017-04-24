
public class Player {
	//fields
	
	private String name;
	private int total;
	private FarkleHand hand;
	private int farkles;
	
	//methods
	
	public Player(String name_i){
		name = name_i;
		total = 0;
		farkles = 0;
		hand = new FarkleHand();
	}
	
	public String getName(){
		return name;
	}
	
	public int getScore(){
		return total;
	}
	
	public void incrementScore(int subscore){
		total += subscore;
	}
	
	public void decrementScore(int subscore){
		if (total - subscore >= 0){
			total -= subscore;
		} else {
			total = 0;
		}
	}
	
	public FarkleHand getHand(){
		return hand;
	}
	
	public void setHand(FarkleHand hand_i){
		hand = hand_i;
	}
	
	public void rollFarkle(){
		farkles++;
	}
	
	public void resetFarkles(){
		farkles = 0;
	}
	
	public int getFarkles(){
		return farkles;
	}

}
