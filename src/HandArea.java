import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HandArea extends JPanel{
	
	JLabel turnScore;
	
	DicePanel kept = new DicePanel();
	DicePanel rolled = new DicePanel();
	
	FarkleFrame top;
	
	//methods
	
//	public static void main(String[] args) {
//		//TEST!
//        //creating and showing this application's GUI.
//        EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                JFrame testFrame = new JFrame();
//                testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                testFrame.add(new HandArea());
//                testFrame.pack();
//                testFrame.setVisible(true);
//            }
//        });
//	}
	
	public HandArea(FarkleFrame top_i){
		top = top_i;
		setLayout(new GridLayout(3,1));	
		rolled.setOther(kept);
		kept.setOther(rolled);
		kept.addKeptLabel();
		rolled.addRolledLabel();
		rolled.populate();
		add(kept);
		add(rolled);
		add(new ButtonPanel());
	}
	
	
	
	//subclasses
	public class DicePanel extends JPanel {
		//fields
		
		DicePanel other;
		DiceLabel d1;
		DiceLabel d2;
		DiceLabel d3;
		DiceLabel d4;
		DiceLabel d5;
		DiceLabel d6;
		JLabel[] dice = new JLabel[6];
		ImageIcon die1 = new ImageIcon("src/1.png");
		ImageIcon die2 = new ImageIcon("src/2.png");
		ImageIcon die3 = new ImageIcon("src/3.png");
		ImageIcon die4 = new ImageIcon("src/4.png");
		ImageIcon die5 = new ImageIcon("src/5.png");
		ImageIcon die6 = new ImageIcon("src/6.png");
		ImageIcon die0 = new ImageIcon("src/NULL.png");
		
		//methods
		
		public void populate(){
			FarkleDie[] hand = top.game.getActivePlayer().getHand().getHand();
			for (int i = 0; i < 6; i++){
				if(!hand[i].getKept()){
					switch (hand[i].getFaceup()){
					case 1:	dice[i].setIcon(die1);
							break;
					case 2:	dice[i].setIcon(die2);
							break;
					case 3:	dice[i].setIcon(die3);
							break;
					case 4:	dice[i].setIcon(die4);
							break;
					case 5:	dice[i].setIcon(die5);
							break;
					case 6:	dice[i].setIcon(die6);
							break;
					default: dice[i].setIcon(die0);
							break;
					}
				}
			}
		}
		
		public void clear(){
			for (JLabel die : dice){
				die.setIcon(die0);
			}
		}
		
		public DicePanel(){
			super();
			d1 = new DiceLabel(die0);
			d1.addMouseListener(new DiceListener());
			d2 = new DiceLabel(die0);
			d2.addMouseListener(new DiceListener());
			d3 = new DiceLabel(die0);
			d3.addMouseListener(new DiceListener());
			d4 = new DiceLabel(die0);
			d4.addMouseListener(new DiceListener());
			d5 = new DiceLabel(die0);
			d5.addMouseListener(new DiceListener());
			d6 = new DiceLabel(die0);
			d6.addMouseListener(new DiceListener());
			dice[0] = d1;
			dice[1] = d2;
			dice[2] = d3;
			dice[3] = d4;
			dice[4] = d5;
			dice[5] = d6;
			add(d1);
			add(d2);
			add(d3);
			add(d4);
			add(d5);
			add(d6);
		}
		
		public void setOther(DicePanel o){
			other = o;
		}
		
		public void addKeptLabel(){
			add(new JLabel("   Kept   "));
		}
		
		public void addRolledLabel(){
			add(new JLabel("  Rolled  "));
		}
		
		public void swapOut(JLabel die){
			ImageIcon tmp = (ImageIcon)die.getIcon();
			if (die.equals(d1)){
				d1.setIcon(die0);
				other.swapIn(1, tmp);
				top.game.getActivePlayer().getHand().getHand()[0].toggleKept();
			} else if (die.equals(d2)){
				d2.setIcon(die0);
				other.swapIn(2, tmp);
				top.game.getActivePlayer().getHand().getHand()[1].toggleKept();
			}  else if (die.equals(d3)){
				d3.setIcon(die0);
				other.swapIn(3, tmp);
				top.game.getActivePlayer().getHand().getHand()[2].toggleKept();
			}  else if (die.equals(d4)){
				d4.setIcon(die0);
				other.swapIn(4, tmp);
				top.game.getActivePlayer().getHand().getHand()[3].toggleKept();
			}  else if (die.equals(d5)){
				d5.setIcon(die0);
				other.swapIn(5, tmp);
				top.game.getActivePlayer().getHand().getHand()[4].toggleKept();
			}  else if (die.equals(d6)){
				d6.setIcon(die0);
				other.swapIn(6, tmp);
				top.game.getActivePlayer().getHand().getHand()[5].toggleKept();
			}
		}
		
		public void swapIn(int die, ImageIcon icon){
			switch (die) {
			case 1: d1.setIcon(icon);
					break;
			case 2: d2.setIcon(icon);
					break;
			case 3: d3.setIcon(icon);
					break;
			case 4: d4.setIcon(icon);
					break;
			case 5: d5.setIcon(icon);
					break;
			case 6: d6.setIcon(icon);
					break;
			default:break;
			}
		}
		
		//subclass
		
		public class DiceLabel extends JLabel{
			private boolean clickable = true;
			
			public DiceLabel(ImageIcon img){
				super(img);
			}
			
			public void noClick(){
				clickable = false;
			}
			
			public void click(){
				clickable = true;
			}
			
			public boolean getClickable(){
				return clickable;
			}
		}
		
		
		
		//listeners
		
		private class DiceListener implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent arg0) {
				//GARBAGE
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {	
				DiceLabel thisDice = (DiceLabel)arg0.getSource();
				if ((!thisDice.getIcon().equals(die0)) && thisDice.getClickable() ){
					thisDice.setCursor(new Cursor(Cursor.HAND_CURSOR));
				}
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				//GARBAGE
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				//GARBAGE
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				DiceLabel thisDice = (DiceLabel)arg0.getSource();
				if ((!thisDice.getIcon().equals(die0)) && thisDice.getClickable()){
					swapOut(thisDice);
					thisDice.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
			}			
		}
	}
	
	public class ButtonPanel extends JPanel{
		//fields
		JButton roll = new JButton("Roll");
		JButton score = new JButton("Score");
		JButton end = new JButton("End Turn");
		JLabel turnScore;
		
		//methods
		public ButtonPanel(){
			add(new JLabel("Current Turn Score: "));
			turnScore = new JLabel(Integer.toString(top.game.getActivePlayer().getHand().getScore()));
			add(turnScore);
			
			roll.addActionListener(new RollListener());
			score.addActionListener(new ScoreListener());
			add(roll);
			add(score);
			add(end);
		}
		
		public class RollListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				top.game.getActivePlayer().getHand().rollHand();
				rolled.populate();
			}
		}
		
		public class ScoreListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FarkleScoringOpt scores = new FarkleScoringOpt(top.game.getActivePlayer().getHand(), top.game);
				scores.createKeptHand();
				scores.scoreHand(scores.getKeptHand());
				System.out.println(top.game.getActivePlayer().getHand().getScore());
			}
			
		}
	}
}
