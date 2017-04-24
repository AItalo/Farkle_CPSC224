import java.util.*;

public class FarkleScoringOpt  {

	//fields
	FarkleHand rawHand;
	int[] rolledHand;
	int[] keptHand;
	Game game;
	
	//these functions are in order. I am able to make it so you guys know exactly what array positions must be turned to kept/unkept. Just create those attributes
	//the first part of the function detects if it is false, and in that case, does nothing. If it is true, the true will be returned after all the right attributes are set
	//and the total increased.
	//Important- Notice that we still need to check essentially every attribute of the array of die objects to make sure they are unkept as part of the algorithm
	//To avoid adding this code, which is actually really convoluted, I advise that you just pass a new hand where you just detect which ones are unkept so that
	//attribute doesnt need to be checked every single time.
	//other than that, all that is missing is the while loop, which goes through the functions in the order I wrote. 
	
	
	//methods
	public FarkleScoringOpt(FarkleHand unsortedHand, Game top){
		game = top;
		rawHand = unsortedHand;
	}
	
	public void createRolledHand(){
		int i = 0;
		for (FarkleDie die : rawHand.getHand()){
			if(!die.getKept()){
				i++;
			}
		}
		rolledHand = new int[i];
		i = 0;
		for (FarkleDie die : rawHand.getHand()){
			if(!die.getKept()){
				rolledHand[i] = die.getFaceup();
				i++;
			}
		}
		sortHand(rolledHand);
	}
	
	public void createKeptHand(){
		int i = 0;
		for (FarkleDie die : rawHand.getHand()){
			if(die.getKept() && !die.getScored()){
				i++;
			}
		}
		keptHand = new int[i];
		i = 0;
		for (FarkleDie die : rawHand.getHand()){
			if(die.getKept() && !die.getScored()){
				keptHand[i] = die.getFaceup();
				i++;
			}
		}
		sortHand(keptHand);
	}
	
	public int[] getRolledHand(){
		return rolledHand;
	}
	
	public int[] getKeptHand(){
		return keptHand;
	}
	
	public void sortHand(int[] hand_i){		
		   boolean swap;
		   int temp;
		   do
		   {
		      swap = false;
		      for (int i = 0; i < hand_i.length - 1; i++)
		      {
		         if (hand_i[i] > hand_i[i + 1])
		         {
		            temp = hand_i[i];
		            hand_i[i] = hand_i[i + 1];
		            hand_i[i + 1] = temp;
		            swap = true;
		         }
		      }
		   } while (swap);
	}
	
	
	public boolean straightExists(int[] hand){
		if(hand.length < 6){
			return false;
		}
		for(int i=1;i<7;i++){
			if (frequency(hand, i)!=1)
				return false;
		}
		return true;
	}
	
	
	public boolean threePairsExists(int[] hand){
		if(hand.length < 6){
			return false;
		}
		int t = 0;
		for(int i = 0; i<6; i+=2 ){
			if (hand[i] == hand[i+1])
				t=t+1;
		}
		if(t!=3){
			return false;
		}
		return true;
	}
	
	
	public boolean sixOfAKindExists(int[] hand){
		if(hand.length < 6){
			return false;
		}
		if (hand[0] != hand[5]){
			return false;
		}
		return true;
	}
	
