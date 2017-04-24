import java.util.*;
import java.util.Arrays;

public class FarkleHand {

	//fields

	private FarkleDie[] hand = new FarkleDie[6];
	int turnScore;
	
	//methods 
	
	public FarkleHand(){
		for(int i = 0; i < 6; i++){
			hand[i] = new FarkleDie();
		}
		turnScore = 0;
	}
	
	public void rollHand(){
		for (FarkleDie die : hand){
			if(!die.getKept()){
				die.roll();
			}
		}
	}
	
	public FarkleDie[] getHand(){
		return hand;
	}
	

	
	public int getScore(){
		return turnScore;
	}
	
	public void addTurnScore(int score){
		turnScore += score;
	}
	
}