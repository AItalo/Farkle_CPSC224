import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game {
	//fields
	int score1, score5, score3_1, score3_2, score3_3, score3_4, score3_5, score3_6;
	int finalScore;
	boolean threePair, straight, FH, ofAKind, adding, doubling, setValue, startingThreshold, piggybacking, hotStreak, kickEm, welfare;
	int threePairScore, straightScore, FHScore, setValue4, setValue5, setValue6, startingThresholdScore, kickEmScore;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private Player activePlayer;
	
	ImageIcon die1 = new ImageIcon("src/icon1.png");
	ImageIcon die2 = new ImageIcon("src/icon2.png");
	ImageIcon die3 = new ImageIcon("src/icon3.png");
	ImageIcon die4 = new ImageIcon("src/icon4.png");
	ImageIcon die5 = new ImageIcon("src/icon5.png");
	ImageIcon die6 = new ImageIcon("src/icon6.png");
	
	RuleInterface settings;
	FarkleFrame GUI;
	
	//methods
	
	public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                Game newGame = new Game();
            }
        });
	}
	
	public Game(){
		settings = new RuleInterface(this);
	}
	
	public int getScore1(){
		return score1;
	}
	
	public int getScore5(){
		return score5;
	}
	public int getScore3_1(){
		return score3_1;
	}
	public int getScore3_2(){
		return score3_2;
	}
	public int getScore3_3(){
		return score3_3;
	}
	public int getScore3_4(){
		return score3_4;
	}
	public int getScore3_5(){
		return score3_5;
	}
	public int getScore3_6(){
		return score3_6;
	}
	
	public void setScore1(int score){
		score1 = score;
	}
	
	public void setScore5(int score){
		score5 = score;
	}
	
	public void setScore3_1(int score){
		score3_1 = score;
	}
	
	public void setScore3_2(int score){
		score3_2 = score;
	}
	
	public void setScore3_3(int score){
		score3_3 = score;
	}
	
	public void setScore3_4(int score){
		score3_4 = score;
	}
	
	public void setScore3_5(int score){
		score3_5 = score;
	}
	
	public void setScore3_6(int score){
		score3_6 = score;
	}
	
	public int getFinalScore(){
		return finalScore;
	}
	
	public void setFinalScore(int score){
		finalScore = score;
	}
	
	public boolean getThreePair(){
		return threePair;
	}
	
	public boolean getStraight(){
		return straight;
	}
	
	public boolean getFH(){
		return FH;
	}
	
	public boolean getOfAKind(){
		return ofAKind;
	}
	
	public boolean getAdding(){
		return adding;
	}
	
	public boolean getDoubling(){
		return doubling;
	}
	
	public boolean getSetValue(){
		return setValue;
	}
	
	public boolean getST(){
		return startingThreshold;
	}
	
	public boolean getPiggybacking(){
		return piggybacking;
	}
	
	public boolean getHS(){
		return hotStreak;
	}
	
	public boolean getKickEm(){
		return kickEm;
	}
	
	public boolean getWelfare(){
		return welfare;
	}
	
	public void setThreePair(boolean on){
		threePair = on;
	}
	
	public void setStraight(boolean on){
		straight = on;
	}
	
	public void setFH(boolean on){
		FH = on;
	}
	
	public void setOfAKind(boolean on){
		ofAKind = on;
	}
	
	public int getFourOfAKindScore(int die){
		if (setValue){
			return setValue4;
		} else {
			switch (die){
			case 1: return score3_1*2;
			case 2: return score3_2*2;
			case 3: return score3_3*2;
			case 4: return score3_4*2;
			case 5: return score3_5*2;
			case 6: return score3_6*2;
			default: return 0;
			}
		}			
	}
	
	public int getFiveOfAKindScore(int die){
		if (setValue){
			return setValue5;
		} else if (adding) {
			switch (die){
			case 1: return score3_1*3;
			case 2: return score3_2*3;
			case 3: return score3_3*3;
			case 4: return score3_4*3;
			case 5: return score3_5*3;
			case 6: return score3_6*3;
			default: return 0;
			}
		} else {
			switch (die){
			case 1: return score3_1*4;
			case 2: return score3_2*4;
			case 3: return score3_3*4;
			case 4: return score3_4*4;
			case 5: return score3_5*4;
			case 6: return score3_6*4;
			default: return 0;
			}
		}
	}
	
	public int getSixOfAKindScore(int die){
		if (setValue){
			return setValue6;
		} else if (adding) {
			switch (die){
			case 1: return score3_1*4;
			case 2: return score3_2*4;
			case 3: return score3_3*4;
			case 4: return score3_4*4;
			case 5: return score3_5*4;
			case 6: return score3_6*4;
			default: return 0;
			}
		} else {
			switch (die){
			case 1: return score3_1*8;
			case 2: return score3_2*8;
			case 3: return score3_3*8;
			case 4: return score3_4*8;
			case 5: return score3_5*8;
			case 6: return score3_6*8;
			default: return 0;
			}
		}
	}
	
	public void setAdding(boolean on){
		adding = on;
	}
	
	public void setDoubling(boolean on){
		doubling = on;
	}
	
	public void setSetValue(boolean on){
		setValue = on;
	}
	
	public void setST(boolean on){
		startingThreshold = on;
	}
	
	public void setPiggybacking(boolean on){
		piggybacking = on;
	}
	
	public void setHS(boolean on){
		hotStreak = on;
	}
	
	public void setKickEm(boolean on){
		kickEm = on;
	}
	
	public void setWelfare(boolean on){
		welfare = on;
	}
	
	public int getThreePairScore(){
		return threePairScore;
	}
	
	public void setThreePairScore(int score){
		threePairScore = score;
	}
	
	public int getStraightScore(){
		return straightScore;
	}
	
	public void setStraightScore(int score){
		straightScore = score;
	}
	
	public int getFHScore(){
		return FHScore;
	}
	
	public void setFHScore(int score){
		FHScore = score;
	}
	
	public int getSetValue4(){
		return setValue4;
	}
	
	public void setSetValue4(int score){
		setValue4 = score;
	}
	
	public int getSetValue5(){
		return setValue5;
	}
	
	public void setSetValue5(int score){
		setValue5 = score;
	}
	
	public int getSetValue6(){
		return setValue6;
	}
	
	public void setSetValue6(int score){
		setValue6 = score;
	}
	
	public int getSTScore(){
		return startingThresholdScore;
	}
	
	public void setSTScore(int score){
		startingThresholdScore = score;
	}
	
	public int getKickEmScore(){
		return kickEmScore;
	}
	
	public void setKickEmScore(int score){
		kickEmScore = score;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}
	
	public Player getActivePlayer(){
		return activePlayer;
	}
	
	public void addPlayers(ArrayList<String> names){
		for (String name : names){
			players.add(new Player(name));
		}
	}
	
	public void launchGame(){
		activePlayer = players.get(0);
		GUI = new FarkleFrame(this);
		
	}
	
	//subclasses

}
