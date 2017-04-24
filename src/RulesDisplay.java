import javax.swing.*;
import java.awt.*;


public class RulesDisplay extends JPanel {
	//fields

	FarkleFrame top;
	
	//methods

//	public static void main(String[] args) {
//		JFrame test = new JFrame();
//		test.add(new RulesDisplay());
//		test.pack();
//		test.setVisible(true);
//	}
	
	public RulesDisplay(FarkleFrame top_i){
		setLayout(new GridLayout(1,2));
		top = top_i;

		add(new StdRulesDisplay());
		add(new ExtraRulesDisplay());
	}
	
	
	//subclasses
	
	public class StdRulesDisplay extends JPanel {
		ImageIcon die1 = new ImageIcon("src/icon1.png");
		ImageIcon die2 = new ImageIcon("src/icon2.png");
		ImageIcon die3 = new ImageIcon("src/icon3.png");
		ImageIcon die4 = new ImageIcon("src/icon4.png");
		ImageIcon die5 = new ImageIcon("src/icon5.png");
		ImageIcon die6 = new ImageIcon("src/icon6.png");
		
		public StdRulesDisplay(){
			Box format = Box.createVerticalBox();
			format.setAlignmentX(LEFT_ALIGNMENT);
			
			Box line1 = Box.createHorizontalBox();
			line1.setAlignmentX(LEFT_ALIGNMENT);
			Box line2 = Box.createHorizontalBox();
			line2.setAlignmentX(LEFT_ALIGNMENT);
			Box line3 = Box.createHorizontalBox();
			line3.setAlignmentX(LEFT_ALIGNMENT);
			Box line4 = Box.createHorizontalBox();
			line4.setAlignmentX(LEFT_ALIGNMENT);
			Box line5 = Box.createHorizontalBox();
			line5.setAlignmentX(LEFT_ALIGNMENT);
			Box line6 = Box.createHorizontalBox();
			line6.setAlignmentX(LEFT_ALIGNMENT);
			Box line7 = Box.createHorizontalBox();
			line7.setAlignmentX(LEFT_ALIGNMENT);
			Box line8 = Box.createHorizontalBox();
			line8.setAlignmentX(LEFT_ALIGNMENT);
			Box line9 = Box.createHorizontalBox();
			line9.setAlignmentX(LEFT_ALIGNMENT);
			
			line1.add(new JLabel(die1));
			line1.add(Box.createRigidArea(new Dimension(60,0)));
			line1.add(new JLabel(Integer.toString(top.game.getScore1())));
			
			line2.add(new JLabel(die5));
			line2.add(Box.createRigidArea(new Dimension(60,0)));
			line2.add(new JLabel(Integer.toString(top.game.getScore5())));
			
			line3.add(new JLabel(die1));
			line3.add(new JLabel(die1));
			line3.add(new JLabel(die1));
			line3.add(Box.createRigidArea(new Dimension(10,0)));
			line3.add(new JLabel(Integer.toString(top.game.getScore3_1())));
			
			line4.add(new JLabel(die2));
			line4.add(new JLabel(die2));
			line4.add(new JLabel(die2));
			line4.add(Box.createRigidArea(new Dimension(10,0)));
			line4.add(new JLabel(Integer.toString(top.game.getScore3_2())));
			
			line5.add(new JLabel(die3));
			line5.add(new JLabel(die3));
			line5.add(new JLabel(die3));
			line5.add(Box.createRigidArea(new Dimension(10,0)));
			line5.add(new JLabel(Integer.toString(top.game.getScore3_3())));
			
			line6.add(new JLabel(die4));
			line6.add(new JLabel(die4));
			line6.add(new JLabel(die4));
			line6.add(Box.createRigidArea(new Dimension(10,0)));
			line6.add(new JLabel(Integer.toString(top.game.getScore3_4())));
			
			line7.add(new JLabel(die5));
			line7.add(new JLabel(die5));
			line7.add(new JLabel(die5));
			line7.add(Box.createRigidArea(new Dimension(10,0)));
			line7.add(new JLabel(Integer.toString(top.game.getScore3_5())));
			
			line8.add(new JLabel(die6));
			line8.add(new JLabel(die6));
			line8.add(new JLabel(die6));
			line8.add(Box.createRigidArea(new Dimension(10,0)));
			line8.add(new JLabel(Integer.toString(top.game.getScore3_6())));
			
			line9.add(new JLabel("End Score:"));
			line9.add(Box.createRigidArea(new Dimension(23,0)));
			line9.add(new JLabel(Integer.toString(top.game.getFinalScore())));
			
			format.add(line1);
			format.add(Box.createRigidArea(new Dimension(0,10)));
			format.add(line2);
			format.add(Box.createRigidArea(new Dimension(0,10)));
			format.add(line3);
			format.add(Box.createRigidArea(new Dimension(0,10)));
			format.add(line4);
			format.add(Box.createRigidArea(new Dimension(0,10)));
			format.add(line5);
			format.add(Box.createRigidArea(new Dimension(0,10)));
			format.add(line6);
			format.add(Box.createRigidArea(new Dimension(0,10)));
			format.add(line7);
			format.add(Box.createRigidArea(new Dimension(0,10)));
			format.add(line8);
			format.add(Box.createRigidArea(new Dimension(0,10)));
			format.add(line9);
			
			add(format);			
		}
	}
	
