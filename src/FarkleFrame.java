import javax.swing.*;
import java.awt.*;


public class FarkleFrame extends JFrame{
	//fields
	Game game;
	RulesDisplay rules;
	Scorecard scores;
	HandArea hand;
	
	//methods
	public FarkleFrame(Game game_i){
		super();
		game = game_i;
		rules = new RulesDisplay(this);
		hand = new HandArea(this);
		scores = new Scorecard(this);
		add(hand, BorderLayout.SOUTH);
		add(rules, BorderLayout.WEST);
		add(scores, BorderLayout.EAST);
		pack();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				JFrame game = new FarkleFrame();
//			}
//		});
//	}
	
	//listeners
}