	public boolean fullHouseExists(int[] hand){
		if(hand.length < 5){
			return false;
		}
		boolean found2K = false;
		boolean found3K = false;
		for (int die : hand){
			if (frequency(hand, die) == 2){
				found2K = true;
			}
			if (frequency(hand, die) == 3){
				found3K = true;
			}
			if (found2K && found3K){
				return true;
			}
		}
		return false;
	}
		
//		if(v+u<2)
//			return false;//now proceeds to find which dice is the unkept one
//		int a;
//		for (int i=1;i<7;i++){
//			if(frequency(hand,i) == 1){
//				a=i;
//				for(int x=0;x<6;x++){
//					if (hand[x]==a){
//						//insert code which changes all hand attributes to iskept except for hand[x]
//						turntotal=turntotal+300;
//						return true;
//					}
//				}}
//			else{
//				//this is the case where we have 2 threes. In that case, ANY 5 of hand attributes can be changed to iskept. (222333)will be a full house for any 5
//				//insert code which changes all hand attributes except for any one (maybe the last one) to iskept
//				turntotal=turntotal+300;
//				return true;//for loop is aborted prematurely		
//				}
//			
//		}
//		return true;//will never be ran but is still necessary
//			}
//	
	
	
	public boolean fiveOfAKindExists(int[] hand){
		if(hand.length < 5){
			return false;
		}
		for (int die : hand){
			if (frequency(hand, die) == 5){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean fourOfAKindExists(int[] hand){
		if(hand.length < 4){
			return false;
		}
		for (int die : hand){
			if (frequency(hand, die) == 4){
				return true;
			}
		}
		return false;
	}
	
	public boolean threeOfAKindExists(int[] hand){
		if(hand.length < 3){
			return false;
		}
		for (int die : hand){
			if (frequency(hand, die) == 3){
				return true;
			}
		}
		return false;
	}
	
	public boolean oneExists(int[] hand){
		if (frequency(hand, 1) != 0){
			return true;
		}
		return false;
	}
	
	public boolean fiveExists(int[] hand){
		if (frequency(hand, 5) != 0){
			return true;
		}
		return false;
	}
	
//	public void scoringoptions(){
//		for(int i = 0; i < 6; i++){
//			if (threes[i] == true)
//				System.out.println("score 3" + i + 's');
//			 	
//		}
//		for(int x = 0; x < 2; x++){
//			if (ones[x] == true)
//				System.out.println("score 1" + x);
//		}
//	}
//	
//	public void choosescore(){
//		for(int i = 0; i<6; i++){
//			if (threes[i]==true){
//				farkle = false;
//				System.out.println("test");
//		}
//		//if user farkled, then score is set to 0 and nothing happens
//		//this function will run the functions sc1 and sc3 again, but with the new hand, after the user has selected a scoring option
//		//that the way the user can select more than 1 scoring option per hand. if there are 0 scoring options, the user may 
//		//choose to roll a new hand and begin the process again
//		}}
//	
//	public boolean farkled(){
//		for(int i = 0; i<6; i++){
//			if (threes[i]== true) 
//			    farkle = false;
//		for(i = 0;i<2;i++){
//			if (ones[i]== true) 
//			    farkle = false;
//			}
//		for(i = 0;i<6;i++){
//			if (hscores[i]== true) 
//			    farkle = false;
//			}
//		}
//		return farkle;
//	}
	
	
	public int frequency(int[] hand, int a){
		int f=0;
		for(int g=0;g<hand.length;g++){
			if(hand[g]==a)
				f++;
		}
		return f;
	}
	
	
	public boolean isScorable(int[] hand){
		if (game.getST() && straightExists(hand)){
			return true;
		}
		if (game.getThreePair() && threePairsExists(hand)){
			return true;
		}
		if (game.getOfAKind() && (fourOfAKindExists(hand) || fiveOfAKindExists(hand) || sixOfAKindExists(hand))){
			return true;
		}
		if (game.getFH() && fullHouseExists(hand)){
			return true;
		}
		if (threeOfAKindExists(hand) || oneExists(hand) || fiveExists(hand)){
			return true;
		}
		return false;
	}
	

	public boolean scoreHand(int[] hand){
		//returns true if successfully scored; false if not

		//scores of 6 dice; all dice scored
		if (game.getStraight() && straightExists(hand)){
			for (FarkleDie die : rawHand.getHand()){
				die.setScored(true);
			}
			rawHand.addTurnScore(game.getStraightScore());
			return true;
		}
		if (game.getThreePair() && threePairsExists(hand)){
			for (FarkleDie die : rawHand.getHand()){
				die.setScored(true);
			}
			rawHand.addTurnScore(game.getThreePairScore());
			return true;
		}
		if (game.getOfAKind() && sixOfAKindExists(hand)){
			for (FarkleDie die : rawHand.getHand()){
				die.setScored(true);
			}
			rawHand.addTurnScore(game.getSixOfAKindScore(hand[0]));
			return true;
		}
		
		//scores of 5 dice; must also check if remaining die is 1 or 5	
		if (game.getFH() && fullHouseExists(hand)){
			if(hand.length == 5){
				for (FarkleDie die : rawHand.getHand()){
					if (die.getKept()){
						die.setScored(true);
					}
				}
				int threes = 0;
				for (int i = 1; i < 7; i++){
					if (frequency(hand, i) == 3){
						threes = i;
					}
				}
				switch (threes){
				case 1:
					rawHand.addTurnScore(game.getScore3_1());
					break;
				case 2:
					rawHand.addTurnScore(game.getScore3_2());
					break;
				case 3:
					rawHand.addTurnScore(game.getScore3_3());
					break;
				case 4:
					rawHand.addTurnScore(game.getScore3_4());
					break;
				case 5:
					rawHand.addTurnScore(game.getScore3_5());
					break;
				case 6:
					rawHand.addTurnScore(game.getScore3_6());
					break;
				}
				rawHand.addTurnScore(game.getFHScore());
				return true;
			} else {
				int[] ghostArray = new int[1];
				for (int die : hand){
					if (frequency(hand, die) == 1){
						ghostArray[0] = die;
					}
				}
				if(scoreHand(ghostArray)){
					for (FarkleDie die : rawHand.getHand()){
						die.setScored(true);
					}
					int threes = 0;
					for (int i = 1; i < 7; i++){
						if (frequency(hand, i) == 3){
							threes = i;
						}
					}
					switch (threes){
					case 1:
						rawHand.addTurnScore(game.getScore3_1());
						break;
					case 2:
						rawHand.addTurnScore(game.getScore3_2());
						break;
					case 3:
						rawHand.addTurnScore(game.getScore3_3());
						break;
					case 4:
						rawHand.addTurnScore(game.getScore3_4());
						break;
					case 5:
						rawHand.addTurnScore(game.getScore3_5());
						break;
					case 6:
						rawHand.addTurnScore(game.getScore3_6());
						break;
					}
					rawHand.addTurnScore(game.getFHScore());
					return true;
				}
			}
		}
		if (game.getOfAKind() && fiveOfAKindExists(hand)){
			if(hand.length == 5){
				for (FarkleDie die : rawHand.getHand()){
					if (die.getKept()){
						die.setScored(true);
					}
				}
				rawHand.addTurnScore(game.getFiveOfAKindScore(hand[0]));
				return true;
			} else {
				int[] ghostArray = new int[1];
				for (int die : hand){
					if (frequency(hand, die) == 1){
						ghostArray[0] = die;
					}
				}
				if (scoreHand(ghostArray)){
					for (int die : hand){
						if (frequency(hand, die) == 5){
							rawHand.addTurnScore(game.getFiveOfAKindScore(die));
							for(FarkleDie dice : rawHand.getHand()){
								if(dice.getKept()){
									dice.setScored(true);
								}
							}
							return true;
						}
					}
				}
			}
		}
		
		// scores of 4 dice, must check other 2
		
		if (game.getOfAKind() && fourOfAKindExists(hand)){
			if(hand.length == 4){
				for (FarkleDie die : rawHand.getHand()){
					if (die.getKept()){
						die.setScored(true);
					}
				}
				rawHand.addTurnScore(game.getFourOfAKindScore(hand[0]));
				return true;
			} else {
				int[] ghostArray = new int[hand.length - 4];
				int i = 0;
				for (int die : hand){
					if (frequency(hand, die) != 4){
						ghostArray[i] = die;
						i++;
					}
				}
				if (scoreHand(ghostArray)){
					for (int die : hand){
						if (frequency(hand, die) == 4){
							rawHand.addTurnScore(game.getFourOfAKindScore(die));
							for(FarkleDie dice : rawHand.getHand()){
								if(dice.getKept()){
									dice.setScored(true);
								}
							}
							return true;
						}
					}
				}
			}
		}
		
		// scores of 3 dice, must check other 3
		
		if(threeOfAKindExists(hand)){
			if(hand.length == 3){
				for (FarkleDie die : rawHand.getHand()){
					if (die.getKept()){
						die.setScored(true);
					}
				}
				switch (hand[0]){
				case 1:
					rawHand.addTurnScore(game.getScore3_1());
					break;
				case 2:
					rawHand.addTurnScore(game.getScore3_2());
					break;
				case 3:
					rawHand.addTurnScore(game.getScore3_3());
					break;
				case 4:
					rawHand.addTurnScore(game.getScore3_4());
					break;
				case 5:
					rawHand.addTurnScore(game.getScore3_5());
					break;
				case 6:
					rawHand.addTurnScore(game.getScore3_6());
					break;
				}
				return true;
			} else {
				int[] ghostArray = new int[hand.length - 3];
				int nPull = 0;
				for (int die : hand){
					if (frequency(hand, die) == 3){
						nPull = die;
						break;
					}
				}
				int i = 0;
				for (int die : hand){
					if(die != nPull){
						ghostArray[i] = die;
					}
				}
				if (scoreHand(ghostArray)){
					for (FarkleDie dice : rawHand.getHand()){
						if (dice.getKept() && dice.getFaceup() == nPull){
							dice.setScored(true);
						}
					}
					switch (nPull){
					case 1:
						rawHand.addTurnScore(game.getScore3_1());
						break;
					case 2:
						rawHand.addTurnScore(game.getScore3_2());
						break;
					case 3:
						rawHand.addTurnScore(game.getScore3_3());
						break;
					case 4:
						rawHand.addTurnScore(game.getScore3_4());
						break;
					case 5:
						rawHand.addTurnScore(game.getScore3_5());
						break;
					case 6:
						rawHand.addTurnScore(game.getScore3_6());
						break;
					}
					return true;
				}
			}
		}
		if (oneExists(hand)){
			if (hand.length == 1){
				for (FarkleDie die : rawHand.getHand()){
					if (die.getKept()){
						die.setScored(true);
					}
				}
				rawHand.addTurnScore(game.getScore1());
			} else {
				int[] ghostArray = new int[hand.length - 1];
				boolean oneFound = false;
				int i = 0;
				for (int die : hand){
					if (!oneFound && die == 1){
						oneFound = true;
					} else if (oneFound){
						ghostArray[i] = die;
						i++;
					}
				}
				if (scoreHand(ghostArray)){
					rawHand.addTurnScore(game.getScore1());
					return true;
				}
			}
		}
		if (fiveExists(hand)){
			if (hand.length == 1){
				for (FarkleDie die : rawHand.getHand()){
					if (die.getKept()){
						die.setScored(true);
					}
				}
				rawHand.addTurnScore(game.getScore5());
			} else {
				int[] ghostArray = new int[hand.length - 1];
				boolean fiveFound = false;
				int i = 0;
				for (int die : hand){
					if (!fiveFound && die == 1){
						fiveFound = true;
					} else if (fiveFound){
						ghostArray[i] = die;
						i++;
					}
				}
				if (scoreHand(ghostArray)){
					rawHand.addTurnScore(game.getScore5());
					return true;
				}
			}
		}
		return false;
	}
}