	public class ExtraRulesDisplay extends JPanel {
		public ExtraRulesDisplay(){
			Box format = Box.createVerticalBox();
			format.setAlignmentX(LEFT_ALIGNMENT);
			
			if(top.game.getThreePair()){
				Box pairLine = Box.createHorizontalBox();
				pairLine.setAlignmentX(LEFT_ALIGNMENT);
				
				pairLine.add(new JLabel("3 Pairs:"));
				pairLine.add(Box.createRigidArea(new Dimension(75,0)));
				pairLine.add(new JLabel(Integer.toString(top.game.getThreePairScore())));
				
				format.add(pairLine);
				format.add(Box.createRigidArea(new Dimension(0,10)));
			}
			
			if(top.game.getStraight()){
				Box straightLine = Box.createHorizontalBox();
				straightLine.setAlignmentX(LEFT_ALIGNMENT);
				
				straightLine.add(new JLabel("Straight:"));
				straightLine.add(Box.createRigidArea(new Dimension(70,0)));
				straightLine.add(new JLabel(Integer.toString(top.game.getStraightScore())));
				
				format.add(straightLine);
				format.add(Box.createRigidArea(new Dimension(0,10)));
			}
			
			if(top.game.getFH()){
				Box FHLine = Box.createHorizontalBox();
				FHLine.setAlignmentX(LEFT_ALIGNMENT);
				
				FHLine.add(new JLabel("Full House:"));
				FHLine.add(Box.createRigidArea(new Dimension(58,0)));
				FHLine.add(new JLabel(Integer.toString(top.game.getFHScore())));
				
				format.add(FHLine);
				format.add(Box.createRigidArea(new Dimension(0,10)));
			}
			
			if(top.game.getOfAKind()){
				if (!top.game.getSetValue()){
					Box ofAKindLine = Box.createHorizontalBox();
					ofAKindLine.setAlignmentX(LEFT_ALIGNMENT);
					
					ofAKindLine.add(new JLabel("4/5/6 of a Kind:"));
					ofAKindLine.add(Box.createRigidArea(new Dimension(37,0)));
					
					if(top.game.getAdding()){
						ofAKindLine.add(new JLabel("Adding"));
					} else if (top.game.getDoubling()){
						ofAKindLine.add(new JLabel("Doubling"));
					} 
				
					format.add(ofAKindLine);
					format.add(Box.createRigidArea(new Dimension(0,10)));
				} else {
					Box ofAKind4 = Box.createHorizontalBox();
					ofAKind4.setAlignmentX(LEFT_ALIGNMENT);
					Box ofAKind5 = Box.createHorizontalBox();
					ofAKind5.setAlignmentX(LEFT_ALIGNMENT);
					Box ofAKind6 = Box.createHorizontalBox();
					ofAKind6.setAlignmentX(LEFT_ALIGNMENT);
					
					ofAKind4.add(new JLabel("4 of a Kind:"));
					ofAKind4.add(Box.createRigidArea(new Dimension(56,0)));
					ofAKind4.add(new JLabel(Integer.toString(top.game.getSetValue4())));
					
					ofAKind5.add(new JLabel("5 of a Kind:"));
					ofAKind5.add(Box.createRigidArea(new Dimension(56,0)));
					ofAKind5.add(new JLabel(Integer.toString(top.game.getSetValue5())));
					
					ofAKind6.add(new JLabel("6 of a Kind:"));
					ofAKind6.add(Box.createRigidArea(new Dimension(56,0)));
					ofAKind6.add(new JLabel(Integer.toString(top.game.getSetValue6())));
					
					format.add(ofAKind4);
					format.add(Box.createRigidArea(new Dimension(0,10)));
					format.add(ofAKind5);
					format.add(Box.createRigidArea(new Dimension(0,10)));
					format.add(ofAKind6);
					format.add(Box.createRigidArea(new Dimension(0,10)));
				}
			}
			
			if(top.game.getST()){
				Box STLine = Box.createHorizontalBox();
				STLine.setAlignmentX(LEFT_ALIGNMENT);
				
				STLine.add(new JLabel("Starting Threshold:"));
				STLine.add(Box.createRigidArea(new Dimension(10,0)));
				STLine.add(new JLabel(Integer.toString(top.game.getSTScore())));
				
				format.add(STLine);
				format.add(Box.createRigidArea(new Dimension(0,10)));
			}
			
			if(top.game.getPiggybacking()){
				Box piggybackingLine = Box.createHorizontalBox();
				piggybackingLine.setAlignmentX(LEFT_ALIGNMENT);
				
				piggybackingLine.add(new JLabel("Piggybacking"));
				
				format.add(piggybackingLine);
				format.add(Box.createRigidArea(new Dimension(0,10)));
			}
			
			if(top.game.getHS()){
				Box hotStreakLine = Box.createHorizontalBox();
				hotStreakLine.setAlignmentX(LEFT_ALIGNMENT);
				
				hotStreakLine.add(new JLabel("Hot Streak"));
				
				format.add(hotStreakLine);
				format.add(Box.createRigidArea(new Dimension(0,10)));
			}
			
			if(top.game.getKickEm()){
				Box kickEmLine = Box.createHorizontalBox();
				kickEmLine.setAlignmentX(LEFT_ALIGNMENT);
				
				kickEmLine.add(new JLabel("Kick 'em While They're Down:"));
				kickEmLine.add(Box.createRigidArea(new Dimension(10,0)));
				kickEmLine.add(new JLabel(Integer.toString(top.game.getKickEmScore())));
				
				format.add(kickEmLine);
				format.add(Box.createRigidArea(new Dimension(0,10)));
			}
			
			if(top.game.getWelfare()){
				Box welfareLine = Box.createHorizontalBox();
				welfareLine.setAlignmentX(LEFT_ALIGNMENT);
				
				welfareLine.add(new JLabel("Welfare"));
				
				format.add(welfareLine);
			}
			
			add(format);
		}
	}
	
	//listeners

}
